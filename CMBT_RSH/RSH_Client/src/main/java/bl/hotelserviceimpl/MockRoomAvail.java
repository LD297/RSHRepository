package bl.hotelserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import constant.ResultMessage;
import constant.RoomType;
import vo.RoomAvailVO;
/**
 * 测试hotel对roomavail的调用
 * @author a297
 *
 */
public class MockRoomAvail extends RoomAvail {

	// 供给order模块
		// 返回该酒店指定日期下该房间类型的可用数量
		public int numOfRoomAvail(RoomType roomType, Date checkIn, Date checkOut) {
			return 10;
		}
		
		// 供给order模块
		// 更新系统的可用客房信息
		public ResultMessage changeRoomAvail(RoomType roomType, int num, Date checkIn, Date checkOut) {
			return ResultMessage.succeed;
		}
		
		public ArrayList<RoomAvailVO> getRoomAvailList(Date date) {
			RoomAvailVO roomAvail = new RoomAvailVO("天鹅大酒店", RoomType.doubleRoom);
			ArrayList<RoomAvailVO> list = new ArrayList<RoomAvailVO>(); 
			list.add(roomAvail);
			return list;
		}
		
		public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> availableRoomList) {
			return ResultMessage.succeed;
		}
	
}
