package data.daohelperimpl.webstaffdaohelperimpl;

import constant.ResultMessage;
import data.daohelper.WebSalesmanDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.WebManagerPO;
import po.WebSalesmanPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class WebSalesmanDaoHelperMySql implements WebSalesmanDaoHelper{
	private DBHelper db = new DBHelper();
    private static final String key = "13klad0s";
    public void init() {

        db.executeSql("USE OurData");
        // 账号 密码 姓名 地区 IF NOT EXISTS
        db.executeSql("CREATE TABLE if not exists WebStaffInfo(id char(10),"
        		+ "password blob,district char(6))" );
    }

    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS WebStaffInfo");
    }
    // 网站营销人员添加
    public ResultMessage insert(WebSalesmanPO po) {
        db.executeSql("USE OurData");
        String salesManID = this.getNewID();
        String password = "aes_encrypt('"+po.getPassword()+"','"+key+"')";
        
        if(this.checkExistence(po.getID())==ResultMessage.idNotExist){
            String addWebSalesmanSql = "INSERT INTO WebStaffInfo VALUES('"+
               salesManID+"',"+password+",'"+po.getDistrict()+"')";
            db.executeSql(addWebSalesmanSql);
            return ResultMessage.succeed;
        }
        else
            return ResultMessage.idAlreadyExist;
    }
    // 网站营销人员更新
    public ResultMessage update(WebSalesmanPO po) {
        db.executeSql("USE OurData");

        String password = "aes_encrypt('"+po.getPassword()+"','"+key+"')";
        if(this.checkExistence(po.getID())==ResultMessage.idAlreadyExist){
            String updateWebSalesmanSql = "UPDATE WebStaffInfo " +
                "SET password="+password+",district='"+po.getDistrict()+"'"+
                " WHERE id='"+po.getID()+"' LIMIT 1";
            db.executeSql(updateWebSalesmanSql);
            return ResultMessage.succeed;
        }
        else
            return ResultMessage.idNotExist;
    }
    
    // 网站管理人员 根据id查找 网站营销人员
    public WebSalesmanPO findByID(String id) {
        db.executeSql("USE OurData");

        String getSalesmanByIDSql = "SELECT count(*) FROM WebStaffInfo WHERE id='"+id+"' LIMIT 1";
        ResultSet result = db.query(getSalesmanByIDSql);
        try{
        	while(result.next())
        		if(result.getInt(1)<=0)
        			return null;
        }catch(SQLException e){
        	e.printStackTrace();
        }
        String getPasswordSql = "SELECT aes_decrypt(password,'"+key+"'),district FROM WebStaffInfo"
        		+ " WHERE id='"+id+"' LIMIT 1";
        ResultSet pwResult = db.query(getPasswordSql);
        try{
        	while(pwResult.next()){
        		String password = pwResult.getString(1);
        		String district = pwResult.getString(2);
        		return new WebSalesmanPO(id,password,district);
        	}
        }catch(SQLException e){
        	e.printStackTrace();
        }
        return null;
    }
    // 网站管理人员 根据地区查找 网站营销人员
    public ArrayList<WebSalesmanPO> findByDistrict(String district) {
        db.executeSql("USE OurData");
        ArrayList<WebSalesmanPO> list = new ArrayList<WebSalesmanPO>();
        String checkExistSql = "SELECT count(*) FROM WebStaffInfo WHERE district='"+district +"'";
        ResultSet result = db.query(checkExistSql);
        try{
        	while(result.next())
        		if(result.getInt(1)<=0)
        			return new ArrayList<WebSalesmanPO>();
        }catch(SQLException e){
        	e.printStackTrace();
        }
        
        String getInfoSql = "SELECT id,aes_decrypt(password,'"+key+"') FROM WebStaffInfo "
        		+ "WHERE district='"+district +"'";
        ResultSet infoResult = db.query(getInfoSql);
        try{
        	while(infoResult.next()){
        		String id = infoResult.getString(1);
        		String password = infoResult.getString(2);
        		list.add(new WebSalesmanPO(id,password,district));
        	}
        	return list;
        }catch(SQLException e){
        	e.printStackTrace();
        }
        return new ArrayList<WebSalesmanPO>();
    }
    // 网站管理人员 查找 网站营销人员
    public ArrayList<WebSalesmanPO> getAll() {
        db.executeSql("USE OurData");

        String findAllWebSalesmanSql = "SELECT count(*) FROM WebStaffInfo";
        ResultSet result = db.query(findAllWebSalesmanSql);
        try{
        	while(result.next())
        		if(result.getInt(1)<=0)
        			return new ArrayList<WebSalesmanPO>();
        }catch(SQLException e){
        	e.printStackTrace();
        }
        String infoSql = "SELECT *FROM WebStaffInfo";
        ResultSet infoResult = db.query(infoSql);
        ArrayList<WebSalesmanPO> list = this.resultSetTOPO(infoResult);
        
        String getPasswordSql = "SELECT aes_decrypt(password,'"+key+"') FROM WebStaffInfo";
        ResultSet pwResult = db.query(getPasswordSql);
        try{
        	int i=0;
        	while(pwResult.next()){
        		list.get(i).setPassword(pwResult.getString(1));
        	}
        	return list;
        }catch(SQLException e){
        	e.printStackTrace();
        }
        return list; 
    }
    
    // 完成resultSet->po的转换
    private ArrayList<WebSalesmanPO> resultSetTOPO(ResultSet result){
    	ArrayList<WebSalesmanPO> list = new ArrayList<WebSalesmanPO>();
        try{
            while(result.next()){
            	if(result.getString("id")=="0000000000")
            		continue;
                WebSalesmanPO po = new WebSalesmanPO(result.getString("id"),
                		result.getString("password"),result.getString("district"));
                list.add(po);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    // 得到新的网站营销人员编号
    public String getNewID(){
    	Calendar instance = Calendar.getInstance();
    	String year = String.valueOf(instance.get(Calendar.YEAR));
    	String checkNumSql = "SELECT id FROM WebStaffInfo";
    	ResultSet result = db.query(checkNumSql);
    	
    	int num = 0;
    	try{
    		while(result.next()){
    			if(result.getString(1).substring(0, 4).equals(year))
    				num++;
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    		return null;
    	}
    	return year+String.format("%6d", num+1).replace(" ", "0");
    }
    
    // 检查需要操作的账号存在
    private ResultMessage checkExistence(String id){
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
