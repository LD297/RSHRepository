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
	ArrayList<RoomVO> roomList;
	
	private void initRemote(){
		if(hotelDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			hotelDao = remoteHelper.getHotelDao();
		}
	}
	
	public RoomManager(String hotelID){
		this.hotelID = hotelID;
	}

	public ArrayList<RoomVO> getRoomList() {
		ArrayList<RoomVO> arrayList = null;
		initRemote();
		try {
			arrayList = hotelDao.getRoomList(hotelID);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return arrayList;
	}
	public ResultMessage addSpecialRoom(RoomVO vo) {
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.addSpecialRoom(RoomPO.changeIntoPO(vo));
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.deleteSpecialRoom(RoomPO.changeIntoPO(vo));
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	public ResultMessage updateRoomList() {
		ArrayList<RoomPO> roomPOList = new ArrayList<RoomPO>();
		for(RoomVO roomVO:roomList){
			roomPOList.add(RoomPO.changeIntoPO(roomVO));
		}
		ResultMessage resultMessage = null;
		initRemote();
		try{
			resultMessage = hotelDao.updateRoomList(roomPOList);
		}catch (RemoteException e){
			return ResultMessage.remote_fail;
		}
		return resultMessage;
	}

	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList2) {
		// TODO Auto-generated method stub
		return null;
	}
}
