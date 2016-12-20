package bl.hotelserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.hotelservice.HotelInfoService;
import constant.ResultMessage;
import vo.RoomNormVO;

public class HotelInfoService_Stub implements HotelInfoService{

	@Override
	public ArrayList<RoomNormVO> getRoomNorm(String hotelID) {
		RoomNormVO vo1 = new RoomNormVO(hotelID, "1人间", 200.0);
		RoomNormVO vo2 = new RoomNormVO(hotelID, "2人间", 200.1);
		RoomNormVO vo3 = new RoomNormVO(hotelID, "3人间", 200.2);
		RoomNormVO vo4 = new RoomNormVO(hotelID, "4人间", 200.3);
		RoomNormVO vo5 = new RoomNormVO(hotelID, "5人间", 200.4);
		RoomNormVO vo6 = new RoomNormVO(hotelID, "6人间", 200.5);
		RoomNormVO vo7 = new RoomNormVO(hotelID, "7人间", 200.6);
		RoomNormVO vo8 = new RoomNormVO(hotelID, "8人间", 200.7);
		RoomNormVO vo9 = new RoomNormVO(hotelID, "9人间", 200.8);
		ArrayList<RoomNormVO> list = new ArrayList<>();
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
	public String getCheckInDDL(String hotelID) {
		// TODO Auto-generated method stub
		return "03:30:00";
	}

	@Override
	public int getRoomAvailNum(String hotelID, String roomType, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		System.out.println(10);
		return 10;
	}

	@Override
	public ResultMessage updateGrade(String hotelID, int grade) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	
}
