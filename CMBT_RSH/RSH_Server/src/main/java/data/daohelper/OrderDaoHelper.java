package data.daohelper;

import constant.ResultMessage;
import constant.StateOfOrder;
import po.OrderPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aa on 2016/12/3.
 */
public interface OrderDaoHelper {
	public void init();
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

    // 新建订单
    public ResultMessage insert(OrderPO orderPO) throws RemoteException;
    // 订单更新
    public ResultMessage update(OrderPO orderPO) throws RemoteException;
}
