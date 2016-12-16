package bl.promotionServiceimpl;

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
	public ArrayList<PromotionVO> getPromotionOfPeriod(Date beginDate, Date EndDate) {
		
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfRoom(String hotelID, String roomType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID) {
		PromotionVO vo1 = new PromotionVO("", "", "Promotion One", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				null, 0, null, 0);
		PromotionVO vo2 = new PromotionVO("", "", "Promotion Two", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				null, 0, null, 0);
		PromotionVO vo3 = new PromotionVO("", "", "Promotion Three", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				null, 0, null, 0);
		PromotionVO vo4 = new PromotionVO("", "", "Promotion Four", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				null, 0, null, 0);
		PromotionVO vo5 = new PromotionVO("", "", "Promotion Five", new Date(), new Date(), ScopeType.DISTRICT, "", "",
				null, 0, null, 0);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String countPromotionOfRoom(String hotelID, String type, int num, int price, Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setCoupon() {
		// TODO Auto-generated method stub
		return null;
	}

}
