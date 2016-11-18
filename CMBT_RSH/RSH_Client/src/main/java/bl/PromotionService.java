package bl;

import java.util.ArrayList;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

import constant.ConditionType;
import constant.PromotionType;
import constant.ResultMessage;
import constant.RoomType;
import constant.ScopeType;
import po.OrderPO;
import vo.PromotionVO;

public interface PromotionService {

	/*
	 * 
	 */
	public ResultMessage addPromotion(String reason,String ID);
	
	public ResultMessage setScope(ScopeType type,String id, RoomType type2);
	
	public ResultMessage setConditioniType(ConditionType type,int Requirement);
	
	public ResultMessage setPromotionType(PromotionType type, int num);
	
	public ResultMessage setDate(Date beginDate, Date endDate);
	
	public ResultMessage update();
	
	public ResultMessage delPromotion(String reason,String ID);
	
	public ArrayList<PromotionVO> getPromotionOfPeriod(Date beginDate, Date EndDate);
	
	public ArrayList <PromotionVO> getPromotionOfRoom (String hotelID, RoomType type);
	
	public ArrayList<PromotionVO> getPromotionOfHotel(String hotelID);
	
	public ArrayList <PromotionVO> getPromotionOfDistrict (String district);
	
	public String countPromotionOfRoom(String hotelID, RoomType type, int num, Date beginDate, Date endDate);
	
	public String countPromotionOfOrder(OrderPO order);
	
	public ResultMessage setCoupon();

	public ResultMessage setPromotionType(bl.promotionServiceimpl.PromotionType type, int num);
}
