package bl.promotionServiceimpl.scope;

import constant.ScopeType;

/**
 * 特定酒店范围
 * @author aa
 *
 */
public class HotelScope extends Scope {

	String hotelID;
	
	public HotelScope(String hotel){
		hotelID=hotel;
	}

	@Override
	public ScopeType getType() {
		return ScopeType.HOTEL;
	}

	@Override
	public String getNum() {
		return hotelID;
	}

	@Override
	public String getRoomType() {
		return null;
	}

	public boolean check(String hotel,String roomType){
		if (hotel==hotelID)
			return true;
		return false;
	}
}
