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
    public OrderPO findByID(String orderid) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> findByUser(String userid) throws RemoteException {
        return null;
    }
    @Override
    public ArrayList<OrderPO> findByHotelWithUser(String userID, String hotelID)throws RemoteException{
        return null;
    }

    @Override
    public ArrayList<OrderPO> findByHotel(String hotelid) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> findByState(StateOfOrder state) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage insert(OrderPO orderpo) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage delete(String orderid) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage stateUpdate(String orderid, StateOfOrder newstate) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage commentUpdate(String orderid, double grade, String comment) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage leaveUpdate(String orderid, Date leavetime) throws RemoteException {
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
