package bl.promotionServiceimpl;

import constant.ConditionType;

/**
 * 对会员等级的要求
 * 等级为100时为企业会员
 * @author aa
 *
 */
public class MemberCondition extends Condition {

	int classNum;
	
	public MemberCondition(int c){
		classNum=c;
	}

	@Override
	public ConditionType getType() {
		return ConditionType.MEMBER;
	}

	@Override
	public int getNum() {
		return classNum;
	}

	public boolean check(int cNum){
		if(classNum==cNum)
			return true;
		return false;
	}
}
