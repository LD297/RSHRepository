package data.dao.promotiondao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import constant.ResultMessage;
import po.PromotionPO;

/**
 * 
 * @author aa
 *
 */
public interface PromotionDao extends Remote{

	public ResultMessage insert(PromotionPO po) throws RemoteException;
	
	public ResultMessage del(String setter, String id)throws RemoteException;
	
	public ResultMessage  update (PromotionPO po)throws RemoteException;
	
	public PromotionPO find(String setterID,String id)throws RemoteException;
	
	public ArrayList<PromotionPO> finds(String setter) throws RemoteException;

	public ArrayList<PromotionPO> finds(Date beginDate, Date endDate) throws RemoteException;
}
