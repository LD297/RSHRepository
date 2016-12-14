package bl.hotelserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.hotelservice.HotelInfoService;
import constant.ResultMessage;
import vo.RoomNormVO;

public class HotelInfoService_Stub implements HotelInfoService{

	@Override
	public ArrayList<RoomNormVO> getRoomNorm(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCheckInDDL(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRoomAvailNum(String hotelID, String roomType, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage updateGrade(int grade) {
		// TODO Auto-generated method stub
		return null;
	}

}
