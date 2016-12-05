package data.daohelperimpl.logindaohelperimpl;

import constant.ResultMessage;
import constant.Role;
import data.daohelperimpl.jdbc.DBHelper;
import po.OnlinePersonPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class LoginDaoHelperMySql {
    private DBHelper db = new DBHelper();

    public void init(){
        //path表示你所创建文件的路径
        String path = "D:\\360downloads";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        // fileName表示你创建的文件名；
        String fileName = "Login.db";
        File file = new File(f,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();}
        }

        db.executeSql("USE Login");
        // 身份 账号 密码
        db.executeSql("CREATE TABLE OnlineInfo(role tinyint,id char(26),password varchar(30))" );
    }

    public void finish(){
        File f = new File("D:\\360downloads\\Login.db");  // 输入要删除的文件位置
        if(f.exists())
            f.delete();
    }

    public ResultMessage addOnline(OnlinePersonPO po) throws RemoteException {
        String addOnlineSql = "INSERT INTO OnlineInfo VALUES("+
                String.valueOf(this.roleToInt(po.getRole()))+",'"+po.getId()+"','"+po.getPassword()+"')";
        db.executeSql(addOnlineSql);
        return ResultMessage.succeed;
    }

    public ResultMessage deleteOnline(Role role, String id) throws RemoteException {
        String deleteOnlineSql = "DELECT FROM OnlineInfo WHERE role="+
                String.valueOf(this.roleToInt(role))+" and id='"+id+"' LIMIT 1";
        db.executeSql(deleteOnlineSql);
        return ResultMessage.succeed;
    }

    public int roleToInt(Role role){
        if(role==Role.user)
            return 1;
        else if(role==Role.hotel)
            return 2;
        else if(role==Role.webmanager)
            return 3;
        else
            return 4;
    }
}
