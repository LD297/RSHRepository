package data.daohelperimpl.userdaohelperimpl;

import constant.CreditAction;
import constant.ResultMessage;
import data.daohelper.CreditRecordListDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.CreditRecordPO;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class CreditRecordListDaoHelperMySql implements CreditRecordListDaoHelper {

    private DBHelper db = new DBHelper();

    public void init(){

        db.executeSql("USE OurData");
        // 账号 日期 订单号 信用更改原因 信用变化 变更后信用值
        db.executeSql("CREATE TABLE if not exists CreditRecordInfo(userID char(11),changeDate date,orderID char(26)," +
                "creditAction tinyint,changeValue int,credit int)" );
    }

    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS CreditRecordInfo");
    }
    
    public Iterator<CreditRecordPO> getCreditRecordList(String userID) throws RemoteException {
        db.executeSql("USE OurData");

        String getCreditRecordNumSql = "SELECT creditRecordNum FROM UserInfo WHERE userID='"+userID+"' LIMIT 1";
        ResultSet recordNumResult = db.query(getCreditRecordNumSql);
        int recordNum = 0;
        try{
            while(recordNumResult.next()){
                recordNum  = recordNumResult.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        ArrayList<CreditRecordPO> CreditRecordList = new ArrayList<CreditRecordPO>();
        if(recordNum >0){
            String getCreditRecordListSql = "SELECT *FROM CreditRecordInfo WHERE userID='"+ userID+"' LIMIT "+String.valueOf(recordNum);
            ResultSet result = db.query(getCreditRecordListSql);
            try{
                while(result.next()){
                    Date date = result.getDate("changeDate");
                    String orderID = result.getString("orderID");
                    CreditAction creditAction = CreditAction.values()[result.getInt("creditAction")];
                    int changeValue = result.getInt("changeValue");
                    String change = String.valueOf(changeValue);
                    if(changeValue>0)
                    	change = "+"+change;
                    int credit= result.getInt("credit");
                   
                    CreditRecordList.add(new CreditRecordPO(userID,date,orderID,creditAction,change,credit));
                }
                Iterator<CreditRecordPO> iter = CreditRecordList.iterator();
                return iter;
            }catch(SQLException e){
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException {
        db.executeSql("USE OurData");

        String userID = po.getUserid();
        
        String getCreditRecordSql = "SELECT creditRecordNum FROM UserInfo WHERE userID='"+userID+"' LIMIT 1";
        ResultSet recordResult = db.query(getCreditRecordSql);
        int creditNum = -1;
        try{
        	while(recordResult.next()){
        		creditNum = recordResult.getInt(1);
        	}
        }catch(SQLException e){
        	e.printStackTrace();
        	return ResultMessage.fail;
        }
        
        Date date = po.getDate();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dateStr=sdf.format(date);
        String orderID = po.getOrderID();
        int action = po.getCreditAction().ordinal();
        String change = po.getChange();
        int creditUpdated = po.getCredit();
        
        String addCreditRecordSql = "INSERT INTO CreditRecordInfo VALUES('"+userID+"','"+dateStr+"','"+orderID+"',"
                +String.valueOf(action)+","+change.substring(1)+","+String.valueOf(creditUpdated)+")";
        db.executeSql(addCreditRecordSql);
        
        String updateUserInfoSql = "UPDATE UserInfo SET credit="+String.valueOf(creditUpdated)
        		+",creditRecordNum="+String.valueOf(creditNum+1)+" WHERE userID='"+userID+"' LIMIT 1";
        db.executeSql(updateUserInfoSql);
        
        return ResultMessage.succeed;
    }
  
}
