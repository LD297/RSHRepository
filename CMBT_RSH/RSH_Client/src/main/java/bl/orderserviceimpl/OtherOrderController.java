package bl.orderserviceimpl;

import constant.ResultMessage;
import constant.StateOfOrder;
import vo.OrderVO;

import java.util.ArrayList;

public class OtherOrderController {

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
	public ArrayList<OrderVO> userClassify(String userID, StateOfOrder state){
		return checkOrder.userClassify(userID,state);
	}

	// 用户取消未执行订单
	public void cancelMyOrder(String orderid){
		normalOrder.cancelMyOrder(orderid);
		return ;
	}

	// 订单详情
	public OrderVO detail(String orderID){
		return checkOrder.detail(orderID);
	}

	// 根据酒店得到订单
	public ArrayList<OrderVO> hotelClassify(String hotelID, StateOfOrder state){
		return checkOrder.hotelClassify(hotelID, state);
	}

	// 酒店执行订单
	public ResultMessage execute(String orderID){
		normalOrder.execute(orderID);
		return ResultMessage.succeed;
	}

	//评价订单
	public ResultMessage comment(String hotelID, String orderID, double grade,String comment){
		normalOrder.comment(hotelID, orderID, grade, comment);
		return ResultMessage.succeed;
	}

	// 酒店手动补登记 改变订单状态 信用值
	public ResultMessage hotelCancelAbnormal(String orderID){
		abnormalOrder.hotelCancelAbnormal(orderID);
		return ResultMessage.succeed;
	}

	// 用户浏览在该酒店下的所有订单
	public ArrayList<OrderVO> specificOrder(String userID,String hotelID){
		return checkOrder.specificOrder(userID, hotelID);
	}

	// 用户离开酒店记录
	public ResultMessage leaveUpdate(String orderID){
		normalOrder.leaveUpdate(orderID);
		return ResultMessage.succeed;
	}


	// 网站营销人员查看未执行订单
	public ArrayList<OrderVO> browseUnperformed(){
		return normalOrder.browseUnexecuted();
	}

	// 网站营销人员撤销异常订单
	public ArrayList<OrderVO> browseAbnormal(){
		return abnormalOrder.browseAbnormal();
	}

	// 网站营销人员撤销异常订单
	public ResultMessage webCancelAbnormal(String orderID,boolean isHalf){
		abnormalOrder.webCancelAbnormal(orderID,isHalf);
		return ResultMessage.succeed;
	}
	// 提供给酒店
	// 用户在酒店下最新一笔订单的状态
	public StateOfOrder getOrderStateOfUser(String userID, String hotelID) {
		return null;
	}

}
