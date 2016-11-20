package bl.hotelserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import constant.ResultMessage;
import constant.RoomType;
import data.dao.hoteldao.HotelDao;
import vo.RoomAvailVO;

public class RoomAvail {

	HotelDao hotelDao;

	public RoomAvail(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public int numOfRoomAvail(String id, RoomType roomType, Date checkIn, Date checkOut) {
		return hotelDao.numOfRoomAvail(id, roomType, checkIn, checkOut);
	}
	
	// 供给order模块
	// 更新系统的可用客房信息
	public ResultMessage changeRoomAvail(String id, RoomType roomType, int num, Date checkIn, Date checkOut) {
		return hotelDao.changeRoomAvail(id, roomType, num, checkIn, checkOut);
	}
	
	public ArrayList<RoomAvailVO> getRoomAvailList(String id, Date date) {
		return hotelDao.getRoomAvailList(id, date);
	}
	
	public ResultMessage updateRoomAvailList(String id, ArrayList<RoomAvailVO> roomAvailList) {
		return hotelDao.updateRoomAvailList(id, roomAvailList);
	}
}
