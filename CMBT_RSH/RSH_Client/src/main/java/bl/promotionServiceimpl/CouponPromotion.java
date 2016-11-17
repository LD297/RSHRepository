package bl.promotionServiceimpl;

/**
 *卡券优惠
 * @author aa
 *
 */
public class CouponPromotion extends PromotionType{

	Coupon coupon;
	public CouponPromotion(Coupon coup){
		coupon=coup;
	}
	
	public int getPromotioin(int total){
		
		return total;
	}
}
