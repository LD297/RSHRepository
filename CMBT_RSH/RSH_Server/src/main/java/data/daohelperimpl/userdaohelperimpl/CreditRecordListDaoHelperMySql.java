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
        db.executeSql("CREATE TABLE CreditRecordInfo(userID char(9),changeDate date,orderID char(26)," +
                "creditAction tinyint,isPlus tinyint,changeValue int,credit int)" );
    }

    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS CreditRecordInfo");
    }
    public Iterator<CreditRecordPO> getCreditRecordList(String userid) throws RemoteException {
        db.executeSql("USE OurData");

        String getCreditRecordNumSql = "SELECT credit,creditRecordNum FROM UserInfo WHERE userID='"+userid+"' LIMIT 1";
        ResultSet recordNumResult = db.query(getCreditRecordNumSql);
        int recordNum = 0;
        int credit = -9999;
        try{
            while(recordNumResult.next()){
                credit = recordNumResult.getInt(1);
                recordNum  = recordNumResult.getInt(2);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        ArrayList<CreditRecordPO> CreditRecordList = new ArrayList<CreditRecordPO>();
        if(recordNum >0){
            String getCreditRecordListSql = "SELECT *FROM CreditRecordInfo WHERE userID='"+ userid+"' LIMIT "+String.valueOf(recordNum );
            ResultSet result = db.query(getCreditRecordListSql);
            try{
                while(result.next()){

                    Date date = result.getDate(2);
                    String orderid = result.getString(3);
                    CreditAction creditAction = this.intToCreditAction(result.getInt(4));
                    String change;
                    if(result.getInt(5)==0){
                        change = "+"+String.valueOf(result.getInt(6));
                        credit -= result.getInt(6);
                    }
                    else{
                        change = "-"+String.valueOf(result.getInt(6));
                        credit += result.getInt(6);
                    }
                    CreditRecordList.add(new CreditRecordPO(userid,date,orderid,creditAction,change,credit));
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

        String userid = po.getUserid();
        Date date = po.getDate();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dateStr=sdf.format(date);

        String orderid = po.getOrderid();
        int action = this.creditActionToInt(po.getCreditAction());
        String change = po.getChange();
        int credit = po.getCredit();
        //creditAction tinyint,isPlus tinyint,changeValue int,credit int
        String addCreditRecordSql = "INSERT INTO CreditRecordInfo VALUES('"+userid+"','"+dateStr+"','"+orderid+"',"
                +String.valueOf(action)+",'"+change.charAt(0)+"',"+Integer.valueOf(change.substring(1))+","+String.valueOf(credit)+")";
        db.executeSql(addCreditRecordSql);
        return ResultMessage.succeed;
    }
    public int creditActionToInt(CreditAction action){
        return action.ordinal();
    }
    public CreditAction intToCreditAction(int action){

        return  CreditAction.values()[action];
    }
}
