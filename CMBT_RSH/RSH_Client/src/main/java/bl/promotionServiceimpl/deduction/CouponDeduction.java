package bl.promotionServiceimpl.deduction;

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
	public double getDeduction(double total) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getNum() {
		// TODO Auto-generated method stub
		return 0;
	}

}
