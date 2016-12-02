package data.daohelperimpl.orderdaohelperimpl;

import constant.ResultMessage;
import constant.RoomType;
import constant.StateOfOrder;
import data.daohelper.DaoHelperMySql;
import data.daohelperimpl.jdbc.DBHelper;
import po.OrderPO;
import vo.RoomNormVO;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by sky-PC on 2016/11/27.
 */
public class OrderDaoHelperMySql extends DaoHelperMySql {

    private DBHelper db = new DBHelper();

    public void init(){

        db.executeSql("USE Test");
        //订单编号 房间类型 房间原价 房间现价 房间数量 促销策略
        db.executeSql("CREATE TABLE OrderRooms(orderID char(26),roomType tinyint,originPrice double,truePrice double,roomNum tinyint,promotion varchar(20))");
        // 订单编号 用户编号 酒店编号 订单状态
        // 入住人数 是否有儿童 原价 折后 促销策略
        // 评价 评分 入住、退房时间 房间记录存储数量
        db.executeSql("CREATE TABLE OrderGeneral(orderID char(26),userID char(9),hotelID char(10),state tinyint," +
                "numOfPeople tinyint,adultOnly tinyint,originalValue double,trueValue double,promotion varchar(20)," +
                "comment varchar(30),grade tinyint,checkIn datetime,checkOut datetime,limitNum tinyint)");
    }
    public void finish(){
        File f = new File("D:\\360downloads\\OrderList.db");  // 输入要删除的文件位置
        if(f.exists())
            f.delete();
    }
    //根据订单编号查找订单
    public OrderPO find(String orderid) throws RemoteException{
        db.executeSql("USE Test");
        String sqlDetail = "SELECT *FROM OrderGeneral WHERE orderID='"+orderid+"'LIMIT 1";
        ResultSet result = db.query(sqlDetail);
        System.out.println("selectsql!");
        try {
            while(result.next()){
                String ordername = result.getString(1);
                String username = result.getString(2);
                String  hotelname = result.getString(3);

                int orderstate = result.getInt(4);
                StateOfOrder state = this.getState(orderstate);
//unexecuted,executed,abnormal,canceled
                int peoplenum = result.getInt(5);
                Boolean adultonly = result.getBoolean(6);
                double originvalue = result.getDouble(7);
                double truevalue = result.getDouble(8);
                String promotion = result.getString(9);
                String comment = result.getString(10);
                int grade = result.getInt(11);

                Date checkin = result.getDate(12);
                Date checkout = result.getDate(13);
                int limit = result.getInt(14);

                ArrayList<RoomNormVO> type = new ArrayList<RoomNormVO>();
                double[] roomprices;
                int[] roomnums;
                if(limit>0) {
                    String sqlRoom = "SELECT *FROM OrderRooms WHERE orderID='" + orderid + "'LIMIT " + String.valueOf(limit);
                    ResultSet resultRoom = db.query(sqlRoom);

                    roomprices = new double[limit];
                    roomnums = new int[limit];
                    int i = 0;
                    while (resultRoom.next()) {

                        type.add(new RoomNormVO(resultRoom.getString(1).substring(0, 10), RoomType.singleRoom, resultRoom.getDouble(3)));
                        roomnums[i] = resultRoom.getInt(5);
                        roomprices[i] = resultRoom.getDouble(4);
                        i++;
                    }

                    OrderPO orderpo = new OrderPO(ordername, username, hotelname, state,
                            type, roomprices, roomnums, peoplenum, adultonly,
                            originvalue, truevalue, promotion,
                            comment, grade, checkin, checkout) {
                    };
                    return orderpo;
                }
                else
                    return null;}
            return null;
        } catch (SQLException e)
        {// TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }
    //根据用户编号查找订单
    public ArrayList<OrderPO> userFind(String userid) throws RemoteException {
        String sqlGeneral = "SELECT *FROM OrderGeneral WHERE userID='" + userid + "'";
        ResultSet result = db.query(sqlGeneral);
        ArrayList<OrderPO> userOrderList = new ArrayList<OrderPO>();
        try {
            while(result.next()){
                // 订单编号 用户编号 酒店编号 订单状态
                // 入住人数 是否有儿童 原价 折后 促销策略
                // 评价 评分 入住、退房时间 房间记录存储数量
                String ordername = result.getString(1);
                String hotelname = result.getString(3);
                int orderstate = result.getInt(4);
                StateOfOrder state = this.getState(orderstate);
                double originvalue = result.getDouble(7);
                double truevalue = result.getDouble(8);
                Date checkin = result.getDate(12);
                Date checkout = result.getDate(13);

                OrderPO orderpo = new OrderPO(ordername,hotelname,state,originvalue,truevalue,checkin,checkout) {};
                userOrderList.add(orderpo);
            }
        } catch (SQLException e) {// TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return userOrderList;
    }
    //根据酒店编号查找订单
    public ArrayList<OrderPO> hotelFind(String hotelid) throws RemoteException{
        String sqlGeneral = "SELECT *FROM OrderGeneral WHERE userID = '" + hotelid + "'";
        ResultSet result = db.query(sqlGeneral);
        ArrayList<OrderPO> hotelOrderList = new ArrayList<OrderPO>();
        try {
            while (result.next()) {
                // 订单编号 用户编号 酒店编号 订单状态
                // 入住人数 是否有儿童 原价 折后 促销策略
                // 评价 评分 入住、退房时间 房间记录存储数量
                String ordername = result.getString(1);
                String username = result.getString(2);
                int orderstate = result.getInt(4);
                StateOfOrder state = this.getState(orderstate);
                int peoplenum = result.getInt(5);
                boolean adultonly = result.getBoolean(6);

                double originvalue = result.getDouble(7);
                double truevalue = result.getDouble(8);
                Date checkin = result.getDate(12);
                Date checkout = result.getDate(13);

                OrderPO orderpo = new OrderPO(ordername,username,state,originvalue,truevalue,checkin,checkout,adultonly,peoplenum) {};
                hotelOrderList.add(orderpo);
            }
        } catch (SQLException e) {// TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return hotelOrderList;
    };
    //根据状态查找订单
    public ArrayList<OrderPO> stateFind(StateOfOrder state) throws RemoteException{
        int s = this.getStateNum(state);
        String sqlGeneral = "SELECT *FROM OrderGeneral WHERE state='" +String.valueOf(s)+ "'";
        ResultSet result = db.query(sqlGeneral);
        ArrayList<OrderPO> stateOrderList = new ArrayList<OrderPO>();
        try {
            while (result.next()) {
                // 订单编号 用户编号 酒店编号 订单状态
                // 入住人数 是否有儿童 原价 折后 促销策略
                // 评价 评分 入住、退房时间 房间记录存储数量
                String ordername = result.getString(1);
                String username = result.getString(2);
                String hotelname = result.getString(3);

                double truevalue = result.getDouble(8);
                Date checkin = result.getDate(12);
                Date checkout = result.getDate(13);

                OrderPO orderpo = new OrderPO(ordername,username,hotelname,state,truevalue,checkin,checkout) {};
                stateOrderList.add(orderpo);
            }
        } catch (SQLException e) {// TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return stateOrderList;
    };
    //新建订单
    public ResultMessage insert(OrderPO orderpo) throws RemoteException{

        String orderid = orderpo.getOrderid();
        String userid = orderpo.getUserid();
        String hotelid = orderpo.getHotelid();
        StateOfOrder state = StateOfOrder.unexecuted;
        ArrayList<RoomNormVO> norm = orderpo.getRooms();
        double[] roomPrices = orderpo.getRoomPrices();
        int[] numbers = orderpo.getNumbers();
        double originvalue = orderpo.getOriginvalue();
        double truevalue = orderpo.getTrueValue();
        String promotion =  orderpo.getPromotion();
        String comment = "";
        int grade = 0;
        int numOfPeople = orderpo.getNumOfPeople();
        boolean adultOnly = orderpo.getAdultOnly();
        int adult = 0;//only adult
        if (adultOnly==false)
            adult = 1;
        int limit = norm.size();

        db.executeSql("USE Test");
        for(int i=0;i<numbers.length;i++) {
            String insertOrdersql = "INSERT INTO OrderRooms VALUES(orderid,roomType tinyint," + String.valueOf(norm.get(i).price)+","
                    +String.valueOf(roomPrices[i])+ ","+String.valueOf(numbers[i])+"promotion varchar（20）"+")";
            db.executeSql(insertOrdersql);
        }
        String insertRoomSql = "INSERT INTO OrderGeneral VALUES('"+orderid+"','"+userid+"','"+hotelid+"',1,"
                +String.valueOf(numOfPeople)+ ","+String.valueOf(adult)+","+String.valueOf(originvalue)+","+String.valueOf(truevalue)+",'"+promotion+"'," +
                "null,0,null,null,"+String.valueOf(limit)+")";
        db.executeSql(insertRoomSql);

        return ResultMessage.succeed;
    }
    //删除订单  public ResultMessage delete(String orderid) throws RemoteException{};

    //订单状态更新
    public ResultMessage stateUpdate(String orderid,StateOfOrder newstate) throws RemoteException{
        int s = this.getStateNum(newstate);
        String stateupdateSql = "UPDATE OrderGeneral SET state=" +String.valueOf(s)+" WHERE orderID='"+orderid+"'";
        db.executeSql(stateupdateSql);
        return ResultMessage.succeed;
    }
    //评价订单
    public ResultMessage commentUpdate(String orderid, double grade, String comment) throws RemoteException{
        String updatecommentSql = "UPDATE OrderGeneral SET grade="+String.valueOf(grade)+
                ",comment='"+comment+"' WHERE orderID='"+orderid+"'";
        db.executeSql(updatecommentSql);
        return ResultMessage.succeed;
    }
    //订单实际离开时间更新
    public ResultMessage leaveUpdate(String orderid,Date leavetime) throws RemoteException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str=sdf.format(leavetime);
        String leavetimeupdateSql = "UPDATE OrderGeneral SET checkOut='"+str+"' WHERE orderID='"+orderid+"'";
        db.executeSql(leavetimeupdateSql);
        return ResultMessage.succeed;
    }

    public StateOfOrder getState(int s) {
        StateOfOrder state;
        switch (s){
            case 1:state = StateOfOrder.unexecuted;
                break;
            case 2:state = StateOfOrder.executed;
                break;
            case 3:state = StateOfOrder.abnormal;
                break;
            case 4:state = StateOfOrder.canceled;
                break;
            default:state = null;
        }
        return state;
    }
    public int getStateNum(StateOfOrder state){
        int s;
        if(state==StateOfOrder.unexecuted)
            s = 1;
        else if(state==StateOfOrder.executed)
            s = 2;
        else if(state==StateOfOrder.abnormal)
            s = 3;
        else
            s = 4;

        return s;
    }
}
