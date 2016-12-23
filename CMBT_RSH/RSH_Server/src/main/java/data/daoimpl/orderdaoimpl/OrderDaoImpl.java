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
 
    //更新订单
	@Override
	public ResultMessage update(OrderPO orderPO) throws RemoteException {
		return orderDaoHelper.update(orderPO);
	}


}
