package driver;

import java.util.Date;

import bl.orderserviceimpl.OrderForHotelController;
import bl.orderserviceimpl.OrderForUserController;
import bl.orderserviceimpl.OrderForWebsiteController;
import constant.StateOfOrder;
import vo.OrderInfo;
import vo.OrderVO;
import vo.RoomNormVO;

public class OrderDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderDriver orderDriver = new OrderDriver();
		orderDriver.test1();
	}
	String orderID = "0100090002000000";
	String string = "123";
	int i = 2;
	String userID = "11111111111";
	OrderVO vo1 = new OrderVO("a12345678987654321", userID, "Xiaoer Wang", "000001", "BIG Hotel", StateOfOrder.unexecuted,
			new RoomNormVO("000001", "单人间", 200.0), 200, 0, 3, true, 200, 300, "No Promotion", "very good", 3,
			new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());

	void test1(){
		OrderForUserController orderForUserController = new OrderForUserController();
		OrderForHotelController orderForHotelController = new OrderForHotelController();
		OrderForWebsiteController orderForWebsiteController = new OrderForWebsiteController();
		System.out.println("begin");
		System.out.println(orderForUserController.confirmReservation(vo1).toString());
		System.out.println(orderForUserController.cancelMyOrder(orderID));
		System.out.println(orderForUserController.getTrueValue(new OrderInfo("0100090001","123", 2, new Date(), new Date(), userID, 123)));
		
		System.out.println(orderForHotelController.execute(orderID));
		
		System.out.println(orderForWebsiteController.browseAbnormal().size());
		
		
		System.out.println("end");
	}
	
	

}
