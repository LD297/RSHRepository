package po;

import bl.promotionServiceimpl.Promotion;
import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;
import vo.PromotionVO;

import java.util.Date;

public class PromotionPO {

	private static final int HOTEL_LENGTH = 10;
	private static final int DISTRICT_LENGTH = 6;

	private String setter;
	private String id;//san wei
	private String reason;
	private Date beginDate;
	private Date endDate;

	private ScopeType scopeType;
	private String scopeNum;

	private ConditionType  conditionType;
	private int condionNum;

    private DeductionType deductionType;
	private int deductionNum;

	public PromotionPO(String setterID,String promotionID,String Reason,
					   Date BeginDate,Date EndDate,
					   ScopeType scopeType, String sNum,String roomType,
					   ConditionType cType, int cNum,
					   DeductionType dType,int dNum){
		setter = setterID;
		id = promotionID;
		reason = Reason;
		beginDate = BeginDate;
		endDate = EndDate;

		this.scopeType = scopeType;
		while(sNum.length()<HOTEL_LENGTH){
			sNum +="0";
		}
		scopeNum = sNum+roomType;

		conditionType = cType;
		condionNum = cNum;

		deductionType = dType;
		deductionNum = dNum;
	}

	public static Promotion changeIntoPromotion(PromotionPO promotionPO){
		String originScope = promotionPO.scopeNum;
		String tempScopeNum;
		String roomType;
		if(originScope.length()==HOTEL_LENGTH){
			if(originScope.substring(DISTRICT_LENGTH)=="0000"){
				tempScopeNum = originScope.substring(DISTRICT_LENGTH);
			}
			else{
				tempScopeNum = originScope;
			}
			roomType = null;
		}else{
			tempScopeNum = originScope.substring(0,HOTEL_LENGTH);
			roomType = originScope.substring(HOTEL_LENGTH);
		}
		Promotion promotion = new Promotion(promotionPO.setter,promotionPO.id,promotionPO.reason);
		promotion.setDate(promotionPO.beginDate,promotionPO.endDate);


		promotion.setScope(promotionPO.scopeType,tempScopeNum,roomType);
		promotion.setCondition(promotionPO.conditionType,promotionPO.condionNum);
		promotion.setDeduction(promotionPO.deductionType,promotionPO.deductionNum);
		return promotion;
	}

	public static PromotionVO changeIntoPromotionVo(PromotionPO promotionPO){
		String originScope = promotionPO.scopeNum;
		String tempScopeNum;
		String roomType;
		if(originScope.length()==HOTEL_LENGTH){
			if(originScope.substring(DISTRICT_LENGTH)=="0000"){
				tempScopeNum = originScope.substring(DISTRICT_LENGTH);
			}
			else{
				tempScopeNum = originScope;
			}
			roomType = null;
		}else{
			tempScopeNum = originScope.substring(0,HOTEL_LENGTH);
			roomType = originScope.substring(HOTEL_LENGTH);
		}
		PromotionVO promotionVO = new PromotionVO(promotionPO.setter,promotionPO.id,promotionPO.reason,
				promotionPO.beginDate,promotionPO.endDate,
				promotionPO.scopeType,tempScopeNum,roomType,
				promotionPO.conditionType,promotionPO.condionNum,
				promotionPO.deductionType,promotionPO.deductionNum);
		return promotionVO;
	}
}
