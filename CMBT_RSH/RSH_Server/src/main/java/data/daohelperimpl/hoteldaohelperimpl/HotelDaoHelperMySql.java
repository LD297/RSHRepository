package data.daohelperimpl.hoteldaohelperimpl;

import data.daohelper.HotelDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.*;

import constant.ResultMessage;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by a297 on 16/11/27.
 */
public class HotelDaoHelperMySql implements HotelDaoHelper {
    private DBHelper db = new DBHelper();

    public void init(){

        db.executeSql("USE OurData");
        // 编号 密码 电话 名称
        // 地址 商圈 简介 设施
        // 星级 评分 最晚入住时间 评论人数 房间类型数量
        db.executeSql("CREATE TABLE if not exists HotelInfo(hotelID char(10),password varchar(20),phoneNumber bigint,name varchar(15)," +
                "address varchar(30),businessArea varchar(10),briefIntro tinytext,facility varchar(20)," +
                "level tinyint,grade double,latestCheckinTime char(8),commentNum int,roomTypeNum tinyint)");
        // 酒店 类型 总量
        // 价格 是否特色 可用数量日期列表
        db.executeSql("CREATE TABLE if not exists RoomInfo(hotelID char(10),roomType varchar(10),amountTotal int,"
                +"price double,basicOrSpecial tinyint,aList text)");
        // 酒店账号 用户账号 评分（0，1，2，3，4，5） 评论
        db.executeSql("CREATE TABLE if not exists COMMENT(hotelID char(10),userID char(26),grade tinyint,comment tinytext)");

    }
    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS HotelInfo");
        db.executeSql("DROP TABLE IF EXISTS RoomInfo");
        db.executeSql("DROP TABLE IF EXISTS COMMENT");
    }
    // 添加评论、评分
    public ResultMessage addComment(String hotelID, String userID, int grade,String comment)throws RemoteException {
        db.executeSql("USE OurData");

        if(this.checkExistence(hotelID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        String getCommentNumSql = "SELECT commentNum from HotelInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet result = db.query(getCommentNumSql);
        int commentNum = -1;
        try{
            while(result.next())
                commentNum = result.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }

        if(commentNum>=0){
            String updateCommentNumSql = "UPDATE HotelInfo SET commentNum="+String.valueOf(commentNum+1)+
                    " WHERE hotelID='"+hotelID+"' LIMIT 1";
            db.executeSql(updateCommentNumSql);

            String addCommentSql = "INSERT INTO COMMENT VALUES('"+hotelID+"','"+userID+"',"+grade+",'"+comment+"')";
            db.executeSql(addCommentSql);
            return ResultMessage.succeed;
        }
        else
            return ResultMessage.fail;
    }

    // 根据账号得到酒店信息
    public HotelPO getHotel(String hotelid)throws RemoteException {
        db.executeSql("USE OurData");

        String getHotelSql = "SELECT *FROM HotelInfo WHERE hotelID='"+hotelid+"' LIMIT 1";
        ResultSet result = db.query(getHotelSql);

        return this.resultsetToHotelPO(result).get(0);
    }
    // 酒店评分更新  在添加评分评论后即刻执行
    public ResultMessage updateGrade(String hotelid,int grade)throws RemoteException {
        db.executeSql("USE OurData");

        if(this.checkExistence(hotelid)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        String findPeopleNumWithGradeSql = "SELECT grade,commentNum FROM HotelInfo WHERE hotelID='"+hotelid+"' LIMIT 1";
        ResultSet result = db.query(findPeopleNumWithGradeSql);
        double gradeUpdated = 0;
        try{
            while(result.next()){
                double gradeTotal = result.getDouble(1);
                int gradeNum = result.getInt(2);
                if(gradeNum!=0)
                    gradeUpdated = ((double)(gradeNum-1)*gradeTotal+grade)/gradeNum;//add Comment first

                String updateGradeSql = "UPDATE HotelInfo SET grade="+gradeUpdated+" WHERE hotelID='"+hotelid+"' LIMIT 1";
                db.executeSql(updateGradeSql);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        return ResultMessage.succeed;
    }
    // 酒店信息更新
    public ResultMessage updateHotel(HotelPO hotelPO)throws RemoteException {
        db.executeSql("USE OurData");
        // 编号 密码 电话 名称
        // 地址 商圈 简介 设施
        // 星级 评分 最晚入住时间
        if(this.checkExistence(hotelPO.getId())==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        String password = hotelPO.getPassword();
        String tel = hotelPO.getTel();
        String name = hotelPO.getName();
        String address = hotelPO.getAddr();
        String bArea = hotelPO.getBusinessArea();
        String briefIntro = hotelPO.getBriefIntro();
        String facility = hotelPO.getFacility();
        int level = hotelPO.getLevel();
        double grade = hotelPO.getGrade();
        String lastestTime = hotelPO.getLatestCheckinTime();

        String updateHotelSql = "UPDATE HotelInfo SET password='"+password+"',phoneNumber="+tel+",name='"+name+"',"+
                "address='"+address+"',bussinessArea='"+bArea+"',briefIntro='"+briefIntro+"',facility='"+facility+","+
                "level="+level+",grade="+grade+",lastestCheckinTime="+lastestTime
                +" WHERE hotelID='"+hotelPO.getId()+"' LIMIT 1";
        db.executeSql(updateHotelSql);
        return ResultMessage.succeed;
    }
    // 添加特色客房
    public ResultMessage addSpecialRoom(RoomPO roomPO)throws RemoteException {
        db.executeSql("USE OurData");
        // 酒店 类型 总量
        // 价格 是否特色 可用数量日期列表
        String hotelID = roomPO.getID();
        String roomType = roomPO.getType();
        int amount = roomPO.getAmountTotal();
        double price = roomPO.getPrice();
        boolean isSpecial = roomPO.getBasicOrSpecial();
        int special = 0;
        if(isSpecial)
            special = 1;
        String availableRoom = String.valueOf(amount);

        for(int i=0;i<180-1;i++){
            availableRoom = availableRoom+","+String.valueOf(amount);
        }

        String addSpecialRoomSql = "INSERT INTO RoomInfo VALUES('"+hotelID+"','"+roomType+"',"+amount+
                ","+price+","+special+",'"+availableRoom+"')";
        db.executeSql(addSpecialRoomSql);

        return ResultMessage.succeed;
    }
    // 删除特色客房
    public ResultMessage deleteSpecialRoom(RoomPO roomPO)throws RemoteException {
        db.executeSql("USE OurData");

        String hotelID = roomPO.getID();
        String roomType = roomPO.getType();
        String deleteSpecialRoomSql = "DELETE FROM RoomInfo WHERE hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
        db.executeSql(deleteSpecialRoomSql);

        return ResultMessage.succeed;
    }
    // 酒店 类型 总量
    // 价格 是否特色
    // ！不包括可用数量日期列表
    // 根据账号 得到酒店房间信息
    public ArrayList<RoomPO> getRoomList(String hotelID)throws RemoteException {
        db.executeSql("USE OurData");

        String findRoomTypeNumSql = "SELECT roomTypeNum FROM RoomInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet result = db.query(findRoomTypeNumSql);
        ArrayList<RoomPO> roomList = new ArrayList<RoomPO>();
        try{
            while(result.next()){
                int typeNum = result.getInt(1);
                String getRoomListSql = "SELECT *FROM RoomInfo WHERE hotelID='"+hotelID+"' LIMIT "+String.valueOf(typeNum);
                ResultSet roomResult = db.query(getRoomListSql);
                try{
                    while(roomResult.next()){
                        String type = roomResult.getString(2);
                        int amountTotal = roomResult.getInt(3);
                        double price = roomResult.getDouble(4);
                        boolean isSpecial = roomResult.getBoolean(5);
                        roomList.add(new RoomPO(hotelID,type,amountTotal,price,isSpecial){});
                    }
                    return roomList;
                }catch (SQLException e){
                    e.printStackTrace();
                    return null;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
    // 改变 酒店某一房间数量和价格
    public ResultMessage updateRoom(RoomPO roomPO)throws RemoteException {
        db.executeSql("USE OurData");

        String roomType = roomPO.getType();
        int num = roomPO.getAmountTotal();
        double price = roomPO.getPrice();
        String checkIsRoomNumChangedSql = "SELECT amountTotal FROM RoomInfo"
                +" Where hotelID='"+roomPO.getID()+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet result = db.query(checkIsRoomNumChangedSql);
        // 查看是否更改酒店房间数量
        int changedNum = 0;
        try{
            while(result.next()){
                if(result.getInt(1)!=num)
                    changedNum = num-result.getInt(1);//现在-原来
            }
        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }

        if(changedNum!=0){
            String getRoomAvailNumSql = "SELECT aList FROM RoomInfo"
                    +" Where hotelID='"+roomPO.getID()+"' and roomType='"+roomType+"' LIMIT 1";
            ResultSet getAList = db.query(getRoomAvailNumSql);
            try{
                while(getAList.next()){
                    String[] aListTem = getAList.getString(1).split(",");
                    int[] aList = new int[180];
                    for(int i=0;i<180;i++)
                        aList[i] = Integer.valueOf(aListTem[i])+changedNum;

                    String aListUpdated = String.valueOf(aList[0]);
                    for(int i=1;i<180;i++)
                        aListUpdated = aListUpdated+","+String.valueOf(aList[i]);
                    String updateAListSql = "UPDATE RoomInfo SET aList='"+aListUpdated+"'"
                            +" Where hotelID='"+roomPO.getID()+"' and roomType='"+roomType+"' LIMIT 1";
                    db.executeSql(updateAListSql);
                }
            }catch(SQLException e){
                e.printStackTrace();
                return ResultMessage.fail;
            }
        }

        String updateRoomInfoSql = "UPDATE RoomInfo SET amountTotal="+String.valueOf(num)+",price="+String.valueOf(price)
                +" Where hotelID='"+roomPO.getID()+"' and roomType='"+roomType+"' LIMIT 1";
        db.executeSql(updateRoomInfoSql);
        return ResultMessage.succeed;
    }
    // 根据新增订单/撤销订单 改变可用房间信息
    public ResultMessage changeRoomAvail(String hotelid,String roomType,boolean isPlus, int num, Date checkIn, Date checkOut)throws RemoteException {
        db.executeSql("USE OurData");

        int tip=1;
        if(isPlus==false)
            tip = -1;//新增订单 撤销订单
        int gap1 = this.getDayGap(checkIn);
        int gap2 = this.getDayGap(checkOut);
        String getRoomListSql = "SELECT aList FROM RoomInfo WHERE hotelID='"+hotelid+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet result = db.query(getRoomListSql);

        try{
            while(result.next()){
                String[] roomNumTem = result.getString(1).split(",");
                int[] roomNum = new int[180];
                for(int i=0;i<180;i++)
                    roomNum[i] = Integer.valueOf(roomNumTem[i]);
                for(int i=gap1;i<=gap2;i++)
                    roomNum[i] = roomNum[i]+tip*num;
                String aListUpdated = String.valueOf(roomNum[0]);
                for(int i=1;i<180;i++)
                    aListUpdated = aListUpdated+","+String.valueOf(roomNum[i]);
                String changeRoomAvailSql = "UPDATE RoomInfo SET aList='"+aListUpdated+
                        " WHERE hotelID='"+hotelid+"' and roomType='"+roomType+"' LIMIT 1";
                db.executeSql(changeRoomAvailSql);
                return ResultMessage.succeed;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        return ResultMessage.fail;
    }
    // 登记退房时间？？改变数量
    // 如果退房时间 超过 最晚入住时间 不更改当天的信息  更改下一天的信息
    // 根据入住时间得到可用房间数量
    public int numOfRoomAvail(String hotelid,String roomType, Date checkIn, Date checkOut)throws RemoteException {
        db.executeSql("USE OurData");

        String findNumOfRoomAvailSql = "SELECT aList FROM RoomInfo WHERE hotelID='"+hotelid+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet result = db.query(findNumOfRoomAvailSql);
        int gap1 = this.getDayGap(checkIn);
        int gap2 = this.getDayGap(checkOut);
        int numsByDay[] = new int[gap2-gap1+1] ;

        try{
            while(result.next()){
                String aList = result.getString(1);
                String[] roomNumTem = aList.split(",");
                int[] roomNum = new int[180];
                for(int i=0;i<180;i++)
                    roomNum[i] = Integer.valueOf(roomNumTem[i]);
                int j=0;
                for(int i=gap1;i<=gap2;i++,j++)
                    numsByDay[j] = roomNum[i];
                int smallest = numsByDay[0];
                for(int i=1;i<numsByDay.length;i++)
                    if(smallest>numsByDay[i])
                        smallest = numsByDay[i];
                return smallest;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
        return -1;
    }
    // 酒店工作人员 根据日期查看可用客房信息
    public ArrayList<RoomAvailPO> getRoomAvailList(String hotelid, Date date)throws RemoteException {
        db.executeSql("USE OurData");

        String getRoomTypeNumSql = "SELECT roomTypeNum FROM HotelInfo"+
                " WHERE hotelID='"+hotelid+"' LIMIT 1";
        ResultSet roomTypeNumResult = db.query(getRoomTypeNumSql);
        int roomTypeNum = 0;
        try{
            while(roomTypeNumResult.next())
                roomTypeNum = roomTypeNumResult.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        if(roomTypeNum>0){
            String getRoomAvailListByDateSql = "SELECT *FROM RoomInfo WHERE hotelID='"+hotelid+"' LIMIT "+String.valueOf(roomTypeNum);
            ResultSet roomAvailResult = db.query(getRoomAvailListByDateSql);
            try{// type isSpecial num price
                // 酒店 类型 总量
                // 价格 是否特色 可用数量日期列表
                ArrayList<RoomAvailPO> roomAvailList = new ArrayList<RoomAvailPO>();
                while(roomAvailResult.next()){
                    int num = Integer.valueOf(roomAvailResult.getString(6).split(",")[this.getDayGap(date)]);

                    RoomAvailPO roomAvailPO = new RoomAvailPO(hotelid,roomAvailResult.getString(2),num,
                            roomAvailResult.getDouble(4),roomAvailResult.getBoolean(5));
                    roomAvailList.add(roomAvailPO);
                }
                return  roomAvailList;
            }catch (SQLException e){
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
    // 生成订单时得到酒店 所有房间的规格信息？？
    public ArrayList<RoomNormPO> getRoomNorm(String id) throws RemoteException{
        return null;
    }
    // 续房？先保留
    public ResultMessage updateRoomAvail(RoomAvailPO availableRoom)throws RemoteException {
        return null;
    }
    // 初始  根据地址商圈得到 酒店列表
    public ArrayList<HotelPO> getHotelList(String address, String businessArea)throws RemoteException {
        db.executeSql("USE OurData");

        String getHotelListSql = "SELECT *FROM HotelInfo WHERE address='"+address+"' and businessArea='"+businessArea+"'";
        ResultSet result = db.query(getHotelListSql);
        return this.resultsetToHotelPO(result);
    }
    //  网站管理人员 根据id 得到酒店信息
    public HotelPO getHotelInfo(String hotelID)throws RemoteException {
        db.executeSql("USE OurData");
        // 编号 密码 电话 名称
        // 地址 商圈 简介 设施
        // 星级 评分 最晚入住时间
        String searchHotelSql = "SELECT *FROM HotelInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet result = db.query(searchHotelSql);

        return this.resultsetToHotelPO(result).get(0);
    }
    // 根据酒店传入地区 初始化酒店账号
    public String getNewHotelID(String district) throws RemoteException{
        int num = this.getHotelNum(district);
        String leftSort = String.format("%4d", num).replace(" ", "0");
        return leftSort;
    }
    // 网站管理人员 得到数据库中符合该地址的酒店数量 来生成酒店id
    public int getHotelNum(String district)throws RemoteException {
        db.executeSql("USE OurData");

        String getHotelNumSql = "SELECT count(*) FROM HotelInfo WHERE address='"+district+"'";
        ResultSet result = db.query(getHotelNumSql);
        try {
            while (result.next())
                return result.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    // 添加酒店
    // 编号 密码 电话 名称
    // 地址 商圈 简介 设施
    // 星级 评分 最晚入住时间 评论人数 房间类型数量
    public ResultMessage addHotel(HotelPO hotelPO)throws RemoteException {
        db.executeSql("USE OurData");
        String hotelID = hotelPO.getId();
        String addHotelSql = "INSERT INTO HotelInfo VALUES('"+hotelPO.getId()+"','"+
                hotelPO.getPassword()+"',"+hotelPO.getTel()+",null,'" +
                hotelPO.getAddr()+"',null,null,null,"+
                "null,0,0,0,2";
        db.executeSql(addHotelSql);
        // 酒店 类型 总量
        // 价格 是否特色 可用数量日期列表
        String addSingleRoomSql = "INSERT INTO RoomInfo VALUES('"+hotelID+"','singleRoom',0," +
                                                                   "9999,0,null)";
        String addDoubleRoomSql = "INSERT INTO RoomInfo VALUES('"+hotelID+"','doubleRoom',0,"+
                                                                   "9999,0,null)";
        db.executeSql(addSingleRoomSql);
        db.executeSql(addDoubleRoomSql);
        return ResultMessage.succeed;
    }
    // 更新酒店工作人员信息
    public ResultMessage updateHotelStaff(HotelStaffPO po)throws RemoteException {
        db.executeSql("USE OurData");

        String updateHotelStaffSql = "UPDATE HotelInfo SET phoneNumber='"+po.getTel()+"'' WHERE hotelID='"+po.getHotelID()+"' LIMIT 1";
        db.executeSql(updateHotelStaffSql);

        return ResultMessage.succeed;
    }



    // 一天过去 修改可用客房日期列表 每天12:00
    /*public void updateRoomAListWithDayChangedExecute(){
        Timer timer = new Timer();
　　    timer.schedule(new class(), 60 * 1000);
    }*/
    public void updateRoomAListWithDayChanged(){
        db.executeSql("USE OurData");

        PreparedStatement pst = null;
        Connection con = null;
        ArrayList<String> aListList = new ArrayList<String>();
        ArrayList<Integer> totalNumList = new ArrayList<Integer>();
        ArrayList<String> hotelIDList = new ArrayList<String>();

        String getAListSql = "SELECT hotelID,amountTotal,aList FROM RoomInfo";
        ResultSet result = db.query(getAListSql);
        try{
            while(result.next()){
                hotelIDList.add(result.getString(1));
                totalNumList.add(result.getInt(2));
                aListList.add(result.getString(3));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        String updateAListWithDayChangedSql = "UPDATE RoomInfo SET aList=? WHERE hotelID=?";
        int index = -1;
        String aList = null;

        try{
            pst = con.prepareStatement(updateAListWithDayChangedSql);
            for(int i=0;i<aListList.size();i++) {
                index = aListList.get(i).indexOf(",");
                aList = aListList.get(i).substring(index+1)+","+String.valueOf(totalNumList.get(i));
                pst.setString(1,aList);
                pst.setString(2,hotelIDList.get(i));
                pst.execute();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    // 根据SQL结果得到酒店PO
    public ArrayList<HotelPO> resultsetToHotelPO(ResultSet result){
        ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
        try{
            while(result.next()){
                HotelPO hotel = new HotelPO(result.getString(1),result.getString(3),
                        result.getString(4),result.getString(5),result.getString(6),
                        result.getString(7),result.getString(8),result.getInt(9),
                        result.getDouble(10),result.getString(11));
                hotel.setPassword(result.getString(2));
                hotelList.add(hotel);
            }
            return hotelList;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // 计算时间差 来查看特定日期段下的可用客房数量
    public int getDayGap(Date date) {
        try {
            //时间转换类
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(sdf.format(date));//the late one
            Date today = new Date();
            String strToday = sdf.format(today);
            today = sdf.parse(strToday);

            //将转换的两个时间对象转换成Calendard对象
            Calendar can1 = Calendar.getInstance();
            can1.setTime(date);
            Calendar can2 = Calendar.getInstance();
            can2.setTime(today);
            //拿出两个年份
            int year1 = can1.get(Calendar.YEAR);
            int year2 = can2.get(Calendar.YEAR);
            //天数
            int days = 0;
            Calendar can = null;
            //如果can1 < can2
            //减去小的时间在这一年已经过了的天数
            //加上大的时间已过的天数
            if(can1.before(can2)){
                days -= can1.get(Calendar.DAY_OF_YEAR);
                days += can2.get(Calendar.DAY_OF_YEAR);
                can = can1;
            }else{
                days -= can2.get(Calendar.DAY_OF_YEAR);
                days += can1.get(Calendar.DAY_OF_YEAR);
                can = can2;
            }
            for (int i = 0; i < Math.abs(year2-year1); i++) {
                //获取小的时间当前年的总天数
                days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
                //再计算下一年。
                can.add(Calendar.YEAR, 1);
            }
            return days;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public ResultMessage checkExistence(String hotelid){
        String checkExistenceSql = "SELECT hotelID FROM HotelInfo";
        ResultSet result = db.query(checkExistenceSql);
        try{
            while(result.next())
                if(result.getString(1).equals(hotelid))
                    return ResultMessage.idAlreadyExist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ResultMessage.idNotExist;
    }
}