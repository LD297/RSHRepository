package vo;

import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;
import po.PromotionPO;

import java.util.Date;

import bl.promotionServiceimpl.Promotion;

public class PromotionVO {

    public String setterID;
    public String promotionID;
    public String reason;// the reason to set this promotion(shown to the user)

    public Date beginDate;
    public Date endDate;

//    促销策略的适用范围
    public  ScopeType scopeType;
    public String scopeNum;     //district OR hotelID
    public String roomType;  // can be null

//    促销策略的适用条件
    public ConditionType conditionType;
    public double conditionNum;

//    促销策略的促销方式及力度
    public DeductionType deductionType;
    public double deductionNum;

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
     * @param conditionNum 在会员促销策略时，若是企业会员，cNum 为会员等级*100；
     * @param deductionType
     * @param deductionNum
     */
    public PromotionVO(String setterID,String promotionID,String reason,
                       Date beginDate, Date endDate,
                       ScopeType scopeType, String scopeNum,String roomType,
                       ConditionType conditionType, double conditionNum,
                       DeductionType deductionType, double deductionNum){
        this.setterID = setterID;
        this.promotionID = promotionID;
        this.reason = promotionID;

       this.beginDate = beginDate;
       this.endDate = endDate;

        this.scopeType = scopeType;
        this.scopeNum = scopeNum;
        this.roomType = roomType;

        this.deductionType = deductionType;
        this.deductionNum = deductionNum;
    }

    public PromotionPO changeIntoPO(){
    	PromotionPO promotionPO = new PromotionPO(setterID, promotionID, reason, 
    			beginDate, endDate, 
    			scopeType, scopeNum, roomType, 
    			conditionType, conditionNum, 
    			deductionType, deductionNum);
    	return promotionPO;	
    }

    public Promotion changeIntoPromotion(){
    	Promotion promotion = new Promotion(setterID, promotionID, reason);
    	promotion.setScope(scopeType, scopeNum, roomType);
    	promotion.setCondition(conditionType, conditionNum);
    	promotion.setDeduction(deductionType, deductionNum);
    	return promotion;
    }
}
