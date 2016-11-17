package bl.promotionServiceimpl;

import java.util.Date;

import constant.ResultMessage;
import constant.RoomType;

/**
 * 卡券类
 * @author aa
 *
 */
public class Coupon {

	String hotelID;
	RoomType type;
	Date beginDate;
	Date endDate;
	public Coupon(){
		
	}
	
	/**
	 * 数据层中增加
	 * @return
	 */
	public ResultMessage add(){
		return null;
	}
	
	/**
	 * 数据层中删除
	 * @return
	 */
	public ResultMessage del(){
		
		return null;
	}
}
