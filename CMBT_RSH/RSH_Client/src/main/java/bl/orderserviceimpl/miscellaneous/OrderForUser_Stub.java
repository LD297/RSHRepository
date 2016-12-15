package bl.orderserviceimpl.miscellaneous;

import java.util.ArrayList;
import java.util.Date;

import bl.orderservice.OrderForUser;
import constant.ResultMessage;
import constant.StateOfOrder;
import vo.OrderVO;
import vo.RoomNormVO;

public class OrderForUser_Stub implements OrderForUser{

	@Override
	public ArrayList<OrderVO> userClassify(String userID, StateOfOrder state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO detail(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cancelMyOrder(String orderID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StateOfOrder getOrderStateOfUser(String userID, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> specificOrder(String userID, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTrueValue(String userID, String hotelID, Date checkIn, Date checkOut, RoomNormVO room,
			int roomNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage confirmReservation(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addComment(String orderID, int grade, String comment) {
		// TODO Auto-generated method stub
		return null;
	}



}
