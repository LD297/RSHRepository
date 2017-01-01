package bl.userserviceimpl;

import bl.hotelserviceimpl.UserForHotel;

/**
 * 消除双向依赖
 * @author aa
 *
 */
public class UserForHotelController implements UserForHotel{

	@Override
	public boolean hasReserved(String userID, String hotelID) {
		User user = User.getInstance(userID);
		if(user == null){
			return false;
		}
		return user.hasReserved(hotelID);
	}

}
