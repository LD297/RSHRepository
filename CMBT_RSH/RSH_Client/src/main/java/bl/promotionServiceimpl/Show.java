package bl.promotionServiceimpl;

import java.util.ArrayList;
import java.util.Date;

import constant.RoomType;
import vo.PromotionVO;

/**
 * 向presentation层返回策略列表
 * @author aa
 *
 */
public class Show {

	/**
	 * 一段时间内的策略
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static ArrayList<PromotionVO> getPromotionOfPeriod(Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 符合某酒店特定房间的优惠策略
	 * @param hotelID
	 * @param type
	 * @return
	 */
	public static ArrayList<PromotionVO> getPrmotionOfRoom(String hotelID, RoomType type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 符合特定酒店的优惠策略
	 * @param hotelID
	 * @return
	 */
	public static ArrayList<PromotionVO> getPromotionOfHotel(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 符合特定地区的优惠策略
	 * @param district
	 * @return
	 */
	public static ArrayList<PromotionVO> getPromotionOfDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

}
