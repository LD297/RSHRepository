package po;

import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;

import java.io.Serializable;
import java.util.Date;

public class PromotionPO implements Serializable {

	String setter;
	String id;
	String name;
	Date beginDate;
	Date endDate;

	ScopeType scopeType;//销售策略适用的范围，包括某地区、某酒店、某房间类型，若无用等长0代替
	String scopeNum;

	ConditionType conditionType;//销售策略适用的条件，包括房间数量、价值、会员等级（企业会员）、用户生日
	double condionNum;

	DeductionType deductionType;//折扣的方式，包括打折，降价，（coupon优惠券方式暂缓）
	double deductionNum;

	public PromotionPO(String setter,String id,String name,
					   Date beginDate,Date endDate,
					   	ScopeType tempSType,String tempSNum,
					   ConditionType tempCType,double tempCNum,
					   DeductionType tempDType,double tempDNum){
		this.setter = setter;
		this.id = id;
		this.name = name;
		this.beginDate = beginDate;
		this.endDate = endDate;

		scopeType = tempSType;
		scopeNum = tempSNum;

		conditionType = tempCType;
		condionNum = tempCNum;

		deductionType = tempDType;
		deductionNum =tempDNum;
	}
	public String getSetter(){
		return this.setter;
	}
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public Date getBeginDate(){
		return this.beginDate;
	}
	public Date getEndDate(){
		return this.endDate;
	}
	public ScopeType getScopeType(){
		return this.scopeType;
	}
	public String getScopeNum(){
		return this.scopeNum;
	}
	public ConditionType getConditionType(){
		return this.conditionType;
	}
	public double getCondionNum(){
		return this.condionNum;
	}
	public DeductionType getDeductionType(){
		return this.deductionType;
	}
	public double getDeductionNum(){
		return this.deductionNum;
	}
}
