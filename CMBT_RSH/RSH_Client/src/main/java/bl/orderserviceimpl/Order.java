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
	
	String userID;
	String orderID;
	Date checkInDate;
	Date checkOutDate;
	Date actualCheckOutTime;
	Date actualCheckInTime;
	StateOfOrder stateOfOrder;
	int trueValue;
	
	String RoomType;	
	String promotionName;
	
	private static void initRemote(){
		if(orderDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			orderDao = remoteHelper.getOrderDao();
		}
	}
	
    public static OrderVO getOrderInfo(String orderID){
    	OrderPO orderPO = null;
    	initRemote();
    	try {
			orderPO = orderDao.searchByID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
    	if(orderPO==null){
    		return null;
    	}
    	return orderPO.changeIntoVO();
    }
	
    public static Order getInstance(String orderID){
    	OrderVO orderVO  = getOrderInfo(orderID);
    	if(orderVO==null){
    		return null;
    	}
    	return orderVO.changeIntoOrder();
    }
    

    /**
     * hotel can execute the order,
     * add the credit and set the state as execute;
     * updata checkin time
     * @return
     */
	public ResultMessage execute(){ 
		
//		can be executed??
		if(stateOfOrder!=StateOfOrder.unexecuted&&stateOfOrder!=StateOfOrder.canceled){
	    	return ResultMessage.noChangeMade;
	    }
//		the time is okay
		Date now = new Date(); 
		Date checkOutTime ;
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    String str=sdf.format(checkOutDate);
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
		stateOfOrder = StateOfOrder.executed;
		
//		change the recordListe:
		UserForOrder userForOrder = new UserForOrderController();
		userForOrder.addCreditRecordForExecute(userID, orderID, trueValue, now);	    
	    actualCheckInTime = now;
	    
	    return update();
	}

    	
	/**
	 * hotel call this method when the guest is leaving 
	 * and set the checkout Date;
	 * @return
	 */
   public ResultMessage leaveUpdate(){
	   if(stateOfOrder!= stateOfOrder.executed){
		   return ResultMessage.noChangeMade;
	   }
	   actualCheckOutTime = new Date();
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
	   if(stateOfOrder != StateOfOrder.abnormal){
		   return ResultMessage.noChangeMade;
	   }
	   //can cancel abnormal?? before checkout time
	   Date cancelTime = new Date();
	   Date checkOutTime  = checkOutDate;
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       String str=sdf.format(checkOutDate);
       try{
           checkOutTime = df.parse(str+" 12:00:00");
       }catch (ParseException e){
           e.printStackTrace();
           return ResultMessage.fail;
       }
       if(checkOutTime.getTime()-cancelTime.getTime()<0)
           return ResultMessage.timeOut;
	   //change the state of order
       
	   stateOfOrder = StateOfOrder.canceled;
	   
	   //change the creditRecordList
	   double halfOrFull = 1/2;
       if(!isHalf)
           halfOrFull = 1;
       int creditChange  =(int) halfOrFull* trueValue;
       UserForOrder userForOrder = new UserForOrderController();
       userForOrder.addCreditRecordForCancel(userID, orderID, creditChange, cancelTime);
       
       //change available room
       HotelController hotelController = new HotelController();
       hotelController.plusRoomAvail(orderID.substring(10, 20), roomType,roomNumber,checkInDate,checkOutDate);
       return update();
   }

   

   public ResultMessage update(){
	   ResultMessage resultMessage = null ;
	   
	   try {
		resultMessage = orderDao.update(this.changeIntoPO());
	
	   } catch (RemoteException e) {
		   e.printStackTrace();
		   return ResultMessage.remote_fail;	
	   }
	   return resultMessage;
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

	String userName;
    String hotelName;
    String roomType;
    double roomPrice;
    int roomNumber;
    int peopleNumber;
    boolean withChild;
    double originValue;
    String comment;
    int grade;
    String hotelDDL;
    Date generationDate;
    Date cancelTime;
    Date cancelAbnormalTime;
    private OrderPO changeIntoPO() {
		
		// TODO Auto-generated method stub
    	
    	String hotelID  = orderID.substring(10,20);
    	OrderPO orderPO = new OrderPO(orderID, userID, userName, 
    			hotelID, hotelName, 
    			stateOfOrder, 
    			new RoomNormVO(hotelID, roomType, roomPrice),  roomPrice, roomNumber,
    			peopleNumber, withChild, originValue, trueValue, promotionName, 
    			comment, grade, 
    			checkInDate, checkOutDate, hotelDDL, generationDate, 
    			actualCheckInTime, actualCheckOutTime, 
    			cancelTime, cancelAbnormalTime);
		return orderPO;
	}
    

}
