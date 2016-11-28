package bl.hotelservice;

import constant.ResultMessage;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;

public interface HotelService {

	// 返回该酒店基本信息
	public HotelVO getHotel ();

	// 系统更新数据库中该酒店的酒店基本信息
	public ResultMessage updateHotel (HotelVO vo);
	
	public ResultMessage addSpecialRoom(RoomVO vo);

	public ResultMessage deleteSpecialRoom(RoomVO vo);
	
	// 返回该酒店的客房信息列表
	public ArrayList<RoomVO> getRoomList();

	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList);

	// 返回该日期下的可用客房信息列表
	public ArrayList<RoomAvailVO> getRoomAvailList(Date date);
	
	// 更新该日期下的可用客房信息列表
	public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> availableRoomList);

}
