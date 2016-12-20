package bl.hotelserviceimpl.controller;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.Hotel;
import bl.hotelserviceimpl.HotelManager;
import bl.hotelserviceimpl.RoomAvail;
import bl.hotelserviceimpl.RoomManager;
import constant.ResultMessage;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomNormVO;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author aa
 *
 */
public class HotelController implements HotelService {
	
	String hotelID;
	Hotel hotel;
	HotelManager hotelManager;
	RoomManager roomManager;
	RoomAvail roomAvail;

	/**
	 * use
	 * @param id
	 */
	public HotelController(String id) {
		// TODO Auto-generated constructor stub
		hotelID = id;
		hotel = Hotel.getInstance(id);
		hotelManager = hotel.getHotelManager();
		roomManager = hotelManager.getRoomManager();
		roomAvail = RoomAvail.getInstance(hotelID);
	}

	@Override
	public HotelVO getHotelInfo(String hotelID) {
		// TODO Auto-generated method stub
		Hotel hotel  = Hotel.getInstance(hotelID);
		HotelManager hotelManager = hotel.getHotelManager();
		return hotel.getHotelInfo();
	}

	@Override
	public HotelVO getHotelInfo() {
		// TODO Auto-generated method stub
		return getHotelInfo(hotelID);
	}
	
	@Override
	public ResultMessage updateHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return hotel.updateHotel(vo);
	}

	@Override
	public ArrayList<RoomVO> getRoomList(String id) {
		// TODO Auto-generated method stub
		return roomManager.getRoomList();
	}

	@Override
	public ResultMessage addSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		return roomManager.addSpecialRoom(vo);
	}

	@Override
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		return roomManager.deleteSpecialRoom(vo);
	}

	public ArrayList<RoomAvailVO> getRoomAvailList(Date checkIn) {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		return roomAvail.getRoomAvailList(checkIn);
	}

	@Override
	public ResultMessage plusRoomAvail(String roomType, int num, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return roomAvail.changeRoomAvail(roomType, true, num, checkIn, checkOut);
	}

	@Override
	public ResultMessage minusRoomAvail(String roomType, int num, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return roomAvail.changeRoomAvail(roomType, false, num, checkIn, checkOut);
	}

	@Override
	public int numOfRoomAvail(String roomType, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return roomAvail.getRoomAvailNum(roomType, checkIn, checkOut);
	}

	public static  ResultMessage checkPassword(String hotelID, String password) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(hotelID);
		return hotel.checkPassword(password);
	}

	@Override
	public ArrayList<String> getImageAddresses(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImageAddress(String hotelID, String roomType) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
