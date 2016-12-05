package data.daohelperimpl.webstaffdaohelperimpl;

import constant.ResultMessage;
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
public class WebSalsmanDaoHelperMySql {
    private DBHelper db = new DBHelper();

    public void init(){
        //path表示你所创建文件的路径
        String path = "D:\\360downloads";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        // fileName表示你创建的文件名；
        String fileName = "WebSalsman.db";
        File file = new File(f,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();}
        }

        db.executeSql("USE WebSalsman");
        // 账号 密码
        db.executeSql("CREATE TABLE WebSalsmanInfo(id char(12),password varchar(30),district varchar(20)" );
    }

    public void finish(){
        File f = new File("D:\\360downloads\\Login.db");  // 输入要删除的文件位置
        if(f.exists())
            f.delete();
    }
    public ResultMessage addWebSalesman(WebSalesmanPO webSalesmanPO) {
        String addWebSalesmanSql = "INSERT INTO WebSalesmanInfo VALUES('"+
               webSalesmanPO.getID()+"','"+webSalesmanPO.getPassword()+"','"+webSalesmanPO.getDistrict()+"')";
        db.executeSql(addWebSalesmanSql);
        return ResultMessage.succeed;
    }

    public ResultMessage updateWebSalesman(WebSalesmanPO webSalesmanPO) {
        String updateWebSalesmanSql = "UPDATE WebSalesmanInfo " +
                "SET password='"+webSalesmanPO.getPassword()+"',district='"+webSalesmanPO.getDistrict()+"'"+
                " WHERE id='"+webSalesmanPO.getID()+"' LIMIT 1";
        db.executeSql(updateWebSalesmanSql);
        return ResultMessage.succeed;
    }

    public ResultMessage delWebSalesman(String SalesmanID) {
        String delWebSalesmanSql = "DELETE FROM WebSalesmanInfo WHERE id='"+SalesmanID+"' LIMIT 1";
        db.executeSql(delWebSalesmanSql);
        return ResultMessage.succeed;
    }

    public WebSalesmanPO getSalesmanInstance(String SalesmanID) {
        return null;
    }

    public ArrayList<WebSalesmanPO> finds(String district) {
        String findWebSalesmanByDistrictSql = "SELECT *FROM WebSalesmanInfo WHERE district='"+district +"'";
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

    public ArrayList<WebSalesmanPO> getAll() {
        String findAllWebSalesmanSql = "SELECT *FROM WebSalesmanInfo";
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
