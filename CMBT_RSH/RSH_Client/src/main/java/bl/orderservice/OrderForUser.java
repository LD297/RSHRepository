package bl.orderservice;

import constant.ResultMessage;
import constant.StateOfOrder;
import vo.OrderVO;
import vo.RoomNormVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a297 on 16/12/12.
 */
public interface OrderForUser {

    /**
     * 用户分类查看订单
     * @param userID
     * @param state
     * @return 查看全部订单时：state设为null
     */
    public ArrayList<OrderVO> userClassify(String userID, StateOfOrder state);
    /**
     * 用户查看订单详情
     * @param orderID
     * @return
     */
    public OrderVO detail(String orderID);
    /**
     * 用户取消未执行订单
     * @param orderID
     * @return 被扣除的信用值
     */
    public int cancelMyOrder(String orderID);
    /**
     * 用户查看酒店时，界面调用（显示自己在该酒店最近一笔订单的状态）
     * 返回该用户在酒店的最近订单的状态
     * @param userID
     * @param hotelID
     * @return 返回值为null：用户未在该酒店预定过
     */
    public StateOfOrder getOrderStateOfUser(String userID, String hotelID);
    /**
     * 用户浏览酒店时
     * 浏览在该酒店下的所有订单
     * @param userID
     * @param hotelID
     * @return
     */
    public ArrayList<OrderVO> specificOrder(String userID,String hotelID);
    /**
     * 选择房间类型、房间数量完成后
     * 根据用户id、酒店id、checkIn、checkOut、房间类型、房间数量
     * 上述参数实时更新后 需要实时去计算
     * 得到优惠后的价格以及优惠策略
     * @param userID
     * @param hotelID
     * @param checkIn
     * @param checkOut
     * @param room
     * @param roomNum
     * @return 优惠策略形式：String#double->promotion#truePrice
     */
    public String getTrueValue(String userID, String hotelID, Date checkIn, Date checkOut, RoomNormVO room, int roomNum);
    /**
     * 确认订单时：
     * 界面封装orderVO（userID,userName,hotelID,hotelName,RoomNormVO,roomPrice,
     * roomNum,originValue,trueValue,promotion,withChildren,peopleNumber,checkIn,checkOut）
     * 根据（用户信用值信息）判断是否可以提交
     * 不可提交 返回信息提示
     * 再次检查可用数量 会员信息 优惠政策是否存在
     * 出现出入 返回出入信息提示
     * 生成orderid
     * 没有出入 更新数据库 返回成功
     * @param orderVO
     * @return
     */
    public ResultMessage confirmReservation(OrderVO orderVO);
    /**
     * 用户评价订单
     * @param orderID
     * @param grade
     * @param comment
     * @return
     */
    public ResultMessage addComment(String orderID, int grade, String comment);

}

