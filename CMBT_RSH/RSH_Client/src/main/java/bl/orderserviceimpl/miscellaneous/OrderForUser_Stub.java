package bl.orderserviceimpl.miscellaneous;

import java.util.ArrayList;
import java.util.Date;

import bl.orderservice.OrderForUser;
import constant.ResultMessage;
import constant.StateOfOrder;
import vo.OrderInfo;
import vo.OrderVO;
import vo.RoomNormVO;

public class OrderForUser_Stub implements OrderForUser{

	@Override
	public ArrayList<OrderVO> userClassify(String userID, StateOfOrder state) {
		OrderVO vo1 = new OrderVO("a12345678987654321", userID, "Xiaoer Wang", "000001", "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo2 = new OrderVO("b12345678987654321", userID, "Xiaoer Wang", "000001", "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo3 = new OrderVO("c12345678987654321", userID, "Xiaoer Wang", "000001", "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo4 = new OrderVO("d12345678987654321", userID, "Xiaoer Wang", "000001", "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo5 = new OrderVO("e12345678987654321", userID, "Xiaoer Wang", "000001", "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo6 = new OrderVO("f12345678987654321", userID, "Xiaoer Wang", "000001", "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo7 = new OrderVO("g12345678987654321", userID, "Xiaoer Wang", "000001", "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo8 = new OrderVO("h12345678987654321", userID, "Xiaoer Wang", "000001", "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo9 = new OrderVO("i12345678987654321", userID, "Xiaoer Wang", "000001", "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		
		ArrayList<OrderVO> list = new ArrayList<>();
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
	public OrderVO detail(String orderID) {
		// TODO Auto-generated method stub
		return new OrderVO(orderID, "123456", "Xiaoer Wang", "000001", "BIG Hotel", StateOfOrder.executed,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "ghdjd", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
	}

	@Override
	public int cancelMyOrder(String orderID) {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public StateOfOrder getOrderStateOfUser(String userID, String hotelID) {
		// TODO Auto-generated method stub
		int n = (int)(Math.random()*4);
		if (n == 1) {
			return StateOfOrder.abnormal;
		} else if (n == 2) {
			return StateOfOrder.canceled;
		} else if (n == 3) {
			return StateOfOrder.executed;
		}
		return StateOfOrder.unexecuted;
	}

	@Override
	public ArrayList<OrderVO> specificOrder(String userID, String hotelID) {
		OrderVO vo1 = new OrderVO("a12345678987654321", userID, "Xiaoer Wang", hotelID, "BIG Hotel", StateOfOrder.abnormal,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo2 = new OrderVO("b12345678987654321", userID, "Xiaoer Wang", hotelID, "BIG Hotel", StateOfOrder.canceled,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo3 = new OrderVO("c12345678987654321", userID, "Xiaoer Wang", hotelID, "BIG Hotel", StateOfOrder.executed,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo4 = new OrderVO("d12345678987654321", userID, "Xiaoer Wang", hotelID, "BIG Hotel", StateOfOrder.unexecuted,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo5 = new OrderVO("e12345678987654321", userID, "Xiaoer Wang", hotelID, "BIG Hotel", StateOfOrder.abnormal,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo6 = new OrderVO("f12345678987654321", userID, "Xiaoer Wang", hotelID, "BIG Hotel", StateOfOrder.canceled,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo7 = new OrderVO("g12345678987654321", userID, "Xiaoer Wang", hotelID, "BIG Hotel", StateOfOrder.executed,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo8 = new OrderVO("h12345678987654321", userID, "Xiaoer Wang", hotelID, "BIG Hotel", StateOfOrder.unexecuted,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo9 = new OrderVO("i12345678987654321", userID, "Xiaoer Wang", hotelID, "BIG Hotel", StateOfOrder.abnormal,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		
		ArrayList<OrderVO> list = new ArrayList<>();
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
	public String getTrueValue(OrderInfo orderVO) {
		// TODO Auto-generated method stub
		return "双十一特惠#1230";
	}

	@Override
	public ResultMessage confirmReservation(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage addComment(String orderID, int grade, String comment) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public int getCreditReduced(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return 0;
	}



}
