package driver;

import java.util.Date;

import bl.promotionServiceimpl.PromotionController;
import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;
import vo.PromotionVO;

public class PromotionDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PromotionDriver promotionDriver = new PromotionDriver();
		promotionDriver.test();
	}
	String id = "圣诞节";
	PromotionVO promotionVO3 = new PromotionVO(id, id, id, new Date(), new Date(), ScopeType.DISTRICT, id, id, ConditionType.BIRTHDAY, 0, DeductionType.DISCOUNT, 0);
	void test(){
		PromotionController promotionController = new PromotionController();
		System.out.println("begin");
		System.out.println(promotionController.addPromotion(promotionVO3).toString());
		System.out.println(promotionController.addPromotion(promotionVO3).toString());
		System.out.println(promotionController.getIDForNewPromotion(id));
		System.out.println(promotionController.getPromotionOfDistrict("123").size());
		System.out.println(promotionController.delPromotion(id, id));
		System.out.println(promotionController.getIDForNewPromotion(id));
		System.out.println(promotionController.addPromotion(promotionVO3));;
		System.out.println(promotionController.getPromotionOfHotel(id).size());
		System.out.println("end");
		
	}
}
