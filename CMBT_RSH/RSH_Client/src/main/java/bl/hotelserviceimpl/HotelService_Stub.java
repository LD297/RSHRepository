package bl.hotelserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.hotelservice.HotelService;
import constant.ResultMessage;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;

public class HotelService_Stub implements HotelService{

	@Override
	public HotelVO getHotelInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelVO getHotelInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoomVO> getRoomList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoomAvailVO> getRoomAvailList(Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage plusRoomAvail(String roomType, int num, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage minusRoomAvail(String roomType, int num, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return null;
	}

}
