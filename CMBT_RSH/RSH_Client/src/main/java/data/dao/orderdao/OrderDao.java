package data.dao.orderdao;

import constant.ResultMessage;
import constant.StateOfOrder;
import po.OrderPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/11/27.
 */
public interface OrderDao {
    //根据订单编号查找订单
    public OrderPO searchByID(String orderID) throws RemoteException;
    //根据用户编号查找订单
    public ArrayList<OrderPO> searchByUser(String userID) throws RemoteException;
    //根据用户编号、酒店编号查找订单
    public ArrayList<OrderPO> searchByHotelWithUser(String userID,String hotelID) throws RemoteException;
    //根据酒店编号查找订单
    public ArrayList<OrderPO> searchByHotel(String hotelID) throws RemoteException;
    //根据状态编号查找订单
    public ArrayList<OrderPO> searchByState(StateOfOrder state) throws RemoteException;
    //新建订单
    public ResultMessage insert(OrderPO orderPO) throws RemoteException;
    //删除订单
    public ResultMessage delete(String orderID) throws RemoteException;
    //订单状态更新
    public ResultMessage stateUpdate(String orderID,StateOfOrder newState) throws RemoteException;
    //评价订单
    public ResultMessage commentUpdate(String orderID, double grade, String comment) throws RemoteException;
    //订单实际离开时间更新
    public ResultMessage leaveUpdate(String orderID,Date leaveTime) throws RemoteException;
    //订单撤销时间更新
    public ResultMessage cancelTimeUpdate(String orderID,Date cancelTime) throws RemoteException;

    public void init() throws RemoteException;

    public void finish() throws RemoteException;
}
