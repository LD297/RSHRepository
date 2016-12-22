package bl.orderservice;

import constant.ResultMessage;
import constant.StateOfOrder;
import vo.OrderVO;

import java.util.ArrayList;

/**
 * Created by a297 on 16/12/12.
 */
public interface OrderForHotel {

    /**
     * 酒店分类查看订单
     * @param hotelID
     * @param state
     * @return
     */
    public ArrayList<OrderVO> hotelClassify(String hotelID, StateOfOrder state);
   
    /**
     * 酒店执行订单时调用
     * 根据订单id，在逻辑层记下该订单实际入住时间（日期＋时间）
     * 更新数据库中该订单信息（状态及实际入住时间）
     * 更新用户信用记录
     * @param orderID
     * @return
     */
    public ResultMessage execute(String orderID);
   
    /**
     * 用户离开酒店时调用
     * 根据订单id，在逻辑层记下该订单实际离开时间（日期＋时间）
     * 更新数据库中该订单信息（实际离开时间）
     * @param orderID
     * @return
     */
    public ResultMessage leaveUpdate(String orderID);

    /**
     * 场景：酒店撤销异常订单（手动补登记）
     *      前提：在用户订单预计离开日期之前->用户交付订单实际价值
     *      后置：更新订单实际入住时间（日期＋时间）
     *            改变订单状态 ；（abnormal->executed）
     *            恢复用户被扣除的信用值
     *            置为已执行->增加信用值
     * @param orderID
     * @return
     * 如果 在预计离开时间之后补登记 返回timeout
     *      抛异常 返回fail
     */
    public ResultMessage hotelCancelAbnormal(String orderID);
}
