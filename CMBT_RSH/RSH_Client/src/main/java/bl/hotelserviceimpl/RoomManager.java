package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.RoomPO;
import rmi.RemoteHelper;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RoomManager {

	HotelDao hotelDao  = null;
	String hotelID;
	ArrayList<Room>
	
	private void initRemote(){
		if(hotelDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			hotelDao = remoteHelper.getHotelDao();
		}
	}
	

	public ArrayList<RoomVO> getRoomList() {
		ArrayList<RoomVO> arrayList = null;
		try {
			arrayList = hotelDao.getRoomList(id);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public ResultMessage updateRoomList() {
		ArrayList<RoomPO> roomPOList = new ArrayList<RoomPO>();
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
