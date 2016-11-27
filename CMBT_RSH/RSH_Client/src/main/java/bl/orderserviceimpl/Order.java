package bl.orderserviceimpl;

import constant.StateOfOrder;
import po.OrderPO;

import java.util.ArrayList;

public class Order {
	// 浏览用户的订单
	public ArrayList<OrderPO> userBrowse(String userid){
		return null;
	}

	// 显示订单详情
	public OrderPO detail(String orderid){
		return null;
	}

	// 浏览酒店的订单
	public ArrayList<OrderPO> hotelBrowse(String hotelid){
		return null;
	}

	// 用户浏览在该酒店下的所有订单
	public ArrayList<OrderPO> specificOrder(String userid,String hotelid){
		return null;
	}

	// 查看所有订单时，可以分类查看
	// 提供给 用户userbrowse 酒店hotelbrowse
	public ArrayList<OrderPO> classify(ArrayList<OrderPO> orders,StateOfOrder state){
		return null;
	}

	// 提供给酒店的
	// 返回该用户在酒店的最近订单的状态
	public StateOfOrder getOrderStateOfUser(String userid, String hotelid){
		return null;
	}

}
