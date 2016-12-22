package bl.orderserviceimpl;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.controller.HotelController;
import bl.promotionServiceimpl.Promotion;
import bl.userserviceimpl.CreditRecordList;
import constant.CreditAction;
import constant.ResultMessage;
import constant.StateOfOrder;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return orderPO.changeIntoVO();
    }
	
    public static Order getInstance(String orderID){
    	OrderVO orderVO  = getOrderInfo(orderID);
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
		Date checkOutTime = null;
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
		int change = trueValue;
	    CreditRecordList creditRecordList = new CreditRecordList(userID);
	    int credit = creditRecordList.getCredit();
	    CreditRecordVO creditRecordVO = new CreditRecordVO(userID,now,orderID,
	            CreditAction.execute,"+"+change,change+credit);	    
	    creditRecordList.addCreditRecord(creditRecordVO);
	    
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
	   Date checkOutTime = null;
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
       CreditRecordList creditRecordList = new CreditRecordList(userID);
       int credit = creditRecordList.getCredit();
       credit += (int)trueValue*halfOrFull;
       CreditRecordVO creditRecordVO = new CreditRecordVO(userID,cancelTime,orderID,
               CreditAction.cancel_abnomal,"+"+String.valueOf((int)trueValue*halfOrFull),credit);//!!!!credit
       creditRecordList.addCreditRecord(creditRecordVO);
       
	   return update();
   }

   

   public ResultMessage update(){
	   ResultMessage resultMessage = null ;
	   
	   try {
		resultMessage = orderDao.update(this.changeIntoPO());
	
	   } catch (RemoteException e) {
		// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.remote_fail;
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
    	
    	String hotelID  = orderID.substring(0,10);
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
    

	public ResultMessage addAvailRoom() {
		// TODO Auto-generated method stub
		HotelService hotelService = new HotelController();
		return hotelService.plusRoomAvail(orderID.substring(0,10),RoomType, roomNumber, checkInDate, checkOutDate);
	}
}
