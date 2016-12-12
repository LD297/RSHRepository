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
     * @param orderID 根据订单id，在逻辑层记下该订单实际入住时间（日期＋时间），并更新数据库中该订单信息（状态及实际入住）
     * @return
     */
    public ResultMessage execute(String orderID);
    /**
     * 用户离开酒店时调用
     * 根据订单id，在逻辑层记下该订单实际离开时间（日期＋时间），并更新数据库中该订单信息（实际离开时间）
     */
    public ResultMessage leaveUpdate(String orderID);

    /**
     * 酒店撤销异常订单（手动补登记）时调用
     * @param orderID 根据订单id，在逻辑层记下该订单实际入住时间（日期＋时间），并更新数据库中该订单信息（状态及实际入住）
     *                信用值在恢复、置为已执行时， 均增加信用值
     */
    public ResultMessage hotelCancelAbnormal(String orderID);
}
