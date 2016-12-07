package bl.hotelserviceimpl;

import bl.hotelservice.HotelService;
import bl.orderservice.HotelInfoService;
import constant.ResultMessage;
import presentation.controller.HotelServiceFactory;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomNormVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

public class HotelController implements HotelService, HotelInfoService{
	
	/*
	 * 暂时考虑每个controller处理自己对应的hotel的业务逻辑
	 */
	private Hotel hotel;
	/*
	 * 默认hotel，id全为零，用来处理逻辑上静态但却写成动态的方法，如验证密码
	 */
	private Hotel defaultHotel;

	/**
	 * 当HotelController被用于处理一些不依托具体酒店对象的业务逻辑，如验证密码时
	 * 创建新对象，调用此构造方法
	 */
	public HotelController(){
		this.initDefaultHotel();
	}

	/**
	 * 当HotelController被用于处理对应的具体酒店的业务逻辑时，调用此重载的构造方法
	 * @param id 酒店id
	 */
	public HotelController(String id){
		hotel = HotelServiceFactory.getHotel(id);
		this.initDefaultHotel();
	}

	private void initDefaultHotel(){
		if(this.defaultHotel==null)
			this.defaultHotel = HotelServiceFactory.getHotel("0000000000");
	}

	public ResultMessage checkPassword(String id, String password) {
		return defaultHotel.checkPassword(id, password);
	}

	public HotelVO getHotel() {
		return hotel.getHotel();
	}

	public ResultMessage updateHotel(HotelVO vo) {
		return hotel.updateHotel(vo);
	}

	public ResultMessage addSpecialRoom(RoomVO vo) {
		return hotel.addSpecialRoom(vo);
	}

	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		return hotel.deleteSpecialRoom(vo);
	}

	public ArrayList<RoomVO> getRoomList() {
		return hotel.getRoomList();
	}

	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		return hotel.updateRoomList(roomList);
	}

	public ArrayList<RoomAvailVO> getRoomAvailList(Date date) {
		return hotel.getRoomAvailList(date);
	}

	public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> roomAvailList) {
		return hotel.updateRoomAvailList(roomAvailList);
	}

	// 供给order模块
	// 返回该酒店的所有房间规格（类型、价格）
	public ArrayList<RoomNormVO> getRoomNorms() {
		return hotel.getRoomNorms();
	}

	// 供给order模块
	// 返回该酒店指定日期下该房间类型的可用数量
	public int numOfRoomAvail(String roomType, Date checkIn, Date checkOut) {
		return hotel.numOfRoomAvail(roomType, checkIn, checkOut);
	}

	// 供给order模块
	// 更新系统的可用客房信息
	public ResultMessage changeRoomAvail(String roomType, int num, Date checkIn, Date checkOut) {
		return hotel.changeRoomAvail(roomType, num, checkIn, checkOut);
	}

	// 供给order模块
	// 返回该酒店的最晚入住时间
	public String getCheckInDDL(String id) {
		return defaultHotel.getCheckInDDL(id);
	}

}
