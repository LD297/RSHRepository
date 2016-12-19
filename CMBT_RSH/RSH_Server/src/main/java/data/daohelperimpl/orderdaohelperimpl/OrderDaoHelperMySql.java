package data.daohelperimpl.orderdaohelperimpl;

import constant.ResultMessage;
import constant.StateOfOrder;
import data.daohelper.OrderDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.OrderPO;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
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

        // 订单编号 用户编号
        // 用户姓名 酒店编号 酒店名称 订单状态 房间类型 房间价格 房间数量
        // 入住人数 是否有儿童 原价 折后 促销策略
        // 评价 评分 预计入住、退房时间 酒店最晚时间
        // 实际入住、退房时间 订单生成时间 撤销订单时间 撤销异常时间
        db.executeSql("CREATE TABLE if not exists OrderGeneral(orderID char(26),userID char(11)," +
                "userName char(10), hotelID char(10), hotelName char(10), state tinyint,roomType char(10),roomPrice double,roomNum tinyint," +
                "peopleNum tinyint,withChild tinyint,originValue double,trueValue double,promotion varchar(20)," +
                "comment tinytext,grade tinyint,checkIn date,checkOut date,hotelDDL char(8)," +
                "bornDate date,actCheckIn datetime,actCheckOut datetime,cancelTime datetime,cancelAbTime datetime)");
    }
    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS OrderGeneral");
    }
    // 遍历得到更新订单（自动置为异常）
    private void updateAll(){
        db.executeSql("USE OurData");

        String generalSql = "SELECT *FROM OrderGeneral";
        ResultSet result = db.query(generalSql);
        ArrayList<OrderPO> originList =  this.transformResultSetToPOList(result);
        Date instance = new Date();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for(int i=0;i<originList.size();i++){
            if(originList.get(i).getState()==StateOfOrder.unexecuted){
                String orderID = originList.get(i).getOrderID();
                String DDLtime = originList.get(i).getHotelDDL();
                Date DDLdate = originList.get(i).getCheckIn();
                String ddldate = sdf.format(DDLdate);
                try{
                    Date ddlTime = df.parse(ddldate+" "+DDLtime);
                    if(ddlTime.getTime()>instance.getTime())
                        this.stateUpdate(orderID,StateOfOrder.abnormal);
                }catch (ParseException e){
                    e.printStackTrace();
                    return ;
                }catch(RemoteException e){
                    e.printStackTrace();
                    return;
                }
            }
         }
    }



    // 根据订单编号查找订单(返回详情)
    public OrderPO searchByID(String orderID) throws RemoteException {
        db.executeSql("USE OurData");
        if (this.checkExistence(orderID) == ResultMessage.idNotExist)
            return null;

        this.updateAll();
        String getDetailSql = "SELECT *FROM OrderGeneral WHERE orderID='" + orderID + "' LIMIT 1";
        ResultSet result = db.query(getDetailSql);

        return this.transformResultSetToPOList(result).get(0);
    }
    // 根据用户、酒店编号查找订单
    public ArrayList<OrderPO> searchByUserWithHotel(String userID,String hotelID)throws RemoteException{
        db.executeSql("USE OurData");

        this.updateAll();
        String generalSql = "SELECT *FROM OrderGeneral WHERE userID='" + userID + "' and hotelID='"+hotelID+"'";
        ResultSet result = db.query(generalSql);

        return this.transformResultSetToPOList(result);
    }
    // 根据用户编号查找订单
    public ArrayList<OrderPO> searchByUser(String userID) throws RemoteException {
        db.executeSql("USE OurData");

        this.updateAll();
        String generalSql = "SELECT *FROM OrderGeneral WHERE userID='" + userID + "'";
        ResultSet result = db.query(generalSql);

        return this.transformResultSetToPOList(result);
    }
    // 根据酒店编号查找订单
    public ArrayList<OrderPO> searchByHotel(String hotelID) throws RemoteException{
        db.executeSql("USE OurData");
        
        this.updateAll();
        String generalSql = "SELECT *FROM OrderGeneral WHERE hotelID = '" + hotelID + "'";
        ResultSet result = db.query(generalSql);

        return this.transformResultSetToPOList(result);
    }
    // 根据状态查找订单
    public ArrayList<OrderPO> searchByState(StateOfOrder state) throws RemoteException{
        db.executeSql("USE OurData");

        this.updateAll();
        String generalSql = "SELECT *FROM OrderGeneral WHERE state=" +String.valueOf(state.ordinal());
        ResultSet result = db.query(generalSql);

        return this.transformResultSetToPOList(result);
    }
    // 插入订单
    public ResultMessage insert(OrderPO orderPO) throws RemoteException{
        String userID = orderPO.getUserID();
        String userName = orderPO.getUserName();
        String hotelID = orderPO.getHotelID();
        String hotelName= orderPO.getHotelName();

        String roomType = orderPO.getRoom();
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
        Date bornDate = orderPO.getGenerationDate();
        String hotelDDL = orderPO.getHotelDDL();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String checkin = sdf.format(checkIn);
        String checkout = sdf.format(checkOut);
        SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String borndate = sdff.format(bornDate);

        String orderID = this.calculateOrderID(borndate,hotelID);

        db.executeSql("USE Ourdata");
        String insertOrderSql = "INSERT INTO OrderGeneral VALUES('"+orderID+"','"+userID+"','"+
                userName+"','"+hotelID+"','"+hotelName+"',0,'"+roomType+"',"+String.valueOf(roomPrice)+","+String.valueOf(roomNumber) +","+String.valueOf(peopleNum)+ ","+String.valueOf(withchild)+
                ","+String.valueOf(originValue)+","+String.valueOf(trueValue)+",'"+promotion+"'," +
                "null,null,'"+checkin+"','"+checkout+"','"+hotelDDL+"','"+borndate+"',null,null,null,null)";
        db.executeSql(insertOrderSql);

        return ResultMessage.succeed;
    }

    // 订单状态更新
    public ResultMessage stateUpdate(String orderID,StateOfOrder newState) throws RemoteException{
        db.executeSql("USE OurData");
        if(this.checkExistence(orderID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;
        
        this.updateAll();
        String isStateChangedSql = "SELECT state FROM OrderGeneral WHERE orderID='"+orderID+"' LIMIT 1";
        ResultSet result = db.query(isStateChangedSql);
        try{
            while(result.next())
                if(result.getInt(1)==newState.ordinal())
                    return ResultMessage.noChangeMade;
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
    public ResultMessage actCheckInUpdate(String orderID, Date actCheckIn) throws RemoteException{
        db.executeSql("USE OurData");
        if(this.checkExistence(orderID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String actcheckin = sdf.format(actCheckIn);
        String cometimeupdateSql = "UPDATE OrderGeneral SET actCheckIn='"+actcheckin+"' WHERE orderID='"+orderID+"' LIMIT 1";
        db.executeSql(cometimeupdateSql);
        return ResultMessage.succeed;
    }
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
    public ResultMessage cancelTimeUpdate(String orderID, Date cancelTime) throws RemoteException{
        db.executeSql("USE OurData");
        if(this.checkExistence(orderID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String canceltime = sdf.format(cancelTime);
        String canceltimeupdateSql = "UPDATE OrderGeneral SET cancelTime='"+canceltime+"' WHERE orderID='"+orderID+"' LIMIT 1";
        db.executeSql(canceltimeupdateSql);
        return ResultMessage.succeed;
    }
    // 订单撤销异常时间更新
    public ResultMessage cancelAbTimeUpdate(String orderID, Date cancelAbTime) throws RemoteException{
        db.executeSql("USE OurData");
        if(this.checkExistence(orderID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String cancelabtime = sdf.format(cancelAbTime);
        String cancelabtimeupdateSql = "UPDATE OrderGeneral SET cancelAbtime='"+cancelabtime+"' WHERE orderID='"+orderID+"' LIMIT 1";
        db.executeSql(cancelabtimeupdateSql);
        return ResultMessage.succeed;
    }

    // 生成订单编号
    private String calculateOrderID(String bornDate,String hotelID){
    	String orderID = bornDate.substring(0,10)+hotelID;
    	
    	db.executeSql("USE OurData");
    	String getSelectedNumSql = "SELECT orderID FROM OrderGeneral";
    	ResultSet result = db.query(getSelectedNumSql);
    	int num = 1;
    	try{
    		while(result.next()){
    			if(result.getString(1).substring(0, 20).equals(orderID))
    				num++;
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    		return null;
    	}
    	String sort = String.format("%6d", num).replace(" ", "0");
    	
    	return orderID+sort;
    }
    // 检查账号是否存在
    private ResultMessage checkExistence(String orderID){
    	db.executeSql("USE OurData");
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
                String roomType = result.getString("roomType");
                double roomPrice = result.getDouble("roomPrice");
                int roomNum = result.getInt("roomNum");
                int peopleNum = result.getInt("peopleNum");
                boolean withChild = result.getBoolean("withChild");
                double originValue = result.getDouble("originValue");
                double trueValue = result.getDouble("trueValue");
                String promotion = result.getString("promotion");
                String comment = result.getString("comment");
                int grade = result.getInt("grade");

                Date checkIn = result.getDate("checkIn");
                Date checkOut = result.getDate("checkOut");
                String hotelDDL = result.getString("hotelDDL");
                Date bornTime = result.getTimestamp("bornDate");
                Date actCheckIn = result.getTimestamp("actCheckIn");
                Date actCheckOut = result.getTimestamp("actCheckOut");
                Date cancelTime = result.getTimestamp("cancelTime");
                Date cancelAbTime = result.getTimestamp("cancelAbTime");


                OrderPO orderpo = new OrderPO(orderID, userID, userName, hotelID, hotelName, state,
                        roomType, roomPrice, roomNum, peopleNum, withChild,
                        originValue, trueValue, promotion,
                        comment, grade, checkIn, checkOut, hotelDDL,
                        bornTime, actCheckIn, actCheckOut, cancelTime, cancelAbTime);

                selectedList.add(orderpo);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return selectedList;
    }
}
