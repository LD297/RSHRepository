package bl.promotionServiceimpl;

import constant.DeductionType;

/**
 * 折扣优惠
 * @author aa
 *
 */
public class DiscountDeduction extends Deduction {

	int discount;
	
	public DiscountDeduction(int disc){
		discount=disc;
	}

	@Override
	public DeductionType getType() {
		return DeductionType.DISCOUNT;
	}

	@Override
	public int getNum() {
		return discount;
	}

	public int getDeduction(int total){
		return total*discount;
	}
}
