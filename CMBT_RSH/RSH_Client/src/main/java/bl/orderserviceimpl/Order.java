package bl.orderserviceimpl;

import java.rmi.RemoteException;
import java.util.Date;

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

public class Order {

	private static OrderDao orderDao=null;
	
	String userID;
	String orderID;
	Date checkInDate;
	Date checkOutDate;
	StateOfOrder stateOfOrder;
	int Value;
	
	String RoomType;	
	Promotion promotion;
	
	private void initRemote(){
		if(orderDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			orderDao = remoteHelper.getOrderDao();
		}
	}
	
    public static OrderVO getOrderInfo(String orderID){
    	OrderPO orderPO = null;
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
    	Order order = changeIntoOrder(orderVO);
    	return order;
    }
    
    private static Order changeIntoOrder(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage execute(){ 
    Date actCheckIn = new Date();
    if(stateOfOrder==StateOfOrder.unexecuted||stateOfOrder==StateOfOrder.abnormal){
    	stateOfOrder = StateOfOrder.executed;
    }
    try {
		orderDao.update(this.changeIntoPO());
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    int change = (int)Value;
    CreditRecordList creditRecordList = new CreditRecordList(userID);
    int credit = creditRecordList.getCredit();

    CreditRecordVO creditRecordVO = new CreditRecordVO(userID,actCheckIn,orderID,
            CreditAction.execute,"+"+change,change+credit);
    
    creditRecordList.addCreditRecord(creditRecordVO);

    return ResultMessage.succeed;
    }
	
    private OrderPO changeIntoPO() {
		// TODO Auto-generated method stub
		return null;
	}

	public  static ResultMessage generateOrder(OrderVO orderVO){
    	
    	return null;
    }
    
    public static ResultMessage delOrder(String orderID){
    	
    	return null;
    }
    
    
}
