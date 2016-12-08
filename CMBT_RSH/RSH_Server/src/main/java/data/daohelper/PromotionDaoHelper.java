package data.daohelper;

import constant.ResultMessage;
import po.PromotionPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by aa on 2016/12/3.
 */
public interface PromotionDaoHelper {

    public ResultMessage insert(PromotionPO po)throws RemoteException ;

    public ResultMessage delete(String setter, String id)throws RemoteException ;

    public ResultMessage update(PromotionPO po)throws RemoteException ;

    public PromotionPO find(String setter, String id)throws RemoteException ;

    public ArrayList<PromotionPO> finds(String district, String hotel)throws RemoteException ;
}
