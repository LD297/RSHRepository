package po;

import bl.promotionServiceimpl.Promotion;
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

	ScopeType scope;
	String scopeNum;

	ConditionType  conditionType;
	int condionNum;

    DeductionType deductionType;
	int deductionNum;

	public static PromotionPO changeIntoPo(Promotion tempPromotion){

		return null;
	}
	public static Promotion getInstance(String tempSetter, String tempID){

		return null;
	}
}
