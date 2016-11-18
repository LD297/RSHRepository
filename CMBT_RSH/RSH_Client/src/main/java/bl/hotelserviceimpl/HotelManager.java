package bl.hotelserviceimpl;

import java.util.ArrayList;

import constant.*;
import vo.*;

public class HotelManager {
	
	RoomManager roomManager;
	
	public HotelManager(RoomManager roomManager){
		this.roomManager = roomManager;
	}
	
	public ResultMessage updateHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultMessage addSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<RoomVO> getRoomList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
