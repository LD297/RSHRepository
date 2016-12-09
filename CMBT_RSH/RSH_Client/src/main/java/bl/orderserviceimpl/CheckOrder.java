package bl.orderserviceimpl;

import constant.StateOfOrder;
import data.dao.orderdao.OrderDao;
import po.OrderPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class CheckOrder {

	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	// 浏览用户的订单
	public ArrayList<OrderPO> userBrowse(String userID){
		try{
		    return orderDao.findByUser(userID);
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}

	}

	// 显示订单详情
	public OrderPO detail(String orderID){
		try{
			return orderDao.findByID(orderID);
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	// 浏览酒店的订单
	public ArrayList<OrderPO> hotelBrowse(String hotelID){
		try{
			return orderDao.findByHotel(hotelID);
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	// 用户浏览在该酒店下的所有订单
	public ArrayList<OrderPO> specificOrder(String userID,String hotelID){
		try{
			return orderDao.findByHotelWithUser(userID,hotelID);
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	// 查看所有订单时，可以分类查看
	// 提供给 用户userbrowse 酒店hotelbrowse
	public ArrayList<OrderPO> classify(ArrayList<OrderPO> orders,StateOfOrder state){
		ArrayList<OrderPO> orderList = new ArrayList<OrderPO>();
		for(int i=0;i<orders.size();i++)
			if(orders.get(i).getState()==state)
				orderList.add(orders.get(i));

		return orderList;
	}

	// 提供给酒店的
	// 返回该用户在酒店的最近订单的状态
	public StateOfOrder getOrderStateOfUser(String userid, String hotelid){
		return null;
	}

}
