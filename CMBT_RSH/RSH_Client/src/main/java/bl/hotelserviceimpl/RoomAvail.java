package bl.hotelserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import constant.ResultMessage;
import constant.RoomType;
import vo.RoomAvailVO;

public class RoomAvail {
	
	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public int numOfRoomAvail(RoomType roomType, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// 供给order模块
	// 更新系统的可用客房信息
	public ResultMessage changeRoomAvail(RoomType roomType, int num, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<RoomAvailVO> getRoomAvailList(Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> availableRoomList) {
		// TODO Auto-generated method stub
		return null;
	}
}
