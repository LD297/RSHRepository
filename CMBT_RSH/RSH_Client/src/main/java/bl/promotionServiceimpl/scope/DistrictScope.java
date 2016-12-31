package bl.promotionServiceimpl.scope;

import constant.ScopeType;

/**
 * 特定地区范围
 * @author aa
 *
 */
public class DistrictScope extends Scope {

	String district;
	private static final int DISTRICT_LENGTH = 6;
	
	public DistrictScope(String dis){
		district=dis;
	}

	@Override
	public ScopeType getType() {
		return ScopeType.DISTRICT;
	}

	@Override
	public String getNum() {
		return district;
	}

	@Override
	public String getRoomType() {
		return null;
	}

	public boolean check(String hotelID,String roomType){
		String tempDis = hotelID.substring(0,DISTRICT_LENGTH);
		if(!district.equals(tempDis))
			return false;
		return true;
	}
}
