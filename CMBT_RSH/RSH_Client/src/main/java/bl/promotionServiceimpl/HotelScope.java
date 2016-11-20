package bl.promotionServiceimpl;

/**
 * 特定酒店范围
 * @author aa
 *
 */
public class HotelScope extends ScopeType {

	String hotelID;
	
	public HotelScope(String hotel){
		hotelID=hotel;
	}
	public boolean check(String hotel){
		boolean result=false;
		
		return result;
	}
}
