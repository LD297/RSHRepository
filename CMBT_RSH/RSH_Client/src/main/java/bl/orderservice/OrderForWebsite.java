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
     * @param orderID
     * @param isHalf 选择恢复扣除信用值的一半或全部
     * @return
     */
    public ResultMessage webCancelAbnormal(String orderID, boolean isHalf);
}
