package bl.promotionServiceimpl;

import constant.ConditionType;

/**
 * 对会员等级的要求
 * 等级为100时为企业会员
 * @author aa
 *
 */
public class MemberCondition extends Condition {

	int memberLevel;
	
	public MemberCondition(int tempMemberLevel){
		memberLevel = tempMemberLevel;
	}

	@Override
	public ConditionType getType() {
		return ConditionType.MEMBER;
	}

	@Override
	public int getNum() {
		return memberLevel;
	}

	@Override
	public boolean check(int num, int price, int tempMemberLevel, boolean isBirthday) {
		if(tempMemberLevel>=memberLevel&&memberLevel>99){
			return true;
		}
		if(memberLevel<=tempMemberLevel&&tempMemberLevel<100){
			return true;
		}
		return false;
	}


}
