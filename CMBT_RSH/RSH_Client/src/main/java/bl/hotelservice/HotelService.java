package bl.hotelservice;

import constant.ResultMessage;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomNormVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

public interface HotelService {

	// 返回该酒店基本信息
	public HotelVO getHotel ();

	// 得到某酒店所有房间规模
	public ArrayList<RoomNormVO> getRoomNorms();

	// 根据日期 得到某酒店的可用客房数
	public int numOfRoomAvail(String roomType, Date checkIn, Date checkOut);

	// 得到某酒店的最晚入住时间
	public String getCheckInDDL(String hotelID);

	// 系统更新数据库中该酒店的酒店基本信息
	public ResultMessage updateHotel (HotelVO vo);

	// 增加特色客房
	public ResultMessage addSpecialRoom(RoomVO vo);

	// 删除特色客房
	public ResultMessage deleteSpecialRoom(RoomVO vo);
	
	// 返回该酒店的客房信息列表
	public ArrayList<RoomVO> getRoomList();

	// 更新客房信息
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList);

	// 返回该日期段的可用客房信息列表
	public ArrayList<RoomAvailVO> getRoomAvailList(Date checkIn,Date checkOut);
	
/*	 更新该日期下的可用客房信息列表
	public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> availableRoomList);
*/
    // 增加可用客房数
    public ResultMessage plusRoomAvail(String roomType,int num, Date checkIn, Date checkOut);
    // 减少可用客房数
    public ResultMessage minusRoomAvail(String roomType,int num, Date checkIn, Date checkOut);
	// 注册酒店账号时 根据地址得到数量 得到账号
	public String getHotelID(String district);
	// 注册生成酒店
	public ResultMessage addHotel(HotelVO hotelVO);

}
