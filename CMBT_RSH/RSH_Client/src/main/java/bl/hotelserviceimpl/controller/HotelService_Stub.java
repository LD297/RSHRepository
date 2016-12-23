package bl.hotelserviceimpl.controller;

import java.util.ArrayList;
import java.util.Date;

import bl.hotelservice.HotelService;
import constant.ResultMessage;
import vo.HotelVO;
import vo.RoomAvailVO;
import vo.RoomVO;

public class HotelService_Stub implements HotelService{

	@Override
	public HotelVO getHotelInfo(String id) {
		// TODO Auto-generated method stub
		HotelVO vo1 = new HotelVO("0100190001", "Dream_in_Asia", "仙林大道", "0100097890","123456", 4, 99.9, "00:00:00", "高端大气上档次", "1101", "/images/defaultHotelImage.jpg");
		return vo1;
	}


	@Override
	public ResultMessage updateHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ArrayList<RoomVO> getRoomList(String id) {
		RoomVO vo1 = new RoomVO("001", "单人间", 20, 200, "/images/默认房间图片.jpg");
		RoomVO vo2 = new RoomVO("002", "标准间", 10, 300, "/images/默认房间图片.jpg");
		RoomVO vo3 = new RoomVO("003", "三人间", 30, 400, "/images/默认房间图片.jpg");
		RoomVO vo4 = new RoomVO("004", "大床房", 50, 500, "/images/默认房间图片.jpg");
		RoomVO vo5 = new RoomVO("005", "小床房", 15, 600, "/images/默认房间图片.jpg");
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
	public ArrayList<RoomAvailVO> getRoomAvailList(String hotelID,Date checkIn) {
		RoomAvailVO vo1 = new RoomAvailVO("001", "单人间","/images/默认房间图片.jpg",new Date(), 20, 200);
		RoomAvailVO vo2 = new RoomAvailVO("002", "双人间","/images/默认房间图片.jpg",new Date(), 10, 300);
		RoomAvailVO vo3 = new RoomAvailVO("003", "三人间","/images/默认房间图片.jpg",new Date(), 30, 400);
		RoomAvailVO vo4 = new RoomAvailVO("004", "大床房","/images/默认房间图片.jpg",new Date(), 50, 500);
		RoomAvailVO vo5 = new RoomAvailVO("005", "小床房","/images/默认房间图片.jpg",new Date(), 15, 600);
		ArrayList<RoomAvailVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		return list;
	}

	@Override
	public ResultMessage plusRoomAvail(String hotelID,String roomType, int num, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage minusRoomAvail(String hotelID,String roomType, int num, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public int numOfRoomAvail(String hotelID,String roomType, Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public ArrayList<String> getImageAddresses(String hotelID) {
		// TODO Auto-generated method stub
		ArrayList<String> imageUrls = new ArrayList<>();
		imageUrls.add("http://i1.piimg.com/4851/e80b91b9c46f0a61.jpg");//酒店图片
		imageUrls.add("http://p1.bqimg.com/4851/57e9209924eaf3c8.jpg");//单人间
		imageUrls.add("http://p1.bqimg.com/4851/332b3d840e84488e.jpg");//标准间
		imageUrls.add("http://p1.bpimg.com/4851/fabade19b78d6293.jpg");//小床房
		imageUrls.add("http://p1.bpimg.com/4851/20928c273e528f8c.jpg");//大床房
		imageUrls.add("http://p1.bpimg.com/4851/be1a1e8673028877.jpg");//三人间
		return imageUrls;
	}

	@Override
	public String getImageAddress(String hotelID, String roomType) {
		if(roomType.equals("单人间")){
			return "http://p1.bqimg.com/4851/57e9209924eaf3c8.jpg";
		}else if (roomType.equals("标准间")) {
			return "http://p1.bqimg.com/4851/332b3d840e84488e.jpg";
		}else if (roomType.equals("小床房")) {
			return "http://p1.bpimg.com/4851/fabade19b78d6293.jpg";
		}else if (roomType.equals("大床房")) {
			return "http://p1.bpimg.com/4851/20928c273e528f8c.jpg";
		}else if (roomType.equals("三人间")) {
			return "http://p1.bpimg.com/4851/be1a1e8673028877.jpg";
		}else {
			return "http://i1.piimg.com/4851/e80b91b9c46f0a61.jpg";
		}
		
	}


}
