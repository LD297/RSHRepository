package data.daohelperimpl.webstaffdaohelperimpl;

//import bl.webstaffserviceimpl.WebManager;
import constant.ResultMessage;
import data.daohelper.WebManagerDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.WebManagerPO;
import po.WebSalesmanPO;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class WebManagerDaoHelperMySql implements WebManagerDaoHelper{
    // with websalesman
    private DBHelper db = new DBHelper();
    public void init(){
        db.executeSql("USE OurData");
        // 账号 密码 地区
        String initSql = "INSERT INTO WebStaffInfo VALUES('0000000000','123456','000000')";
        db.executeSql(initSql);
    }
    // 更新管理人员信息
    public ResultMessage update (String managerID,String password)throws RemoteException {
        db.executeSql("USE OurData");
        String updateMangerSql = "UPDATE WebStaffInfo SET password='"+password+
                "' WHERE id='"+managerID+"' LIMIT 1";
        db.executeSql(updateMangerSql);
        return ResultMessage.succeed;
    }
    // 得到管理人员信息
    public WebManagerPO getManagerInfo(String managerID)throws RemoteException{
        db.executeSql("USE OurData");
        String getManagerSql = "SELECT *FROM WebStaffInfo WHERE id='"+managerID+"' LIMIT 1";
        ResultSet result = db.query(getManagerSql);
        try{
            while(result.next()){
                String id = result.getString(1);
                String password = result.getString(2);
                return new WebManagerPO(id,password);
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
