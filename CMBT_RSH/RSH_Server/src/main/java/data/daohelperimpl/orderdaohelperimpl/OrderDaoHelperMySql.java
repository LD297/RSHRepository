package data.daohelperimpl.orderdaohelperimpl;

import constant.ResultMessage;
import constant.StateOfOrder;
import data.daohelper.OrderDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.OrderPO;
import vo.RoomNormVO;

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
        // 房间数量 房间促销策略
        db.executeSql("CREATE TABLE if not exists OrderRooms(orderID char(26)," +
                "roomType varchar(10),originPrice double,truePrice double," +
                "roomNum tinyint,promotion varchar(20))");
        // 订单编号 用户编号 用户姓名 酒店编号 订单状态
        // 入住人数 是否有儿童 原价 折后 促销策略
        // 评价 评分 预计入住、退房时间
        // 实际入住、退房时间 订单生成时间 撤销订单时间 撤销异常时间
        db.executeSql("CREATE TABLE if not exists OrderGeneral(" +
                "orderID char(26),userID char(11),userName char(10),hotelID char(10),state tinyint," +
                "peopleNum tinyint,withChild tinyint,originValue double,trueValue double,promotion varchar(20)," +
                "comment varchar(30),grade tinyint,checkIn datetime,checkOut datetime," +
                "bornDate date,actCheckIn datetime,actCheckOut datetime,cancelTime,datetime,cancelAbTime datetime)");
    }
    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS OrderGeneral");
        db.executeSql("DROP TABLE IF EXISTS OrderRooms ");
    }
    //根据订单编号查找订单(返回详情)
    public OrderPO find(String orderID) throws RemoteException{
        db.executeSql("USE OurData");
        if(this.checkExistence(orderID)==ResultMessage.idNotExist)
            return null;
        String getDetailSql = "SELECT *FROM OrderGeneral WHERE orderID='"+orderID+"' LIMIT 1";
        ResultSet result = db.query(getDetailSql);
        try {
            while(result.next()) {
                String userID = result.getString("userID");
                String userName = result.getString("userName");
                String hotelID = result.getString("hotelID");
                String hotelName = result.getString("hotelName");

                StateOfOrder state = StateOfOrder.values()[result.getInt("state")];
                int peopleNum = result.getInt("peopleNum");
                boolean withChild = result.getBoolean("withChild");
                double originValue = result.getDouble("originValue");
                double trueValue = result.getDouble("trueValue");
                String promotion = result.getString("promotion");
                String comment = result.getString("comment");
                int grade = result.getInt("grade");

                Date checkIn = result.getTimestamp("checkIn");
                Date checkOut = result.getTimestamp("checkOut");
                Date hotelDDL = result.getTimestamp("hotelDDL");
                Date bornTime = result.getDate("bornDate");
                Date actCheckIn = result.getTimestamp("actCheckIn");
                Date actCheckOut = result.getTimestamp("actCheckOut");
                Date cancelTime = result.getTimestamp("cancelTime");
                Date cancelAbTime = result.getTimestamp("cancelAbTime");

                RoomNormVO roomVO;

                String getRoomSql = "SELECT *FROM OrderRooms WHERE orderID='" + orderID + "' LIMIT 1" ;
                ResultSet resultRoom = db.query(getRoomSql);
                try{
                    while (resultRoom.next()) {
                        roomVO = new RoomNormVO(resultRoom.getString("orderID").substring(0, 10),
                                resultRoom.getString("roomType"), resultRoom.getDouble("originPrice"));
                        int roomTruePrice = resultRoom.getInt("truePrice");
                        int roomNum = resultRoom.getInt("roomNum");
                        String promo = promotion+"\n"+resultRoom.getString("promotion");

                        OrderPO orderpo = new OrderPO(orderID, userID, userName, hotelID,hotelName,state,
                                roomVO, roomTruePrice, roomNum, peopleNum, withChild,
                                originValue, trueValue, promo,
                                comment, grade, checkIn, checkOut,hotelDDL,
                                bornTime, actCheckIn, actCheckOut, cancelTime, cancelAbTime) ;

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
    public ArrayList<OrderPO> userFind(String userID) throws RemoteException {
        db.executeSql("USE OurData");

        String generalSql = "SELECT *FROM OrderGeneral WHERE userID='" + userID + "'";
        ResultSet result = db.query(generalSql);
        ArrayList<OrderPO> userOrderList = new ArrayList<OrderPO>();
        try {
            while(result.next()){
                // 订单编号 用户编号 用户姓名
                // 酒店编号 订单状态
                // 入住人数 是否有儿童 原价 折后 促销策略
                // 评价 评分 预计入住、退房时间
                // 实际入住、退房时间 订单生成时间 撤销订单时间 撤销异常时间
                String orderID = result.getString("orderID");
                String hotelID = result.getString("hotelID");
                StateOfOrder stateOfOrder = StateOfOrder.values()[result.getInt("state")];
                double originValue = result.getDouble("originalValue");
                double trueValue = result.getDouble("trueValue");
                Date checkIn = result.getTimestamp("checkIn");
                Date checkOut = result.getTimestamp("checkOut");

                OrderPO orderpo = new OrderPO() {};
                userOrderList.add(orderpo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return userOrderList;
    }
    //根据酒店编号查找订单
    public ArrayList<OrderPO> hotelFind(String hotelID) throws RemoteException{
        db.executeSql("USE OurData");

        String generalSql = "SELECT *FROM OrderGeneral WHERE hotelID = '" + hotelID + "'";
        ResultSet result = db.query(generalSql);
        ArrayList<OrderPO> hotelOrderList = new ArrayList<OrderPO>();
        try {
            while (result.next()) {

                String orderID = result.getString("orderID");
                String userID = result.getString("userID");
                String userName = result.getString("userName");

                StateOfOrder state = StateOfOrder.values()[result.getInt("state")];
                int peopleNum = result.getInt("peopleNum");
                Boolean withChild = result.getBoolean("withChild");
                double originValue = result.getDouble("originValue");
                double trueValue = result.getDouble("trueValue");

                Date bornDate = result.getDate("bornDate");
                Date checkIn = result.getTimestamp("checkIn");
                Date checkOut = result.getTimestamp("checkOut");
                Date actCheckIn = result.getTimestamp("actCheckIn");
                Date actCheckout = result.getTimestamp("actCheckOut");
                RoomNormVO roomvo;

                String getRoomSql = "SELECT *FROM OrderRooms WHERE orderID='" + orderID + "' LIMIT 1" ;
                ResultSet resultRoom = db.query(getRoomSql);
                try{
                    while (resultRoom.next()) {
                        roomvo = new RoomNormVO(resultRoom.getString("orderID").substring(0, 10),
                                resultRoom.getString("roomType"), resultRoom.getDouble("originPrice"));
                        OrderPO orderpo = new OrderPO(orderID, userID, userName, state,
                                roomvo, result.getInt("roomNum"), peopleNum, withChild,
                                originValue, trueValue, checkIn, checkOut,
                                bornDate, actCheckIn, actCheckout) ;
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

        int s = state.ordinal();
        String generalSql = "SELECT *FROM OrderGeneral WHERE state=" +String.valueOf(s);
        ResultSet result = db.query(generalSql);
        ArrayList<OrderPO> stateOrderList = new ArrayList<OrderPO>();
        try {
            while (result.next()) {
                // 订单编号 用户编号 酒店编号 订单状态
                // 入住人数 是否有儿童 原价 折后 促销策略
                // 评价 评分 入住、退房时间 房间记录存储数量
                String orderID = result.getString("orderID");
                String userID = result.getString("userID");
                String hotelID = result.getString("hotelID");

                double trueValue = result.getDouble("trueValue");
                Date checkIn = result.getTimestamp("checkIn");
                Date checkOut = result.getTimestamp("checkOut");

                OrderPO orderpo = new OrderPO() {};
                stateOrderList.add(orderpo);
            }
        } catch (SQLException e) {// TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return stateOrderList;
    };
    //新建订单
    public ResultMessage insert(OrderPO orderPO) throws RemoteException{
        db.executeSql("USE OurData");

        String orderID = orderPO.getOrderID();
        String userID = orderPO.getUserID();
        String userName = orderPO.getUserName();
        String hotelID = orderPO.getHotelID();

        RoomNormVO room = orderPO.getRoom();
        double roomPrice = orderPO.getRoomPrice();
        int roomNumber = orderPO.getRoomNumber();
        double originValue = orderPO.getOriginValue();
        double trueValue = orderPO.getTrueValue();
        String promotion =  orderPO.getPromotion();

        int peopleNum = orderPO.getPeopleNumber();
        boolean withChild = orderPO.getWithChild();
        int withchild = 0;// right -> child along with
        if (withChild==false)
            withchild = 1;
        Date checkIn = orderPO.getCheckIn();
        Date checkOut = orderPO.getCheckOut();
        Date bornDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String checkin = sdf.format(checkIn);
        String checkout = sdf.format(checkOut);
        SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
        String borndate = sdff.format(bornDate);


        db.executeSql("USE Ourdata");
        String insertRoomSql = "INSERT INTO OrderRooms VALUES('"+orderID+"','"+room.getRoomType()+"',"
                +String.valueOf(originValue)+","+String.valueOf(trueValue)+","+
                String.valueOf(roomNumber)+",'"+promotion+"')";
        db.executeSql(insertRoomSql);

        String insertOrderSql = "INSERT INTO OrderGeneral VALUES('"+orderID+"','"+userID+"','"+
                userName+"','"+hotelID+"',0," +String.valueOf(peopleNum)+ ","+String.valueOf(withchild)+
                ","+String.valueOf(originValue)+","+String.valueOf(trueValue)+",'"+promotion+"'," +
                "null,null,"+checkin+","+checkout+","+borndate+"null,null,null,null";
        db.executeSql(insertOrderSql);

        return ResultMessage.succeed;
    }
    //删除订单  public ResultMessage delete(String orderid) throws RemoteException{};

    //订单状态更新
    public ResultMessage stateUpdate(String orderID,StateOfOrder newState) throws RemoteException{
        db.executeSql("USE OurData");
        if(this.checkExistence(orderID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;
        String isStateChangedSql = "SELECT state FROM OrderGeneral WHERE orderID='"+orderID+"' LIMIT 1";
        ResultSet result = db.query(isStateChangedSql);
        try{
            while(result.next())
                if(result.getInt(1)==newState.ordinal())
                    return ResultMessage.fail;/////////////////////nochangemade
        }catch (SQLException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        int s = newState.ordinal();
        String stateUpdateSql = "UPDATE OrderGeneral SET state=" +String.valueOf(s)+" WHERE orderID='"+orderID+"' LIMIT 1";
        db.executeSql(stateUpdateSql);
        return ResultMessage.succeed;
    }
    //评价订单
    public ResultMessage commentUpdate(String orderID, int grade, String comment) throws RemoteException{
        db.executeSql("USE OurData");
        if(this.checkExistence(orderID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        String updateCommentSql = "UPDATE OrderGeneral SET grade="+String.valueOf(grade)+
                ",comment='"+comment+"' WHERE orderID='"+orderID+"' LIMIT 1";
        db.executeSql(updateCommentSql);
        return ResultMessage.succeed;
    }
    //订单实际离开时间更新
    public ResultMessage leaveUpdate(String orderID,Date actCheckOut) throws RemoteException{
        db.executeSql("USE OurData");
        if(this.checkExistence(orderID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String actcheckout = sdf.format(actCheckOut);
        String leavetimeupdateSql = "UPDATE OrderGeneral SET actCheckOut='"+actcheckout+"' WHERE orderID='"+orderID+"' LIMIT 1";
        db.executeSql(leavetimeupdateSql);
        return ResultMessage.succeed;
    }

    public ResultMessage checkExistence(String orderID){
        String checkExistenceSql = "SELECT orderID FROM OrderGeneral";
        ResultSet result = db.query(checkExistenceSql);
        try{
            while(result.next())
                if(result.getString(1).equals(orderID))
                    return ResultMessage.idAlreadyExist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ResultMessage.idNotExist;
    }

}
