package data.daohelperimpl.promotiondaohelperimpl;

import constant.ConditionType;
import constant.DeductionType;
import constant.ResultMessage;
import constant.ScopeType;
import data.daohelper.PromotionDaoHelper;
import data.daohelperimpl.DaoHelperFactoryImpl;
import data.daohelperimpl.jdbc.DBHelper;
import po.PromotionPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class PromotionDaoHelperMySql implements PromotionDaoHelper{
	private DBHelper db = DaoHelperFactoryImpl.getDBHelper();

    public void init() {                         

        db.executeSql("USE OurData");
        // 制定者 序号 策略名称
        // 生效日期 失效日期(2010-01-01默认0点) 针对类型（地区，酒店，房间类型） 具体条件（酒店id10位(前6位地区id)，房间类型Str）
        // 适用条件（房间数量、价值、会员等级（企业会员）、用户生日）
        // 折扣方式（打折，降价） 数字均为正数  满200减20(200,20) 满2间打8折(2,0.8) 满10级减10(10,10) 用户生日：85折(0,0.85)
        db.executeSql("CREATE TABLE if not exists PromotionInfo(setter char(10),id char(3),name char(10)," +
                "beginDate date,endDate date,scopeType tinyint,scopeNum char(20)," +
                "conditionType tinyint,conditionNum double,deductionType tinyint,deductionNum double)default character set utf8" );
    }

    public void finish(){
        db.executeSql("USE OurData");
        db.executeSql("DROP TABLE IF EXISTS PromotionInfo");
    }
    
    // 得到新的促销策略的编号
 	public String getNewID(String setterID)throws RemoteException{
 		db.executeSql("USE OurData");
 		String selectNumSql = "SELECT count(*) FROM PromotionInfo WHERE setter='"+setterID+"'";
 		ResultSet result = db.query(selectNumSql);
 		try{
 			while(result.next()){
 				int num = result.getInt(1)+1;
 				String sort = String.format("%3d", num).replace(" ", "0");
 		    	return sort;
 			}
 		}catch(SQLException e){
 			e.printStackTrace();
 		}
 		return null;
 	}
    // 添加促销策略
    public ResultMessage insert(PromotionPO po)throws RemoteException {
        db.executeSql("USE OurData");
        String setter = po.getSetter();
        String id = po.getId();
        String name = po.getName();
		if(this.checkExistence(setter,name)==ResultMessage.idAlreadyExist)
			return ResultMessage.idAlreadyExist;
        
        Date beginDate = po.getBeginDate();
        Date endDate = po.getEndDate();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String begin = sdf.format(beginDate);
        String end =sdf.format(endDate);
        int scopeType = po.getScopeType().ordinal();
        String scopeNum = po.getScopeNum();
        int conditionType = po.getConditionType().ordinal();
        double conditionNum = po.getConditionNum();
        int deductionType = po.getDeductionType().ordinal();
        double deductionNum = po.getDeductionNum();

        String insertSql = "INSERT INTO PromotionInfo VALUES('" +setter+"','"+id+"','"+name+"','"+
                begin+"','"+end+"',"+String.valueOf(scopeType)+",'"+String.valueOf(scopeNum)+"'," +
                String.valueOf(conditionType)+","+String.valueOf(conditionNum)+","+
                String.valueOf(deductionType)+","+String.valueOf(deductionNum)+")";
        db.executeSql(insertSql);
        return ResultMessage.succeed;
    }
    // 删除促销策略
    public ResultMessage delete(String setter, String id)throws RemoteException {
        db.executeSql("USE OurData");
        String checkSql = "SELECT count(*) FROM PromotionInfo WHERE setter='"+setter+"' and id='"+id+"' LIMIT 1";
        ResultSet result = db.query(checkSql);
        try{
        	while(result.next())
        		if(result.getInt(1)<=0)
        			return ResultMessage.idNotExist;
        }catch(SQLException e){
        	e.printStackTrace();
        }
        
        String deleteSql = "DELETE FROM PromotionInfo WHERE setter='"+setter+"' and id='"+id+"' LIMIT 1";
        db.executeSql(deleteSql);
        return ResultMessage.succeed;
    }
    // 更新促销策略
    public ResultMessage update(PromotionPO po)throws RemoteException {
        db.executeSql("USE OurData");
        String setter = po.getSetter();
        String id = po.getId();
        String name = po.getName();
        
        String checkSql = "SELECT *FROM PromotionInfo WHERE setter='"+setter+"' and id='"+id+"' LIMIT 1";
        ResultSet result = db.query(checkSql);
        if(result==null)
        	return ResultMessage.idNotExist;
        
        Date beginDate = po.getBeginDate();
        Date endDate = po.getEndDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String begin = sdf.format(beginDate);
        String end =sdf.format(endDate);

        int scopeType = po.getScopeType().ordinal();
        String scopeNum = po.getScopeNum();
        int conditionType = po.getConditionType().ordinal();
        double conditionNum = po.getConditionNum();
        int deductionType = po.getDeductionType().ordinal();
        double deductionNum = po.getDeductionNum();
        String updateSql = "UPDATE PromotionInfo SET name='"+name+"',beginDate='"+begin+"',endDate='"+end+"',"+
                "scopeType="+String.valueOf(scopeType)+",scopeNum='"+scopeNum+"',conditionType="+String.valueOf(conditionType)+
                ",conditionNum="+String.valueOf(conditionNum)+",deductionType="+String.valueOf(deductionType)+
                ",deductionNum="+String.valueOf(deductionNum)+
                " WHERE setter='"+setter+"' and id='"+id+"' LIMIT 1";

        db.executeSql(updateSql);
        return ResultMessage.succeed;
    }
    // 制定者、策略编号 -> 查找
  	public PromotionPO find(String setter, String promotionID) throws RemoteException{
  		 db.executeSql("USE OurData");
         String checkSql = "SELECT *FROM PromotionInfo WHERE setter='"+setter+"' and id='"+promotionID+"' LIMIT 1";
         ResultSet result = db.query(checkSql);
         if(result==null)
        	 return null;
         return this.resultToPO(result).get(0);
  	}
  	// 6位->district 10->hotel
  	public ArrayList<PromotionPO> finds(String scope) throws RemoteException{
        System.out.println("get into promotion data");
  		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
  		String selectSql;
  		ResultSet result;
        System.out.println(scope);
  		if(scope.length()==6){
  			selectSql = "SELECT *FROM PromotionInfo";
  			result = db.query(selectSql);
  			try{
  				while(result.next()){
  					if(result.getString("scopeNum").substring(0, 10).equals(scope+"0000")){
  						String setter = result.getString("setter");
  		                String id = result.getString("id");
  		                String name = result.getString("name");
  		                Date beginDate = result.getDate("beginDate");
  		                Date endDate = result.getDate("endDate");
  		                ScopeType sType = ScopeType.values()[result.getInt("scopeType")];
  		                String sNum = result.getString("scopeNum");
  		                ConditionType cType = ConditionType.values()[result.getInt("conditionType")];
  		                double cNum = result.getDouble("conditionNum");
  		                DeductionType dType = DeductionType.values()[result.getInt("deductionType")];
                        double dNum = result.getDouble("deductionNum");

  		                PromotionPO po = new PromotionPO(setter,id,name,beginDate,endDate,sType,sNum,cType,cNum,dType,dNum);
  		                list.add(po);
  					}
  				}
  			}catch(SQLException e){
  				e.printStackTrace();
  				return null;
  			}
  			return list;
  		}
  		else{
  			selectSql = "SELECT *FROM PromotionInfo";
  			result = db.query(selectSql);
  			try{
  				while(result.next()){
  					if(result.getString("scopeNum").substring(0, 10).equals(scope)){
  						String setter = result.getString("setter");
  		                String id = result.getString("id");
  		                String name = result.getString("name");
  		                Date beginDate = result.getDate("beginDate");
  		                Date endDate = result.getDate("endDate");
  		                ScopeType sType = ScopeType.values()[result.getInt("scopeType")];
  		                String sNum = result.getString("scopeNum");
  		                int num = result.getInt("conditionType");
  		                System.out.println(num);
  		                ConditionType cType = ConditionType.values()[num];
  		                double cNum = result.getDouble("conditionNum");
  		                DeductionType dType = DeductionType.values()[result.getInt("deductionType")];
  		                double dNum = result.getDouble("deductionNum");

  		                PromotionPO po = new PromotionPO(setter,id,name,beginDate,endDate,sType,sNum,cType,cNum,dType,dNum);
  		                list.add(po);
  					}
  				}
  			}catch(SQLException e){
  				e.printStackTrace();
  				return null;
  			}
  			return list;
  		}
  			
  	}
    
  	// 从结果集到po
    public ArrayList<PromotionPO> resultToPO(ResultSet result){
        ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
        try{
            while(result.next()){
                String setter = result.getString("setter");
                String id = result.getString("id");
                String name = result.getString("name");
                Date beginDate = result.getDate("beginDate");
                Date endDate = result.getDate("endDate");
                ScopeType sType = ScopeType.values()[result.getInt("scopeType")];
                String sNum = result.getString("scopeNum");
                ConditionType cType = ConditionType.values()[result.getInt("conditionType")];
                double cNum = result.getDouble("conditionNum");
                DeductionType dType = DeductionType.values()[result.getInt("deductionType")];
                double dNum = result.getDouble("deductionNum");

                PromotionPO po = new PromotionPO(setter,id,name,beginDate,endDate,sType,sNum,cType,cNum,dType,dNum);
                list.add(po);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    // 检查策略是否存在
    private ResultMessage checkExistence(String setter,String name) {
    	db.executeSql("USE OurData");
    	String checkExistenceSql = "SELECT setter,name FROM PromotionInfo";
        ResultSet result = db.query(checkExistenceSql);
        try{
            while(result.next())
                if(result.getString(1).equals(setter)&&
                		result.getString(2).equals(name))
                    return ResultMessage.idAlreadyExist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ResultMessage.idNotExist;
    }
}
