package bl.orderserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.orderservice.HotelInfoService;
import po.OrderPO;
import vo.RoomNormVO;
import vo.RoomVO;
import constant.*;

public class Order {
	
	
	
	public OrderPO[] userbrowse(String userid){
		return null;
	}
	
	public OrderPO detail(String orderid){
		return null;
	}
	
	public OrderPO[] hotelBrowse(String hotelid){
		return null;
	}
	
	public OrderPO[] specificOrder(String userid,String hotelid){
		return null;
	}
	
	public OrderPO[] classify(OrderPO[] list,StateOfOrder state){
		return null;
	}
	//״提供给酒店̬
	public StateOfOrder getOrderStateOfUser(String userid, String hotelid){
		return null;
	}

}
