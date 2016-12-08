package bl.orderserviceimpl;

import bl.orderservice.OtherOrderService;
import constant.ResultMessage;
import constant.StateOfOrder;
import po.OrderPO;

import java.util.ArrayList;

public class OtherOrderController implements OtherOrderService {

	CheckOrder checkOrder;
	NormalOrder normalOrder;
	AbnormalOrder abnormalOrder;

	public void setCheckOrder(CheckOrder order) {
		this.checkOrder = order;
	}

	public void setNormalorder(NormalOrder normalorder) {
		this.normalOrder = normalorder;
	}

	public void setAbnormalorder(AbnormalOrder abnormalorder) {
		this.abnormalOrder = abnormalorder;
	}

	// 浏览用户的订单
	public ArrayList<OrderPO> userBrowse(String userid){
		return checkOrder.userBrowse(userid);
	}

	// 用户取消未执行订单
	public void cancelMyOrder(String orderid){
		normalOrder.cancelMyOrder(orderid);
		return ;
	}

	// 订单详情
	public OrderPO detail(String orderid){
		return checkOrder.detail(orderid);
	}

	// 根据酒店得到订单
	public ArrayList<OrderPO> hotelBrowse(String hotelid){
		return checkOrder.hotelBrowse(hotelid);
	}

	// 酒店执行订单
	public ResultMessage execute(String orderid){
		normalOrder.execute(orderid);
		return ResultMessage.succeed;
	}

	//评价订单
	public ResultMessage comment(String hotelid, String orderid, double grade,String comment){
		normalOrder.comment(hotelid,orderid,grade, comment);
		return ResultMessage.succeed;
	}

	// 酒店手动补登记 改变订单状态 信用值
	public ResultMessage hotelCancelAbnormal(String orderid){
		abnormalOrder.hotelCancelAbnormal(orderid);
		return ResultMessage.succeed;
	}

	// 用户浏览在该酒店下的所有订单
	public ArrayList<OrderPO> specificOrder(String userid,String hotelid){
		return checkOrder.specificOrder(userid, hotelid);
	}

	// 用户离开酒店记录
	public ResultMessage leaveUpdate(String orderid){
		normalOrder.leaveUpdate(orderid);
		return ResultMessage.succeed;
	}

	// 查看所有订单时，可以分类查看
	// 提供给 用户userbrowse 酒店hotelbrowse
	public ArrayList<OrderPO> classify(ArrayList<OrderPO> orders,StateOfOrder state){
		return checkOrder.classify(orders, state);
	}

	// 网站营销人员查看未执行订单
	public ArrayList<OrderPO> browseUnperformed(){
		return normalOrder.browseUnperformed();
	}

	// 网站营销人员撤销异常订单
	public ArrayList<OrderPO> browseAbnormal(){
		return abnormalOrder.browseAbnormal();
	}

	// 网站营销人员撤销异常订单
	public ResultMessage webCancelAbnormal(String orderid){
		abnormalOrder.webCancelAbnormal(orderid);
		return ResultMessage.succeed;
	}
	// 提供给酒店
	// 用户在酒店下最新一笔订单的状态
	public StateOfOrder getOrderStateOfUser(String userid, String hotelid) {
		return null;
	}

}
