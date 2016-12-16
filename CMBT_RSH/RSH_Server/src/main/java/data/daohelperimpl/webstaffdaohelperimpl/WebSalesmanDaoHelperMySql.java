package data.daohelperimpl.webstaffdaohelperimpl;

import constant.ResultMessage;
import data.daohelper.WebSalesmanDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.WebSalesmanPO;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class WebSalesmanDaoHelperMySql implements WebSalesmanDaoHelper{
    private DBHelper db = new DBHelper();

    public void init(){

        db.executeSql("USE OurData");
        // 账号 密码 地区 IF NOT EXISTS
        db.executeSql("CREATE TABLE if not exists WebStaffInfo(id char(12),password varchar(30),district varchar(20))" );
    }

    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS WebStaffInfo");
    }
    // 网站营销人员添加
    public ResultMessage insert(WebSalesmanPO po) {
        db.executeSql("USE OurData");
        if(this.checkExistence(po.getID())==ResultMessage.idNotExist){
            String addWebSalesmanSql = "INSERT INTO WebStaffInfo VALUES('"+
               po.getID()+"','"+po.getPassword()+"','"+po.getDistrict()+"')";
            db.executeSql(addWebSalesmanSql);
            return ResultMessage.succeed;
        }
        else
            return ResultMessage.idAlreadyExist;
    }
    // 网站营销人员更新
    public ResultMessage update(WebSalesmanPO po) {
        db.executeSql("USE OurData");
        if(this.checkExistence(po.getID())==ResultMessage.idAlreadyExist){
            String updateWebSalesmanSql = "UPDATE WebStaffInfo " +
                "SET password='"+po.getPassword()+"',district='"+po.getDistrict()+"'"+
                " WHERE id='"+po.getID()+"' LIMIT 1";
            db.executeSql(updateWebSalesmanSql);
            return ResultMessage.succeed;
        }
        else
            return ResultMessage.idNotExist;
    }
    // 网站营销人员注销
    public ResultMessage delete(String id) {
        db.executeSql("USE OurData");
        if(this.checkExistence(id)==ResultMessage.idAlreadyExist) {
            String delWebSalesmanSql = "DELETE FROM WebStaffInfo WHERE id='" + id + "' LIMIT 1";
            db.executeSql(delWebSalesmanSql);
            return ResultMessage.succeed;
        }
        else
            return ResultMessage.idNotExist;
    }
    // 网站管理人员 根据id查找 网站营销人员
    public WebSalesmanPO findByID(String id) {
        db.executeSql("USE OurData");

        String getSalesmanByIDSql = "SELECT *FROM WebStaffInfo WHERE id='"+id+"' LIMIT 1";
        ResultSet result = db.query(getSalesmanByIDSql);
        try{
            while (result.next()){
                WebSalesmanPO po = new WebSalesmanPO(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
                return po;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
    // 网站管理人员 根据地区查找 网站营销人员
    public ArrayList<WebSalesmanPO> findByDistrict(String district) {
        db.executeSql("USE OurData");

        String findWebSalesmanByDistrictSql = "SELECT *FROM WebStaffInfo WHERE district='"+district +"'";
        ResultSet result = db.query(findWebSalesmanByDistrictSql);
        ArrayList<WebSalesmanPO> webSalesmanlist = new ArrayList<WebSalesmanPO>();
        try{
            while(result.next()){
                WebSalesmanPO po = new WebSalesmanPO(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
                webSalesmanlist.add(po);
            }
            return webSalesmanlist;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    // 网站管理人员 查找 网站营销人员
    public ArrayList<WebSalesmanPO> getAll() {
        db.executeSql("USE OurData");

        String findAllWebSalesmanSql = "SELECT *FROM WebStaffInfo";
        ResultSet result = db.query(findAllWebSalesmanSql);
        ArrayList<WebSalesmanPO> webSalesmanlist = new ArrayList<WebSalesmanPO>();
        try{
            while(result.next()){
                WebSalesmanPO po = new WebSalesmanPO(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
                webSalesmanlist.add(po);
            }
            return webSalesmanlist;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    // 检查需要操作的账号存在
    public ResultMessage checkExistence(String id){
        String checkExistenceSql = "SELECT id FROM WebStaffInfo";
        ResultSet result = db.query(checkExistenceSql);
        try{
            while(result.next())
                if(result.getString(1).equals(id))
                    return ResultMessage.idAlreadyExist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ResultMessage.idNotExist;
    }
}
