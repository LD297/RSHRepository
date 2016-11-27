package data.daohelperimpl.orderdaohelper;

import constant.ResultMessage;
import constant.StateOfOrder;
import data.daohelper.DaoHelperMySql;
import data.daohelperimpl.jdbc.JDBC;
import po.OrderPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import java.sql.ResultSet;

/**
 * Created by sky-PC on 2016/11/27.
 */
public class OrderDaoHelperMySql extends DaoHelperMySql {

    private OrderDaoHelperMySql mySql = new OrderDaoHelperMySql();
    private final String tableName = "OrderList";
    private JDBC db = new JDBC();
    private ResultSet resultSet;

    public void init(){
        //path表示你所创建文件的路径

        db.executeSql("USE Test");
        //订单编号 用户编号 酒店编号 订单状态
        db.executeSql("CREATE TABLE OrderList(orderID char(26),userID char(9)),hotelID char(10),statement int(1)");
    }
    public void finish(){
        File f = new File("D:\\360downloads\\OrderList.db");  // 输入要删除的文件位置
        if(f.exists())
            f.delete();
    }
    //根据订单编号查找订单
/*    public OrderPO find(String orderid) throws RemoteException{
        String sql = "SELECT 1 FROM OrderList WHERE orderID = ";
        ResultSet result = db.query(sql);

    }
    //根据用户编号查找订单
    public ArrayList<OrderPO> userFind(String uderid) throws RemoteException;
    //根据酒店编号查找订单
    public ArrayList<OrderPO> hotelFind(String hotelid) throws RemoteException;
    //根据状态编号查找订单
    public ArrayList<OrderPO> stateFind(StateOfOrder state) throws RemoteException;
    //新建订单
    public ResultMessage insert(OrderPO orderpo) throws RemoteException;
    //删除订单
    public ResultMessage delete(String orderid) throws RemoteException;
    //订单状态更新
    public ResultMessage stateUpdate(String orderid,StateOfOrder newstate) throws RemoteException;
    //评价订单
    public ResultMessage commentUpdate(String orderid, double grade, String comment) throws RemoteException;
    //订单实际离开时间更新
    public ResultMessage leaveUpdate(String orderid,Date leavetime) throws RemoteException;
    */
}
