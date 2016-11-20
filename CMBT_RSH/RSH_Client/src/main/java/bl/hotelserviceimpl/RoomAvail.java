package bl.hotelserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import constant.ResultMessage;
import constant.RoomType;
import data.dao.hoteldao.HotelDao;
import vo.RoomAvailVO;

public class RoomAvail {

	HotelDao hotelDao;
	
	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public int numOfRoomAvail(RoomType roomType, Date checkIn, Date checkOut) {
		return hotelDao.numOfRoomAvail(roomType, checkIn, checkOut);
	}
	
	// 供给order模块
	// 更新系统的可用客房信息
	public ResultMessage changeRoomAvail(RoomType roomType, int num, Date checkIn, Date checkOut) {
		return hotelDao.changeRoomAvail(roomType, num, checkIn, checkOut);
	}
	
	public ArrayList<RoomAvailVO> getRoomAvailList(Date date) {
		return hotelDao.getRoomAvailList(date);
	}
	
	public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> roomAvailList) {
		return hotelDao.updateRoomAvailList(roomAvailList);
	}
}
