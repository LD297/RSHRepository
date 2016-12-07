package data.daohelperimpl.promotiondaohelperimpl;

import constant.ConditionType;
import constant.DeductionType;
import constant.ResultMessage;
import constant.ScopeType;
import data.daohelper.PromotionDaoHelper;
import data.daohelperimpl.jdbc.DBHelper;
import po.PromotionPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class PromotionDaoHelperMySql implements PromotionDaoHelper{

    private DBHelper db = new DBHelper();

    public void init(){

        db.executeSql("USE OurData");
        db.executeSql("CREATE TABLE PromotionInfo(setter char(10),id char(3),name varchar(15)," +
                "beginDate date,endDate date,scopeType tinyint,scopeNum char(20)," +
                "conditionType tinyint,conditionNum int,deductionType tinyint,deductionNum int)" );
    }

    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS PromotionInfo");
    }
    public ResultMessage insert(PromotionPO po)throws RemoteException {
        db.executeSql("USE OurData");
        String setter = po.getSetter();
        String id = po.getId();
        String name = po.getName();
        Date beginDate = po.getBeginDate();
        Date endDate = po.getEndDate();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String begin = sdf.format(beginDate);
        String end =sdf.format(endDate);
        int scopeType = po.getScopeType().ordinal();
        String scopeNum = po.getScopeNum();
        int conditionType = po.getConditionType().ordinal();
        int conditionNum = po.getCondionNum();
        int deductionType = po.getDeductionType().ordinal();
        int deductionNum = po.getDeductionNum();
        String insertSql = "INSERT INTO PromotionInfo VALUES('" +setter+"','"+id+"','"+name+"','"+
                begin+"','"+end+"',"+String.valueOf(scopeType)+","+String.valueOf(scopeNum)+"," +
                String.valueOf(conditionType)+","+String.valueOf(conditionNum)+","+
                String.valueOf(deductionType)+","+String.valueOf(deductionNum)+")";
        db.executeSql(insertSql);
        return ResultMessage.succeed;
    }

    public ResultMessage delete(String setter, String id)throws RemoteException {
        db.executeSql("USE OurData");
        String deleteSql = "DELETE FROM PromotionInfo WHERE setter='"+setter+"' and id='"+id+"' LIMIT 1";
        db.executeSql(deleteSql);
        return ResultMessage.succeed;
    }

    public ResultMessage update(PromotionPO po)throws RemoteException {
        db.executeSql("USE OurData");
        String setter = po.getSetter();
        String id = po.getId();
        String name = po.getName();
        Date beginDate = po.getBeginDate();
        Date endDate = po.getEndDate();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String begin = sdf.format(beginDate);
        String end =sdf.format(endDate);
        int scopeType = po.getScopeType().ordinal();
        String scopeNum = po.getScopeNum();
        int conditionType = po.getConditionType().ordinal();
        int conditionNum = po.getCondionNum();
        int deductionType = po.getDeductionType().ordinal();
        int deductionNum = po.getDeductionNum();
        String updateSql = "UPDATE PromotionInfo SET name='"+name+"',beginDate='"+begin+"',endDate='"+end+"',"+
                "scopeType="+String.valueOf(scopeType)+",scopeNum="+scopeNum+",conditionType="+String.valueOf(conditionType)+
                ",conditionNum="+String.valueOf(conditionNum)+",deductionType="+String.valueOf(deductionType)+
                ",deductionNum="+String.valueOf(deductionNum)+
                " WHERE setter='"+setter+"' and id='"+id+"' LIMIT 1";
        db.executeSql(updateSql);
        return ResultMessage.succeed;
    }
    // 根据制定者和序号数得到策略
    public PromotionPO find(String setter, String id)throws RemoteException {
        db.executeSql("USE OurData");

        String findSql = "SELECT *FROM PromotionInfo  WHERE setter='"+setter+"' and id='"+id+"' LIMIT 1";
        ResultSet result = db.query(findSql);
        return this.resultToPO(result).get(0);
    }
    // 根据制定者得到策略列表
    public ArrayList<PromotionPO> finds(String district,String hotel)throws RemoteException {
        db.executeSql("USE OurData");
        String findsSql = "SELECT *From PromotionInfo";
        ResultSet result = db.query(findsSql);
        ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();

        try{
            while(result.next()){
                if(result.getString(7).substring(0,10).equals(district+"0000")||result.getString(7).substring(0,10)==hotel){
                    String setter = result.getString(1);
                    String id = result.getString(2);
                    String name = result.getString(3);
                    Date beginDate = result.getDate(4);
                    Date endDate = result.getDate(5);
                    ScopeType sType = ScopeType.values()[result.getInt(6)];
                    String sNum = result.getString(7);
                    ConditionType cType = ConditionType.values()[result.getShort(8)];
                    int cNum = result.getInt(9);
                    DeductionType dType = DeductionType.values()[result.getInt(10)];
                    int dNum = result.getInt(11);

                    PromotionPO po = new PromotionPO(setter,id,name,beginDate,endDate,sType,sNum,cType,cNum,dType,dNum);
                    list.add(po);
                }
                return list;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<PromotionPO> resultToPO(ResultSet result){
        ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
        try{
            while(result.next()){
                String setter = result.getString(1);
                String id = result.getString(2);
                String name = result.getString(3);
                Date beginDate = result.getDate(4);
                Date endDate = result.getDate(5);
                ScopeType sType = ScopeType.values()[result.getInt(6)];
                String sNum = result.getString(7);
                ConditionType cType = ConditionType.values()[result.getShort(8)];
                int cNum = result.getInt(9);
                DeductionType dType = DeductionType.values()[result.getInt(10)];
                int dNum = result.getInt(11);

                PromotionPO po = new PromotionPO(setter,id,name,beginDate,endDate,sType,sNum,cType,cNum,dType,dNum);
                list.add(po);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
