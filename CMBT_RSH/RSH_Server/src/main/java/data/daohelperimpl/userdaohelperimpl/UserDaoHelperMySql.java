package data.daohelperimpl.userdaohelperimpl;

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
        db.executeSql("CREATE TABLE UserInfo(userID char(26),password varchar(30),nickName varchar(10),image varchar(30)," +
                "birthday char(10),grade tinyint,memberType tinyint,credit int," +
                "trueName varchar(10),sex tinyint,eMail varchar(30),creditRecordNum int)" );
    }

    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS UserInfo");
    }
    // 根据id得到用户基本信息
    public UserPO getInfo(String id) throws RemoteException {
        db.executeSql("USE OurData");

        String getInfoSql = "SELECT *FROM UserInfo WHERE userID='"+id+"' LIMIT 1";
        ResultSet result = db.query(getInfoSql);

        try{
            while(result.next()){
                String password = result.getString(2);
                String nickName = result.getString(3);
                String image = result.getString(4);
                String birth = result.getString(5);
                int level = result.getInt(6);
                MemberType type = this.intToMemberType(result.getInt(7));
                int credit = result.getInt(8);
                String name = result.getString(9);
                Sexuality sex = this.intToSexuality(result.getInt(10));
                String eMail = result.getString(11);

                UserPO po = new UserPO(id,password,nickName,image,birth,level,type,credit,name,sex,eMail){};
                return po;
            }

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
    // 修改用户基本信息
    public ResultMessage update(UserPO po) throws RemoteException {
        db.executeSql("USE OurData");

        String userid = po.getId();
        String password = po.getPassword();
        String nickName = po.getNickName();
        String image = po.getImageAddress();

        String name = po.getName();
        int sex = this.sexualityToInt(po.getSexuality());
        String eMail = po.geteMail();

        String updateSql = "UPDATE UserInfo SET password='"+password+"',nickName='"+nickName+"',image='"+image+
                "',trueName='"+name+"',sex="+String.valueOf(sex)+",eMail='"+eMail+"' WHERE userID='"+userid+"' LIMIT 1";
        db.executeSql(updateSql);
        return ResultMessage.succeed;
    }
    // 注册成为用户
    // 账号 密码 昵称 头像url
    // 会员等级 会员类型 信用值
    // 真实姓名 性别 邮箱
    public ResultMessage insert(UserPO po) throws RemoteException {
        db.executeSql("USE OurData");

        String id = po.getId();
        String password = po.getPassword();
        String nickName = po.getNickName();
        String image = po.getImageAddress();
        String name = po.getName();
        int sex = this.sexualityToInt(po.getSexuality());
        String eMail = po.geteMail();
        String insertSql = "INSERT INTO UserInfo VALUES('"+id+"','"+password+"','"+nickName+"','"+image+
                "',0,0,0,'"+ name+"',"+String.valueOf(sex)+",'"+eMail+"',0";
        db.executeSql(insertSql);

        return ResultMessage.succeed;
    }
    // 用户核实密码
    public ResultMessage checkPassword(String id, String password) throws RemoteException {
        db.executeSql("USE OurData");

        String checkPasswordSql = "SELECT password FROM UserInfo WHERE userID='"+id+"' LIMIT 1";
        ResultSet result = db.query(checkPasswordSql);
        try{
            while(result.next()) {
                if (password.equals(result.getString(1)))
                    return ResultMessage.succeed;
                else
                    return ResultMessage.fail;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        return ResultMessage.succeed;
    }
    // 用户注册普通会员
    public ResultMessage register(String id) throws RemoteException {
        db.executeSql("USE OurData");

        String registerSql = "UPDATE UserInfo SET memberType=1 WHERE userID='"+id+"' LIMIT 1";
        db.executeSql(registerSql);
        return ResultMessage.succeed;
    }
    // 用户注册企业会员
    public ResultMessage register(String id, String commerceName) throws RemoteException {
        db.executeSql("USE OurData");

        String registerSql = "UPDATE UserInfo SET memberType=2 WHERE userID='"+id+"' LIMIT 1";
        db.executeSql(registerSql);
        return ResultMessage.succeed;
    }

    public MemberType intToMemberType(int type){
       return MemberType.values()[type];
    }
    public int memberTypeToInt(MemberType type){
        return type.ordinal();
    }

    public Sexuality intToSexuality(int sex){
        return Sexuality.values()[sex];
    }
    public int sexualityToInt(Sexuality sex){
       return sex.ordinal();
    }

}
