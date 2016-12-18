package bl.promotionServiceimpl.condition;

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
		return ConditionType.ROOMNUM;
	}

	@Override
	public double getNum() {
		return num;
	}


	@Override
	public boolean check(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return false;
	}


}
