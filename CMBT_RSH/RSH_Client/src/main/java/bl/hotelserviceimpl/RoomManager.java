package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.RoomPO;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RoomManager {

	HotelDao hotelDao;

	public RoomManager(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public ArrayList<RoomVO> getRoomList(String id) {
		ArrayList<RoomVO> arrayList = null;
		try {
			arrayList = hotelDao.getRoomList(id);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		ArrayList<RoomPO> roomPOList = new ArrayList(roomList.size());
		for(RoomVO roomVO:roomList){
			roomPOList.add(RoomPO.createRoomPO(roomVO));
		}
		ResultMessage resultMessage = null;
		try{
			resultMessage = hotelDao.updateRoomList(roomPOList);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
}
