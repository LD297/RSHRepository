package bl.promotionServiceimpl;

import constant.ConditionType;

/**
 * 对数量的要求
 * @author aa
 *
 */
public class NumCondition extends Condition {

	int num;
	
	public NumCondition(int n){
		num=n;
	}

	@Override
	public ConditionType getType() {
		return ConditionType.NUM;
	}

	@Override
	public int getNum() {
		return num;
	}

	public boolean check(int cNum){
		if(cNum>=num)
			return true;
		else
			return false;
	}
}
