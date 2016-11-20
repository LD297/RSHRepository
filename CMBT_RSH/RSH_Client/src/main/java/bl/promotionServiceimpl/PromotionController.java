package bl.promotionServiceimpl;

import java.util.ArrayList;
import java.util.Date;

import constant.ResultMessage;
import constant.RoomType;
import po.OrderPO;
import bl.promotionservice.PromotionService;
import vo.PromotionVO;

/**
 * 策略包总控
 * @author aa
 *
 */
public class PromotionController implements PromotionService {

	
	Promotion promotion;
	PromotionVO promotionVO=null;

	@Override
	public ResultMessage addPromotion(PromotionVO tempPromotionVO) {
		promotionVO=tempPromotionVO;
		if(Promotion.getInstance(promotionVO.reason,promotionVO.setter)!=null){
			return ResultMessage.fail;
		}
		promotion=new Promotion(promotionVO.reason,promotionVO.setter);
		promotion.setDate(promotionVO.beginDate,promotionVO.endDate);
		promotion.setScope(promotionVO.scopeType,promotionVO.id,promotionVO.roomType);
		promotion.setConditionType(promotionVO.conditionType,promotionVO.requirement);
		promotion.setDeductionType(promotionVO.deductionType,promotionVO.deduction);
		promotion.insertPromotion();
		return ResultMessage.succeed;
	}		;


	@Override
	public ResultMessage delPromotion(String reason, String ID) {
		// TODO Auto-generated method stub
		return Promotion.delPromotion(reason,ID);
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfPeriod(Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		return Show.getPromotionOfPeriod(beginDate,endDate);
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfRoom(String hotelID, RoomType type) {
		// TODO Auto-generated method stub
		return Show.getPrmotionOfRoom(hotelID,type);
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID) {
		// TODO Auto-generated method stub
		return Show.getPromotionOfHotel(hotelID);
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfDistrict(String district) {
		// TODO Auto-generated method stub
		return Show.getPromotionOfDistrict(district);
	}

	@Override
	public String countPromotionOfRoom(String hotelID, RoomType type, int num, Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		return Count.countPromotionOfRoom(hotelID,type,num,beginDate,endDate);
	}

	@Override
	public String countPromotionOfOrder(OrderPO order) {
		// TODO Auto-generated method stub
		return Count.countPromotionOfOrder(order);
	}



	@Override
	public ResultMessage setCoupon() {
		// TODO Auto-generated method stub
		return null;
	}



}
