package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import po.RoomPO;
import vo.HotelVO;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class HotelManager {

	RoomManager roomManager;
	HotelDao hotelDao;
	
	public HotelManager(RoomManager roomManager, HotelDao hotelDao){
		this.roomManager = roomManager;
		this.hotelDao = hotelDao;
	}
	
	public ResultMessage updateHotel(HotelVO vo) {
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.updateHotel(HotelPO.createHotelPO(vo));
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	public ResultMessage addSpecialRoom(RoomVO vo) {
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.addSpecialRoom(RoomPO.createRoomPO(vo));
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.deleteSpecialRoom(RoomPO.createRoomPO(vo));
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	public ArrayList<RoomVO> getRoomList(String id) {
		return roomManager.getRoomList(id);
	}
	
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		return roomManager.updateRoomList(roomList);
	}
	
}
