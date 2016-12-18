package data.daohelperimpl.promotiondaohelperimpl;

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

/**
 * Created by sky-PC on 2016/12/12.
 */
public class test {
    PromotionDaoHelperMySql promotionDao = new PromotionDaoHelperMySql();

    public void insert() throws RemoteException,ParseException{
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date tempBeginDate = sim.parse("2016-11-11 12:00:00");
        Date tempEndDate = sim.parse("2016-11-13 12:00:00");
        ScopeType tempSType = ScopeType.HOTEL;
        ConditionType tempCType = ConditionType.BIRTHDAY;
        DeductionType tempDType = DeductionType.DISCOUNT;
        PromotionPO po = new PromotionPO("setter","id","任性优惠",
                tempBeginDate,tempEndDate,
                tempSType,"num",
                tempCType,80,
                tempDType, 80);
        ResultMessage result = promotionDao.insert(po);
    }

    public void delete()throws RemoteException{
        String setter = "";
        String id = "";
        ResultMessage result = promotionDao.delete(setter,id);
    }

    public void  update ()throws RemoteException,ParseException{
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date tempBeginDate = sim.parse("2016-11-11 12:00:00");
        Date tempEndDate = sim.parse("2016-11-13 12:00:00");
        ScopeType tempSType = ScopeType.HOTEL;
        ConditionType tempCType = ConditionType.BIRTHDAY;
        DeductionType tempDType = DeductionType.DISCOUNT;
        PromotionPO po = new PromotionPO("setter","id","任性优惠",
                tempBeginDate,tempEndDate,
                tempSType,"num",
                tempCType,80,
                tempDType, 80);
        ResultMessage result = promotionDao.update(po);
    }

    public void find()throws RemoteException{
        String setter = "";
        String id = "";
        PromotionPO po = promotionDao.find(setter,id);
    }

    public void findByDistrictWithHotel() throws RemoteException{
        String scope="";
        ArrayList<PromotionPO> list = promotionDao.finds(scope);
    }

}
