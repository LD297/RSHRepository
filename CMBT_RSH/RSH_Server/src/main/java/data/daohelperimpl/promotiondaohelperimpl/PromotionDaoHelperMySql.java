package data.daohelperimpl.promotiondaohelperimpl;

import constant.ResultMessage;
import data.daohelperimpl.jdbc.DBHelper;
import po.PromotionPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class PromotionDaoHelperMySql {

    private DBHelper db = new DBHelper();

    public void init(){

        db.executeSql("USE OurData");
        // String setter;
        String reason;
        String scope;
        String  conditionType;
        String promotionType;
        db.executeSql("CREATE TABLE PromotionInfo(role tinyint,id char(26),password varchar(30))" );
    }

    public void finish(){
        db.executeSql("USE OurData");
    }
    public ResultMessage insert(PromotionPO po)throws RemoteException {
        db.executeSql("USE OurData");
        return null;
    }

    public ResultMessage del(String id, String reason)throws RemoteException {
        db.executeSql("USE OurData");
        return null;
    }

    public ResultMessage update(PromotionPO po)throws RemoteException {
        db.executeSql("USE OurData");
        return null;
    }

    public PromotionPO find(String id, String reason)throws RemoteException {
        db.executeSql("USE OurData");
        return null;
    }

    public ArrayList<PromotionPO> finds(String str)throws RemoteException {
        db.executeSql("USE OurData");
        return null;
    }
}
