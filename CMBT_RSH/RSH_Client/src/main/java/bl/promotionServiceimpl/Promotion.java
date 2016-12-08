package bl.promotionServiceimpl;

import constant.ScopeType;
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
	private String setter;
	private String id;
	private String reason;

	private Date beginDate;
	private Date endDate;

	Scope scope;
	Condition condition;
	Deduction deduction;

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
		return promotion;
	}

	public void setScope(ScopeType stype, String scopeNum) {
		// TODO Auto-generated method stub
		if(stype == ScopeType.DISTRICT){
			scope = new DistrictScope(scopeNum);
		}
		else if(stype == ScopeType.HOTEL){
			scope = new HotelScope(scopeNum);
		}
		else if(stype == ScopeType.ROOM){
			scope = new RoomScope(scopeNum.substring(0,10),scopeNum.substring(10));
		}
	}
	public void setCondition(ConditionType cType,int cNum) {
		// TODO Auto-generated method stub
		if(cType == ConditionType.BIRTHDAY){
			condition = new BirthdayCondition();
		}
		else if(cType == ConditionType.MEMBER){
			condition = new MemberCondition(cNum);
		}
		else if(cType == ConditionType.NUM){
			condition = new NumCondition(cNum);
		}
		else if(cType == ConditionType.TOTAL){
			condition = new TotalCondition(cNum);
		}
	}
	public void setDeduction(DeductionType dType, int dNum) {
		// TODO Auto-generated method stub
		if(dType == DeductionType.DISCOUNT){
			deduction = new DiscountDeduction(dNum);
		}
		else if(dType == DeductionType.REDUCE){
			deduction = new ReduceDeduction(dNum);
		}
	}
	public void setDate(Date tempBeginDate, Date tempEndDate) {
		// TODO Auto-generated method stub
		beginDate=tempBeginDate;
		endDate=tempEndDate;
	}

	/**
	 * 在数据层中插入；
	 * @return
	 */
	public ResultMessage insertPromotion(){
		PromotionPO promotionPO = this.changeIntoPO();
		try {
			promotionDao.insert(promotionPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.succeed;
	}

	/**
	 * 从数据库中删除
	 * @param tempSetter
	 * @param ID
	 * @return
	 */
	public static ResultMessage delPromotion(String tempSetter, String ID) {
		// TODO Auto-generated method stub
		try {
			promotionDao.del(tempSetter,ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.succeed;
	}

	/**
	 * 在数据层中更新
	 * @return
	 */
	public ResultMessage update() {
		// TODO Auto-generated method stub
		PromotionPO promotionPO = this.changeIntoPO();
		try {
			promotionDao.update(promotionPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.succeed;
	}
	
	public PromotionPO changeIntoPO(){
		PromotionPO promotionPO = new PromotionPO(setter,id,reason,
				beginDate,endDate,
				scope.getType(),scope.getNum(),
				condition.getType(),condition.getNum(),
				deduction.getType(),deduction.getNum());
		return promotionPO;
	}
}
