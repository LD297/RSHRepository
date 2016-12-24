package bl.hotelserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.hotelservice.HotelInfoService;
import constant.ResultMessage;
import vo.RoomNormVO;
/**
 * 
 * @author aa
 *
 */
public class HotelInfoController implements HotelInfoService{
	
	@Override
	public ArrayList<RoomNormVO> getRoomNorm(String hotelID) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(hotelID);
		if(hotel == null){
			return new ArrayList<>();
		}
		return hotel.getRoomNorms();
	}

	@Override
	public String getCheckInDDL(String hotelID) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(hotelID);
		if(hotel==null){
			return null;
		}
		return hotel.getCheckInDDL();
	}

	@Override
	public ResultMessage updateGrade(String hotelID,int grade) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(hotelID);
		if(hotel == null){
			return ResultMessage.idNotExist;
		}
		return hotel.updateGrade(grade);
	}

}
