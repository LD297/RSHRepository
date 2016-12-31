package bl.promotionServiceimpl.condition;

import constant.ConditionType;
import vo.OrderInfo;

public class SpecialPeriodCondition extends Condition {

	@Override
	public ConditionType getType() {
		return ConditionType.SPECIALPERIOD;
	}

	@Override
	public double getNum() {
		return 0;
	}

	@Override
	public boolean check(OrderInfo orderInfo) {
		return true;
	}

}
