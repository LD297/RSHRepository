package bl.hotelserviceimpl;

import bl.hotelservice.HotelService;
import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.RoomAvailPO;
import rmi.RemoteHelper;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomNormVO;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;

/**
 * 
 * @author aa
 *
 */
public class HotelController implements HotelService {
	
	private static HotelDao hotelDao = null;

	private static void initRemote(){
		if(hotelDao==null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			hotelDao = remoteHelper.getHotelDao();
		}
	}
	

	@Override
	public HotelVO getHotelInfo(String hotelID) {
		// TODO Auto-generated method stub
		Hotel hotel  = Hotel.getInstance(hotelID);
		if(hotel==null){
			return null;
		}
		return hotel.getHotelInfo();
	}

	
	@Override
	public ResultMessage updateHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(vo.getHotelID());
		if(hotel == null){
			return ResultMessage.idNotExist;
		}
		return hotel.updateHotel(vo);
	}

	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID) {
		// TODO Auto-generated method stub		
		Hotel hotel = Hotel.getInstance(hotelID);
		if(hotel == null){
			return new ArrayList<>();
		}
		return hotel.getRoomList();
	}

	@Override
	public ResultMessage addSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(vo.getHotelID());
		if(hotel== null){
			return ResultMessage.idNotExist;
		}
		return hotel.addSpecialRoom(vo);
	}

	@Override
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(vo.getHotelID());
		if(hotel == null){
			return ResultMessage.idNotExist;
		}
		return hotel.deleteSpecialRoom(vo);
	}

	@Override
	public ArrayList<String> getImageAddresses(String hotelID) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(hotelID);
		if(hotel == null){
			return new ArrayList<>();
		}
		return hotel.getImageAddresses();
	}

	@Override
	public String getImageAddress(String hotelID, String roomType) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(hotelID);
		if(hotel == null){
			return null;
		}
		return hotel.getImageAddresForRoom(roomType);
	}

	@Override
	public ArrayList<RoomAvailVO> getRoomAvailList(String hotelID, Date checkIn) {
		// TODO Auto-generated method stub
		initRemote();
		ArrayList<RoomAvailVO> roomAvailVOs = new ArrayList<>();
		ArrayList<RoomAvailPO> roomAvailPOs = new ArrayList<>();
		try {
			roomAvailPOs = hotelDao.getRoomAvailList(hotelID, checkIn);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return roomAvailVOs;
		}
		for(RoomAvailPO roomAvailPO:roomAvailPOs){
			roomAvailVOs.add(roomAvailPO.changeIntoVO());
		}
		return roomAvailVOs;
	}

	@Override
	public ResultMessage plusRoomAvail(String hotelID, String roomType, int num, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		RoomAvail roomAvail = RoomAvail.getInstance(hotelID);
		if(roomAvail == null){
			return ResultMessage.idNotExist;
		}
		return roomAvail.changeRoomAvail(roomType, true, num, checkIn, checkOut);
	}

	@Override
	public ResultMessage minusRoomAvail(String hotelID, String roomType, int num, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		RoomAvail roomAvail = RoomAvail.getInstance(hotelID);
		if(roomAvail==null){
			return ResultMessage.idNotExist;
		}
		return roomAvail.changeRoomAvail(roomType, false, num, checkIn, checkOut);
	}

	@Override
	public int numOfRoomAvail(String hotelID, String roomType, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		RoomAvail roomAvail = RoomAvail.getInstance(hotelID);
		if(roomAvail==null){
			return -1;
		}
		return roomAvail.getRoomAvailNum(roomType, checkIn, checkOut);
	}



	/**
	 * 登陆模块调用
	 * @param hotelID
	 * @param password
	 * @return
	 */
	public static  ResultMessage checkPassword(String hotelID, String password) {
		// TODO Auto-generated method stub
		Hotel hotel = Hotel.getInstance(hotelID);
		if(hotel==null){
			return ResultMessage.idNotExist;
		}
		return hotel.checkPassword(password);
	}
}
