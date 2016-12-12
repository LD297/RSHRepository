package bl.promotionServiceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.promotionservice.PromotionService;
import constant.ResultMessage;
import vo.PromotionVO;

public class PromotionService_Stub implements PromotionService{

	@Override
	public ResultMessage addPromotion(PromotionVO promotionVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delPromotion(String setterID, String promotionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfPeriod(Date beginDate, Date EndDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfRoom(String hotelID, String roomType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID) {
		// TODO Auto-generated method stub
		return null;
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
