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
        db.executeSql("CREATE TABLE UserInfo(userID char(11),password varchar(30),nickName varchar(10),image varchar(30)," +
                "birthday char(10),grade tinyint,memberType tinyint,credit int," +
                "trueName varchar(10),sex tinyint,eMail varchar(30),creditRecordNum int)" );
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
                String passWord = result.getString(2);
                String nickName = result.getString(3);
                String image = result.getString(4);
                String birth = result.getString(5);
                LocalDate birthday = LocalDate.now();
                int level = result.getInt(6);
                MemberType type = MemberType.values()[result.getInt(7)];
                int credit = result.getInt(8);
                String name = result.getString(9);
                Sexuality sex = Sexuality.values()[result.getInt(10)];
                String eMail = result.getString(11);

                UserPO userPO = new UserPO(userID,passWord,nickName,image,birthday,level,type,credit,name,sex,eMail,null){};
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
        if(this.checkExistence(userPO.getId())==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        String userid = userPO.getId();
        String password = userPO.getPassword();
        String nickName = userPO.getNickName();
        String image = userPO.getImageAddress();

        String name = userPO.getName();
        int sex = userPO.getSexuality().ordinal();
        String eMail = userPO.geteMail();

        String updateSql = "UPDATE UserInfo SET password='"+password+"',nickName='"+nickName+"',image='"+image+
                "',trueName='"+name+"',sex="+String.valueOf(sex)+",eMail='"+eMail+"' WHERE userID='"+userid+"' LIMIT 1";
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
        String passWord = userPO.getPassword();
        String nickName = userPO.getNickName();
        String image = userPO.getImageAddress();
        String name = userPO.getName();
        int sex = userPO.getSexuality().ordinal();
        String eMail = userPO.geteMail();
        String insertSql = "INSERT INTO UserInfo VALUES('"+userID+"','"+passWord+"','"+nickName+"','"+image+
                "',0,0,0,'"+ name+"',"+String.valueOf(sex)+",'"+eMail+"',0";
        db.executeSql(insertSql);

        return ResultMessage.succeed;
    }
    // 用户核实密码
    public ResultMessage checkPassword(String id, String password) throws RemoteException {
        return ResultMessage.succeed;
       /* db.executeSql("USE OurData");

        if(this.checkExistence(id)==ResultMessage.idNotExist)
            return ResultMessage.idNotExist;

        String checkPasswordSql = "SELECT password FROM UserInfo WHERE userID='"+id+"' LIMIT 1";
        ResultSet result = db.query(checkPasswordSql);
        try{
            while(result.next()) {
                if (password.equals(result.getString(1)))
                    return ResultMessage.succeed;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        return  ResultMessage.fail;*/

    }
    // 用户注册普通会员
    public ResultMessage register(String userID) throws RemoteException {
        db.executeSql("USE OurData");

        String registerSql = "UPDATE UserInfo SET memberType=1 WHERE userID='"+userID+"' LIMIT 1";
        db.executeSql(registerSql);
        return ResultMessage.succeed;
    }
    // 用户注册企业会员
    public ResultMessage register(String userID, String commerceName) throws RemoteException {
        db.executeSql("USE OurData");

        String registerSql = "UPDATE UserInfo SET memberType=2 WHERE userID='"+userID+"' LIMIT 1";
        db.executeSql(registerSql);
        return ResultMessage.succeed;
    }
    // 网站营销人员 制定会员等级制度
    public ResultMessage setMemberLevel(int[][] gradeWithCredit) throws RemoteException {
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
