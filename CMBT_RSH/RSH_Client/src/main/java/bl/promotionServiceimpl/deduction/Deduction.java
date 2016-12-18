package bl.promotionServiceimpl.deduction;

import constant.DeductionType;

/**
 * 优惠的种类
 * @author aa
 *
 */
public abstract class Deduction {

	DeductionType deductionType;
	double deductionNum;

	public abstract DeductionType getType();
	public abstract double getNum();
	public abstract double getDeduction(double total);
}
