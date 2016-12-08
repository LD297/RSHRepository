package bl.promotionServiceimpl;

import constant.DeductionType;

/**
 *卡券优惠
 * @author aa
 *
 */
public class CouponDeduction extends Deduction {

	Coupon coupon;
	public CouponDeduction(Coupon coup){
		coupon=coup;
	}
	
	public int getPromotioin(int total){
		
		return total;
	}

	@Override
	public DeductionType getType() {
		return null;
	}

	@Override
	public int getNum() {
		return 0;
	}

	@Override
	public int getDeduction(int total) {
		return 0;
	}

}
