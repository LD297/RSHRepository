package bl.orderserviceimpl;


import bl.orderservice.OrderForWebsite;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import rmi.RemoteHelper;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by sky-PC on 2016/12/14.
 */
public class OrderForWebsiteController implements OrderForWebsite {
    private static OrderDao orderDao = null;
    private void initRemote(){
    	if(orderDao == null){
    		RemoteHelper remoteHelper = RemoteHelper.getInstance();
    		orderDao = remoteHelper.getOrderDao();
    	}
    }
   
    /**
     * 网站营销人员浏览未执行订单
     * @return
     */
    @Override
    public ArrayList<OrderVO> browseUnperformed(){
        ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
        ArrayList<OrderPO> orderPOs = new ArrayList<>();
        initRemote();
        try{
            orderPOs = orderDao.searchByState(StateOfOrder.unexecuted);
        }catch (RemoteException e){
            e.printStackTrace();
            return orderVOs;
        }
       for(OrderPO orderPO:orderPOs){
    	   orderVOs.add(orderPO.changeIntoVO());
       }
        return orderVOs;
    }
    
    /**
     * 网站营销人员查看异常订单
     * @return
     */
    @Override
    public ArrayList<OrderVO> browseAbnormal(){
        ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
        ArrayList<OrderPO> orderPOs = new ArrayList<>();
        initRemote();
        try{
            orderPOs = orderDao.searchByState(StateOfOrder.abnormal);
        }catch (RemoteException e){
            e.printStackTrace();
            return orderVOs;
        }
        for(OrderPO orderPO:orderPOs){
        	orderVOs.add(orderPO.changeIntoVO());
        }
        return orderVOs;
    }
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
    @Override
    public ResultMessage webCancelAbnormal(String orderID, boolean isHalf){
    	Order order = Order.getInstance(orderID);
    	if(order==null){
    		return ResultMessage.idNotExist;
    	}
    	return order.webCancelAbnormal(isHalf);
    }
}
