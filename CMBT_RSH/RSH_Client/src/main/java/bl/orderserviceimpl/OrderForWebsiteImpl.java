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
     * 如果 订单状态不是异常 返回nochangemade
     *      撤销异常 checkOut12:00 的24.5小时之内不予撤销 返回timeout
     *      抛异常 返回fail
     */
    public ResultMessage webCancelAbnormal(String orderID, boolean isHalf){
        OrderPO orderPO;
        try{
            orderPO = orderDao.searchByID(orderID);
        }catch(RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }

        // 检查：订单状态是否为异常
        if(orderPO.getState()!=StateOfOrder.abnormal)
            return ResultMessage.noChangeMade;

        Date cancelABTime = new Date();
        String userID = orderPO.getUserID();
        Date checkIn = orderPO.getCheckIn();
        Date checkOut = orderPO.getCheckOut();
        double orderValue = orderPO.getTrueValue();

        // 检查：用户仍在预计入住时期
        // checkOut12:00 前的24.5小时已经不允许
        Date checkOutTime = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String str=sdf.format(checkOut);
        try{
            checkOutTime = df.parse(str+" 12:00:00");
        }catch (ParseException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        if(checkOutTime.getTime()-cancelABTime.getTime()<24.5*60*60*1000)
            return ResultMessage.timeOut;

        // 改变酒店的房间信息
        hotelService.plusRoomAvail(orderPO.getRoom().getRoomType(),
                orderPO.getRoomNumber(),checkIn,checkOut);

        // 增加用户信用值（全部/一半）
        double halfOrFull = 1/2;
        if(!isHalf)
            halfOrFull = 1;
        CreditRecordList creditRecordList = new CreditRecordList(userID);
        int credit = creditRecordList.getCredit();
        credit += (int)orderValue*halfOrFull;
        CreditRecordVO creditRecordVO = new CreditRecordVO(userID,cancelABTime,orderID,
                CreditAction.cancel_abnomal,"+"+String.valueOf((int)orderValue*halfOrFull),credit);//!!!!credit
        creditRecordList.addCreditRecord(creditRecordVO);

        // 改变订单状态、记录撤销订单时间
        try {
            orderDao.stateUpdate(orderID,StateOfOrder.canceled);
            orderDao.cancelTimeUpdate(orderID, cancelABTime);
        }catch (RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        return ResultMessage.succeed;
    }
}
