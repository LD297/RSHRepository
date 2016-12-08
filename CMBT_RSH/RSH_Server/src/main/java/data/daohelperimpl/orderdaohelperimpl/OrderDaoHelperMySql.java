package data.daohelperimpl.orderdaohelperimpl;

import constant.ResultMessage;
import constant.StateOfOrder;
import data.daohelper.OrderDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.OrderPO;
import vo.RoomNormVO;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by sky-PC on 2016/11/27.
 */
public class OrderDaoHelperMySql implements OrderDaoHelper{

    private DBHelper db = new DBHelper();

    public void init(){

        // 订单编号
        // 房间类型 房间原价 房间现价
        // 房间数量 促销策略
        db.executeSql("CREATE TABLE if not exists OrderRooms(orderID char(26)," +
                "roomType varchar(10),originPrice double,truePrice double," +
                "roomNum tinyint,promotion varchar(20))");
        // 订单编号 用户编号 用户姓名 酒店编号 订单状态
        // 入住人数 是否有儿童 原价 折后 促销策略
        // 评价 评分 预计入住、退房时间
        // 实际入住、退房时间 订单生成时间
        db.executeSql("CREATE TABLE if not exists OrderGeneral(orderID char(26),userID char(9),userName char(10),hotelID char(10),state tinyint," +
                "numOfPeople tinyint,adultOnly tinyint,originalValue double,trueValue double,promotion varchar(20)," +
                "comment varchar(30),grade tinyint,checkIn datetime,checkOut datetime," +
                "ACheckIn datetime,ACheckOut datetime，OrderBorn date)");
    }
    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXIST OrderGeneral");
        db.executeSql("DROP TABLE IF EXIST OrderRooms ");
    }
    //根据订单编号查找订单
    public OrderPO find(String orderid) throws RemoteException{
        db.executeSql("USE OurData");

        String sqlDetail = "SELECT *FROM OrderGeneral WHERE orderID='"+orderid+"'LIMIT 1";
        ResultSet result = db.query(sqlDetail);
        try {
            while(result.next()) {
                String userid = result.getString(2);
                String username = result.getString(3);
                String hotelid = result.getString(4);

                StateOfOrder state = StateOfOrder.values()[result.getInt(5)];
//unexecuted,executed,abnormal,canceled
                int peoplenum = result.getInt(6);
                Boolean adultonly = result.getBoolean(7);
                double originvalue = result.getDouble(8);
                double truevalue = result.getDouble(9);
                String promotion = result.getString(10);
                String comment = result.getString(11);
                int grade = result.getInt(12);

                Date checkin = result.getTimestamp(12);
                Date checkout = result.getTimestamp(13);
                Date Acheckin = result.getTimestamp(15);
                Date Acheckout = result.getTimestamp(16);
                Date borntime = result.getDate(17);
                RoomNormVO roomvo;

                String sqlRoom = "SELECT *FROM OrderRooms WHERE orderID='" + orderid + "'LIMIT 1" ;
                ResultSet resultRoom = db.query(sqlRoom);
                try{
                    while (resultRoom.next()) {
                        roomvo = new RoomNormVO(resultRoom.getString(1).substring(0, 10), resultRoom.getString(2), resultRoom.getDouble(3));
                        OrderPO orderpo = new OrderPO(orderid, userid, username, state,
                                originvalue, truevalue,roomvo, result.getInt(5),
                                checkin, checkout,Acheckin,Acheckout,borntime,
                                adultonly, peoplenum) ;
                        return orderpo;
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            return null;
        } catch (SQLException e)
        {e.printStackTrace();
            return null;
        }
    }
    //根据用户编号查找订单
    public ArrayList<OrderPO> userFind(String userid) throws RemoteException {
        db.executeSql("USE OurData");

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
        db.executeSql("USE OurData");

        String sqlGeneral = "SELECT *FROM OrderGeneral WHERE userID = '" + hotelid + "'";
        ResultSet result = db.query(sqlGeneral);
        ArrayList<OrderPO> hotelOrderList = new ArrayList<OrderPO>();
        try {
            while (result.next()) {
                // 订单编号 用户编号 用户姓名 酒店编号 订单状态
                // 入住人数 是否有儿童 原价 折后 促销策略
                // 评价 评分 预计入住、退房时间
                // 实际入住、退房时间 订单生成时间
                String orderid = result.getString(1);
                String userid = result.getString(2);
                String username = result.getString(3);

                StateOfOrder state = StateOfOrder.values()[result.getInt(5)];
//unexecuted,executed,abnormal,canceled
                int peoplenum = result.getInt(6);
                Boolean adultonly = result.getBoolean(7);
                double originvalue = result.getDouble(8);
                double truevalue = result.getDouble(9);

                Date checkin = result.getTimestamp(13);
                Date checkout = result.getTimestamp(14);
                Date Acheckin = result.getTimestamp(15);
                Date Acheckout = result.getTimestamp(16);
                Date borntime = result.getDate(17);
                RoomNormVO roomvo;

                String sqlRoom = "SELECT *FROM OrderRooms WHERE orderID='" + orderid + "'LIMIT 1" ;
                ResultSet resultRoom = db.query(sqlRoom);
                try{
                    while (resultRoom.next()) {
                        roomvo = new RoomNormVO(resultRoom.getString(1).substring(0, 10), resultRoom.getString(2), resultRoom.getDouble(3));
                        OrderPO orderpo = new OrderPO(orderid, userid, username, state,
                                originvalue, truevalue,roomvo, result.getInt(5),
                                checkin, checkout,Acheckin,Acheckout,borntime,
                                adultonly, peoplenum) ;
                        hotelOrderList.add(orderpo);
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            return hotelOrderList;
        } catch (SQLException e)
        {e.printStackTrace();
            return null;
        }
    };
    //根据状态查找订单
    public ArrayList<OrderPO> stateFind(StateOfOrder state) throws RemoteException{
        db.executeSql("USE OurData");

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
        db.executeSql("USE OurData");

        String orderid = orderpo.getOrderid();
        String userid = orderpo.getUserid();
        String hotelid = orderpo.getHotelid();
        StateOfOrder state = StateOfOrder.unexecuted;
        RoomNormVO norm = orderpo.getRoom();
        double roomPrice = orderpo.getRoomPrice();
        int roomNumber = orderpo.getRoomNumber();
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

        db.executeSql("USE Ourdata");
        String insertOrdersql = "INSERT INTO OrderRooms VALUES(orderid,roomType tinyint," + String.valueOf(norm.price)+","
                    +String.valueOf(roomPrice)+ ","+String.valueOf(roomNumber)+"promotion varchar（20）"+")";
            db.executeSql(insertOrdersql);

        String insertRoomSql = "INSERT INTO OrderGeneral VALUES('"+orderid+"','"+userid+"','"+hotelid+"',1,"
                +String.valueOf(numOfPeople)+ ","+String.valueOf(adult)+","+String.valueOf(originvalue)+","+String.valueOf(truevalue)+",'"+promotion+"'," +
                "null,0,null,null";
        db.executeSql(insertRoomSql);

        return ResultMessage.succeed;
    }
    //删除订单  public ResultMessage delete(String orderid) throws RemoteException{};

    //订单状态更新
    public ResultMessage stateUpdate(String orderid,StateOfOrder newstate) throws RemoteException{
        db.executeSql("USE OurData");

        int s = this.getStateNum(newstate);
        String stateupdateSql = "UPDATE OrderGeneral SET state=" +String.valueOf(s)+" WHERE orderID='"+orderid+"'";
        db.executeSql(stateupdateSql);
        return ResultMessage.succeed;
    }
    //评价订单
    public ResultMessage commentUpdate(String orderid, int grade, String comment) throws RemoteException{
        db.executeSql("USE OurData");

        String updatecommentSql = "UPDATE OrderGeneral SET grade="+String.valueOf(grade)+
                ",comment='"+comment+"' WHERE orderID='"+orderid+"'";
        db.executeSql(updatecommentSql);
        return ResultMessage.succeed;
    }
    //订单实际离开时间更新
    public ResultMessage leaveUpdate(String orderid,Date leavetime) throws RemoteException{
        db.executeSql("USE OurData");

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str=sdf.format(leavetime);
        String leavetimeupdateSql = "UPDATE OrderGeneral SET checkOut='"+str+"' WHERE orderID='"+orderid+"'";
        db.executeSql(leavetimeupdateSql);
        return ResultMessage.succeed;
    }

    public StateOfOrder getState(int s) {
        StateOfOrder state=StateOfOrder.values()[s];
        return state;
    }
    public int getStateNum(StateOfOrder state){
        return state.ordinal();
    }
}
