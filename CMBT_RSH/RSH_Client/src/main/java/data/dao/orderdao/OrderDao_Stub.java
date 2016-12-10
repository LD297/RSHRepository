package data.dao.orderdao;

import constant.ResultMessage;
import constant.StateOfOrder;
import po.OrderPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a297 on 16/12/9.
 */
public class OrderDao_Stub implements OrderDao {
    @Override
    public OrderPO searchByID(String orderID) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> searchByUser(String userID) throws RemoteException {
        return null;
    }
    @Override
    public ArrayList<OrderPO> searchByHotelWithUser(String userID, String hotelID)throws RemoteException{
        return null;
    }

    @Override
    public ArrayList<OrderPO> searchByHotel(String hotelID) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> searchByState(StateOfOrder state) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage insert(OrderPO orderPO) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage delete(String orderID) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage stateUpdate(String orderID, StateOfOrder newstate) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage commentUpdate(String orderID, double grade, String comment) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage leaveUpdate(String orderID, Date actualCheckOut) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage cancelTimeUpdate(String orderID, Date cancelTime) throws RemoteException{
        return null;
    }

    @Override
    public void init() throws RemoteException {

    }

    @Override
    public void finish() throws RemoteException {

    }
}
