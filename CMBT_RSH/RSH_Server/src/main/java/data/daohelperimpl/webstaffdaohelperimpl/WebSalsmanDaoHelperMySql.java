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
public class WebSalsmanDaoHelperMySql implements WebSalesmanDaoHelper{
    private DBHelper db = new DBHelper();

    public void init(){

        db.executeSql("USE OurData");
        // 账号 密码
        db.executeSql("CREATE TABLE WebStaffInfo(id char(12),password varchar(30),district varchar(20)" );
    }

    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS WebStaffInfo");
    }
    // 网站营销人员添加
    public ResultMessage addWebSalesman(WebSalesmanPO webSalesmanPO) {
        db.executeSql("USE OurData");

        String addWebSalesmanSql = "INSERT INTO WebStaffInfo VALUES('"+
               webSalesmanPO.getID()+"','"+webSalesmanPO.getPassword()+"','"+webSalesmanPO.getDistrict()+"')";
        db.executeSql(addWebSalesmanSql);
        return ResultMessage.succeed;
    }
    // 网站营销人员更新
    public ResultMessage updateWebSalesman(WebSalesmanPO webSalesmanPO) {
        db.executeSql("USE OurData");

        String updateWebSalesmanSql = "UPDATE WebStaffInfo " +
                "SET password='"+webSalesmanPO.getPassword()+"',district='"+webSalesmanPO.getDistrict()+"'"+
                " WHERE id='"+webSalesmanPO.getID()+"' LIMIT 1";
        db.executeSql(updateWebSalesmanSql);
        return ResultMessage.succeed;
    }
    // 网站营销人员注销
    public ResultMessage delWebSalesman(String webSalesmanID) {
        db.executeSql("USE OurData");

        String delWebSalesmanSql = "DELETE FROM WebStaffInfo WHERE id='"+webSalesmanID+"' LIMIT 1";
        db.executeSql(delWebSalesmanSql);
        return ResultMessage.succeed;
    }
    // 网站管理人员 根据id查找 网站营销人员
    public WebSalesmanPO getSalesmanByID(String webSalesmanID) {
        db.executeSql("USE OurData");

        String getSalesmanByIDSql = "SELECT *FROM WebStaffInfo WHERE id='"+webSalesmanID+"' LIMIT 1";
        ResultSet result = db.query(getSalesmanByIDSql);
        try{
            while (result.next()){
                WebSalesmanPO po = new WebSalesmanPO(result.getString(1),result.getString(2),result.getString(3));
                return po;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
    // 网站管理人员 根据地区查找 网站营销人员
    public ArrayList<WebSalesmanPO> finds(String district) {
        db.executeSql("USE OurData");

        String findWebSalesmanByDistrictSql = "SELECT *FROM WebStaffInfo WHERE district='"+district +"'";
        ResultSet result = db.query(findWebSalesmanByDistrictSql);
        ArrayList<WebSalesmanPO> webSalesmanlist = new ArrayList<WebSalesmanPO>();
        try{
            while(result.next()){
                WebSalesmanPO po = new WebSalesmanPO(result.getString(1),result.getString(2),result.getString(3));
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
                WebSalesmanPO po = new WebSalesmanPO(result.getString(1),result.getString(2),result.getString(3));
                webSalesmanlist.add(po);
            }
            return webSalesmanlist;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
