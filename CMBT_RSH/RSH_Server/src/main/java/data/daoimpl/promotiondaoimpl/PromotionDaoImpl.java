package data.daoimpl.promotiondaoimpl;

import constant.ResultMessage;
import data.dao.promotiondao.PromotionDao;
import po.PromotionPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aa on 2016/11/27.
 */
public class PromotionDaoImpl extends UnicastRemoteObject implements PromotionDao {
    public PromotionDaoImpl()throws RemoteException{}

    public ResultMessage insert(PromotionPO po)throws RemoteException {
        return null;
    }

    public ResultMessage del(String id, String reason)throws RemoteException {
        return null;
    }

    public ResultMessage update(PromotionPO po)throws RemoteException {
        return null;
    }

    public PromotionPO find(String id, String reason)throws RemoteException {
        return null;
    }

    public ArrayList<PromotionPO> finds(String str)throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<PromotionPO> finds(Date beginDate, Date endDate) throws RemoteException {
        return null;
    }
}
