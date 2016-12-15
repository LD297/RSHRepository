package data.dao_Stub.promotiondao_Stub;

import constant.ConditionType;
import constant.DeductionType;
import constant.ResultMessage;
import constant.ScopeType;
import data.dao.promotiondao.PromotionDao;
import po.PromotionPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aa on 2016/12/7.
 */
public class PromotionDao_Stub implements PromotionDao {
    @Override
    public ResultMessage insert(PromotionPO po) throws RemoteException {
        return ResultMessage.succeed;
    }

    @Override
    public ResultMessage delete(String setter, String id) throws RemoteException {
        return ResultMessage.succeed;
    }

    @Override
    public ResultMessage update(PromotionPO po) throws RemoteException {
        return ResultMessage.succeed;
    }

    @Override
    public PromotionPO find(String setterID, String id) throws RemoteException {
        Date beforeDate  = new Date(20161111);
        Date afterDate  = new Date(20161212);
        PromotionPO promotionPO = new PromotionPO(setterID,id,"双十一",beforeDate,afterDate,
                ScopeType.DISTRICT,"123456","单人间",
                ConditionType.BIRTHDAY,1,
                DeductionType.REDUCE,10);
        return promotionPO;
    }

    @Override
    public ArrayList<PromotionPO> finds(String setter) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<PromotionPO> finds(Date beginDate, Date endDate) throws RemoteException {
        return null;
    }
}
