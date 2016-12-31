package bl.promotionServiceimpl.condition;

import constant.ConditionType;
import vo.OrderInfo;
import vo.OrderVO;

/**
 * 总额要求
 * @author aa
 *
 */
public class TotalCondition extends Condition {

	double total;
	
	public TotalCondition(double t){
		total=t;
	}

	@Override
	public ConditionType getType() {
		return ConditionType.TOTAL;
	}

	@Override
	public double getNum() {
		return total;
	}

	@Override
	public boolean check(OrderInfo orderVO) {
		double valueInOrder = orderVO.getOriginalValue();
		if(valueInOrder<total)
			return false;
		else
			return true;
	}

}
