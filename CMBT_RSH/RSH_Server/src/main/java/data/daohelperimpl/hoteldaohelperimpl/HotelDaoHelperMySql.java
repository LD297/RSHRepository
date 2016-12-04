package data.daohelperimpl.hoteldaohelperimpl;

import data.daohelperimpl.jdbc.DBHelper;
import po.HotelPO;
import po.HotelStaffPO;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;
import vo.SelectConditionVO;

import constant.ResultMessage;
import constant.SortBy;
import constant.SortMethod;
import data.daohelper.DaoHelperMySql;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
/**
 * Created by a297 on 16/11/27.
 */
public class HotelDaoHelperMySql extends DaoHelperMySql{
    private DBHelper db = new DBHelper();

    public void init(){
        //path表示你所创建文件的路径
        String path = "D:\\360downloads";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        // fileName表示你创建的文件名；
        String fileName = "Hotel.db";
        File file = new File(f,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();}
        }

        db.executeSql("USE Hotel");
        // 编号 密码 电话 名称
        // 地址 商圈 简介 设施
        // 星级 评分 最晚入住时间 评论人数 房间类型数量
        db.executeSql("CREATE TABLE HotelInfo(hotelID char(10),password varchar(20),phoneNumber bigint,name varchar(15)," +
                "address varchar(30),businessArea varchar(10),briefIntro tinytext,facility varchar(20)," +
                "level tinyint,grade double,latestCheckinTime int,commentNum int，roomTypeNum tinyint)");
        // 酒店 类型 总量
        // 价格 是否特色 可用数量日期列表
        db.executeSql("CREATE TABLE RoomInfo(hotelID char(10),roomType varchar(10),amountTotal int,"
                +"price double,basicOrSpecial tinyint,aList text)");
        db.executeSql("CREATE TABLE COMMENT(hotelID char(10),userID char(26),grade tinyint,comment tinytext)");

    }
    public void finish(){
        File f = new File("D:\\360downloads\\HotelList.db");  // 输入要删除的文件位置
        if(f.exists())
            f.delete();
    }
    public ResultMessage addComment(String hotelID, String userID, int grade,String comment)throws RemoteException {

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

    public ResultMessage checkPassword(String id, String password)throws RemoteException {
        String checkPasswordSql = "SELECT password FROM HotelInfo WHERE hotelID='"+id+"' LIMIT 1";
        ResultSet result = db.query(checkPasswordSql);
        try{
            while(result.next())
                if(password.equals(result.getString(1)))
                    return ResultMessage.succeed;
        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        return ResultMessage.fail;
    }

    public HotelPO getHotel(String id)throws RemoteException {
        String getHotelSql = "SELECT *FROM HotelInfo WHERE hotelID='"+id+"' LIMIT 1";
        ResultSet result = db.query(getHotelSql);

        return this.resultsetToHotelPO(result).get(0);
    }

    public ResultMessage updateGrade(String hotelID,int grade)throws RemoteException {

        String findPeopleNumWithGradeSql = "SELECT grade,commentNum FROM HotelInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet result = db.query(findPeopleNumWithGradeSql);
        try{
            while(result.next()){
                double gradeTotal = result.getDouble(1);
                int gradeNum = result.getInt(2);
                double gradeUpdated = ((double)(gradeNum-1)*gradeTotal+grade)/gradeNum;//add Comment first

                String updateGradeSql = "UPDATE HotelInfo SET grade="+gradeUpdated+" WHERE hotelID='"+hotelID+"' LIMIT 1";
                db.executeSql(updateGradeSql);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        return ResultMessage.succeed;
    }

    public ResultMessage updateHotel(HotelVO vo)throws RemoteException {
        // 编号 密码 电话 名称
        // 地址 商圈 简介 设施
        // 星级 评分 最晚入住时间
        String password = vo.getPassword();
        String tel = vo.getTel();
        String name = vo.getName();
        String address = vo.getAddr();
        String bArea = vo.getBusinessArea();
        String briefIntro = vo.getBriefIntro();
        String facility = vo.getFacility();
        int level = vo.getLevel();
        double grade = vo.getGrade();
        int lastestTime = vo.getLatestCheckinTime();
        String updateHotelSql = "UPDATE HotelInfo SET password='"+password+"',phoneNumber="+tel+",name='"+name+"',"+
                "address='"+address+"',bussinessArea='"+bArea+"',briefIntro='"+briefIntro+"',facility='"+facility+","+
                "level="+level+",grade="+grade+",lastestCheckinTime="+lastestTime
                +" WHERE hotelID='"+vo.getId()+"' LIMIT 1";
        db.executeSql(updateHotelSql);
        return ResultMessage.succeed;
    }

    public ResultMessage addSpecialRoom(RoomVO vo)throws RemoteException {
        // 酒店 类型 总量
        // 价格 是否特色 可用数量日期列表
        String hotelID = vo.getID();
        String roomType = vo.getType();
        int amount = vo.getAmountTotal();
        double price = vo.getPrice();
        boolean isSpecial = vo.getBasicOrSpecial();
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

    public ResultMessage deleteSpecialRoom(RoomVO vo)throws RemoteException {
        String hotelID = vo.getID();
        String roomType = vo.getType();
        String deleteSpecialRoomSql = "DELETE FROM RoomInfo WHERE hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
        db.executeSql(deleteSpecialRoomSql);

        return ResultMessage.succeed;
    }
    // 酒店 类型 总量
    // 价格 是否特色 可用数量日期列表
    public ArrayList<RoomVO> getRoomList(String id)throws RemoteException {
        String findRoomTypeNumSql = "SELECT roomTypeNum FROM RoomInfo WHERE hotelID='"+id+"' LIMIT 1";
        ResultSet result = db.query(findRoomTypeNumSql);
        ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
        try{
            while(result.next()){
                int typeNum = result.getInt(1);
                String getRoomListSql = "SELECT *FROM RoomInfo WHERE hotelID='"+id+"' LIMIT "+String.valueOf(typeNum);
                ResultSet roomResult = db.query(getRoomListSql);
                try{
                    while(roomResult.next()){
                        String type = roomResult.getString(2);
                        int amountTotal = roomResult.getInt(3);
                        double price = roomResult.getDouble(4);
                        boolean isSpecial = roomResult.getBoolean(5);
                        roomList.add(new RoomVO(id,type,amountTotal,price,isSpecial){});
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

    public ResultMessage updateRoomList(ArrayList<RoomVO> roomList)throws RemoteException {

        return null;
    }

    public ResultMessage changeRoomAvail(String id,String roomType,Boolean isPlus, int num, Date checkIn, Date checkOut)throws RemoteException {
        int tip=1;
        if(isPlus==false)
            tip = -1;
        int gap1 = this.getDayGap(checkIn);
        int gap2 = this.getDayGap(checkOut);
        String getRoomListSql = "SELECT aList FROM RoomInfo WHERE hotelID='"+id+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet result = db.query(getRoomListSql);
        String aList = "";
        String aListUpdated = "";
        try{
            while(result.next()){
                aList = result.getString(1);
                String[] roomNumTem = aList.split(",");
                int[] roomNum = new int[180];
                for(int i=0;i<180;i++)
                    roomNum[i] = Integer.valueOf(roomNumTem[i]);
                for(int i=gap1;i<=gap2;i++)
                    roomNum[i] = roomNum[i]+tip*num;
                aListUpdated = String.valueOf(roomNum[0]);
                for(int i=1;i<180;i++)
                    aListUpdated = aListUpdated+","+String.valueOf(roomNum[i]);
                String changeRoomAvailSql = "UPDATE RoomInfo SET aList='"+aListUpdated+
                        " WHERE hotelID='"+id+"' and roomType='"+roomType+"' LIMIT 1";
                db.executeSql(changeRoomAvailSql);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }

        String changeRoomAvailSql = "UPDATE RoomInfo SET aList='"+"' WHERE hotelID='"+id+"' and roomType='"+roomType+"' LIMIT 1";
        return null;
    }

    public int numOfRoomAvail(String hotelid,RoomType roomType, Date checkIn, Date checkOut)throws RemoteException {
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

    public ArrayList<RoomAvailVO> getRoomAvailList(Date date)throws RemoteException {
        return null;
    }

    public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> availableRoomList)throws RemoteException {
        return null;
    }

    public ArrayList<HotelVO> getHotelList(String address, String businessArea)throws RemoteException {
        String getHotelListSql = "SELECT *FROM HotelInfo WHERE address='"+address+"' and businessArea='"+businessArea+"'";
        ResultSet result = db.query(getHotelListSql);
        return this.resultsetToHotelVO(result);
    }

    public HotelVO getHotelInfo(String id)throws RemoteException {
        // 编号 密码 电话 名称
        // 地址 商圈 简介 设施
        // 星级 评分 最晚入住时间
        String searchHotelSql = "SELECT *FROM HotelInfo WHERE hotelID='"+id+"' LIMIT 1";
        ResultSet result = db.query(searchHotelSql);
        try{
            while(result.next()){
                HotelVO hotel = new HotelVO(result.getString(1));
                hotel.setPassword(result.getString(2));
                hotel.setTel(result.getString(3));
                hotel.setName(result.getString(4));
                hotel.setAddr(result.getString(5));
                hotel.setBusinessArea(result.getString(6));
                hotel.setBriefIntro(result.getString(7));
                hotel.setFacility(result.getString(8));
                hotel.setLevel(result.getInt(9));
                hotel.setGrade(result.getInt(10));
                hotel.setLatestCheckinTime(result.getInt(11));

                return hotel;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM)throws RemoteException {
        return null;
    }

    public ArrayList<HotelVO> select(SelectConditionVO vo)throws RemoteException {
        return null;
    }
    //得到数据库中符合该地址的酒店数量
    public int getHotelNum(String address)throws RemoteException {
        String getHotelNumSql = "SELECT count(*) FROM HotelInfo where address='"+address+"'";
        ResultSet result = db.query(getHotelNumSql);
        try {
            while (result.next())
                return result.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    // 编号 密码 电话 名称
    // 地址 商圈 简介 设施
    // 星级 评分 最晚入住时间 评论人数 房间类型数量
    public ResultMessage addHotel(String id, String password)throws RemoteException {
        String addHotelSql = "INSERT INTO HotelInfo VALUES('"+id+"','"+password+"',null,null," +
                "null,null,null,null,"+
                "null,0,0,0,2";
        db.executeSql(addHotelSql);
        // 酒店 类型 总量
        // 价格 是否特色 可用数量日期列表
        String addSingleRoomSql = "INSERT INTO RoomInfo VALUES('"+id+"','singleRoom',0," +
                                                                   "9999,0,null)";
        String addDoubleRoomSql = "INSERT INTO RoomInfo VALUES('"+id+"','doubleRoom',0,"+
                                                                   "9999,0,null)";
        db.executeSql(addSingleRoomSql);
        db.executeSql(addDoubleRoomSql);
        return ResultMessage.succeed;
    }

    public ResultMessage deleteHotel(String id)throws RemoteException {
        String deleteHotelSql = "DELETE FROM HotelInfo WHERE hotelID='"+id+"' LIMIT 1";
        db.executeSql(deleteHotelSql);

        return ResultMessage.succeed;
    }

    public ResultMessage updateHotelStaff(HotelStaffPO po)throws RemoteException {
        String updateHotelStaffSql = "UPDATE HotelInfo SET phoneNumber='"+po.getTel()+"'' WHERE hotelID='"+po.getHotelID()+"' LIMIT 1";
        db.executeSql(updateHotelStaffSql);

        return ResultMessage.succeed;
    }

    public ArrayList<HotelPO> resultsetToHotelPO(ResultSet result) {
        ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
        try {
            while (result.next()) {
                // 编号 密码 电话 名称
                // 地址 商圈 简介 设施
                // 星级 评分 最晚入住时间
                String idname = result.getString(1);
                String password = result.getString(2);
                String tel = result.getString(3);
                String name = result.getString(4);
                String address = result.getString(5);
                String bArea = result.getString(6);
                String briefintro = result.getString(7);
                String facility = result.getString(8);
                int level = result.getInt(9);
                int grade = result.getInt(10);
                int time = result.getInt(11);

                hotelList.add(new HotelPO(idname, password, tel, name, address, bArea, briefintro, facility, level, grade, time){});
            }
            return hotelList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<HotelVO> resultsetToHotelVO(ResultSet result){
        ArrayList<HotelVO> hotelList = new ArrayList<HotelVO>();
        try{
            while(result.next()){
                HotelVO hotel = new HotelVO(result.getString(1));
                hotel.setPassword(result.getString(2));
                hotel.setTel(result.getString(3));
                hotel.setName(result.getString(4));
                hotel.setAddr(result.getString(5));
                hotel.setBusinessArea(result.getString(6));
                hotel.setBriefIntro(result.getString(7));
                hotel.setFacility(result.getString(8));
                hotel.setLevel(result.getInt(9));
                hotel.setGrade(result.getInt(10));
                hotel.setLatestCheckinTime(result.getInt(11));

                hotelList.add(hotel);
            }
            return hotelList;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
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
}