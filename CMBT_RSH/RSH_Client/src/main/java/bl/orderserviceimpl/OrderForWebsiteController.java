package bl.orderserviceimpl;

import bl.orderservice.OrderForWebsite;
import constant.ResultMessage;
import vo.OrderVO;

import java.util.ArrayList;

/**
 * Created by sky-PC on 2016/12/14.
 */
public class OrderForWebsiteController {
    OrderForWebsiteImpl orderForWebsite;

    public void setOrderForWebsite(OrderForWebsiteImpl orderForWebsite) {
        this.orderForWebsite = orderForWebsite;
    }

    /**
     * 网站营销人员浏览未执行订单
     * @return
     */
    public ArrayList<OrderVO> browseUnperformed(){
        return orderForWebsite.browseUnperformed();
    }
    /**
     * 网站营销人员查看异常订单
     * @return
     */
    public ArrayList<OrderVO> browseAbnormal(){
        return orderForWebsite.browseAbnormal();
    }
    /**
     * 网站营销人员撤销异常订单
     * @param orderID
     * @param isHalf 选择恢复扣除信用值的一半或全部
     * @return
     */
    public ResultMessage webCancelAbnormal(String orderID, boolean isHalf){
        return orderForWebsite.webCancelAbnormal(orderID, isHalf);
    }
}
