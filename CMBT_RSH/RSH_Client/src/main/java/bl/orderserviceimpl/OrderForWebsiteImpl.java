package bl.orderserviceimpl;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.HotelController;
import bl.orderservice.OrderForWebsite;
import bl.userserviceimpl.CreditRecordList;
import constant.CreditAction;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import vo.CreditRecordVO;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/14.
 */
public class OrderForWebsiteImpl implements OrderForWebsite {
    private OrderDao orderDao;
    public void setOrderDao(OrderDao orderDao){
        this.orderDao = orderDao;
    }
    private HotelService hotelService;
    public void setHotelService(HotelController hotelController) {
        this.hotelService = hotelController;
    }
    /**
     * 网站营销人员浏览未执行订单
     * @return
     */
    public ArrayList<OrderVO> browseUnperformed(){
        ArrayList<OrderVO> selectedList = new ArrayList<OrderVO>();
        try{
            ArrayList<OrderPO> orders = orderDao.searchByState(StateOfOrder.unexecuted);
            for(int i=0;i<orders.size();i++)
                selectedList.add(orders.get(i).transformPOToVO());
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
    public ArrayList<OrderVO> browseAbnormal(){
        ArrayList<OrderVO> selectedList = new ArrayList<OrderVO>();

        try{
            ArrayList<OrderPO> orders = orderDao.searchByState(StateOfOrder.abnormal);
            for(int i=0;i<orders.size();i++){
                selectedList.add(orders.get(i).transformPOToVO());
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
     */
    public ResultMessage webCancelAbnormal(String orderID, boolean isHalf){
        OrderPO orderPO;
        try{
            orderPO = orderDao.searchByID(orderID);
        }catch(RemoteException e){
            e.printStackTrace();
            return null;
        }
        // 判断：用户仍在预计入住时期(checkOut12:00 前的24.5小时已经不允许)
        Date cancelDate = new Date();
        if(orderPO.getCheckOut().getTime()-cancelDate.getTime()<24.5*60)
            return ResultMessage.timeOut;

        // 改变酒店的房间信息
        hotelService.plusRoomAvail(orderPO.getRoom().getRoomType(),
                orderPO.getRoomNumber(),orderPO.getCheckIn(),orderPO.getCheckOut());

        // 增加用户信用值（全部/一半）
        double halfOrFull = 1/2;
        if(!isHalf)
            halfOrFull = 1;
        CreditRecordVO creditRecordVO = new CreditRecordVO(orderPO.getUserID(),new Date(),orderID,
                CreditAction.cancel_abnomal,"+"+String.valueOf(orderPO.getTrueValue()*halfOrFull),0);//!!!!credit
        CreditRecordList creditRecordList = new CreditRecordList(orderPO.getUserID());
        creditRecordList.addCreditRecord(creditRecordVO);

        // 记录撤销订单时间、改变订单状态
        try {
            orderDao.stateUpdate(orderID,StateOfOrder.canceled);
            orderDao.cancelTimeUpdate(orderID, cancelDate);
        }catch (RemoteException e){
            e.printStackTrace();
            return null;
        }
        return ResultMessage.succeed;
    }
}
