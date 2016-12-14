package bl.orderserviceimpl;

import bl.orderservice.OrderForHotel;
import constant.ResultMessage;
import constant.StateOfOrder;
import vo.OrderVO;

import java.util.ArrayList;

/**
 * Created by sky-PC on 2016/12/14.
 */
public class OrderForHotelController implements OrderForHotel{
    OrderForHotelImpl orderForHotel;

    public void setOrderForHotel(OrderForHotelImpl orderForHotel) {
        this.orderForHotel = orderForHotel;
    }

    /**
     * 酒店分类查看订单
     * @param hotelID
     * @param state
     * @return
     */
    public ArrayList<OrderVO> hotelClassify(String hotelID, StateOfOrder state){
        return orderForHotel.hotelClassify(hotelID, state);
    }
    /**
     * 酒店执行订单时调用
     * @param orderID 根据订单id，在逻辑层记下该订单实际入住时间（日期＋时间），并更新数据库中该订单信息（状态及实际入住）
     * @return
     */
    public ResultMessage execute(String orderID){
        return orderForHotel.execute(orderID);
    }
    /**
     * 用户离开酒店时调用
     * 根据订单id，在逻辑层记下该订单实际离开时间（日期＋时间），并更新数据库中该订单信息（实际离开时间）
     */
    public ResultMessage leaveUpdate(String orderID){
        return orderForHotel.leaveUpdate(orderID);
    }

    /**
     * 酒店撤销异常订单（手动补登记）时调用
     * @param orderID 根据订单id，在逻辑层记下该订单实际入住时间（日期＋时间），并更新数据库中该订单信息（状态及实际入住）
     *                信用值在恢复、置为已执行时， 均增加信用值
     */
    public ResultMessage hotelCancelAbnormal(String orderID){
        return orderForHotel.hotelCancelAbnormal(orderID);
    }
}
