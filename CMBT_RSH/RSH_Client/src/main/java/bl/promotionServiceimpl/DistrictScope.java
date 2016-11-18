package bl.promotionServiceimpl;

/**
 * 特定地区范围
 * @author aa
 *
 */
public class DistrictScope extends Scope{

	String district;
	
	public DistrictScope(String dis){
		district=dis;
	}
	
	public boolean check(String hotelID){
		boolean result=false;
		
		return result;
	}
}
