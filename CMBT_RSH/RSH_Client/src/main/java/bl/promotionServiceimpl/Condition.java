package bl.promotionServiceimpl;

import constant.ConditionType;

/**
 * 优惠的条件种类
 * @author aa
 *
 */
public abstract class Condition {

	int num;
	ConditionType conditionType;

	public abstract ConditionType getType();


	public abstract int getNum();


	/**
	 * 检测是否符合条件
	 * @param condition
	 * @return
	 */
	public abstract boolean check(int condition);
}
