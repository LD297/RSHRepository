package bl.hotelserviceimpl;

import java.util.ArrayList;

import constant.ResultMessage;
import constant.RoomType;
import vo.RoomVO;

/**
 * 测试hotelmanager对roommanager的调用
 * @author a297
 *
 */
public class MockRoomManager extends RoomManager{
	
	
	public ArrayList<RoomVO> getRoomList() {
		RoomVO roomVO = new RoomVO("天鸿凯莱", RoomType.doubleRoom);
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		rooms.add(roomVO);
		return rooms;
	}
	
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		return ResultMessage.succeed;
	}
}
