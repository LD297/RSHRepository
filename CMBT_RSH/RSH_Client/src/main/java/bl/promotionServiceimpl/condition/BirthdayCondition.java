package bl.promotionServiceimpl.condition;

import constant.ConditionType;

/**
 * 生日要求
 * @author aa
 *
 */
public class BirthdayCondition extends Condition {

	public BirthdayCondition(){

	}

	@Override
	public ConditionType getType() {
		return ConditionType.BIRTHDAY;
	}

	@Override
	public double getNum() {
		return 0;
	}

	@Override
	public boolean check(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return false;
	}


}
