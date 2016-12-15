package bl.hotelserviceimpl;

import bl.hotelservice.HotelService;
import constant.ResultMessage;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomNormVO;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class HotelController implements HotelService {
	/*
	 * 暂时考虑每个controller处理自己对应的hotel的业务逻辑
	 */
	private Hotel hotel;
	

	public HotelController(String id) {
		// TODO Auto-generated constructor stub
	}

	public HotelController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public HotelVO getHotelInfo(String id) {
		// TODO Auto-generated method stub

		hotel = HotelServiceFactory.getHotel(id);
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

	@Override
	public int numOfRoomAvail(String roomType, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static  ResultMessage checkPassword(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
