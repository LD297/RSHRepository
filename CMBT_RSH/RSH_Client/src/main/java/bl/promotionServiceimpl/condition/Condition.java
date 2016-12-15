package bl.promotionServiceimpl.condition;

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
	 *
	 * @param num
	 * @param price
	 * @return
	 */
	public abstract boolean check(int num,int price,int memberLevel,boolean isBirthday);
}
