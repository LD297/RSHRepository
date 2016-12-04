package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import vo.RoomAvailVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class RoomAvail {

	HotelDao hotelDao;

	public RoomAvail(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public int numOfRoomAvail(String id, String roomType, Date checkIn, Date checkOut) {
		int numOfRoomAvail = 0;
		try{
			numOfRoomAvail = hotelDao.numOfRoomAvail(id, roomType, checkIn, checkOut);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return numOfRoomAvail;
	}
	
	// 供给order模块
	// 更新系统的可用客房信息
	public ResultMessage changeRoomAvail(String id, String roomType, int num, Date checkIn, Date checkOut) {
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.changeRoomAvail(id, roomType, num, checkIn, checkOut);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	public ArrayList<RoomAvailVO> getRoomAvailList(String id, Date date) {
		ArrayList<RoomAvailVO> availVOs = null;
		try{
			availVOs = hotelDao.getRoomAvailList(id, date);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return availVOs;
	}
	
	public ResultMessage updateRoomAvailList(String id, ArrayList<RoomAvailVO> roomAvailList) {
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.updateRoomAvailList(id, roomAvailList);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
}
