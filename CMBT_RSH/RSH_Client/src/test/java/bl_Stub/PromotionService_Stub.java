package bl_Stub;

import java.util.ArrayList;
import java.util.Date;

import bl.promotionservice.PromotionService;
import constant.ConditionType;
import constant.DeductionType;
import constant.ResultMessage;
import constant.ScopeType;
import vo.PromotionVO;

public class PromotionService_Stub implements PromotionService{

	@Override
	public ResultMessage addPromotion(PromotionVO promotionVO) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage delPromotion(String setterID, String promotionID) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}



	@Override
	public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID) {
		PromotionVO vo1 = new PromotionVO("", "001", "大额满减", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				ConditionType.BIRTHDAY, 0, DeductionType.DISCOUNT, 9);
		PromotionVO vo2 = new PromotionVO("", "002", "双十一促销", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				ConditionType.MEMBER, 0, DeductionType.DISCOUNT, 9);
		PromotionVO vo3 = new PromotionVO("", "003", "生日特惠", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				ConditionType.COMMERCE, 0, DeductionType.REDUCE, 8);
		PromotionVO vo4 = new PromotionVO("", "004", "双十一促销", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				ConditionType.ROOMNUM, 3, DeductionType.DISCOUNT, 8);
		PromotionVO vo5 = new PromotionVO("", "005", "Promotion Five", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				ConditionType.TOTAL, 4000, DeductionType.REDUCE, 8);
		ArrayList<PromotionVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		return list;
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfDistrict(String district) {
		PromotionVO vo1 = new PromotionVO("", "001", "Promotion One", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				ConditionType.BIRTHDAY, 0, DeductionType.DISCOUNT, 9);
		PromotionVO vo2 = new PromotionVO("", "002", "Promotion Two", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				ConditionType.MEMBER, 0, DeductionType.DISCOUNT, 9);
		PromotionVO vo3 = new PromotionVO("", "003", "Promotion Three", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				ConditionType.COMMERCE, 0, DeductionType.REDUCE, 8);
		PromotionVO vo4 = new PromotionVO("", "004", "Promotion Four", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				ConditionType.ROOMNUM, 3, DeductionType.DISCOUNT, 8);
		PromotionVO vo5 = new PromotionVO("", "005", "Promotion Five", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				ConditionType.TOTAL, 4000, DeductionType.REDUCE, 8);
		ArrayList<PromotionVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		return list;
	}

	@Override
	public String getIDForNewPromotion(String setterID) {
		// TODO Auto-generated method stub
		return "010";
	}

	

	

}
