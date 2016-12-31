package po;

import bl.promotionServiceimpl.Promotion;
import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;
import vo.PromotionVO;

import java.io.Serializable;
import java.util.Date;

public class PromotionPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int HOTEL_LENGTH = 10;
	private static final int DISTRICT_LENGTH = 6;

	private String setterID;
	private String promotionID;// san wei
	private String reason;
	private Date beginDate;
	private Date endDate;

	private ScopeType scopeType;
	private String scopeNum;

	private ConditionType conditionType;
	private double conditionNum;

	private DeductionType deductionType;
	private double deductionNum;

	/**
	 * 
	 * @param setterID
	 * @param promotionID
	 * @param reason
	 * @param beginDate
	 * @param endDate
	 * @param scopeType
	 * @param scopeNum
	 * @param roomType
	 * @param conditionType
	 * @param conditionNum
	 * @param deductionType
	 * @param deductionNum
	 */
	public PromotionPO(String setterID, String promotionID, String reason, Date beginDate, Date endDate,
			ScopeType scopeType, String scopeNum, String roomType, ConditionType conditionType, double conditionNum,
			DeductionType deductionType, double deductionNum) {
		this.setterID = setterID;
		this.promotionID = promotionID;
		this.reason = reason;
		this.beginDate = beginDate;
		this.endDate = endDate;

		this.scopeType = scopeType;
		while (scopeNum.length() < HOTEL_LENGTH) {
			scopeNum += "0";
		}
		this.scopeNum = scopeNum + roomType;

		this.conditionType = conditionType;
		this.conditionNum = conditionNum;

		this.deductionType = deductionType;
		this.deductionNum = deductionNum;
	}

	public Promotion changeIntoPromotion() {
		String originScope = scopeNum;
		String tempScopeNum = null;
		String roomType = null;
		switch (scopeType) {
		case ROOM:
			roomType = scopeNum.substring(HOTEL_LENGTH);
		case HOTEL:
			tempScopeNum = scopeNum.substring(0, HOTEL_LENGTH);
			break;
		case DISTRICT:
			tempScopeNum = scopeNum.substring(0, DISTRICT_LENGTH);
		}
		Promotion promotion = new Promotion(setterID, promotionID, reason);
		promotion.setDate(beginDate, endDate);
		promotion.setScope(scopeType, tempScopeNum, roomType);
		promotion.setCondition(conditionType, conditionNum);
		promotion.setDeduction(deductionType, deductionNum);
		return promotion;
	}

	public PromotionVO changeIntoVO() {
		String tempScopeNum = null;
		String roomType = null;
		if (scopeNum.length() == HOTEL_LENGTH) {
			if (scopeNum.substring(DISTRICT_LENGTH).equals("0000")) {
				tempScopeNum = scopeNum.substring(DISTRICT_LENGTH);
			} else {
				tempScopeNum = scopeNum;
			}
			roomType = null;
		} else {
			tempScopeNum = scopeNum.substring(0, HOTEL_LENGTH);
			roomType = scopeNum.substring(HOTEL_LENGTH);
		}
		PromotionVO promotionVO = new PromotionVO(setterID, promotionID, reason, beginDate, endDate, scopeType,
				tempScopeNum, roomType, conditionType, conditionNum, deductionType, deductionNum);
		return promotionVO;
	}

	public static PromotionVO changeIntoPromotionVo(PromotionPO promotionPO) {
		String originScope = promotionPO.scopeNum;
		String tempScopeNum;
		String roomType;
		if (originScope.length() == HOTEL_LENGTH) {
			if (originScope.substring(DISTRICT_LENGTH) == "0000") {
				tempScopeNum = originScope.substring(DISTRICT_LENGTH);
			} else {
				tempScopeNum = originScope;
			}
			roomType = null;
		} else {
			tempScopeNum = originScope.substring(0, HOTEL_LENGTH);
			roomType = originScope.substring(HOTEL_LENGTH);
		}
		PromotionVO promotionVO = new PromotionVO(promotionPO.setterID, promotionPO.promotionID, promotionPO.reason,
				promotionPO.beginDate, promotionPO.endDate, promotionPO.scopeType, tempScopeNum, roomType,
				promotionPO.conditionType, promotionPO.conditionNum, promotionPO.deductionType,
				promotionPO.deductionNum);
		return promotionVO;
	}

	public String getReason() {
		// TODO Auto-generated method stub
		return reason;
	}
}
