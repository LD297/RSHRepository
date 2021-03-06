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
	// 得到新的促销策略的编号
	public String getNewID(String setterID)throws RemoteException;
    // 添加策略
	public ResultMessage insert(PromotionPO po) throws RemoteException;
    // 制定者、策略编号 -> 删除
	public ResultMessage delete(String setterID, String promotionID)throws RemoteException;
    // 更新策略
	public ResultMessage update(PromotionPO po)throws RemoteException;
    // 制定者、策略编号 -> 查找
	public PromotionPO find(String setter, String promotionID) throws RemoteException;
	// 6位->district 10->hotel
	public ArrayList<PromotionPO> finds(String scope) throws RemoteException;

}
