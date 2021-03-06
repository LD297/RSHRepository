package bl.orderservice;

import constant.ResultMessage;
import constant.StateOfOrder;
import vo.OrderInfo;
import vo.OrderVO;
import vo.RoomNormVO;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by a297 on 16/12/12.
 */
public interface OrderForUser {
	/**
	 * 计算被扣除的信用值
	 * @return
	 */
	public int getCreditReduced(OrderVO orderVO);

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
     * 场景：用户取消未执行订单
     * 判断：距离最晚执行时间>=6h
     * 后置：？用户信用值扣除
     *       酒店可用客房数量增加
     *       订单状态改变
     * @param orderID
     * @return 被扣除的信用值(>=0 ,-1表示出错)
     * 注：出错（remote；订单状态不是unexecuted）
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
     * 生成订单界面得到最优方案
     * 方法传递的参数改为OrderInfo
     * @param orderVO
     * @return String#double ->promotionReason#truePrice
     */
    public String getTrueValue(OrderInfo orderInfo);
    
    
    /**
     * 确认订单时：
     * 界面封装orderVO（userID,userName,hotelID,hotelName,RoomNormVO,roomPrice,
     * roomNum,originValue,trueValue,withChildren,peopleNumber,checkIn,checkOut）
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
     * 订单评分评论更新
     * 酒店评分更新
     * @param orderID
     * @param grade
     * @param comment
     * @return
     */
    public ResultMessage addComment(String orderID, int grade, String comment);

}

