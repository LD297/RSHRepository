package bl.promotionServiceimpl.deduction;

import constant.DeductionType;

/**
 * 折扣优惠
 * @author aa
 *
 */
public class DiscountDeduction extends Deduction {

	double discount;
	
	public DiscountDeduction(double discount){
		this.discount=discount;
	}

	@Override
	public DeductionType getType() {
		return DeductionType.DISCOUNT;
	}

	@Override
	public double getNum() {
		return discount;
	}

	public double getDeduction(double total){
		return total*discount;
	}
}
