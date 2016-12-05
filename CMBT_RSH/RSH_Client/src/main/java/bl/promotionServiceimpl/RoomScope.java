package bl.promotionServiceimpl;

/**
 * 适用某酒店特定房间
 * @author aa
 *
 */
public class RoomScope extends ScopeType {

	String hotelID;
	String rType;
	public RoomScope(String hotel, String type){
		hotelID=hotel;
		rType=type;
	}
	
	public boolean check(String hotelAndRoom){
		boolean result=false;
		
		return result;
	}
}
