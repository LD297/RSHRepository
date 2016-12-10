package vo;

import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;

import java.util.Date;

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
    public int conditionNum;

//    促销策略的促销方式及力度
    public DeductionType deductionType;
    public int deductionNum;

    /**
     *
     * @param tempSetter
     * @param tempPromID
     * @param tempReasom
     * @param tempBeginDate
     * @param tempEndDate
     * @param tempSType
     * @param tempSNum
     * @param roomType
     * @param tempCType
     * @param tempCNum 在会员促销策略时，若是企业会员，cNum 为会员等级*100；
     * @param tempDType
     * @param tempDNum
     */
    public PromotionVO(String tempSetter,String tempPromID,String tempReasom,
                       Date tempBeginDate, Date tempEndDate,
                       ScopeType tempSType, String tempSNum,String roomType,
                       ConditionType tempCType, int tempCNum,
                       DeductionType tempDType, int tempDNum){
        setterID = tempSetter;
        promotionID = tempPromID;
        reason = tempPromID;

        beginDate = tempBeginDate;
        endDate = tempEndDate;

        scopeType = tempSType;
        scopeNum = tempSNum;

        deductionType = tempDType;
        deductionNum = tempDNum;
    }


}
