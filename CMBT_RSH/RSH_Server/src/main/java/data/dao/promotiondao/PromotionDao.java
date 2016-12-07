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
	
	public ResultMessage delete(String setter, String id)throws RemoteException;
	
	public ResultMessage  update (PromotionPO po)throws RemoteException;
	
	public PromotionPO find(String setter, String id)throws RemoteException;

	public ArrayList<PromotionPO> finds(String district,String hotel) throws RemoteException;
}
