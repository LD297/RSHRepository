package data.dao.promotiondao;

import constant.ResultMessage;
import po.PromotionPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by aa on 2016/11/27.
 */
public interface PromotionDao extends Remote{

    public ResultMessage insert(PromotionPO po)throws RemoteException;

    public ResultMessage del(String id, String reason)throws RemoteException;

    public ResultMessage  update (PromotionPO po)throws RemoteException;

    public PromotionPO find(String id,String reason)throws RemoteException;

    public ArrayList<PromotionPO> finds(String str)throws RemoteException;
}
