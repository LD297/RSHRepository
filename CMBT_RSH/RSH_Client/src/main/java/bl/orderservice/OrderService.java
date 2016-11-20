package bl.orderservice;

import java.util.ArrayList;
import po.OrderPO;
import constant.ResultMessage;
import constant.StateOfOrder;

public interface OrderService {

	// 用户浏览订单
	public ArrayList<OrderPO> userBrowse(String userid);

	// 用户取消未执行订单
	public void cancelMyOrder(String orderid);

	// 订单详情
	public OrderPO detail(String orderid);

	// 酒店查看订单
	public ArrayList<OrderPO> hotelBrowse(String hotelid);

	// 酒店执行订单
	public ResultMessage execute(String orderid);

	// 用户评价订单
	public ResultMessage comment(String hotelid, String orderid, double grade,String comment);

	// 酒店手动补登记 改变订单状态 信用值
	public ResultMessage hotelCancelAbnormal(String orderid);

	// 用户浏览在该酒店下的所有订单
	public ArrayList<OrderPO> specificOrder(String userid,String hotelid);

	// 用户离开酒店记录
	public ResultMessage leaveUpdate(String orderid);

	// 查看所有订单时，可以分类查看
	// 提供给 用户userbrowse 酒店hotelbrowse
	public ArrayList<OrderPO> classify(ArrayList<OrderPO> list,StateOfOrder state);

	// 网站营销人员查看未执行订单
	public ArrayList<OrderPO> browseUnperformed();

	// 网站营销人员撤销异常订单
	public ArrayList<OrderPO> browseAbnormal();

	// 网站营销人员撤销异常订单
	public ResultMessage webCancelAbnormal(String orderid);

	// 提供给酒店
	// 用户在酒店下最新一笔订单的状态
	public StateOfOrder getOrderStateOfUser(String userid, String hotelid);
}
