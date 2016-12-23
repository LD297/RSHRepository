package data.dao.orderdao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.OrderPO;
import constant.ResultMessage;
import constant.StateOfOrder;

public interface OrderDao extends Remote{
	// 根据订单编号查找订单
	public OrderPO searchByID(String orderID) throws RemoteException;
	// 根据用户编号查找订单
	public ArrayList<OrderPO> searchByUser(String userID) throws RemoteException;
	// 根据用户编号、酒店编号查找订单
	public ArrayList<OrderPO> searchByUserWithHotel(String userID,String hotelID) throws RemoteException;
	// 根据酒店编号查找订单
	public ArrayList<OrderPO> searchByHotel(String hotelID) throws RemoteException;
	// 根据状态编号查找订单
	public ArrayList<OrderPO> searchByState(StateOfOrder state) throws RemoteException;
    // 添加订单
	public ResultMessage insert(OrderPO orderPO) throws RemoteException;
	
	public ResultMessage update(OrderPO orderPO) throws RemoteException;
	
}