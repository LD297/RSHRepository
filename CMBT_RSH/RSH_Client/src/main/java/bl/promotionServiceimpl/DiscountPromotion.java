package bl.promotionServiceimpl;

/**
 * 折扣优惠
 * @author aa
 *
 */
public class DiscountPromotion extends PromotionType{

	int discount;
	
	public DiscountPromotion(int disc){
		discount=disc;
	}
	
	public int getPromotion(int total){
		int result=total;
		
		return result;
	}
}
