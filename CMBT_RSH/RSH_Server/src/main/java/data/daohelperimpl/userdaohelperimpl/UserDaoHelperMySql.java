package data.daohelperimpl.userdaohelperimpl;

import com.mysql.jdbc.StringUtils;
import constant.MemberType;
import constant.ResultMessage;
import constant.Sexuality;
import data.dao.userdao.UserDao;
import data.daohelper.UserDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.UserPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class UserDaoHelperMySql implements UserDaoHelper{

    private DBHelper db = new DBHelper();

    public void init(){

        db.executeSql("USE OurData");
        // 账号 密码 昵称 头像url
        // 生日 会员等级 会员类型 信用值
        // 真实姓名 性别 邮箱 信用记录条数
        db.executeSql("CREATE TABLE if not exists UserInfo(userID char(11),password char(20),nickName char(10),image varchar(30)," +
                "birthday char(10),level tinyint,memberType tinyint,commerceName char(12),credit int," +
                "trueName varchar(10),sex tinyint,eMail char(30),creditRecordNum int)" );
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
        String getInfoSql = "SELECT *FROM UserInfo WHERE userID='"+userID+"' LIMIT 1";
        ResultSet result = db.query(getInfoSql);

        try{
            while(result.next()){
                String passWord = result.getString("password");
                String nickName = result.getString("nickName");
                String image = result.getString("image");
                String birth = result.getString("birthday");
                int level = result.getInt("level");
                LocalDate birthday = LocalDate.now();//////////
                MemberType type = MemberType.values()[result.getInt("memberType")];
                int credit = result.getInt("credit");
                String name = result.getString("trueName");
                Sexuality sex = Sexuality.values()[result.getInt("sex")];
                String eMail = result.getString("eMail");
                String commerceName = result.getString("commerceName");

                UserPO userPO = new UserPO(userID,passWord,nickName,image,
                		birthday,level,type,credit,name,sex,eMail,commerceName);
                return userPO;
            }

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
    // 修改用户基本信息
    public ResultMessage update(UserPO userPO) throws RemoteException {
        db.executeSql("USE OurData");
        
        String userID = userPO.getId();
        if(this.checkExistence(userID)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;
      
        String password = userPO.getPassword();
        String nickName = userPO.getNickName();
        String image = userPO.getImageAddress();
        int level = userPO.getLevel();
        MemberType type = userPO.getMemberType();
        int credit = userPO.getCredit();
        
        int sex = userPO.getSexuality().ordinal();
        String eMail = userPO.geteMail();
        String commerceName = userPO.getCommerceName();

        String updateSql = "UPDATE UserInfo SET password='"+password+"',nickName='"+nickName+"',image='"+image+
                "',level="+String.valueOf(level)+",memberType="+String.valueOf(type)+",credit="+String.valueOf(credit)
                +",sex="+String.valueOf(sex)+",eMail='"+eMail+"',commerceName='"+commerceName
                +"' WHERE userID='"+userID+"' LIMIT 1";
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

        String userID = userPO.getId();
        String password = userPO.getPassword();
        String nickName = userPO.getNickName();
        String image = userPO.getImageAddress();
        String name = userPO.getName();
        int sex = userPO.getSexuality().ordinal();
        String eMail = userPO.geteMail();
        String insertSql = "INSERT INTO UserInfo VALUES('"+userID+"','"+password+"','"+nickName+"','"+image+
                "',0,null,0,'"+ name+"',"+String.valueOf(sex)+",'"+eMail+"',0";
        db.executeSql(insertSql);

        return ResultMessage.succeed;
    }


    // 网站营销人员 制定会员等级制度
    public ResultMessage setMemberLevel(int[] gradeWithCredit) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    // 检查需要操作的账号存在
    public ResultMessage checkExistence(String id){
        String checkExistenceSql = "SELECT id FROM UserInfo";
        ResultSet result = db.query(checkExistenceSql);
        try{
            while(result.next())
                if(result.getString(1).equals(id))
                    return ResultMessage.idAlreadyExist;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return ResultMessage.idNotExist;
    }

}
