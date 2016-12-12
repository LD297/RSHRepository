package presentation.tools;

import java.util.ArrayList;
import java.util.Date;

import bl.hotelservice.HotelService;
import constant.ResultMessage;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;

public class HotelStub implements HotelService {

	public HotelStub(String hotelID) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public HotelVO getHotel() {
		HotelVO vo = new HotelVO("123456", "12345678901", "NJU Great Hotel1", "南京市栖霞区仙林大道", "仙林",
				"nothing to introduce", "nothing", 7, 100, "10:00:00");
		return vo;
	}

	@Override
	public HotelVO getHotelInfo(String id) {
		return null;
	}

	@Override
	public HotelVO getHotelInfo() {
		return null;
	}

	@Override
	public ResultMessage updateHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
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
		return null;
	}

	@Override
	public ResultMessage plusRoomAvail(String roomType, int num, Date checkIn, Date checkOut) {
		return null;
	}

	@Override
	public ResultMessage minusRoomAvail(String roomType, int num, Date checkIn, Date checkOut) {
		return null;
	}

	@Override
	public ArrayList<RoomVO> getRoomList() {
		RoomVO vo1 = new RoomVO("000001", "大床房", 200, 300, "basic");
		RoomVO vo2 = new RoomVO("000002", "大床房", 200, 300, "basic");
		RoomVO vo3 = new RoomVO("000003", "大床房", 200, 300, "basic");
		RoomVO vo4 = new RoomVO("000004", "大床房", 200, 300, "basic");
		RoomVO vo5 = new RoomVO("000005", "大床房", 200, 300, "basic");
		RoomVO vo6 = new RoomVO("000006", "大床房", 200, 300, "basic");
		RoomVO vo7 = new RoomVO("000007", "大床房", 200, 300, "basic");
		RoomVO vo8 = new RoomVO("000008", "大床房", 200, 300, "basic");
		RoomVO vo9 = new RoomVO("000009", "大床房", 200, 300, "basic");
		
		ArrayList<RoomVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		list.add(vo6);
		list.add(vo7);
		list.add(vo8);
		list.add(vo9);
		return list;
	}

	@Override
	public ResultMessage updateRoomList(ArrayList<RoomVO> roomList) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ArrayList<RoomAvailVO> getRoomAvailList(Date date) {
		RoomAvailVO vo1 = new RoomAvailVO("000001", "大床房", 200, 300, "basic");
		RoomAvailVO vo2 = new RoomAvailVO("000002", "大床房", 200, 300, "basic");
		RoomAvailVO vo3 = new RoomAvailVO("000003", "大床房", 200, 300, "basic");
		RoomAvailVO vo4 = new RoomAvailVO("000004", "大床房", 200, 300, "basic");
		RoomAvailVO vo5 = new RoomAvailVO("000005", "大床房", 200, 300, "basic");
		RoomAvailVO vo6 = new RoomAvailVO("000006", "大床房", 200, 300, "basic");
		RoomAvailVO vo7 = new RoomAvailVO("000007", "大床房", 200, 300, "basic");
		RoomAvailVO vo8 = new RoomAvailVO("000008", "大床房", 200, 300, "basic");
		RoomAvailVO vo9 = new RoomAvailVO("000009", "大床房", 200, 300, "basic");
		
		ArrayList<RoomAvailVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		list.add(vo6);
		list.add(vo7);
		list.add(vo8);
		list.add(vo9);
		return list;
	}

	@Override
	public ResultMessage updateRoomAvailList(ArrayList<RoomAvailVO> availableRoomList) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

}
