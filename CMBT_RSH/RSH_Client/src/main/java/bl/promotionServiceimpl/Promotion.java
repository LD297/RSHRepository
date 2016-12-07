package bl.promotionServiceimpl;

import constant.ConditionType;
import constant.DeductionType;
import constant.ResultMessage;
import data.dao.promotiondao.PromotionDao;
import po.PromotionPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * 策略类
 * @author aa
 *
 */
public class Promotion {

	private static PromotionDao promotionDao;
	String setter;
	String id;
	String reason;

	Date beginDate;
	Date endDate;

	ScopeType scopeType;
	String scopeNum ;

	ConditionType conditionType;
	int conditionNum = 0;

	DeductionType deductionType;
	int deductionNum = 0;

	public Promotion (String Reason, String ID){
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		promotionDao = remoteHelper.getPromotionDao();
		reason=Reason;
		setter = ID;
	}

	/**
	 * 读取数据层中数据，若无返回null
	 * @param tempSetter
	 * @param ID
	 * @return
	 */
	public static Promotion getInstance(String tempSetter, String ID){
		Promotion promotion = null;
		try {
			PromotionPO promotionPO = promotionDao.find(tempSetter,ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
//		promotion = PromotionPO.
		return promotion;
	}

	public ResultMessage setScope(constant.ScopeType stype, String id, String rtype) {
		// TODO Auto-generated method stub
		scopeType =new ScopeType();
		return null;
	}
	public ResultMessage setConditionType(ConditionType type, int requirement) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage setDeductionType(DeductionType type, int num) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage setDate(Date tempBeginDate, Date tempEndDate) {
		// TODO Auto-generated method stub
		beginDate=tempBeginDate;
		endDate=tempEndDate;
		return null;
	}

	/**
	 * 在数据层中插入；
	 * @return
	 */
	public ResultMessage insertPromotion(){

		return null;
	}


	/**
	 * 从数据库中删除
	 * @param tempReason
	 * @param iD
	 * @return
	 */
	public static ResultMessage delPromotion(String tempReason, String iD) {
		// TODO Auto-generated method stub

		return null;
	}

	/**
	 * 在数据层中更新
	 * @return
	 */
	public ResultMessage update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
