package bl.orderserviceimpl;

import java.util.Date;

import bl.promotionServiceimpl.PromotionController;
import constant.RoomType;

public class MockPromotion extends PromotionController{
    String a = "房间八折#96";
    String b = "总价九折#540";
	
	public String countPromotionOfRoom(String hotelID, RoomType type, int num, Date beginDate, Date endDate){
		return a;
	}
	
	public String countPromotionOfOrder(Order order){
		return b;
	}
	
}
