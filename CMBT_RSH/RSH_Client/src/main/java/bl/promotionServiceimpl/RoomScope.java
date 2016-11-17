package bl.promotionServiceimpl;

import constant.RoomType;

/**
 * 适用某酒店特定房间
 * @author aa
 *
 */
public class RoomScope extends Scope {

	String hotelID;
	RoomType rType;
	public RoomScope(String hotel, RoomType type){
		hotelID=hotel;
		rType=type;
	}
	
	public boolean check(String hotelAndRoom){
		boolean result=false;
		
		return result;
	}
}
