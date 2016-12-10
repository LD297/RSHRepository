package data.daohelperimpl.logindaohelperimpl;

import constant.ResultMessage;
import constant.Role;
import data.daohelper.LoginDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.OnlinePersonPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class LoginDaoHelperMySql implements LoginDaoHelper{
    private DBHelper db = new DBHelper();

    public void init(){

        db.executeSql("USE OurData");
        // 身份 账号 密码
        db.executeSql("CREATE TABLE if not exists OnlineInfo(role tinyint,id char(26),password varchar(30))" );
    }

    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS OnlineInfo");
    }
    // 添加在线人员
    public ResultMessage addOnline(OnlinePersonPO po) throws RemoteException {
        db.executeSql("USE OurData");

        String addOnlineSql = "INSERT INTO OnlineInfo VALUES("+
                String.valueOf(po.getRole().ordinal())+",'"+po.getId()+"','"+po.getPassword()+"')";
        db.executeSql(addOnlineSql);
        return ResultMessage.succeed;
    }
    // 去除在线人员
    public ResultMessage deleteOnline(Role role, String id) throws RemoteException {
        db.executeSql("USE OurData");

        String deleteOnlineSql = "DELECT FROM OnlineInfo WHERE role="+
                String.valueOf(role.ordinal())+" and id='"+id+"' LIMIT 1";
        db.executeSql(deleteOnlineSql);
        return ResultMessage.succeed;
    }


}
