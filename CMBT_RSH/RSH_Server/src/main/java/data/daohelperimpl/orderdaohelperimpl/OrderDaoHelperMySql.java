package data.daohelperimpl.orderdaohelperimpl;

import constant.ResultMessage;
import constant.StateOfOrder;
import data.daohelper.OrderDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.OrderPO;
import vo.RoomNormVO;

import java.rmi.RemoteException;
import java.sql.Time;
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
        // 房间数量
        db.executeSql("CREATE TABLE if not exists OrderRooms(orderID char(26)," +
                "roomType varchar(10),originPrice double,truePrice double," +
                "roomNum tinyint)");
        // 订单编号 用户编号
        // 用户姓名 酒店编号 酒店名称 订单状态
        // 入住人数 是否有儿童 原价 折后 促销策略
        // 评价 评分 预计入住、退房时间 酒店最晚时间
        // 实际入住、退房时间 订单生成时间 撤销订单时间 撤销异常时间
        db.executeSql("CREATE TABLE if not exists OrderGeneral(orderID char(26),userID char(11)," +
                "userName char(10), hotelID char(10), hotelName char(10), state tinyint," +
                "peopleNum tinyint,withChild tinyint,originValue double,trueValue double,promotion varchar(20)," +
                "comment varchar(30),grade tinyint,checkIn datetime,checkOut datetime,hotelDDL time" +
                "bornDate date,actCheckIn datetime,actCheckOut datetime,cancelTime datetime,cancelAbTime datetime)");
    }
    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS OrderGeneral");
        db.executeSql("DROP TABLE IF EXISTS OrderRooms ");
    }
    // 根据订单编号查找订单(返回详情)
    public OrderPO searchByID(String orderID) throws RemoteException {
        db.executeSql("USE OurData");
        if (this.checkExistence(orderID) == ResultMessage.idNotExist)
            return null;
        String getDetailSql = "SELECT *FROM OrderGeneral WHERE orderID='" + orderID + "' LIMIT 1";
        ResultSet result = db.query(getDetailSql);

        return this.transformResultSetToPOList(result).get(0);
    }
    // 根据用户、酒店编号查找订单
    public ArrayList<OrderPO> seachByUserWithHotel(String userID,String hotelID)throws RemoteException{}
    // 根据用户编号查找订单
    public ArrayList<OrderPO> searchByUser(String userID) throws RemoteException {
        db.executeSql("USE OurData");

        String generalSql = "SELECT *FROM OrderGeneral WHERE userID='" + userID + "'";
        ResultSet result = db.query(generalSql);

        return this.transformResultSetToPOList(result);
    }
    // 根据酒店编号查找订单
    public ArrayList<OrderPO> searchByHotel(String hotelID) throws RemoteException{
        db.executeSql("USE OurData");

        String generalSql = "SELECT *FROM OrderGeneral WHERE hotelID = '" + hotelID + "'";
        ResultSet result = db.query(generalSql);

        return this.transformResultSetToPOList(result);
    }
    // 根据状态查找订单
    public ArrayList<OrderPO> searchByState(StateOfOrder state) throws RemoteException{
        db.executeSql("USE OurData");

        String generalSql = "SELECT *FROM OrderGeneral WHERE state=" +String.valueOf(state.ordinal());
        ResultSet result = db.query(generalSql);

        return this.transformResultSetToPOList(result);
    }
    // 插入订单
    public ResultMessage insert(OrderPO orderPO) throws RemoteException{
        String orderID = orderPO.getOrderID();
        String userID = orderPO.getUserID();
        String userName = orderPO.getUserName();
        String hotelID = orderPO.getHotelID();
        String hotelName= orderPO.getHotelName();

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
        String hotelDDL = orderPO.getHotelDDL();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String checkin = sdf.format(checkIn);
        String checkout = sdf.format(checkOut);
        SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
        String borndate = sdff.format(bornDate);


        db.executeSql("USE Ourdata");
        String insertRoomSql = "INSERT INTO OrderRooms VALUES('"+orderID+"','"+room.getRoomType()+"',"
                +String.valueOf(room.getPrice())+","+String.valueOf(roomPrice)+","+
                String.valueOf(roomNumber)+")";
        db.executeSql(insertRoomSql);

        String insertOrderSql = "INSERT INTO OrderGeneral VALUES('"+orderID+"','"+userID+"','"+
                userName+"','"+hotelID+"','"+hotelName+"',0," +String.valueOf(peopleNum)+ ","+String.valueOf(withchild)+
                ","+String.valueOf(originValue)+","+String.valueOf(trueValue)+",'"+promotion+"'," +
                "null,null,"+checkin+","+checkout+","+borndate+",'"+hotelDDL+"',null,null,null,null)";
        db.executeSql(insertOrderSql);

        return ResultMessage.succeed;
    }

    // 订单状态更新
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
        String stateUpdateSql = "UPDATE OrderGeneral SET state=" +String.valueOf(newState.ordinal())+
                " WHERE orderID='"+orderID+"' LIMIT 1";
        db.executeSql(stateUpdateSql);
        return ResultMessage.succeed;
    }
    // 评价订单
    public ResultMessage commentUpdate(String orderID, int grade, String comment) throws RemoteException{
        db.executeSql("USE OurData");
        if(this.checkExistence(orderID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        String updateCommentSql = "UPDATE OrderGeneral SET grade="+String.valueOf(grade)+
                ",comment='"+comment+"' WHERE orderID='"+orderID+"' LIMIT 1";
        db.executeSql(updateCommentSql);
        return ResultMessage.succeed;
    }
    // 订单实际入住时间更新
    public ResultMessage actCheckInUpdate(String orderID, Date actCheckIn) throws RemoteException{}
    //订单实际离开时间更新
    public ResultMessage actCheckOutUpdate(String orderID,Date actCheckOut) throws RemoteException{
        db.executeSql("USE OurData");
        if(this.checkExistence(orderID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String actcheckout = sdf.format(actCheckOut);
        String leavetimeupdateSql = "UPDATE OrderGeneral SET actCheckOut='"+actcheckout+"' WHERE orderID='"+orderID+"' LIMIT 1";
        db.executeSql(leavetimeupdateSql);
        return ResultMessage.succeed;
    }
    // 订单撤销时间更新
    public ResultMessage cancelTimeUpdate(String orderID, Date cancelTime) throws RemoteException{}
    // 订单撤销异常时间更新
    public ResultMessage cancelAbTimeUpdate(String orderID, Date cancelAbTime) throws RemoteException{}


    // 检查账号是否存在
    private ResultMessage checkExistence(String orderID){
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
    // 完成从ResultSet到POList的操作
    private ArrayList<OrderPO> transformResultSetToPOList(ResultSet result) {
        ArrayList<OrderPO> selectedList = new ArrayList<OrderPO>();

        try {
            while (result.next()) {
                String orderID = result.getString("orderID");
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
                String hotelDDL = result.getString("hotelDDL");
                Date bornTime = result.getDate("bornDate");
                Date actCheckIn = result.getTimestamp("actCheckIn");
                Date actCheckOut = result.getTimestamp("actCheckOut");
                Date cancelTime = result.getTimestamp("cancelTime");
                Date cancelAbTime = result.getTimestamp("cancelAbTime");

                RoomNormVO roomVO = null;
                String getRoomSql = "SELECT *FROM OrderRooms WHERE orderID='" + orderID + "' LIMIT 1" ;
                ResultSet resultRoom = db.query(getRoomSql);
                int roomTruePrice = 0;
                int roomNum = 0;
                try{
                    while (resultRoom.next()) {
                        roomVO = new RoomNormVO(resultRoom.getString("orderID").substring(0, 10),
                                resultRoom.getString("roomType"), resultRoom.getDouble("originPrice"));
                        roomTruePrice = resultRoom.getInt("truePrice");
                        roomNum = resultRoom.getInt("roomNum");
                        String promo = promotion + "\n" + resultRoom.getString("promotion");
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                    return null;
                }
                if(roomVO!=null) {
                    OrderPO orderpo = new OrderPO(orderID, userID, userName, hotelID, hotelName, state,
                            roomVO, roomTruePrice, roomNum, peopleNum, withChild,
                            originValue, trueValue, promotion,
                            comment, grade, checkIn, checkOut, hotelDDL,
                            bornTime, actCheckIn, actCheckOut, cancelTime, cancelAbTime);

                    selectedList.add(orderpo);
                }
            }
            return selectedList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
