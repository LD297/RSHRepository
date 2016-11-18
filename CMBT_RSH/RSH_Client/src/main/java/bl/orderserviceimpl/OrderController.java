package bl.orderserviceimpl;

import java.util.ArrayList;
import java.util.Date;

import bl.hotelserviceimpl.CommentImpl;
import bl.orderservice.OrderService;
import constant.ResultMessage;
import constant.StateOfOrder;
import po.OrderPO;
import vo.RoomNormVO;
import constant.*;

public class OrderController implements OrderService{
	
	Order order;
	normalOrder normalorder;
	abnormalOrder abnormalorder;
	initialOrder initialorder;
	
	//根据酒店得到房间规模
	public ArrayList<RoomNormVO> getHotelRoom(String hotelid){
		return initialorder.getHotelRoom(hotelid);
	}
		
	//根据时间得到可用房间信息
	public int[] getRoomInfo(String hotelid,Date checkIn,Date checkOut){
		return initialorder.getRoomInfo(hotelid, checkIn, checkOut);
	}
		
	//根据界面得到 orderpo 初始信息
	public OrderPO getOrder(String hotelid,String userid,Date checkIn,Date checkOut,int roomNum[]){
		return initialorder.getOrder(hotelid, userid, checkIn, checkOut, roomNum);
	}
		
	//根据界面 生成orderid  得到orderpo
	public void add(OrderPO order){
		initialorder.add(order);
		return;
	}
		
	//根据初始orderpo得到优惠后价格完善orderpo
	public double getDiscounted(OrderPO order){
		return initialorder.getDiscounted(order);
	}
	//根据用户浏览订单
	@Override 
	public OrderPO[] userbrowse(String userid){
		return order.userbrowse(userid);
	}
	//用户取消未执行订单
	@Override
	public void cancelMyOrder(String orderid){
		normalorder.cancelMyOrder(orderid);
		return ;
	}
	//订单详情
	@Override
	public OrderPO detail(String orderid){
		return order.detail(orderid);
	}
	//根据酒店得到订单
	@Override
	public OrderPO[] hotelBrowse(String hotelid){
		return order.hotelBrowse(hotelid);
	}
	//酒店执行订单
	@Override
	public ResultMessage execute(String orderid){
		normalorder.execute(orderid);
		
		return ResultMessage.succeed;//catch exception
	}
	//评价订单
	
	@Override
	public ResultMessage comment(String hotelid, String orderid, double grade,String comment){
		normalorder.comment(hotelid,orderid,grade, comment);
		
		return ResultMessage.succeed;//catch exception
	}
	//酒店取消异常订单 手动补登记
	@Override
	public ResultMessage hotelCancelAbnormal(String orderid){
		abnormalorder.hotelCancelAbnormal(orderid);
		
		return ResultMessage.succeed;//catch exception
	}
	/**
	 * 
	 * @param userid
	 * @param hotelid
	 * @return
	 */
	@Override
	public OrderPO[] specificOrder(String userid,String hotelid){
		return order.specificOrder(userid, hotelid);
	}
	@Override
	public ResultMessage leaveUpdate(String orderid){
		normalorder.leaveUpdate(orderid);
		
		return ResultMessage.succeed;//catch exception
	}
	@Override
	public OrderPO[] classify(OrderPO[] list,StateOfOrder state){
		return order.classify(list, state);
	}
	@Override
	public OrderPO[] browseUnperformed(){
		return normalorder.browseUnperformed();
	}
	@Override
	public OrderPO[] browseAbnormal(){
		return abnormalorder.browseAbnormal();
	}
	@Override
	public ResultMessage webCancelAbnormal(String orderid){
		abnormalorder.webCancelAbnormal(orderid);
		
		return ResultMessage.succeed;//catch exception
	}
	@Override
	public StateOfOrder getOrderStateOfUser(String userid, String hotelid) {
		// TODO Auto-generated method stub
		return null;
	}

}
