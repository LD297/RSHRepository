package data.daohelperimpl.hoteldaohelperimpl;

import bl.hotelserviceimpl.Hotel;
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
        // 地址 商圈 标准双人间价格 简介 设施
        // 星级 评分 最晚入住时间 评论人数 房间类型数量
        db.executeSql("CREATE TABLE if not exists HotelInfo(hotelID char(10),password char(20),phoneNumber char(11),name char(10)," +
                "address char(15),businessArea char(10),doubleRoomPrice double,briefIntro tinytext,facility char(20)," +
                "level tinyint,grade double,latestCheckinTime char(8),commentNum int,roomTypeNum tinyint)");
        // 酒店 类型 总量
        // 价格 是否特色 可用数量日期列表
        db.executeSql("CREATE TABLE if not exists RoomInfo(hotelID char(10),roomType char(10),amountTotal int,"
                +"price double,basicOrSpecial tinyint,aList text)");
    }
    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS HotelInfo");
        db.executeSql("DROP TABLE IF EXISTS RoomInfo");
    }

    // 根据账号得到酒店信息
    public HotelPO getHotel(String hotelID)throws RemoteException {
        db.executeSql("USE OurData");

        String getHotelSql = "SELECT *FROM HotelInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet result = db.query(getHotelSql);

        return this.resultsetToHotelPO(result).get(0);
    }
 // 根据酒店传入地区 初始化酒店账号
    public String getNewHotelID(String district) throws RemoteException{
        int num = this.getHotelNum(district);
        String sort = String.format("%4d", num).replace(" ", "0");
        return "000000"+sort;
    }
    // 添加酒店
    // 编号 密码 电话 名称
    // 地址 商圈 标准双人间价格 简介 设施
    // 星级 评分 最晚入住时间 评论人数 房间类型数量
    public ResultMessage addHotel(HotelPO hotelPO)throws RemoteException {
        db.executeSql("USE OurData");
        String hotelID = hotelPO.getID(); 
        String addHotelSql = "INSERT INTO HotelInfo VALUES('"+hotelID+"','"+
                hotelPO.getPassword()+"','"+hotelPO.getTel()+"','"+hotelPO.getName()+"','" +
                hotelPO.getAddr()+"','"+hotelPO.getBusinessArea()+"',9999,null,null,"+
                "null,0,null,0,2";
        db.executeSql(addHotelSql);
        // 酒店 类型 总量
        // 价格 是否特色 可用数量日期列表
        String addSingleRoomSql = "INSERT INTO RoomInfo VALUES('"+hotelID+"','标准大床间',0," +
                                                                   "9999,0,null)";
        String addDoubleRoomSql = "INSERT INTO RoomInfo VALUES('"+hotelID+"','标准双人间',0," +
                                                                   "9999,0,null)";
        db.executeSql(addSingleRoomSql);
        db.executeSql(addDoubleRoomSql);
        return ResultMessage.succeed;
    }
    // 酒店评分更新
    public ResultMessage updateGrade(String hotelID,int grade)throws RemoteException {
        db.executeSql("USE OurData");

        if(this.checkExistence(hotelID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        String findPeopleNumWithGradeSql = "SELECT grade,commentNum FROM HotelInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet result = db.query(findPeopleNumWithGradeSql);

        try{
            while(result.next()){
                double gradeTotal = result.getDouble(1);
                int gradeNum = result.getInt(2);
                if(gradeNum!=0){
                    double gradeUpdated = ((double)(gradeNum)*gradeTotal+grade)/(gradeNum+1);//add Comment first

                    String updateGradeSql = "UPDATE HotelInfo SET grade="+String.valueOf(gradeUpdated)+",commentNum="+String.valueOf(gradeNum+1)+" WHERE hotelID='"+hotelID+"' LIMIT 1";
                    db.executeSql(updateGradeSql);
                }
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
        if(this.checkExistence(hotelPO.getID())==ResultMessage.idNotExist)
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
        String lastestTime = hotelPO.getLatestCheckInTime();

        String updateHotelSql = "UPDATE HotelInfo SET password='"+password+"',phoneNumber='"+tel+"',name='"+name+"',"+
                "address='"+address+"',bussinessArea='"+bArea+"',briefIntro='"+briefIntro+"',facility='"+facility+"',"+
                "level="+level+",grade="+grade+",lastestCheckinTime='"+lastestTime
                +"' WHERE hotelID='"+hotelPO.getID()+"' LIMIT 1";
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
        // 酒店下该类型是否存在
        String checkExistenceSql = "SELECT *FROM RoomInfo WHERE hotelID='"+ hotelID+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet roomTypeResult = db.query(checkExistenceSql);
        if(roomTypeResult!=null)
            return ResultMessage.idAlreadyExist;
        String checkHotelSql = "SELECT roomTypeNum FROM HotelInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet hotelResult = db.query(checkHotelSql);
        
        int typeNum = -1;
        if(hotelResult==null)
        	return ResultMessage.idNotExist;
        else{
        	try{
        		while(hotelResult.next()){
        			typeNum = hotelResult.getInt(1);
        			typeNum++;
        		}
        	}catch(SQLException e){
        		e.printStackTrace();
        		return ResultMessage.fail;
        	}
        }
        
        int amount = roomPO.getAmountTotal();
        double price = roomPO.getPrice();
        boolean isSpecial = roomPO.getBasicOrSpecial();
        int special = 1;
        if(isSpecial)
            special = 0;//特色
        String availableRoom = String.valueOf(amount);

        for(int i=0;i<180-1;i++){
            availableRoom = availableRoom+","+String.valueOf(amount);
        }

        String addSpecialRoomSql = "INSERT INTO RoomInfo VALUES('"+hotelID+"','"+roomType+"',"+amount+
                ","+price+","+special+",'"+availableRoom+"')";
        db.executeSql(addSpecialRoomSql);
        
        String updateHotelSql = "UPDATE HotelInfo SET roomTypeNum="+String.valueOf(typeNum)+
        		" WHERE hotelID='"+hotelID+"' LIMIT 1";
        db.executeSql(updateHotelSql);

        return ResultMessage.succeed;
    }
    // 删除特色客房
    public ResultMessage deleteSpecialRoom(RoomPO roomPO)throws RemoteException {
        db.executeSql("USE OurData");

        String hotelID = roomPO.getID();
        String roomType = roomPO.getType();
        String checkRoomSql = "SELECT roomType FROM RoomInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet result = db.query(checkRoomSql);
        if(result==null)
        	return ResultMessage.idNotExist;
        
        String checkHotelSql = "SELECT roomTypeNum FROM HotelInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet hotelResult = db.query(checkHotelSql);
        
        int typeNum = -1;
        if(hotelResult==null)
        	return ResultMessage.idNotExist;
        else{
        	try{
        		while(hotelResult.next()){
        			typeNum = hotelResult.getInt(1);
        			typeNum--;
        		}
        	}catch(SQLException e){
        		e.printStackTrace();
        		return ResultMessage.fail;
        	}
        }
        
        String deleteSpecialRoomSql = "DELETE FROM RoomInfo WHERE hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
        db.executeSql(deleteSpecialRoomSql);

        String updateHotelSql = "UPDATE HotelInfo SET roomTypeNum="+String.valueOf(typeNum)+
        		" WHERE hotelID='"+hotelID+"' LIMIT 1";
        db.executeSql(updateHotelSql);
        
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
        if(result==null)
        	return null;
        
        ArrayList<RoomPO> roomList = new ArrayList<RoomPO>();
        try{
            while(result.next()){
                int typeNum = result.getInt(1);
                String getRoomListSql = "SELECT *FROM RoomInfo WHERE hotelID='"+hotelID+"' LIMIT "+String.valueOf(typeNum);
                ResultSet roomResult = db.query(getRoomListSql);
                try{
                    while(roomResult.next()){
                        String type = roomResult.getString("roomType");
                        int amountTotal = roomResult.getInt("amountTotal");
                        double price = roomResult.getDouble("price");
                        boolean isSpecial = roomResult.getBoolean("basicOrSpecial");
                        roomList.add(new RoomPO(hotelID,type,amountTotal,price,isSpecial));
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
    // 改变 酒店某一房间数量、价格、特色
    public ResultMessage updateRoom(RoomPO roomPO)throws RemoteException {
        db.executeSql("USE OurData");

        String roomType = roomPO.getType();
        int amountTotal = roomPO.getAmountTotal();
        double price = roomPO.getPrice();
        boolean isSpecial = roomPO.getBasicOrSpecial();
        int judSpecial = 1;
        if(isSpecial)
            judSpecial = 0;//特色
        String checkIsRoomNumChangedSql = "SELECT amountTotal FROM RoomInfo"
                +" Where hotelID='"+roomPO.getID()+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet result = db.query(checkIsRoomNumChangedSql);
        // 查看是否更改酒店房间数量
        int changedNum = 0;
        try{
            while(result.next()){
                if(result.getInt(1)!=amountTotal)
                    changedNum = amountTotal-result.getInt(1);//现在-原来
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

        String updateRoomInfoSql = "UPDATE RoomInfo SET amountTotal="+String.valueOf(amountTotal)+
                ",price="+String.valueOf(price)+",basicOrSpecial="+String.valueOf(judSpecial)
                +" Where hotelID='"+roomPO.getID()+"' and roomType='"+roomType+"' LIMIT 1";
        db.executeSql(updateRoomInfoSql);
        return ResultMessage.succeed;
    }
    // 根据新增订单/撤销订单 改变可用房间信息
    // 当酒店手动修改（checkin==checkout）
    public ResultMessage changeRoomAvail(String hotelID,String roomType,boolean isPlus, int num, Date checkIn, Date checkOut)throws RemoteException {
        db.executeSql("USE OurData");

        int tip=1;
        if(isPlus==false)
            tip = -1;//新增订单 撤销订单
        int gap1 = this.getDayGap(checkIn);
        int gap2 = this.getDayGap(checkOut);
        String getRoomListSql = "SELECT aList FROM RoomInfo WHERE hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
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
                        "' WHERE hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
                db.executeSql(changeRoomAvailSql);
                return ResultMessage.succeed;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        return ResultMessage.fail;
    }

    // 根据入住时间得到可用房间数量
    public int numOfRoomAvail(String hotelID,String roomType, Date checkIn, Date checkOut)throws RemoteException {
        db.executeSql("USE OurData");

        String findNumOfRoomAvailSql = "SELECT aList FROM RoomInfo WHERE hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet result = db.query(findNumOfRoomAvailSql);
        if(result==null)
        	return -1;
        
        int gap1 = this.getDayGap(checkIn);
        int gap2 = this.getDayGap(checkOut);

        try{
            while(result.next()){
                String aList = result.getString(1);
                String[] roomNumTem = aList.split(",");
                int[] roomNum = new int[180];
                for(int i=0;i<180;i++)
                    roomNum[i] = Integer.valueOf(roomNumTem[i]);
                
                int smallest = roomNum[gap1];
                for(int i=gap1+1;i<=gap2;i++)
                    if(smallest>roomNum[i])
                    	smallest = roomNum[i];
                return smallest;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
        return -1;
    }
    // 酒店工作人员 根据日期查看可用客房信息
    public ArrayList<RoomAvailPO> getRoomAvailList(String hotelID, Date date)throws RemoteException {
        db.executeSql("USE OurData");

        String getRoomTypeNumSql = "SELECT roomTypeNum FROM HotelInfo"+
                " WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet roomTypeNumResult = db.query(getRoomTypeNumSql);
        if(roomTypeNumResult==null)
        	return null;
        
        int roomTypeNum = 0;
        try{
            while(roomTypeNumResult.next())
                roomTypeNum = roomTypeNumResult.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        if(roomTypeNum>0){
            String getRoomAvailListByDateSql = "SELECT *FROM RoomInfo WHERE hotelID='"+hotelID+"' LIMIT "+String.valueOf(roomTypeNum);
            ResultSet roomAvailResult = db.query(getRoomAvailListByDateSql);
            try{// type isSpecial num price
                // 酒店 类型 总量
                // 价格 是否特色 可用数量日期列表
                ArrayList<RoomAvailPO> roomAvailList = new ArrayList<RoomAvailPO>();
                while(roomAvailResult.next()){
                    int num = Integer.valueOf(roomAvailResult.getString(6).split(",")[this.getDayGap(date)]);

                    RoomAvailPO roomAvailPO = new RoomAvailPO(hotelID,roomAvailResult.getString("roomType"),num,
                            roomAvailResult.getDouble("price"),roomAvailResult.getBoolean("basicOrSpecial"));
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

    // 初始  根据地址商圈得到 酒店列表
    public ArrayList<HotelPO> getHotelList(String address, String businessArea)throws RemoteException {
        db.executeSql("USE OurData");

        String getHotelListSql = "SELECT *FROM HotelInfo WHERE address='"+address+"' and businessArea='"+businessArea+"'";
        ResultSet result = db.query(getHotelListSql);
        if(result==null)
        	return null;
        
        return this.resultsetToHotelPO(result);
    }
    //  网站管理人员 根据id 得到酒店信息
    public ArrayList<HotelPO> getAllHotel()throws RemoteException {
        db.executeSql("USE OurData");
        // 编号 密码 电话 名称
        // 地址 商圈 简介 设施
        // 星级 评分 最晚入住时间
        String searchHotelSql = "SELECT *FROM HotelInfo";
        ResultSet result = db.query(searchHotelSql);

        return this.resultsetToHotelPO(result);
    }

    
    // 得到数据库中符合该地址的酒店数量
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
   
    // 根据SQL结果得到酒店PO
    public ArrayList<HotelPO> resultsetToHotelPO(ResultSet result){
        ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
        try{
            while(result.next()){
                HotelPO hotel = new HotelPO(result.getString("hotelID"),result.getString("phoneNumber"),
                        result.getString("name"),result.getString("address"),result.getString("businessArea"),
                        result.getDouble("doubleRoomPrice"),result.getString("briefIntro"),result.getString("facility"),
                        result.getInt("level"),result.getDouble("grade"),result.getString("latestCheckInTime"));
                hotel.setPassword(result.getString("password"));
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
    // 检验账号是否存在
    public ResultMessage checkExistence(String hotelID){
        String checkExistenceSql = "SELECT hotelID FROM HotelInfo";
        ResultSet result = db.query(checkExistenceSql);
        try{
            while(result.next())
                if(result.getString(1).equals(hotelID))
                    return ResultMessage.idAlreadyExist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ResultMessage.idNotExist;
    }
}