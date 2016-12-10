package bl.promotionServiceimpl;

import bl.promotionservice.PromotionService;
import constant.ResultMessage;
import po.OrderPO;
import vo.PromotionVO;

import java.util.ArrayList;
import java.util.Date;

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
		if(Promotion.getInstance(promotionVO.setterID,promotionVO.promotionID)!=null){
			return ResultMessage.already_exist;
		}
		promotion=new Promotion(promotionVO.setterID,promotionVO.promotionID,promotionVO.reason);
		promotion.setDate(promotionVO.beginDate,promotionVO.endDate);

		promotion.setScope(promotionVO.scopeType,promotionVO.scopeNum,promotionVO.roomType);
		promotion.setCondition(promotionVO.conditionType,promotionVO.conditionNum);
		promotion.setDeduction(promotionVO.deductionType,promotionVO.deductionNum);

		promotion.insertPromotion();
		return ResultMessage.succeed;
	}		;


	@Override
	public ResultMessage delPromotion(String tempSetterID, String tempPromID) {
		// TODO Auto-generated method stub
		return Promotion.delPromotion(tempSetterID,tempSetterID);
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfPeriod(Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		return Show.getPromotionOfPeriod(beginDate,endDate);
	}

	@Override
	public ArrayList<PromotionVO> getPromotionOfRoom(String hotelID, String type) {
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
	public String countPromotionOfRoom(String hotelID, String type, int num, int price,Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		return Count.countPromotionOfRoom(hotelID,type,num,price,beginDate,endDate);
	}

//	@Override
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
