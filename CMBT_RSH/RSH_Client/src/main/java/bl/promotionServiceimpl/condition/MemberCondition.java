package bl.promotionServiceimpl.condition;

import constant.ConditionType;
import constant.MemberType;

/**
 * 对会员等级的要求
 * 等级为100时为企业会员
 * @author aa
 *
 */
public class MemberCondition extends Condition {

	MemberType memberType;
	int memberLevel;
	
	public MemberCondition(double memberLevel){
		this.memberLevel = (int)memberLevel;
	}

	@Override
	public ConditionType getType() {
		if(memberLevel>100)
			return ConditionType.COMMERCE;
		return ConditionType.MEMBER;
	}

	@Override
	public double getNum() {
		return memberLevel;
	}

	

	@Override
	public boolean check(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return false;
	}


}
