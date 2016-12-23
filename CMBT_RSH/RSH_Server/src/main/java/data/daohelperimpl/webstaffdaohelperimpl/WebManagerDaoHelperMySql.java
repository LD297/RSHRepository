package data.daohelperimpl.webstaffdaohelperimpl;

//import bl.webstaffserviceimpl.WebManager;
import constant.ResultMessage;
import data.daohelper.WebManagerDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.WebManagerPO;
import po.WebSalesmanPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class WebManagerDaoHelperMySql implements WebManagerDaoHelper{
	// with websalesman
    private DBHelper db = new DBHelper();
    private static final String key = "&fas03#j63uk,qw4";

    public void init() {
        db.executeSql("USE OurData");
        // 账号 密码 地区
        String initSql = "INSERT INTO WebStaffInfo VALUES('0000000000',"
        		+ "aes_encrypt('123456','"+key+"'),null)";
        db.executeSql(initSql);
    }
    // 更新管理人员信息
    public ResultMessage update(String managerID,String password)throws RemoteException {
        db.executeSql("USE OurData");
        String dePassword = "aes_encrypt('"+password+"','"+key+"')";
        String updateMangerSql = "UPDATE WebStaffInfo SET password="+dePassword+
                " WHERE id='"+managerID+"' LIMIT 1";
        db.executeSql(updateMangerSql);
        return ResultMessage.succeed;
    }
    // 得到管理人员信息
    public WebManagerPO getManagerInfo(String managerID)throws RemoteException{
        db.executeSql("USE OurData");
        String getManagerSql = "SELECT aes_decrypt(password,'"+key+"') From WebStaffInfo"
        		+ " WHERE id='"+managerID+"' LIMIT 1";
        ResultSet result = db.query(getManagerSql);
        try{
            while(result.next()){
                String password = result.getString(1);
                return new WebManagerPO(managerID,password);
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
