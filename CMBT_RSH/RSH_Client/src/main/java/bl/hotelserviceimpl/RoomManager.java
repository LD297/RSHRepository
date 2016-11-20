package bl.hotelserviceimpl;

import java.util.ArrayList;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.RoomPO;
import vo.RoomVO;

public class RoomManager {

	HotelDao hotelDao;

	public RoomManager(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public ArrayList<RoomVO> getRoomList(String id) {
		return hotelDao.getRoomList(id);
	}
	
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		ArrayList<RoomPO> roomPOList = new ArrayList<>(roomList.size());
		for(RoomVO roomVO:roomList){
			roomPOList.add(RoomPO.createRoomPO(roomVO));
		}
		return hotelDao.updateRoomList(roomPOList);
	}
}
