package po;

import bl.promotionServiceimpl.Promotion;
import constant.ConditionType;

import java.util.Date;

public class PromotionPO {

	String setter;
	String id;
	String reason;
	Date beginDate;
	Date endDate;

	String scope;
	String scopeNum;

	String  conditionType;
	int condionNum;

    String deductionType;
	int deductionNum;

	public static PromotionPO changeIntoPo(Promotion tempPromotion){

		return null;
	}
	public static Promotion getInstance(String tempSetter, String tempID){

		return null;
	}
}
