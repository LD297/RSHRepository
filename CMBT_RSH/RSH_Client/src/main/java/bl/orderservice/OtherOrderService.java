package bl.orderservice;

import constant.ResultMessage;
import constant.StateOfOrder;
import po.OrderPO;
import vo.OrderVO;

import java.util.ArrayList;

public interface OtherOrderService {

	/**
	 * 显示订单详情
	 * @param orderID
	 * @return
	 */
	public OrderVO detail(String orderID);

	/**
	 * 用户浏览酒店时
	 * 浏览在该酒店下的所有订单
	 * @param userID
	 * @param hotelID
	 * @return
	 */
	public ArrayList<OrderVO> specificOrder(String userID,String hotelID);

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

	/**
	 * 提供给酒店视角：
	 *     分类查看订单
	 *
	 * PS:查看全部订单时：
	 *     state设为null
	 * @param hotelID
	 * @param state
	 * @return
	 */
	public ArrayList<OrderVO> hotelClassify(String hotelID, StateOfOrder state);

	/**
	 * 提供给酒店的
	 * 返回该用户在酒店的最近订单的状态
	 * when return null->no order be reserved
	 * @param userID
	 * @param hotelID
	 * @return
	 */
	public StateOfOrder getOrderStateOfUser(String userID, String hotelID);

	/**
	 * 用户取消未执行订单时
	 * 返回被扣除的信用值
	 * @param orderID
	 * @return
	 */
	public int cancelMyOrder(String orderID);

	/**
	 * 酒店执行订单时
	 * @param orderID
	 * @return
	 */
	public ResultMessage execute(String orderID);

	/**
	 * 用户评价订单
	 * @param orderID
	 * @param grade
	 * @param comment
	 * @return
	 */
	public ResultMessage addComment(String orderID, double grade,String comment);

	// 酒店手动补登记 改变订单状态、actCheckIn 信用值在恢复时 置为已执行时均 增加信用值
	public ResultMessage hotelCancelAbnormal(String orderID);

	// 用户离开酒店记录
	public ResultMessage leaveUpdate(String orderID);

	// 网站营销人员查看未执行订单
	public ArrayList<OrderVO> browseUnperformed();

	// 网站营销人员撤销异常订单
	public ArrayList<OrderVO> browseAbnormal();

	// 网站营销人员撤销异常订单
	public ResultMessage webCancelAbnormal(String orderID,boolean isHalf);

}
