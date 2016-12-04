package vo;

import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;

import java.util.Date;

public class PromotionVO {

    public String reason;
    public String setter;

    public Date beginDate;
    public Date endDate;

    public  ScopeType scopeType;
    public String id;
    public String roomType;

    public ConditionType conditionType;
    public int requirement;

    public DeductionType deductionType;
    public int deduction;
}
