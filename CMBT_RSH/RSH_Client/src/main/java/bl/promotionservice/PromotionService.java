package bl.promotionservice;

import java.util.ArrayList;
import java.util.Date;

import constant.ResultMessage;
import po.OrderPO;
import vo.PromotionVO;

public interface PromotionService {

	/*
	 * 
	 */
	public ResultMessage addPromotion(PromotionVO promotionVO);
	
	public ResultMessage delPromotion(String reason,String ID);
	
	public ArrayList<PromotionVO> getPromotionOfPeriod(Date beginDate, Date EndDate);
	
	public ArrayList <PromotionVO> getPromotionOfRoom (String hotelID, String type);
	
	public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID);
	
	public ArrayList <PromotionVO> getPromotionOfDistrict (String district);
	
	public String countPromotionOfRoom(String hotelID, String type, int num, Date beginDate, Date endDate);
	
	public String countPromotionOfOrder(OrderPO order);
	
	public ResultMessage setCoupon();
}
