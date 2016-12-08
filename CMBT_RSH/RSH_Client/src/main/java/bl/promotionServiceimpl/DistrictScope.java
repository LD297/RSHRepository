package bl.promotionServiceimpl;

import constant.ScopeType;

/**
 * 特定地区范围
 * @author aa
 *
 */
public class DistrictScope extends Scope {

	String district;
	
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

	public boolean check(String hotelID){
		String tempDis = hotelID.substring(0,6);
		if(district==tempDis)
			return true;
		return false;
	}
}
