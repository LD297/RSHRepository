package data.dao.promotiondao;

import java.rmi.Remote;
import java.util.ArrayList;

import constant.ResultMessage;
import po.PromotionPO;

/**
 * 
 * @author aa
 *
 */
public interface PromotionDao extends Remote{

	public ResultMessage insert(PromotionPO po);
	
	public ResultMessage del(String id, String reason);
	
	public ResultMessage  update (PromotionPO po);
	
	public PromotionPO find(String id,String reason);
	
	public ArrayList<PromotionPO> finds(String str);
}
