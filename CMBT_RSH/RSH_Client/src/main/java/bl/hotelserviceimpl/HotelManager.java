package bl.hotelserviceimpl;

import java.util.ArrayList;

import constant.*;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import po.RoomPO;
import vo.*;

public class HotelManager {

	RoomManager roomManager;
	HotelDao hotelDao;
	
	public HotelManager(RoomManager roomManager, HotelDao hotelDao){
		this.roomManager = roomManager;
		this.hotelDao = hotelDao;
	}
	
	public ResultMessage updateHotel(HotelVO vo) {
		return hotelDao.updateHotel(HotelPO.createHotelPO(vo));
	}
	
	public ResultMessage addSpecialRoom(RoomVO vo) {
		return hotelDao.addSpecialRoom(RoomPO.createRoomPO(vo));
	}
	
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		return hotelDao.deleteSpecialRoom(RoomPO.createRoomPO(vo));
	}
	
	public ArrayList<RoomVO> getRoomList(String id) {
		return roomManager.getRoomList(id);
	}
	
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		return roomManager.updateRoomList(roomList);
	}
	
}
