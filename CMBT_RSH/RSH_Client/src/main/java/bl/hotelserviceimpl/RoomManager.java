package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.RoomPO;
import rmi.RemoteHelper;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;


public class RoomManager {

	private static HotelDao hotelDao  = null;
	String hotelID;
	ArrayList<RoomVO> roomList;
	
	private static void initRemote(){
		if(hotelDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			hotelDao = remoteHelper.getHotelDao();
		}
	}
	
	private RoomManager(String hotelID){
		this.hotelID = hotelID;
		roomList = getRoomList();
	}
	
	protected static RoomManager getInstance(String hotelID){
		RoomManager roomManager = new RoomManager(hotelID);
		initRemote();
		try {
			if(hotelDao.getHotel(hotelID)==null){
				return null;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		return roomManager;
	}

	public ArrayList<RoomVO> getRoomList() {
		ArrayList<RoomPO> roomPOs = new ArrayList<>();
		ArrayList<RoomVO> roomVOs = new ArrayList<>();
		initRemote();
		try {
			roomPOs = hotelDao.getRoomList(hotelID);
		}catch (RemoteException e){
			e.printStackTrace();
			return roomVOs;
		}
		for(RoomPO roomPO:roomPOs){
			roomVOs.add(roomPO.changeIntoVO());
		}
		return roomVOs;
	}
	public ResultMessage addSpecialRoom(RoomVO vo) {
		initRemote();
		try {
			return hotelDao.addSpecialRoom(vo.changeIntoPO());
		}catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.remote_fail;
        }
	}
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		try {
			return hotelDao.deleteSpecialRoom(vo.changeIntoPO());
		}catch (RemoteException e){
			e.printStackTrace();
            return ResultMessage.remote_fail;
		}
	}
	
}
