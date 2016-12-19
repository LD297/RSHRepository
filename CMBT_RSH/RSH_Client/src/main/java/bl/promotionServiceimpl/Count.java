package bl.promotionServiceimpl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import bl.orderserviceimpl.Order;
import bl.promotionServiceimpl.condition.OrderInfo;
import constant.MemberType;
import data.dao.promotiondao.PromotionDao;
import po.OrderPO;
import po.PromotionPO;
import rmi.RemoteHelper;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomNormVO;

/**
 * 计算并返回最优策略方案及价格
 * @author aa
 *
 */
public class Count {

	private static final int DISTRICT_LENGTH = 6;
	
	private static PromotionDao promotionDao = null;
	private static void initRemote(){
		if(promotionDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			promotionDao = remoteHelper.getPromotionDao();
		}
	}
	
	/**
	 * 
	 * @param hotelID
	 * @param roomType
	 * @param num
	 * @param price
	 * @param beginDate
	 * @param endDate
	 * @param birthday
	 * @param memberType
	 * @param memberLevel
	 * @return
	 */
	public static String countPromotionOfRoom(OrderVO orderInfo) {
		initRemote();
		ArrayList<PromotionPO> promotionPOsForHotel = new ArrayList<>();
		ArrayList<PromotionPO> promotionPOsForDistrict = new ArrayList<>();
		String hotelID = orderInfo.getHotelID();
		try {
			promotionPOsForHotel = promotionDao.finds(hotelID);
			promotionPOsForDistrict = promotionDao.finds(hotelID.substring(0,DISTRICT_LENGTH));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "remote_fail";
		}
		double tempValue;
		double minValue = orderInfo.getOriginValue();
		String reason = null;
		for(PromotionPO promotionPO:promotionPOsForDistrict){
			tempValue = count(promotionPO.changeIntoPromotion(),orderInfo);
			if(tempValue<minValue){
				minValue = tempValue;
				reason = promotionPO.getReason();
			}
		}
		for(PromotionPO promotionPO:promotionPOsForHotel){
			tempValue = count(promotionPO.changeIntoPromotion(), orderInfo);
			if(tempValue<minValue){
				minValue = tempValue;
				reason = promotionPO.getReason();
			}
		}
		return reason+"#"+minValue;
	}

	private static double count(Promotion promotion, OrderVO orderInfo){
		double result = orderInfo.getOriginValue();
		if(promotion.scope.check(orderInfo.getHotelID(),orderInfo.getRoomType())&&
		promotion.condition.check(orderInfo)){
			result = promotion.deduction.getDeduction(result);
		}
		return result;
	}



	/**
	 * 计算总额特价
	 * @param order
	 * @return 优惠原因#优惠后价格
	 */
	public static String countPromotionOfOrder(OrderPO order) {
		// TODO Auto-generated method stub
		String reason ="双十一特惠";
		String money = "1200";
		String result = reason+"#"+money;
		
		return result;
	}


}
