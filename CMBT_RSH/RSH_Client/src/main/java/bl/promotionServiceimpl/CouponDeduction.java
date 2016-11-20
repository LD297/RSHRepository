package bl.promotionServiceimpl;

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
}
