package bl.orderservice;

import constant.ResultMessage;
import constant.StateOfOrder;
import po.OrderPO;
import vo.OrderVO;

import java.util.ArrayList;

public interface OtherOrderService {

	/**
	 * 提供给用户：
	 *     分类查看订单
	 *
	 * PS:查看全部订单时：
	 *     state设为null
	 * @param userID
	 * @param state
	 * @return
	 */
	public ArrayList<OrderVO> userClassify(String userID, StateOfOrder state);

	// 用户取消未执行订单
	public void cancelMyOrder(String orderID);

	// 订单详情
	public OrderVO detail(String orderID);


	public ArrayList<OrderVO> hotelClassify(String hotelID, StateOfOrder state);

	// 酒店执行订单
	public ResultMessage execute(String orderid);

	// 用户评价订单
	public ResultMessage comment(String hotelid, String orderid, double grade,String comment);

	// 酒店手动补登记 改变订单状态 信用值
	public ResultMessage hotelCancelAbnormal(String orderid);

	// 用户浏览在该酒店下的所有订单
	public ArrayList<OrderVO> specificOrder(String userid,String hotelid);

	// 用户离开酒店记录
	public ResultMessage leaveUpdate(String orderid);

	// 网站营销人员查看未执行订单
	public ArrayList<OrderVO> browseUnperformed();

	// 网站营销人员撤销异常订单
	public ArrayList<OrderVO> browseAbnormal();

	// 网站营销人员撤销异常订单
	public ResultMessage webCancelAbnormal(String orderID,boolean isHalf);

	// 提供给酒店
	// 用户在该酒店最近一笔订单的状态
	public StateOfOrder getOrderStateOfUser(String userid, String hotelid);
}
