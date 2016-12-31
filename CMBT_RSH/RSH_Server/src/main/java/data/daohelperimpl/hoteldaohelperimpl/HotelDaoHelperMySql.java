package data.daohelperimpl.hoteldaohelperimpl;

import data.daohelper.HotelDaoHelper;
import data.daohelperimpl.DaoHelperFactoryImpl;
import data.daohelperimpl.jdbc.DBHelper;
import po.*;
import constant.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.DoubleToLongFunction;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by a297 on 16/11/27.
 */
public class HotelDaoHelperMySql implements HotelDaoHelper {
	private DBHelper db = DaoHelperFactoryImpl.getDBHelper();
    private static final String key = "^sf43&67u";
    public void init() {

        db.executeSql("USE OurData");
        // 编号 密码 电话 名称
        // 地址 商圈 标准双人间价格 简介 设施
        // 星级 评分 最晚入住时间  图片地址 评论人数 房间类型数量
        db.executeSql("CREATE TABLE if not exists HotelInfo(hotelID char(10),password blob,phoneNumber char(11),name char(15)," +
                "district char(6),addressDetail char(20),standardPrice double,briefIntro tinytext,facility char(4)," +
                "level tinyint,grade double,latestCheckinTime char(8),imageAddress tinytext,commentNum int,roomTypeNum tinyint)default character set utf8");
        // 酒店 类型 总量
        // 价格 图片地址 可用数量日期列表
        db.executeSql("CREATE TABLE if not exists RoomInfo(hotelID char(10),roomType char(10),amountTotal int,"
                +"price double,imageAddress tinytext,aList text)default character set utf8");
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
        ArrayList<HotelPO> hotelPOs =this.resultsetToHotelPO(result);
        if(hotelPOs.size()==0)
        	return null;
        return hotelPOs.get(0);
    }
    // 根据酒店传入地区 初始化酒店账号
    public String getNewHotelID(String district) throws RemoteException{
        int num = this.getHotelNum(district)+1;
        String sort = String.format("%4d", num).replace(" ", "0");
        return district+sort;
    }
    // 酒店新增
    // 编号 密码 电话 名称
    // 地址 商圈 标准双人间价格 简介 设施
    // 星级 评分 最晚入住时间  图片地址 评论人数 房间类型数量
    public ResultMessage addHotel(HotelPO hotelPO)throws RemoteException {
        db.executeSql("USE OurData");
      
        String hotelID = hotelPO.getID(); 
        
        String password = hotelPO.getPassword();
        String dePassword = this.getSecreted(password);
        String tel = hotelPO.getTel();
        String name = hotelPO.getName();
        String district = hotelPO.getAddress();
        String detail = hotelPO.getAddressDetail();
        double standardPrice = hotelPO.getStandardPrice();
        String briefIntro = hotelPO.getBriefIntro();
        if(briefIntro==null)
        	briefIntro = "";
        else
        	briefIntro = "'"+briefIntro+"'";
        String facility = hotelPO.getFacility();
        int level = hotelPO.getLevel();
        double grade = hotelPO.getGrade();
        String latestCheckinTime = hotelPO.getLatestCheckInTime();
        String imageAddress = hotelPO.getImageAddress();
        System.out.println(latestCheckinTime);
        String addHotelSql = "INSERT INTO HotelInfo VALUES('"+hotelID+"',"+
                dePassword+",'"+tel+"','"+name+"','" + district+"','"+detail+"',"+
        		String.valueOf(standardPrice)+","+briefIntro+",'"+facility+"',"+
                String.valueOf(level)+","+String.valueOf(grade)+",'"+latestCheckinTime+
                "','"+imageAddress+"',0,2)";
        db.executeSql(addHotelSql);
        
        return ResultMessage.succeed;
    }
    // 酒店评分更新
    public ResultMessage updateGrade(String hotelID,int grade)throws RemoteException {
        db.executeSql("USE OurData");

        if(this.checkExistence(hotelID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        String findPeopleNumWithGradeSql = "SELECT grade,commentNum FROM HotelInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet result = db.query(findPeopleNumWithGradeSql);
        if(result==null)
        	return ResultMessage.idNotExist;
        try{
            while(result.next()){
                double gradeTotal = result.getDouble(1);
                int gradeNum = result.getInt(2);
                if(gradeNum>=0){
                    double gradeUpdated = ((double)(gradeNum)*gradeTotal+grade)/(gradeNum+1);//add Comment first
                    String updateGradeSql = "UPDATE HotelInfo SET grade="+String.valueOf(gradeUpdated)+
                    		",commentNum="+String.valueOf(gradeNum+1)+" WHERE hotelID='"+hotelID+"' LIMIT 1";
                    db.executeSql(updateGradeSql);
                    return ResultMessage.succeed;
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
        // 地址 商圈 标准双人间价格 简介 设施
        // 星级 评分 最晚入住时间  图片地址 评论人数 房间类型数量
        if(this.checkExistence(hotelPO.getID())==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;
        
        String password = hotelPO.getPassword();
        String dePassword = this.getSecreted(password);
        String tel = hotelPO.getTel();
        String name = hotelPO.getName();
        String district = hotelPO.getAddress();
        String addressDetail = hotelPO.getAddressDetail();
        double standardPrice = hotelPO.getStandardPrice();
        String briefIntro = hotelPO.getBriefIntro();
        String facility = hotelPO.getFacility();
        int level = hotelPO.getLevel();
        String lastestTime = hotelPO.getLatestCheckInTime();
        String imageAddress = hotelPO.getImageAddress();

        String updateHotelSql = "UPDATE HotelInfo SET password="+dePassword+",phoneNumber='"+
                tel+"',name='"+name+"',district='"+district+"',addressDetail='"+addressDetail
                +"',standardPrice="+standardPrice+",briefIntro='"+briefIntro+"',facility='"+facility+"',"+
                "level="+level+",latestCheckinTime='"+lastestTime+"',imageAddress='"+imageAddress
                +"' WHERE hotelID='"+hotelPO.getID()+"' LIMIT 1";
        db.executeSql(updateHotelSql);
        return ResultMessage.succeed;
    }
    // 添加特色客房
    public ResultMessage addSpecialRoom(RoomPO roomPO)throws RemoteException {
        db.executeSql("USE OurData");
        // 酒店 类型 总量
        // 价格 是否特色  图片地址 可用数量日期列表
        String hotelID = roomPO.getID();
        String roomType = roomPO.getType();
        // 酒店下该类型是否存在
        String checkExistenceSql = "SELECT count(*) FROM RoomInfo WHERE hotelID='"+ hotelID+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet roomTypeResult = db.query(checkExistenceSql);
        try{
        	while(roomTypeResult.next())
        		if(roomTypeResult.getInt(1)>0)
        			return ResultMessage.idAlreadyExist;
        }catch(SQLException e){
        	e.printStackTrace();
        }
       
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
        String imageAddress = roomPO.getImageAddress();
        int amount = roomPO.getAmountTotal();
        double price = roomPO.getPrice();
        String availableRoom = String.valueOf(amount);

        for(int i=0;i<180-1;i++){
            availableRoom = availableRoom+","+String.valueOf(amount);
        }

        String addSpecialRoomSql = "INSERT INTO RoomInfo VALUES('"+hotelID+"','"+roomType+"',"+amount+
                ","+price+",'"+imageAddress+"','"+availableRoom+"')";
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
        String checkRoomSql = "SELECT count(*) FROM RoomInfo WHERE "
        		+ "hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet result = db.query(checkRoomSql);
        try{
        	while(result.next())
        		if(result.getInt(1)<=0)
        			return ResultMessage.idNotExist;
        }catch(SQLException e){
        	e.printStackTrace();
        }
        
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
    // 价格 是否特色  图片地址 可用数量日期列表
    // ！不包括可用数量日期列表
    // 根据账号 得到酒店房间信息
    public ArrayList<RoomPO> getRoomList(String hotelID)throws RemoteException {
        db.executeSql("USE OurData");

        String findRoomTypeNumSql = "SELECT roomTypeNum FROM HotelInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        ResultSet result = db.query(findRoomTypeNumSql);
        int typeNum = 0;
        try{
        	while(result.next()){
        		typeNum = result.getInt(1);
        		if(typeNum<=0)
        			return new ArrayList<RoomPO>();
        	}
        }catch (SQLException e) {
        	e.printStackTrace();
        	return new ArrayList<RoomPO>();
		}
        
        ArrayList<RoomPO> roomList = new ArrayList<RoomPO>();

        String getRoomListSql = "SELECT *FROM RoomInfo WHERE hotelID='"+hotelID+"' LIMIT "+String.valueOf(typeNum);
        ResultSet roomResult = db.query(getRoomListSql);
        try{
            while(roomResult.next()){
                String type = roomResult.getString("roomType");
                int amountTotal = roomResult.getInt("amountTotal");
                double price = roomResult.getDouble("price");
                String imageAddress = roomResult.getString("imageAddress");
                System.out.println(imageAddress+"lkjj");
                roomList.add(new RoomPO(hotelID,type,imageAddress,amountTotal,price));
            }
            return roomList;
        }catch (SQLException e){
            e.printStackTrace();
            return roomList;
        }
    }
    // 改变 酒店某一房间数量、价格、特色
    public ResultMessage updateRoom(RoomPO roomPO)throws RemoteException {
        db.executeSql("USE OurData");
        String hotelID = roomPO.getID();
        String roomType = roomPO.getType();
        String checkExistenceSql = "SELECT count(*) FROM RoomInfo "
        		+ "WHERE hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet exsitenceResult = db.query(checkExistenceSql);
        try{
        	while(exsitenceResult.next())
        		if(exsitenceResult.getInt(1)<=0)
        			return ResultMessage.idNotExist;
        }catch(SQLException e){
        	e.printStackTrace();
        }
        
        int amountTotal = roomPO.getAmountTotal();
        double price = roomPO.getPrice();
        String checkIsRoomNumChangedSql = "SELECT amountTotal FROM RoomInfo"
                +" Where hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
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
                    break;
                }
            }catch(SQLException e){
                e.printStackTrace();
                return ResultMessage.fail;
            }
        }
        String imageAddress = roomPO.getImageAddress();
        String updateRoomInfoSql = "UPDATE RoomInfo SET amountTotal="+String.valueOf(amountTotal)+
                ",price="+String.valueOf(price)+",imageAddress='"+imageAddress
                +"' Where hotelID='"+roomPO.getID()+"' and roomType='"+roomType+"' LIMIT 1";
        db.executeSql(updateRoomInfoSql);
        
        if(roomPO.getType().equals("标准间")){
        	String updateHotelSql = "UPDATE HotelInfo SET standardPrice="+roomPO.getPrice()+
        			" WHERE hotelID='"+roomPO.getID()+"' LIMIT 1";
        	db.executeSql(updateHotelSql);
        }
        return ResultMessage.succeed;
    }
    // 根据新增订单/撤销订单 改变可用房间信息
    // 当酒店手动修改（checkin==checkout）
    public ResultMessage changeRoomAvail(String hotelID,String roomType,boolean isPlus, int num, Date checkIn, Date checkOut)throws RemoteException {
        System.out.println("get into change room Avail");
    	
    	db.executeSql("USE OurData");

        int tip=1;
        if(isPlus==false)
            tip = -1;//新增订单 撤销订单
        int gap1 = this.getDayGap(checkIn);
        int gap2 = this.getDayGap(checkOut);
        System.out.println(gap1+" "+gap2+"  时间差");
        String getRoomListSql = "SELECT aList FROM RoomInfo WHERE hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet result = db.query(getRoomListSql);
        if(!(gap1>=0&&gap2>=gap1))
        	return ResultMessage.fail;
        	
        try{System.out.println("get into success");
            while(result.next()){
                String[] roomNumTem = result.getString(1).split(",");
                int[] roomNum = new int[180];
                for(int i=0;i<180;i++)
                    roomNum[i] = Integer.valueOf(roomNumTem[i]);
                for(int i=gap1;i<=gap2-1;i++)
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

        String checkExistSql = "SELECT count(*) FROM RoomInfo WHERE hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet exsitenceResult = db.query(checkExistSql);
        try{
        	while(exsitenceResult.next())
        		if(exsitenceResult.getInt(1)<=0)
        			return -1;
        }catch(SQLException e){
        	e.printStackTrace();
        }
        
        int gap1 = this.getDayGap(checkIn);
        int gap2 = this.getDayGap(checkOut);
        
        if(gap1<0||gap2<0||gap1>179||gap2>180)
        	return -1;
        
        String findNumOfRoomAvailSql = "SELECT aList FROM RoomInfo WHERE hotelID='"+hotelID+"' and roomType='"+roomType+"' LIMIT 1";
        ResultSet result = db.query(findNumOfRoomAvailSql);
        try{
            while(result.next()){
                String aList = result.getString(1);
                String[] roomNumTem = aList.split(",");
                int[] roomNum = new int[180];
                for(int i=0;i<180;i++)
                    roomNum[i] = Integer.valueOf(roomNumTem[i]);
                
                int smallest = roomNum[gap1];
                for(int i=gap1+1;i<=gap2-1;i++){
                    if(smallest>roomNum[i])
                    	smallest = roomNum[i];
                }
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
        	return new ArrayList<RoomAvailPO>();
        
        int roomTypeNum = 0;
        try{
            while(roomTypeNumResult.next()){
                roomTypeNum = roomTypeNumResult.getInt(1);
                break;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return new ArrayList<RoomAvailPO>();
        }
        
        ArrayList<RoomAvailPO> roomAvailList = new ArrayList<RoomAvailPO>();
        
        if(roomTypeNum>0){
            String getRoomAvailListByDateSql = "SELECT *FROM RoomInfo WHERE hotelID='"+hotelID+"' LIMIT "+String.valueOf(roomTypeNum);
            ResultSet roomAvailResult = db.query(getRoomAvailListByDateSql);
            if(roomAvailResult==null)
            	return new ArrayList<RoomAvailPO>();
            try{
                // 酒店 类型 总量
            	// 价格 是否特色  图片地址 可用数量日期列表
                while(roomAvailResult.next()){
                	String[] avail = roomAvailResult.getString("aList").split(",");
                    int num = Integer.valueOf(avail[this.getDayGap(date)]);
                    RoomAvailPO roomAvailPO = new RoomAvailPO(hotelID,roomAvailResult.getString("roomType"),
                    		roomAvailResult.getString("imageAddress"),date,roomAvailResult.getInt("amountTotal"),
                            roomAvailResult.getDouble("price"));
                    roomAvailPO.setAmountAvail(num);
                    roomAvailList.add(roomAvailPO);
                }
                return  roomAvailList;
            }catch (SQLException e){
                e.printStackTrace();
                return roomAvailList;
            }
        }
        return roomAvailList;
    }

    // 初始  根据地址商圈得到 酒店列表
    public ArrayList<HotelPO> getHotelList(String district)throws RemoteException {
        db.executeSql("USE OurData");

        String getHotelListSql = "SELECT *FROM HotelInfo WHERE district='"+district+"'";
        ResultSet result = db.query(getHotelListSql);
        if(result==null)
        	return new ArrayList<HotelPO>();
        
        return this.resultsetToHotelPO(result);
    }
    
    // 得到数据库中符合该地址的酒店数量
    public int getHotelNum(String district)throws RemoteException {
        db.executeSql("USE OurData");

        String getHotelNumSql = "SELECT count(*) FROM HotelInfo WHERE district='"+district+"'";
        ResultSet result = db.query(getHotelNumSql);
        if(result==null)
        	return 0;
        try {
            while (result.next())
                return result.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    // 网站管理人员 得到酒店信息
    public ArrayList<HotelPO> getAll() throws RemoteException{
    	db.executeSql("USE OurData");

        String getHotelNumSql = "SELECT * FROM HotelInfo";
        ResultSet result = db.query(getHotelNumSql);
        return this.resultsetToHotelPO(result);
    }
    
    // 得到酒店所需图片地址
    public ArrayList<String> getImageAddresses(String hotelID) throws RemoteException{
    	db.executeSql("USE OurData");
    	ArrayList<String> address = new ArrayList<String>();
    	
        String getHotelSql = "SELECT imageAddress,roomTypeNum FROM HotelInfo WHERE hotelID='"+hotelID+"' LIMIT 1";
        int roomTypeNum = -1;
        String imageAddress;
        ResultSet hotelResult = db.query(getHotelSql);
        try{
        	while(hotelResult.next()){
        		imageAddress = hotelResult.getString(1);
        		roomTypeNum = hotelResult.getInt(2);
        		address.add("hotel "+imageAddress);
        		break;
        	}
        }catch(SQLException e){
        	e.printStackTrace();
        	return address;
        }
        
        if(roomTypeNum!=-1){
        	String getRoomSql = "SELECT roomType,imageAddress FROM RoomInfo "
        			+ "WHERE hotelID='"+hotelID+"' LIMIT "+String.valueOf(roomTypeNum);
        	ResultSet roomResult = db.query(getRoomSql);
        	try{
        		while(roomResult.next()){
        			String roomType = roomResult.getString(1);
        			imageAddress = roomResult.getString(2);
        			address.add(roomType+" "+imageAddress);
        		}
        	}catch(SQLException e){
        		e.printStackTrace();
        		return address;
        	}
        }
        return address;
    }
    
    // 根据SQL结果得到酒店PO
    private ArrayList<HotelPO> resultsetToHotelPO(ResultSet result){
        ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
        try{
            while(result.next()){
            	String hotelID = result.getString("hotelID");
                HotelPO hotel = new HotelPO(hotelID,result.getString("phoneNumber"),
                        result.getString("name"),result.getString("imageAddress"),result.getString("district"),result.getString("addressDetail"),
                        result.getDouble("standardPrice"),result.getString("briefIntro"),result.getString("facility"),
                        result.getInt("level"),result.getDouble("grade"),result.getString("latestCheckInTime"));
                hotelList.add(hotel);
            }
            ArrayList<HotelPO> list = new ArrayList<HotelPO>();
            for(int i=0;i<hotelList.size();i++){
            	HotelPO hotelPO = hotelList.get(i);
            	String hotelID = hotelPO.getID();
            	hotelPO.setPassword(this.getClear(hotelID));
            	list.add(hotelPO);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<HotelPO>();
    }
    //
    private String getClear(String hotelID){
    	String getClearSql = "SELECT aes_decrypt(password,'"+key+"') FROM HotelInfo "
    			+ "WHERE hotelID='"+hotelID+"' LIMIT 1";
    	ResultSet result = db.query(getClearSql);
    	try{
    		while(result.next()){
    			return result.getString(1);
    		}
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
            date = sdf.parse(sdf.format(date));//the later one
            
            Date today = new Date();
            String strToday = sdf.format(today);
            today = sdf.parse(strToday);
            
            
            //将转换的两个时间对象转换成Calendard对象
            Calendar checkNeed = Calendar.getInstance();
            checkNeed.setTime(date);
            Calendar instance = Calendar.getInstance();
            instance.setTime(today);
            //拿出两个年份
            int checkNeedYear = checkNeed.get(Calendar.YEAR);
            int instanceYear = instance.get(Calendar.YEAR);
            //天数
            int days = 0;
            Calendar can = null;
            //如果can1 < can2
            //减去小的时间在这一年已经过了的天数
            //加上大的时间已过的天数
            if(checkNeed.before(instance)){
            	return -1;
            }else{
                days -= instance.get(Calendar.DAY_OF_YEAR);
                days += checkNeed.get(Calendar.DAY_OF_YEAR);
                can = instance;
            }
            for (int i = 0; i < checkNeedYear-instanceYear; i++) {
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
    //
    public String getSecreted(String clear){
    	return "aes_encrypt('"+clear+"','"+key+"')";
    }
}