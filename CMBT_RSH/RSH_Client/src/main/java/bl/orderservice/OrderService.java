package bl.orderservice;

import java.util.ArrayList;
import java.util.Date;

import po.OrderPO;
import vo.RoomNormVO;
import bl.hotelserviceimpl.CommentImpl;
import bl.orderserviceimpl.abnormalOrder;
import constant.ResultMessage;
import constant.StateOfOrder;

public interface OrderService {
	
	//得到某酒店的客房规模
	public ArrayList<RoomNormVO> getHotelRoom(String hotelid);
	
	//根据日期得到可用客房数量
	public int[] getRoomInfo(String hotelid,Date checkIn,Date checkOut);
	
	
	public OrderPO getOrder(String hotelid,String userid,Date checkIn,Date checkOut,int roomNum[]);
	
	//根据界面信息 生成orderid 完善orderpo
	public void add(OrderPO order);
	
	//得到优惠后价格
	public double getDiscounted(OrderPO order);
	
	//根据用户浏览订单
	public OrderPO[] userbrowse(String userid);
	 
	//用户取消未执行订单
	public void cancelMyOrder(String orderid);

	//订单详情
	public OrderPO detail(String orderid);
	
	//根据酒店得到订单
	public OrderPO[] hotelBrowse(String hotelid);
	 
	//执行订单
	public ResultMessage execute(String orderid);
	
	//评价订单
	public ResultMessage comment(String hotelid, String orderid, double grade,String comment);
	
	//酒店取消异常订单 手动补登记
	public ResultMessage hotelCancelAbnormal(String orderid);

	public OrderPO[] specificOrder(String userid,String hotelid);
	
	public ResultMessage leaveUpdate(String orderid);
	
	public OrderPO[] classify(OrderPO[] list,StateOfOrder state);
	
	public OrderPO[] browseUnperformed();
	
	public OrderPO[] browseAbnormal();
	
	public ResultMessage webCancelAbnormal(String orderid);
	//提供给酒店
	public StateOfOrder getOrderStateOfUser(String userid, String hotelid);
}
