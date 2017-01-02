package driver;

import javax.naming.directory.SearchControls;

import bl.hotelserviceimpl.HotelController;
import bl.hotelserviceimpl.HotelInfoController;
import bl.hotelserviceimpl.SearchHotelController;
import vo.HotelVO;
import vo.RoomVO;

public class HotelDriver {

	public static void main(String[] args) {
		HotelDriver hotelDriver = new HotelDriver();
		hotelDriver.test();
	}
	
	String hotelID = "0100090002";
//	HotelVO hotelVO2 = new HotelVO(hotelID, hotelName, detailAddress, tel, password, level, standardRoomPrice, latestCheckInTime, briefIntro, facility, imageAddress);
	HotelVO hotelVO = new HotelVO(hotelID, "1号酒店", "仙林大道", "0100097890","123456", 4, 99.9,0, "00:01:01", "nothing", "0101", "/images/默认酒店图片.jpg");
	RoomVO roomVO = new RoomVO(hotelID, "122", 2, 200, "123");
	void test(){
		HotelController hotelController = new HotelController();
		SearchHotelController searchHotelController = new SearchHotelController();
		System.out.println("begin");
		
		System.out.println(hotelController.getHotelInfo(hotelID).tel);
		System.out.println(hotelController.addSpecialRoom(roomVO));
		System.out.println(searchHotelController.getHotelList("江苏省","南京市","栖霞区").size());
		System.out.println(hotelController.getImageAddresses(hotelID).get(1));
		System.out.println("end");
	}

}
