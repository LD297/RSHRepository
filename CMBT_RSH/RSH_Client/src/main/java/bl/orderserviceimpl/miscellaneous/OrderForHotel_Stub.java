package bl.orderserviceimpl.miscellaneous;

import java.util.ArrayList;

import bl.orderservice.OrderForHotel;
import constant.ResultMessage;
import constant.StateOfOrder;
import vo.OrderVO;

public class OrderForHotel_Stub implements OrderForHotel{

	@Override
	public ArrayList<OrderVO> hotelClassify(String hotelID, StateOfOrder state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage execute(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage leaveUpdate(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage hotelCancelAbnormal(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

}
