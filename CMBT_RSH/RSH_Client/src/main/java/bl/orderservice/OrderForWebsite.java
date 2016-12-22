package bl.orderservice;

import constant.ResultMessage;
import vo.OrderVO;

import java.util.ArrayList;

/**
 * Created by a297 on 16/12/12.
 */
public interface OrderForWebsite {

    /**
     * 网站营销人员浏览未执行订单
     * @return
     */
    public ArrayList<OrderVO> browseUnperformed();
  
    /**
     * 网站营销人员查看异常订单
     * @return
     */
    public ArrayList<OrderVO> browseAbnormal();
   
    /**
     * 网站营销人员撤销异常订单
     * 场景：前提：用户仍在预计入住时期
     *       动作：用户取消入住计划
     *       后置：改变酒店的房间信息；
     *             增加用户信用值（全部/一半）；
     *             记录撤销订单时间、改变订单状态
     * @param orderID
     * @param isHalf
     * @return
     * 如果 订单状态不是异常 返回nochangemade
     *      撤销异常 checkOut12:00 的24.5小时之内不予撤销 返回timeout
     *      抛异常 返回fail
     */
    public ResultMessage webCancelAbnormal(String orderID, boolean isHalf);
}
