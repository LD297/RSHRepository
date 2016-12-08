package po;

import bl.promotionServiceimpl.Promotion;
import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;

import java.util.Date;

public class PromotionPO {

	private String setter;
	String id;
	String reason;
	Date beginDate;
	Date endDate;

	ScopeType scopeType;
	String scopeNum;

	ConditionType  conditionType;
	int condionNum;

    DeductionType deductionType;
	int deductionNum;

	public PromotionPO(String Setter,String ID,String Reason,
					   Date BeginDate,Date EndDate,
					   ScopeType sType, String sNum,
					   ConditionType cType, int cNum,
					   DeductionType dType,int dNum){
		setter = Setter;
		id = ID;
		reason = Reason;
		beginDate = BeginDate;
		endDate = EndDate;

		scopeType = sType;
		scopeNum = sNum;
		conditionType = cType;
		condionNum = cNum;
		deductionType = dType;
		deductionNum = dNum;
	}

	public static Promotion changeIntoPromotion(PromotionPO promotionPO){
		Promotion promotion = new Promotion(promotionPO.setter,promotionPO.id);
		promotion.setDate(promotionPO.beginDate,promotionPO.endDate);

		promotion.setScope(promotionPO.scopeType,promotionPO.scopeNum);
		promotion.setCondition(promotionPO.conditionType,promotionPO.condionNum);
		promotion.setDeduction(promotionPO.deductionType,promotionPO.deductionNum);
		return promotion;
	}
}
