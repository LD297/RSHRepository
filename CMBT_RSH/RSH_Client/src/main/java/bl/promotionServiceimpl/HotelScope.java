package bl.promotionServiceimpl;

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

	public boolean check(String hotel){
		if (hotel==hotelID)
			return true;
		return false;
	}
}
