package bl.hotelserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.hotelservice.HotelService;
import bl.orderservice.CommentService;
import constant.ResultMessage;
import constant.RoomType;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomNormVO;
import vo.RoomVO;

public class HotelController implements HotelService, CommentService{
	
	/**
	 * 暂时考虑一个controller掌管一个hotel的业务逻辑
	 */
	Hotel hotel;
	
	public HotelController(String id){
		hotel = new Hotel(id);
	}
	
	public static ResultMessage checkPassword(String id, String password) {
		return Hotel.checkPassword(id, password);
	}

	@Override
	public HotelVO getHotel() {
		// TODO Auto-generated method stub
		return null;
	}


	// 供给order模块
	// 根据用户评分加权计算，更新酒店评分
	public ResultMessage updateGrade(double grade) {
		return hotel.updateGrade(grade);
	}

	@Override
	public ResultMessage updateHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoomVO> getRoomList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoomAvailVO> getRoomAvailList(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> availableRoomList) {
		// TODO Auto-generated method stub
		return null;
	}

	// 供给order模块
	// 返回该酒店的所有房间规格（类型、价格）
	public ArrayList<RoomNormVO> getRoomNorms() {
		return hotel.getRoomNorms();
	}

	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public int numOfRoomAvail(RoomType roomType, Date checkIn, Date checkOut) {
		return hotel.numOfRoomAvail(roomType, checkIn, checkOut);
	}

	// 供给order模块
	// 更新系统的可用客房信息
	public ResultMessage changeRoomAvail(RoomType roomType, int num, Date checkIn, Date checkOut) {
		return hotel.changeRoomAvail(roomType, num, checkIn, checkOut);
	}

	// 供给order模块
	// 返回该酒店的最晚入住时间
	public String getCheckInDDL(String id) {
		return hotel.getCheckInDDL(id);
	}

	public  static ResultMessage addComment(String id, String userID, String comment){
		return CommentImpl.addComment(id, userID, comment);
		
	}
	
}
