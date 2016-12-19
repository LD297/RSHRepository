package bl.promotionServiceimpl.condition;

import constant.ConditionType;
import vo.OrderInfo;
import vo.OrderVO;

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
	public boolean check(OrderInfo orderVO) {
		// TODO Auto-generated method stub
		int numInOrder = orderVO.getRoomNum();
		if(numInOrder<num){
			return false;
		}
		return true;
	}


}
