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

	public boolean check(int num, double price, int memberLevel, boolean isBirthday) {
		if(num*price>=total){
			return true;
		}
		return false;
	}

	@Override
	public boolean check(OrderInfo orderVO) {
		// TODO Auto-generated method stub
		double valueInOrder = orderVO.getOriginalValue();
		if(valueInOrder<total)
			return false;
		else
			return true;
	}

}
