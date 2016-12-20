package data.daohelperimpl.promotiondaohelperimpl;

import static org.junit.Assert.*;
import constant.ConditionType;
import constant.DeductionType;
import constant.ResultMessage;
import constant.ScopeType;
import po.PromotionPO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class test {
    static PromotionDaoHelperMySql promotionDao = new PromotionDaoHelperMySql();

   @Test 
    public void insert() throws RemoteException,ParseException{
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        Date tempBeginDate = sim.parse("2016-11-11");
        Date tempEndDate = sim.parse("2016-11-13");
        ScopeType tempSType = ScopeType.HOTEL;
        ConditionType tempCType = ConditionType.BIRTHDAY;
        DeductionType tempDType = DeductionType.DISCOUNT;
        String id = promotionDao.getNewID("2016000001");
        PromotionPO po = new PromotionPO("2016000001",id,"老总生日优惠",
                tempBeginDate,tempEndDate,
                tempSType,"2153000001",
                tempCType,80,
                tempDType, 80);
        ResultMessage result = promotionDao.insert(po);
        assertEquals(result,ResultMessage.idAlreadyExist);
    }
    @Test 
    public void delete()throws RemoteException{
        String setter = "2016000001";
        String id = "004";
        ResultMessage result = promotionDao.delete(setter,id);
        assertEquals(result,ResultMessage.idNotExist);
    }
    @Test 
    public void  update ()throws RemoteException,ParseException{
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date tempBeginDate = sim.parse("2016-11-11 12:00:00");
        Date tempEndDate = sim.parse("2016-11-13 12:00:00");
        ScopeType tempSType = ScopeType.HOTEL;
        ConditionType tempCType = ConditionType.BIRTHDAY;
        DeductionType tempDType = DeductionType.DISCOUNT;
        PromotionPO po = new PromotionPO("2016000001","001","任性u优惠",
                tempBeginDate,tempEndDate,
                tempSType,"2153000000",
                tempCType,400,
                tempDType, 80);
        ResultMessage result = promotionDao.update(po);
        assertEquals(result,ResultMessage.succeed);
    }
    @Test 
    public void find()throws RemoteException{
        String setter = "2016000001";
        String id = "002";
        PromotionPO po = promotionDao.find(setter,id);
        assertEquals(po.getName(),"老总生日优惠");
    }
    @Test 
    public void finds() throws RemoteException{
        String scope="2153000001";
        ArrayList<PromotionPO> list = promotionDao.finds(scope);
        assertEquals(list.get(0).getName(),"老总生日优惠");
    }
   

}
