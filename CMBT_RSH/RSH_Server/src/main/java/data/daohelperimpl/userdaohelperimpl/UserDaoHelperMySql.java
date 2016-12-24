package data.daohelperimpl.userdaohelperimpl;

import constant.MemberType;
import constant.ResultMessage;
import constant.Sexuality;
import data.daohelper.UserDaoHelper;
import data.daohelperimpl.DaoHelperFactoryImpl;
import data.daohelperimpl.jdbc.DBHelper;
import po.UserPO;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class UserDaoHelperMySql implements UserDaoHelper{
	private DBHelper db = DaoHelperFactoryImpl.getDBHelper();
    private static final String nameKey = "1jkl43";
    private static final String pwKey = "&afds890";
    public void init(){
        db.executeSql("USE OurData");
        // 账号 密码 昵称 头像url
        // 生日 会员等级 会员类型 企业名称 信用值
        // 真实姓名 性别 邮箱 信用记录条数
        db.executeSql("CREATE TABLE if not exists UserInfo(userID blob,password blob,"
        		+ "nickName char(10),image tinytext,birthday char(10),level tinyint,"
        		+ "memberType tinyint,commerceName char(20),credit int," +
                "trueName blob,sex tinyint,eMail char(30),creditRecordNum int)" );
    }

    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS UserInfo");
    }
    // 根据id得到用户基本信息
    public UserPO getInfo(String userID) throws RemoteException {
        db.executeSql("USE OurData");

        if(this.checkExistence(userID)==ResultMessage.idNotExist)
            return null;
        String deUserID = this.getSecreted(userID, nameKey);
        
        String getInfoSql = "SELECT *FROM UserInfo WHERE userID="+deUserID+" LIMIT 1";
        ResultSet result = db.query(getInfoSql);
        UserPO userPO = this.resultSetToUserPO(result).get(0);
        userPO = this.getClearByID(userID, userPO);
        return userPO; 
    }
    // 修改用户基本信息
    public ResultMessage update(UserPO userPO) throws RemoteException {
        db.executeSql("USE OurData");
        
        String userID = userPO.getId();
        if(this.checkExistence(userID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;
        
        String deUserID = this.getSecreted(userID, nameKey);
        String password = userPO.getPassword();
        String dePassword = this.getSecreted(password, pwKey);
        String nickName = userPO.getNickName();
        String image = userPO.getImageAddress();
        String birth = userPO.getBirthday().toString();
        int level = userPO.getLevel();
        int type = userPO.getMemberType().ordinal();
        int credit = userPO.getCredit();
        String name = userPO.getName();
        String deName = this.getSecreted(name, nameKey);
        int sex = userPO.getSexuality().ordinal();
        String eMail = userPO.geteMail();
        String commerceName = userPO.getCommerceName();

        String updateSql = "UPDATE UserInfo SET password="+dePassword+",nickName='"+nickName+"',image='"+image+
                "',birthday='"+birth+"',level="+String.valueOf(level)+",memberType="+String.valueOf(type)+
                ",credit="+String.valueOf(credit)+",trueName="+deName+",sex="+String.valueOf(sex)+
                ",eMail='"+eMail+"',commerceName='"+commerceName
                +"' WHERE userID="+deUserID+" LIMIT 1";
        db.executeSql(updateSql);
        return ResultMessage.succeed;
    }
    // 注册成为用户
    // 账号 密码 昵称 头像url
    // 会员等级 会员类型 信用值
    // 真实姓名 性别 邮箱
    public ResultMessage insert(UserPO userPO) throws RemoteException {
        db.executeSql("USE OurData");

        if(this.checkExistence(userPO.getId())==ResultMessage.idAlreadyExist)
            return ResultMessage.idAlreadyExist;
       System.out.println(userPO.getName());
        String userID = userPO.getId();
        String deUserID = this.getSecreted(userID, nameKey);
        String password = userPO.getPassword();
        String dePassword = this.getSecreted(password, pwKey);
        String nickName = userPO.getNickName();
        String image = userPO.getImageAddress();
        int level = userPO.getLevel();
        int memberType = userPO.geMemberType().ordinal();
        
        String name = userPO.getName();
        String deName = this.getSecreted(name, nameKey);
        int sex = userPO.getSexuality().ordinal();
        String eMail = userPO.geteMail();
        int credit = userPO.getCredit();
        String birthday = "null"; 
        if(userPO.getBirthday()!=null)
            birthday = "'"+userPO.getBirthday().toString()+"'";
        String commerceName = userPO.getCommerceName();
       
        String insertSql = "INSERT INTO UserInfo VALUES("+deUserID+","+dePassword+
        		",'"+nickName+"','"+image+"',"+birthday+","+String.valueOf(level)+","+
        		String.valueOf(memberType)+",'"+commerceName+"',"+String.valueOf(credit)+","
        		+ deName+","+String.valueOf(sex)+",'"+eMail+"',0)";
        db.executeSql(insertSql);

        return ResultMessage.succeed;
    }

    @Override
    public ResultMessage setMemberLevel(int gradeWithCredit) throws RemoteException {
        return null;
    }


    // 网站营销人员 制定会员等级制度
    public ResultMessage setMemberLevel(int[] gradeWithCredit) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
 // 网站管理人员 得到用户信息
 	public ArrayList<UserPO> getAll()throws RemoteException{
 		db.executeSql("USE OurData");
 		ResultSet result = db.query("SELECT *FROM UserInfo");
 		ArrayList<UserPO> list = this.resultSetToUserPO(result);
 		if(list.size()==0)
 			return list;
 		ResultSet resultCleared = db.query("SELECT aes_decrypt(userID,'"+nameKey+"'),"
    			+ "aes_decrypt(trueName,'"+nameKey+"') FROM UserInfo");
 		int ptr = 0;
 		try{
 			while(resultCleared.next()){
 				list.get(ptr).setId(resultCleared.getString(1));
 				String name = resultCleared.getString(2);
 				System.out.println(name);
 				list.get(ptr).setName(name);
 				ptr++;
 			}
 		}catch(SQLException e){
 			e.printStackTrace();
 		}
 		return list;
 	}

    // 检查需要操作的账号存在
    public ResultMessage checkExistence(String userID){
        String checkExistenceSql = "SELECT count(*) FROM UserInfo WHERE userID="
                                     +this.getSecreted(userID, nameKey);
        ResultSet result = db.query(checkExistenceSql);
        try{
            while(result.next())
                if(result.getInt(1)>0)
                    return ResultMessage.idAlreadyExist;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return ResultMessage.idNotExist;
    }
    
    private ArrayList<UserPO> resultSetToUserPO(ResultSet result){
    	ArrayList<UserPO> list = new ArrayList<UserPO>();
    	 try{
             while(result.next()){
            	 String userID = result.getString("userID");
                 String password = result.getString("password");
                 String nickName = result.getString("nickName");
                 String image = result.getString("image");
                 String birth = result.getString("birthday");
                 System.out.println("birth = "+birth);
                 LocalDate birthday = LocalDate.parse(birth);
                 int level = result.getInt("level");
                 MemberType type = MemberType.values()[result.getInt("memberType")];
                 int credit = result.getInt("credit");
                 String name = result.getString("trueName");
                 Sexuality sex = Sexuality.values()[result.getInt("sex")];
                 String eMail = result.getString("eMail");
                 String commerceName = result.getString("commerceName");

                 UserPO userPO = new UserPO(userID,password,nickName,image,
                 		birthday,level,type,credit,name,sex,eMail,commerceName);
                 list.add(userPO);
             }
             return list;
         }catch(SQLException e){
             e.printStackTrace();
             return null;
         }
    }
    // 
    private String getSecreted(String clear,String key){
    	return "aes_encrypt('"+clear+"','"+key+"')";
    }
    //
    private UserPO getClearByID(String userID,UserPO userPO){
    	String deUserID = this.getSecreted(userID, nameKey);
    	String getSecrtedSql = "SELECT aes_decrypt(password,'"+pwKey+"'),"
    			+ "aes_decrypt(trueName,'"+nameKey+"') FROM UserInfo "
    					+ "WHERE userID="+deUserID+" LIMIT 1";
    	ResultSet result = db.query(getSecrtedSql);
    	try{
    		while(result.next()){
    			userPO.setId(userID);
    			userPO.setPassword(result.getString(1));
    			userPO.setName(result.getString(2));
    			return userPO;
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	return userPO;
    }
}
