package bl.promotionServiceimpl;

import java.util.ArrayList;
import java.util.Date;

import constant.ConditionType;
import constant.ResultMessage;
import constant.RoomType;
import constant.ScopeType;
import po.OrderPO;
import bl.PromotionService;
import vo.PromotionVO;

/**
 * 策略包总控
 * @author aa
 *
 */
public class PromotionController implements PromotionService {

	
	Promotion promotion;
	@Override
	public ResultMessage addPromotion(String reason, String ID) {
		// TODO Auto-generated method stub
		
		promotion=new Promotion(reason, ID);
		return null;
	}

	@Override
	public ResultMessage setScope(ScopeType stype, String id, RoomType rtype) {
		// TODO Auto-generated method stub
		return promotion.setScope(stype,id,rtype);
	}

	@Override
	public ResultMessage setConditioniType(ConditionType type, int Requirement) {
		// TODO Auto-generated method stub
		return promotion.setConditionType(type,Requirement);
	}

	@Override
	public ResultMessage setPromotionType(PromotionType type, int num) {
		// TODO Auto-generated method stub
		return promotion.setPromotionType(type,num);
	}

	@Override
	public ResultMessage setDate(Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		return promotion.setDate(beginDate,  endDate);
	}

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
	public ResultMessage update() {
		// TODO Auto-generated method stub
		return promotion.update();
	}

	@Override
	public ResultMessage setCoupon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setPromotionType(constant.PromotionType type, int num) {
		// TODO Auto-generated method stub
		return null;
	}


}
