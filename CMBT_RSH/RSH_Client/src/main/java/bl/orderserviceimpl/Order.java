package bl.orderserviceimpl;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.HotelController;
import bl.userserviceimpl.CreditRecordList;
import bl.userserviceimpl.UserController;
import bl.userserviceimpl.UserForOrderController;
import constant.CreditAction;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.hoteldao.HotelDao;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import rmi.RemoteHelper;
import vo.CreditRecordVO;
import vo.OrderVO;
import vo.RoomNormVO;

public class Order {

	private static OrderDao orderDao=null;
	OrderPO orderPO;
	
	public Order(String orderID) {
		initRemote();
		try {
			orderPO = orderDao.searchByID(orderID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void initRemote(){
		if(orderDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			orderDao = remoteHelper.getOrderDao();
		}
	}
	
   
	
    public static Order getInstance(String orderID){
    	Order order = new Order(orderID);
    	if(order.orderPO==null)
    		return null;
    	else{
    		return order;
    	}
    }
    

    /**
     * hotel can execute the order,
     * add the credit and set the state as execute;
     * updata checkin time
     * @return
     */
	public ResultMessage execute(){ 
		
//		can be executed??
		StateOfOrder stateOfOrder = orderPO.getState();
		if(stateOfOrder!=StateOfOrder.unexecuted&&stateOfOrder!=StateOfOrder.canceled){
	    	return ResultMessage.noChangeMade;
	    }
		
//		the time is okay
		Date now = new Date(); 
		Date checkOutTime ;
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    String str=sdf.format(orderPO.getCheckOut());
	    try{
	    	checkOutTime = df.parse(str+" 12:00:00");
	    }catch (ParseException e){
	    	e.printStackTrace();
	    	return ResultMessage.fail;
	    }
		if(now.getTime()-checkOutTime.getTime()>0){
			return ResultMessage.timeOut;
		}
		
//		change the state
		orderPO.setState(StateOfOrder.executed);
		
//		change the recordListe:
		UserForOrder userForOrder = new UserForOrderController();
		userForOrder.addCreditRecordForExecute(orderPO.getUserID(), orderPO.getOrderID(), (int)orderPO.getTrueValue(), now);	      
	    return update();
	}

    	
	/**
	 * hotel call this method when the guest is leaving 
	 * and set the checkout Date;
	 * @return
	 */
   public ResultMessage leaveUpdate(){
	   if(orderPO.getState()!= StateOfOrder.executed){
		   return ResultMessage.noChangeMade;
	   }
	   orderPO.setActualCheckOut(new Date());
       return update();
   }
   
   /**
    * for hotel and webSalesman, they can both cancel the abnormal order 
    * and set the state as canceled,
    * hotel will cancel it, add all the credit, and execute it
    * webSalesman will cancel it, add all or half the credit.    * 
    * @return
    */
  
   public ResultMessage cancelAbnormal(boolean isHalf){
	   //is abnormal or not
	   if(orderPO.getState()!= StateOfOrder.abnormal){
		   return ResultMessage.noChangeMade;
	   }
	   //can cancel abnormal?? before checkout time
	   Date cancelTime = new Date();
	   Date checkOutTime  = orderPO.getCheckOut();
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       String str=sdf.format(checkOutTime);
       try{
           checkOutTime = df.parse(str+" 12:00:00");
       }catch (ParseException e){
           e.printStackTrace();
           return ResultMessage.fail;
       }
       if(checkOutTime.getTime()-cancelTime.getTime()<0)
           return ResultMessage.timeOut;
	   //change the state of order
       
	   orderPO.setState(StateOfOrder.canceled);
	   
	   //change the creditRecordList
	   double halfOrFull = 1/2;
       if(!isHalf)
           halfOrFull = 1;
       int creditChange  =(int) (halfOrFull* orderPO.getTrueValue());
       UserForOrder userForOrder = new UserForOrderController();
       userForOrder.addCreditRecordForCancel(orderPO.getUserID(), orderPO.getOrderID(), creditChange, cancelTime);
       
       return update();
   }

   

   public ResultMessage update(){
	   try {
		return orderDao.update(orderPO);
	
	   } catch (RemoteException e) {
		   e.printStackTrace();
		   return ResultMessage.remote_fail;	
	   }
   }
	
   public  static ResultMessage generateOrder(OrderVO orderVO){
    	OrderPO orderPO = orderVO.changeIntoPO();
    	initRemote();
    	ResultMessage resultMessage = null;
    	try {
			resultMessage = orderDao.insert(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
    	if(resultMessage==ResultMessage.succeed){
    		HotelController hotelController = new HotelController();
    		resultMessage = hotelController.minusRoomAvail(orderVO.getHotelID(), orderVO.getRoomType(),
    				orderVO.getRoomNumber(), orderVO.getCheckIn(), orderVO.getActualCheckOut());
    	}
    	return resultMessage;
    }

   
    
    
    

}
