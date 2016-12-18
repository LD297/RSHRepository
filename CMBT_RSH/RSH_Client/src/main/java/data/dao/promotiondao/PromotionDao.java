package data.dao.promotiondao;

import constant.ResultMessage;
import po.PromotionPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aa on 2016/11/27.
 */
public interface PromotionDao extends Remote{
	
	public String getNewID(String setterID) throws RemoteException;
	
    public ResultMessage insert(PromotionPO po) throws RemoteException;

    public ResultMessage delete(String setterID, String promotionID)throws RemoteException;

    public ResultMessage  update (PromotionPO po)throws RemoteException;

    public PromotionPO find(String setterID,String promtionID)throws RemoteException;

    // 6 for district or 10 for hotel
    public ArrayList<PromotionPO> finds(String Scope) throws RemoteException;



}
