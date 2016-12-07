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
    /*//根据订单编号查找订单
    private DatabaseFactoryImpl mysql = new DatabaseFactoryImpl();
    private final String tableName = "OrderInfo";
    private Connection conn = null;**/

    private static OrderDaoImpl orderDaoImpl;
    private OrderDaoHelper orderDaoHelper;
    private DaoHelperFactory daoHelperFactory;

    private OrderDaoImpl()throws RemoteException{

        daoHelperFactory = new DaoHelperFactoryImpl();
        orderDaoHelper = daoHelperFactory.getOrderDaoHelper();
    }

    public static OrderDaoImpl getInstance(){
        if(orderDaoImpl == null){
            try {
                orderDaoImpl = new OrderDaoImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return orderDaoImpl;
    }
    public OrderPO find(String orderid) throws RemoteException{
        return null;
    };
    //根据用户编号查找订单
    public ArrayList<OrderPO> userFind(String uderid) throws RemoteException{
        return null;
    };
    //根据酒店编号查找订单
    public ArrayList<OrderPO> hotelFind(String hotelid) throws RemoteException{
        return null;
    };
    //根据状态编号查找订单
    public ArrayList<OrderPO> stateFind(StateOfOrder state) throws RemoteException{
        return null;
    };
    //新建订单
    public ResultMessage insert(OrderPO orderpo) throws RemoteException{
        return null;
    };
    //删除订单
    public ResultMessage delete(String orderid) throws RemoteException{
        return null;
    };
    //订单状态更新
    public ResultMessage stateUpdate(String orderid,StateOfOrder newstate) throws RemoteException{
        return null;
    };
    //评价订单
    public ResultMessage commentUpdate(String orderid, double grade, String comment) throws RemoteException{
        return null;
    };
    //订单实际离开时间更新
    public ResultMessage leaveUpdate(String orderid,Date leavetime) throws RemoteException{
        return null;
    };

    public void init() throws RemoteException{};

    public void finish() throws RemoteException{};

}
