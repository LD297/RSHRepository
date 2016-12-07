package po;

import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;

import java.util.Date;

public class PromotionPO {

	String setter;
	String id;
	String reason;
	Date beginDate;
	Date endDate;

	ScopeType scopeType;//销售策略适用的范围，包括某地区、某酒店、某房间类型，若无用等长0代替
	String scopeNum;

	ConditionType conditionType;//销售策略适用的条件，包括房间数量、价值、会员等级（企业会员）、用户生日
	int condionNum;

	DeductionType deductionType;//折扣的方式，包括打折，降价，（coupon优惠券方式暂缓）
	int deductionNum;

	public PromotionPO(String tempSetter,String tempId,String tempReason,
					   Date tempBeginDate,Date tempEndDate,
					   	ScopeType tempSType,String tempSNum,
					   ConditionType tempCType,int tempCNum,
					   DeductionType tempDType, int tempDNum){
		setter = tempSetter;
		id = tempId;
		reason = tempReason;
		beginDate = tempBeginDate;
		endDate = tempEndDate;

		scopeType = tempSType;
		scopeNum = tempSNum;

		conditionType = tempCType;
		condionNum = tempCNum;
	}
}
