package bl.promotionServiceimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.promotiondao.PromotionDao;
import po.OrderPO;
import po.PromotionPO;
import rmi.RemoteHelper;
import vo.OrderInfo;

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
	 * @param orderInfo
	 * @return
	 */
	public static String countPromotionOfRoom(OrderInfo orderInfo) {
		initRemote();
		ArrayList<PromotionPO> promotionPOsForHotel = new ArrayList<>();
		ArrayList<PromotionPO> promotionPOsForDistrict = new ArrayList<>();
		String hotelID = orderInfo.getHotelID();
		try {
			promotionPOsForHotel = promotionDao.finds(hotelID);
			promotionPOsForDistrict = promotionDao.finds(hotelID.substring(0,DISTRICT_LENGTH));
		} catch (RemoteException e) {
			e.printStackTrace();
			return "remote_fail";
		}
		double tempValue;
		double minValue = orderInfo.getOriginalValue();
		String reason = null;
		for(PromotionPO promotionPO:promotionPOsForDistrict){
			tempValue = count(promotionPO.changeIntoPromotion(),orderInfo);
			if(tempValue<minValue){
				minValue = tempValue;
				reason = promotionPO.getReason();
			}
			System.out.print(promotionPO.getReason());
		}
		for(PromotionPO promotionPO:promotionPOsForHotel){
			tempValue = count(promotionPO.changeIntoPromotion(), orderInfo);
			if(tempValue<minValue){
				minValue = tempValue;
				reason = promotionPO.getReason();
			}
			System.out.print(promotionPO.getReason());
		}
		return reason+"#"+minValue;
	}

	private static double count(Promotion promotion, OrderInfo orderInfo){
		double result = orderInfo.getOriginalValue();
		if(promotion.scope.check(orderInfo.getHotelID(),orderInfo.getRoomType())&&
		promotion.condition.check(orderInfo)){
			result = promotion.deduction.getDeduction(result);
		}
		return result;
	}




}
