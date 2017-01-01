package bl.promotionServiceimpl;

import constant.ScopeType;
import constant.ConditionType;
import constant.DeductionType;
import constant.ResultMessage;
import data.dao.promotiondao.PromotionDao;
import po.PromotionPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import bl.promotionServiceimpl.condition.BirthdayCondition;
import bl.promotionServiceimpl.condition.CommerceCondtion;
import bl.promotionServiceimpl.condition.Condition;
import bl.promotionServiceimpl.condition.MemberCondition;
import bl.promotionServiceimpl.condition.NumCondition;
import bl.promotionServiceimpl.condition.SpecialPeriodCondition;
import bl.promotionServiceimpl.condition.TotalCondition;
import bl.promotionServiceimpl.deduction.Deduction;
import bl.promotionServiceimpl.deduction.DiscountDeduction;
import bl.promotionServiceimpl.deduction.ReduceDeduction;
import bl.promotionServiceimpl.scope.DistrictScope;
import bl.promotionServiceimpl.scope.HotelScope;
import bl.promotionServiceimpl.scope.RoomScope;
import bl.promotionServiceimpl.scope.Scope;

/**
 * 策略类
 * @author aa
 *负责策略的增删改查
 */
public class Promotion {

	private static PromotionDao promotionDao = null;
	public static ArrayList<PromotionPO> existPromotionPO = new ArrayList<PromotionPO>();

	private String setterID;
	private String promotionID;
	private String reason;

	Date beginDate;
	Date endDate;

	Scope scope;
	Condition condition;
	Deduction deduction;

	/**
	 * 
	 * @param setterID
	 * @param promotionID
	 * @param reason
	 */
	public Promotion (String setterID, String promotionID,String reason){
		this.setterID = setterID;
		this.promotionID = promotionID;
		this.reason=reason;
	}
	
	/**
	 * 
	 * @param beginDate
	 * @param endDate
	 */
	public void setDate(Date beginDate, Date endDate) {
		this.beginDate=beginDate;
		this.endDate=endDate;
	}

	/**
	 * 
	 * @param scopeType
	 * @param scopeNum
	 * @param roomType
	 */
	public void setScope(ScopeType scopeType, String scopeNum,String roomType) {
		if(scopeType == ScopeType.DISTRICT){
			scope = new DistrictScope(scopeNum);
		}
		else if(scopeType == ScopeType.HOTEL){
			scope = new HotelScope(scopeNum);
		}
		else if(scopeType == ScopeType.ROOM){
			scope = new RoomScope(scopeNum,roomType);
		}
	}
	
	/**
	 * 
	 * @param conditionType
	 * @param conditionNum
	 */
	public void setCondition(ConditionType conditionType,double conditionNum) {
		if(conditionType == ConditionType.BIRTHDAY){
			condition = new BirthdayCondition();
		}
		else if(conditionType == ConditionType.MEMBER){
			condition = new MemberCondition((int)conditionNum);
		}
		else if(conditionType == ConditionType.COMMERCE){
			condition = new CommerceCondtion((int)conditionNum);
		}
		else if(conditionType == ConditionType.ROOMNUM){
			condition = new NumCondition((int)conditionNum);
		}
		else if(conditionType == ConditionType.TOTAL){
			condition = new TotalCondition(conditionNum);
		}
		else if(conditionType == ConditionType.SPECIALPERIOD){
			condition = new SpecialPeriodCondition();
		}
	}
	
	/**
	 * 
	 * @param deductionType
	 * @param deductionNum
	 */
	public void setDeduction(DeductionType deductionType, double deductionNum) {
		if(deductionType == DeductionType.DISCOUNT){
			deduction = new DiscountDeduction(deductionNum/10);
		}
		else if(deductionType == DeductionType.REDUCE){
			deduction = new ReduceDeduction(deductionNum);
		}
	}

	public String getReason(){
		return this.reason;
	}


	public static void initRemote(){
		if(promotionDao!=null) {
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			promotionDao = remoteHelper.getPromotionDao();
		}
	}
	/**
	 * 读取数据层中数据，若无返回null
	 * @param setterID
	 * @param promotionID
	 * @return
	 */
	public static Promotion getInstance(String setterID, String promotionID){
		initRemote();
		PromotionPO promotionPO = null;
		try {
			promotionPO = promotionDao.find(setterID,promotionID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(promotionPO==null)
			return null;
		else
			return promotionPO.changeIntoPromotion();
	}	
	
	public PromotionPO changeIntoPO(){
		PromotionPO promotionPO = new PromotionPO(setterID,promotionID,reason,
				beginDate,endDate,
				scope.getType(),scope.getNum(),scope.getRoomType(),
				condition.getType(),condition.getNum(),
				deduction.getType(),deduction.getNum());
		return promotionPO;
	}
}
