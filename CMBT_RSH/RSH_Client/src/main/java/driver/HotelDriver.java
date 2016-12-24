package driver;

import javax.naming.directory.SearchControls;

import bl.hotelserviceimpl.HotelManager;
import bl.hotelserviceimpl.SearchHotelController;
import bl.hotelserviceimpl.controller.HotelController;
import bl.hotelserviceimpl.controller.HotelInfoController;
import bl.hotelserviceimpl.controller.ManagerHotelController;
import vo.HotelVO;
import vo.RoomVO;

public class HotelDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelDriver hotelDriver = new HotelDriver();
		hotelDriver.test();
	}
	
	String hotelID = "0100090001";
//	HotelVO hotelVO2 = new HotelVO(hotelID, hotelName, detailAddress, tel, password, level, standardRoomPrice, latestCheckInTime, briefIntro, facility, imageAddress);
	HotelVO hotelVO = new HotelVO(hotelID, "1号酒店", "仙林大道", "0100097890","123456", 4, 99.9, "00:01:01", "nothing", "0101", "/images/默认酒店图片.jpg");
	RoomVO roomVO = new RoomVO(hotelID, "123", 2, 200, "123");
	void test(){
		HotelController hotelController = new HotelController();
		HotelInfoController hotelInfoController = new HotelInfoController();
		ManagerHotelController managerHotelController = new ManagerHotelController();
		SearchHotelController searchHotelController = new SearchHotelController();
		System.out.println("begin");
		
		System.out.println(managerHotelController.addHotel(hotelVO));
		System.out.println(hotelInfoController.getCheckInDDL(hotelID));
		System.out.println(managerHotelController.getHotelID("010009"));
		System.out.println(hotelController.getHotelInfo(hotelID).tel);		
		System.out.println(hotelController.addSpecialRoom(roomVO));
		System.out.println(hotelController.deleteSpecialRoom(roomVO));
		System.out.println(searchHotelController.getHotelList("江苏省","南京市","栖霞区"));
		System.out.println("end");
	}

}
