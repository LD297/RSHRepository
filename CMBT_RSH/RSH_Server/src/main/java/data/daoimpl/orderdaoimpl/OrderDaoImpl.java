package data.daoimpl.orderdaoimpl;

import constant.ResultMessage;
import constant.StateOfOrder;
//import data.dao.databasefactory.DatabaseFactory;
import data.dao.orderdao.OrderDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.OrderDaoHelper;
//import data.daoimpl.databasefactoryimpl.DatabaseFactoryImpl;
import data.daohelperimpl.DaoHelperFactoryImpl;
import po.OrderPO;

import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/11/27.
 */
public class OrderDaoImpl extends UnicastRemoteObject implements OrderDao{
    
    private OrderDaoHelper orderDaoHelper = null;
    private DaoHelperFactory daoHelperFactory = null;

    private OrderDaoImpl()throws RemoteException{
    	if(daoHelperFactory==null)
            daoHelperFactory = new DaoHelperFactoryImpl();
        if(orderDaoHelper==null)
    	    orderDaoHelper = daoHelperFactory.getOrderDaoHelper();
    }
    
    public static OrderDaoImpl getInstance(){
    	try {
			return new OrderDaoImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    @Override
    public OrderPO searchByID(String orderID) throws RemoteException{
        return orderDaoHelper.searchByID(orderID);
    }
    //根据用户编号查找订单
    @Override
    public ArrayList<OrderPO> searchByUser(String userID) throws RemoteException{
        return orderDaoHelper.searchByUser(userID);
    }
    // 根据用户编号、酒店编号查找订单
    @Override
    public ArrayList<OrderPO> searchByUserWithHotel(String userID,String hotelID) throws RemoteException{
        return orderDaoHelper.searchByUserWithHotel(userID, hotelID);
    }

    //根据酒店编号查找订单
    @Override
    public ArrayList<OrderPO> searchByHotel(String hotelID) throws RemoteException{
        return orderDaoHelper.searchByHotel(hotelID);
    }
    //根据状态编号查找订单
    @Override
    public ArrayList<OrderPO> searchByState(StateOfOrder state) throws RemoteException{
        return orderDaoHelper.searchByState(state);
    }
    //新建订单
    @Override
    public ResultMessage insert(OrderPO orderPO) throws RemoteException{
        return orderDaoHelper.insert(orderPO);
    }

    //订单状态更新
    @Override
    public ResultMessage stateUpdate(String orderID,StateOfOrder newState) throws RemoteException{
        return orderDaoHelper.stateUpdate(orderID,newState);
    }
    //评价订单
    @Override
    public ResultMessage commentUpdate(String orderid, int grade, String comment) throws RemoteException{
        return orderDaoHelper.commentUpdate(orderid,grade,comment);
    }
    // 订单实际入住时间更新
    @Override
    public ResultMessage actCheckInUpdate(String orderID, Date actCheckIn) throws RemoteException{
        return orderDaoHelper.actCheckInUpdate(orderID, actCheckIn);
    }
    // 订单实际离开时间更新
    @Override
    public ResultMessage actCheckOutUpdate(String orderID, Date actCheckOut) throws RemoteException{
        return orderDaoHelper.actCheckOutUpdate(orderID, actCheckOut);
    }
    // 订单撤销时间更新
    @Override
    public ResultMessage cancelTimeUpdate(String orderID, Date cancelTime) throws RemoteException{
        return orderDaoHelper.cancelTimeUpdate(orderID, cancelTime);
    }
    // 订单撤销异常时间更新
    @Override
    public ResultMessage cancelAbTimeUpdate(String orderID, Date cancelAbTime) throws RemoteException{
        return orderDaoHelper.cancelAbTimeUpdate(orderID, cancelAbTime);
    }

	@Override
	public ResultMessage update(OrderPO orderPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
