package bl.hotelserviceimpl;

import java.util.ArrayList;

import constant.ResultMessage;
import vo.HotelVO;
import vo.RoomVO;

/**
 * 测试hotel对hotelmanager的调用
 * @author a297
 *
 */
public class MockHotelManager extends HotelManager{
	public MockHotelManager(RoomManager roomManager) {
		super(roomManager);
		this.roomManager = roomManager;
	}

	public ResultMessage updateHotel(HotelVO vo) {
		return ResultMessage.succeed;
	}
	
	public ResultMessage addSpecialRoom(RoomVO vo) {
		return ResultMessage.succeed;
	}
	
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		return ResultMessage.succeed;
	}
	
	public ArrayList<RoomVO> getRoomList() {
		return roomManager.getRoomList();
	}
	
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		return roomManager.updateRoomList(roomList);
	}
}
