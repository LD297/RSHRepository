package bl.orderserviceimpl;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.controller.HotelController;
import bl.orderservice.OrderForWebsite;
import bl.userserviceimpl.CreditRecordList;
import constant.CreditAction;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import rmi.RemoteHelper;
import vo.CreditRecordVO;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/14.
 */
public class OrderForWebsiteImpl implements OrderForWebsite {
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
        ArrayList<OrderVO> selectedList = new ArrayList<OrderVO>();
        initRemote();
        try{
            ArrayList<OrderPO> orders = orderDao.searchByState(StateOfOrder.unexecuted);
            for(int i=0;i<orders.size();i++)
                selectedList.add(orders.get(i).changeIntoVO());
            return selectedList;
        }catch (RemoteException e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 网站营销人员查看异常订单
     * @return
     */
    @Override
    public ArrayList<OrderVO> browseAbnormal(){
        ArrayList<OrderVO> selectedList = new ArrayList<OrderVO>();

        initRemote();
        try{
            ArrayList<OrderPO> orders = orderDao.searchByState(StateOfOrder.abnormal);
            for(int i=0;i<orders.size();i++){
                selectedList.add(orders.get(i).changeIntoVO());
            }
            return selectedList;
        }catch (RemoteException e){
            e.printStackTrace();
            return null;
        }
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
    	order.cancelAbnormal(isHalf);
        return order.addAvailRoom();
    }
}
