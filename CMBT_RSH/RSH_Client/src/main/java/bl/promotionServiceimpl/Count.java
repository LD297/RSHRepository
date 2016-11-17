package bl.promotionServiceimpl;

import java.util.Date;

import constant.RoomType;
import po.OrderPO;

/**
 * 计算并返回最优策略方案及价格
 * @author aa
 *
 */
public class Count {

	/**
	 * 计算房间特价
	 * @param hotelID
	 * @param type
	 * @param num
	 * @param beginDate
	 * @param endDate
	 * @return 优惠原因#优惠后价格
	 */
	public static String countPromotionOfRoom(String hotelID, RoomType type, int num, Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		String reason ="双十一特惠";
		String money = "120";
		String result = reason+"#"+money;
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
