package driver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bl.orderserviceimpl.OrderForHotelController;
import bl.orderserviceimpl.OrderForUserController;
import bl.orderserviceimpl.OrderForWebsiteController;
import constant.ResultMessage;
import constant.StateOfOrder;
import vo.OrderInfo;
import vo.OrderVO;
import vo.RoomNormVO;

public class OrderDriver {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		OrderDriver orderDriver = new OrderDriver();
		orderDriver.test2();
	}
	public void test2() throws ParseException{
		OrderForUserController orderForUserController = new OrderForUserController();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date checkin = df.parse("2016-12-26");
		Date checkout = df.parse("2016-12-30");
		OrderVO orderVO = new OrderVO("", userID, "Xiaoer Wang", "0100090001", "BIG Hotel", StateOfOrder.unexecuted,
				new RoomNormVO("000001", "单人间", 200.0), 200, 0, 3, true, 200, 300, "No Promotion", "very good", 3,
				checkin, checkout, "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
        
		
		System.out.println(orderForUserController.confirmReservation(orderVO).toString());
	}
	String orderID = "0100090002000000";
	String string = "123";
	int i = 2;
	String userID = "44444444444";
/**
 * 	OrderVO orderVO = new OrderVO(orderID, userID, userName, hotelID, hotelName, state, room, roomPrice, roomNumber, peopleNumber, withChild, originValue, trueValue, promotion, comment, grade, checkIn, checkOut, hotelDDL, generationDate, actualCheckIn, actualCheckOut, cancelTime, cancelAbnormalTime)
 */
			
	String hotelID = "0100090001";
	OrderVO vo1 = new OrderVO("", userID, "Xiaoer Wang", "0100090001", "BIG Hotel", StateOfOrder.unexecuted,
			new RoomNormVO("000001", "单人间", 200.0), 200, 0, 3, true, 200, 300, "No Promotion", "very good", 3,
			new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());

	void test1(){
		OrderForUserController orderForUserController = new OrderForUserController();
		OrderForHotelController orderForHotelController = new OrderForHotelController();
		OrderForWebsiteController orderForWebsiteController = new OrderForWebsiteController();
		System.out.println("begin");
//		System.out.println(orderForUserController.confirmReservation(vo1));
//		System.out.println(orderForUserController.confirmReservation(vo1).toString());
		String orderID = orderForUserController.specificOrder(userID, hotelID).get(0).getOrderID();
		System.out.println(orderID);
		System.out.println(orderForUserController.cancelMyOrder(orderID));
		System.out.println(orderForUserController.getTrueValue(new OrderInfo("0100090001","123", 2, new Date(), new Date(), userID, 123)));
		
		System.out.println(orderForHotelController.execute(orderID));
		
		System.out.println(orderForWebsiteController.browseAbnormal().size());
		
		System.out.println("end");
	}
	
	

}
