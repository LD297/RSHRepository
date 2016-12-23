package driver;

import bl.hotelserviceimpl.HotelManager;
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
	
	String hotelID = "0100090004";
	HotelVO hotelVO = new HotelVO("0100190001", "1号酒店", "仙林大道", "0100097890","123456", 4, 99.9, "00:00:00", "nothing", "nothing", "/images/默认酒店图片.jpg");
	RoomVO roomVO = new RoomVO(hotelID, "123", 2, 200, "123");
	void test(){
		HotelController hotelController = new HotelController();
		HotelInfoController hotelInfoController = new HotelInfoController();
		ManagerHotelController managerHotelController = new ManagerHotelController();
		System.out.println("begin");
		System.out.println(hotelInfoController.getCheckInDDL(hotelID));
		System.out.println(managerHotelController.getHotelID("010009"));
		hotelController.getHotelInfo(hotelID);
		
		System.out.println(hotelController.addSpecialRoom(roomVO));
		System.out.println("end");
	}

}
