package bl.promotionServiceimpl;

import constant.DeductionType;

/**
 * 优惠的种类
 * @author aa
 *
 */
public abstract class Deduction {

	DeductionType deductionType;
	int deductionNum;

	public abstract DeductionType getType();
	public abstract int getNum();
	public abstract int getDeduction(int total);
}
