package Test;

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

import data.daohelperimpl.promotiondaohelperimpl.PromotionDaoHelperMySql;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class PromotionTest {
    static PromotionDaoHelperMySql promotionDao =null;// new PromotionDaoHelperMySql();

   @Test // 添加策略
    public void insert() throws RemoteException,ParseException{
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        Date tempBeginDate = sim.parse("2016-12-10");
        Date tempEndDate = sim.parse("2017-03-12");
        ScopeType tempSType = ScopeType.HOTEL;
        ConditionType tempCType = ConditionType.BIRTHDAY;
        DeductionType tempDType = DeductionType.DISCOUNT;
        String id = promotionDao.getNewID("2016000001");
        PromotionPO po = new PromotionPO("2016000001",id,"冬季优惠",
                tempBeginDate,tempEndDate,
                tempSType,"2153000001",
                tempCType,200,
                tempDType, 80);
        ResultMessage result = promotionDao.insert(po);
        assertEquals(result,ResultMessage.idAlreadyExist);
    }
    @Test // 删除策略
    public void delete()throws RemoteException{
        String setter = "2016000001";
        String id = "004";
        ResultMessage result = promotionDao.delete(setter,id);
        assertEquals(result,ResultMessage.idNotExist);
    }
   
    @Test // 查看策略
    public void find()throws RemoteException{
        String setter = "2016000001";
        String id = "002";
        PromotionPO po = promotionDao.find(setter,id);
        assertEquals(po.getName(),"老总生日优惠");
    }
    @Test // 查看策略
    public void finds() throws RemoteException{
        String scope="2153000001";
        ArrayList<PromotionPO> list = promotionDao.finds(scope);
        assertEquals(list.size(),2);
    }
   

}
