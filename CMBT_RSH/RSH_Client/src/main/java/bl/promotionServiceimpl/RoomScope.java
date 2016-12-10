package bl.promotionServiceimpl;

import constant.ScopeType;

/**
 * 适用某酒店特定房间
 * @author aa
 *
 */
public class RoomScope extends Scope {

	String hotelID;
	String roomType;
	public RoomScope(String hotel, String rType){
		hotelID=hotel;
		roomType=rType;
	}

	@Override
	public ScopeType getType() {
		return ScopeType.ROOM;
	}

	@Override
	public String getNum() {
		return hotelID;
	}

	@Override
	public String getRoomType() {
		return roomType;
	}

	public boolean check(String tempHotelID,String tempRoomType){
		if((hotelID==tempHotelID)&&roomType == tempRoomType)
			return true;
		return false;
	}
}
