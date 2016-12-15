package bl.hotelserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.hotelservice.HotelService;
import constant.ResultMessage;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;

public class HotelService_Stub implements HotelService{

	String hotelID = null;
	public HotelService_Stub(String hotelID) {
		this.hotelID = hotelID;
	}
	
	@Override
	public HotelVO getHotelInfo(String id) {
		// TODO Auto-generated method stub
		return new HotelVO(id, "1234567890", "1号酒店", "南京市栖霞区仙林中心", "仙林中心",
				"no more info", "懒得写", 3, 99.9, "1day");
	}

	@Override
	public HotelVO getHotelInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ArrayList<RoomVO> getRoomList() {
		RoomVO vo1 = new RoomVO("001", "单人间", 20, 200, "basic");
		RoomVO vo2 = new RoomVO("002", "双人间", 10, 300, "basic");
		RoomVO vo3 = new RoomVO("003", "三人间", 30, 400, "basic");
		RoomVO vo4 = new RoomVO("004", "大床房", 50, 500, "basic");
		RoomVO vo5 = new RoomVO("005", "小床房", 15, 600, "special");
		ArrayList<RoomVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		return list;
	}

	@Override
	public ResultMessage addSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage deleteSpecialRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ArrayList<RoomAvailVO> getRoomAvailList(Date checkIn, Date checkOut) {
		RoomAvailVO vo1 = new RoomAvailVO("001", "单人间", 20, 200, "basic");
		RoomAvailVO vo2 = new RoomAvailVO("002", "双人间", 10, 300, "basic");
		RoomAvailVO vo3 = new RoomAvailVO("003", "三人间", 30, 400, "basic");
		RoomAvailVO vo4 = new RoomAvailVO("004", "大床房", 50, 500, "basic");
		RoomAvailVO vo5 = new RoomAvailVO("005", "小床房", 15, 600, "special");
		ArrayList<RoomAvailVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		return list;
	}

	@Override
	public ResultMessage plusRoomAvail(String roomType, int num, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage minusRoomAvail(String roomType, int num, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public int numOfRoomAvail(String roomType, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return 20;
	}



}
