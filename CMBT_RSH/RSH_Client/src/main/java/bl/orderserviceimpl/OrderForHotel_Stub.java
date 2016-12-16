package bl.orderserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.orderservice.OrderForHotel;
import constant.ResultMessage;
import constant.StateOfOrder;
import vo.OrderVO;
import vo.RoomNormVO;

public class OrderForHotel_Stub implements OrderForHotel{

	@Override
	public ArrayList<OrderVO> hotelClassify(String hotelID, StateOfOrder state) {
		OrderVO vo1 = new OrderVO("a12345678987654321", "000001", "Xiaoer Wang", hotelID, "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo2 = new OrderVO("b12345678987654321", "000002", "Xiaoer Wang", hotelID, "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo3 = new OrderVO("c12345678987654321", "000003", "Xiaoer Wang", hotelID, "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo4 = new OrderVO("d12345678987654321", "000001", "Xiaoer Wang", hotelID, "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo5 = new OrderVO("e12345678987654321", "000001", "Xiaoer Wang", hotelID, "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo6 = new OrderVO("f12345678987654321", "000001", "Xiaoer Wang", hotelID, "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo7 = new OrderVO("g12345678987654321", "000001", "Xiaoer Wang", hotelID, "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo8 = new OrderVO("h12345678987654321", "000001", "Xiaoer Wang", hotelID, "BIG Hotel", state,
				new RoomNormVO("000001", "单人间", 200.0), 200, 2, 3, true, 200, 300, "No Promotion", "very good", 3,
				new Date(), new Date(), "03:30:00", new Date(), new Date(), new Date(), new Date(), new Date());
		OrderVO vo9 = new OrderVO("i12345678987654321", "000001", "Xiaoer Wang", hotelID, "BIG Hotel", state,
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
	public ResultMessage execute(String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage leaveUpdate(String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage hotelCancelAbnormal(String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

}
