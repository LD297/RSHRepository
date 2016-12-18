package bl.promotionServiceimpl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import constant.MemberType;
import data.dao.promotiondao.PromotionDao;
import po.OrderPO;
import po.PromotionPO;
import rmi.RemoteHelper;

/**
 * 计算并返回最优策略方案及价格
 * @author aa
 *
 */
public class Count {

	private static Count count = null;
	private static PromotionDao promotionDao;
	private Count(){
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		promotionDao = remoteHelper.getPromotionDao();
	}
	public static Count getInstance(){
		if(count == null){
			count = new Count();
		}
		return count;
	}
	/**
	 * 计算房间特价
	 * @param hotelID
	 * @param type
	 * @param num
	 * @param beginDate
	 * @param endDate
	 * @return 优惠原因#优惠后价格，优惠原因可为空
	 */
	public static String countPromotionOfRoom(String hotelID, String roomType, int num,int price,
											  Date beginDate, Date endDate,
											  LocalDate birthday, MemberType memberType, int memberLevel) {
		// TODO Auto-generated method stub
		Iterator<PromotionPO> promotionPOIterator = null;
		try {
			promotionPOIterator= promotionDao.finds(beginDate,endDate).iterator();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		int total=num*price;
		Promotion promotion = null;
		while (promotionPOIterator.hasNext()){
			int tempTotal;
			Promotion tempPromotion;
			tempPromotion = PromotionPO.changeIntoPromotion(promotionPOIterator.next());
			if(memberType == MemberType.commerce){
				memberLevel = memberLevel*100;
			}
			tempTotal = count(tempPromotion,hotelID,roomType,num,price,birthday,memberLevel);
			if(total>tempTotal){
				promotion = tempPromotion;
				total = tempTotal;
			}
		}
		String reason = null;
		if(promotion!=null){
			reason = promotion.getReason();
		}
		return reason+"#"+total;
	}

	private static int count(Promotion promotion, String hotelID, String roomType, int num, int price, LocalDate birthday, int memberLevel){
		int result = num*price;
		Boolean isBirthday = false;
		if(LocalDate.now()==birthday){
			isBirthday = true;
		}
		if(promotion.scope.check(hotelID,roomType)&&
		promotion.condition.check(num,price,memberLevel,isBirthday)){
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
