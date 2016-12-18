package bl.promotionServiceimpl.condition;

import bl.orderserviceimpl.Order;
import constant.ConditionType;
import vo.UserVO;

/**
 * 优惠的条件种类
 * @author aa
 *
 */
public abstract class Condition {

	double num;
	ConditionType conditionType;

	public abstract ConditionType getType();


	public abstract double getNum();


	/**
	 *
	 * @param num
	 * @param price
	 * @return
	 */
	public abstract boolean check(OrderInfo orderInfo);
}
