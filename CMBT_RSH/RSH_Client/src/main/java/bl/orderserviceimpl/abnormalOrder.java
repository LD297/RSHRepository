package bl.orderserviceimpl;

import bl.orderservice.HotelInfoService;
import bl.userserviceimpl.CreditRecordList;
import constant.CreditAction;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import vo.CreditRecordVO;
import vo.RoomNormVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by john on 2016/11/27.
 */
public class AbnormalOrder {

    HotelInfoService hotelInfoService;
    private OrderDao orderDao;

    CreditRecordList creditRecordList;
    OrderPO orderPO;


    public void setHotelInfoService(HotelInfoService hotelInfoService) {
        this.hotelInfoService = hotelInfoService;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setCreditRecordList(CreditRecordList re){creditRecordList = re;
    }
    public void setOrder(OrderPO order){
        orderPO = order;
    }


    // 场景：酒店手动补登记 改变订单状态 信用值
    //      前提：在用户订单预计离开日期之前->用户交付订单实际价值
    //      后置：改变订单状态 ；
    //            增加用户信用值；
    public ResultMessage hotelCancelAbnormal(String orderID){
        // 改变订单状态 异常->已执行
        try{
            orderDao.stateUpdate(orderID,StateOfOrder.executed);
        }catch(RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        String userID;
        double orderValue;
        try{
            userID = orderDao.findByID(orderID).getUserid();
            orderValue = orderDao.findByID(orderID).getTrueValue();
        }catch(RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        // 改变用户信用记录
        CreditRecordVO creditRecordVO = new CreditRecordVO(userID,new Date(),orderID,
                CreditAction.delay_checkin,"+"+String.valueOf(orderValue),0);//!!!!!!credit

        CreditRecordList creditRecordList = new CreditRecordList(userID);
        creditRecordList.addCreditRecord(creditRecordVO);
        return ResultMessage.succeed;
    }

    // 网站营销人员查询异常订单
    public ArrayList<OrderPO> browseAbnormal(){
        try{
            return orderDao.findByState(StateOfOrder.abnormal);
        }catch (RemoteException e){
            e.printStackTrace();
            return null;
        }
    }



    // 网站营销人员撤销异常订单
    // 场景：前提：用户仍在预计入住时期
    //       动作：用户取消入住计划
    //       后置：改变酒店的房间信息；
    //             增加用户信用值（全部/一半）；
    //             记录撤销订单时间、改变订单状态
    public ResultMessage webCancelAbnormal(String orderID,Boolean IsHalf){//cause:申诉->change credit
        OrderPO orderPO;
        try{
            orderPO = orderDao.findByID(orderID);
        }catch(RemoteException e){
            e.printStackTrace();
            return null;
        }
        // 判断：用户仍在预计入住时期(checkOut12:00 前的24.5小时已经不允许)
        Date cancelDate = new Date();
        if(orderPO.getTime()[1].getTime()-cancelDate.getTime()<24.5*60)
            return ResultMessage.timeOut;

        // 改变酒店的房间信息
        hotelInfoService.changeRoomAvail(orderPO.getRoom().roomType,
                true,orderPO.getRoomNumber(),orderPO.getTime()[0],orderPO.getTime()[1]);

        // 增加用户信用值（全部/一半）
        double halfOrFull = 1/2;
        if(!IsHalf)
            halfOrFull = 1;
		CreditRecordVO creditRecordVO = new CreditRecordVO(orderPO.getUserid(),new Date(),orderID,
                CreditAction.cancel_abnomal,"+"+String.valueOf(orderPO.getTrueValue()*halfOrFull),0);//!!!!credit
		CreditRecordList creditRecordList = new CreditRecordList(orderPO.getUserid());
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

