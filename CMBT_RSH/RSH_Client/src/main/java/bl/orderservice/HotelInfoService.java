package bl.orderservice;

import java.util.Date;
import java.util.ArrayList;

import constant.*;
import vo.*;

public interface HotelInfoService {
	//得到某酒店房间规模
	public ArrayList<RoomNormVO> getRoomNorms();
	
	// 根据日期 得到某酒店的可用客房数
	public int numOfRoomAvail(RoomType roomType, Date checkIn, Date checkOut);
	
	// 改变可用客房数
	public ResultMessage changeRoomAvail(RoomType roomType, int num, Date checkIn, Date checkOut);
	
	// 得到某酒店的最晚入住时间
	public String getCheckInDDL(String id);
}
