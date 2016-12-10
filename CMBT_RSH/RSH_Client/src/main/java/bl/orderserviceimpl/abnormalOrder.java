package bl.orderserviceimpl;

import bl.orderservice.HotelInfoService;
import bl.userserviceimpl.CreditRecordList;
import constant.CreditAction;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import vo.CreditRecordVO;
import vo.OrderVO;
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

    public void setCreditRecordList(CreditRecordList creditRecordList){this.creditRecordList = creditRecordList;
    }
    public void setOrder(OrderPO orderPO){
        this.orderPO = orderPO;
    }


    /**
     * 场景：酒店手动补登记 改变订单状态 信用值
     *      前提：在用户订单预计离开日期之前->用户交付订单实际价值
     *      后置：改变订单状态 ；
     *            恢复用户被扣除的信用值 ；
     * @param orderID
     * @return
     */
    public ResultMessage hotelCancelAbnormal(String orderID){
        // 改变订单状态:异常->已执行
        try{
            orderDao.stateUpdate(orderID,StateOfOrder.executed);
        }catch(RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }

        // 恢复用户被扣除的信用值
        String userID = null;
        double orderValue = 0;
        OrderPO orderPO;
        try{
            orderPO = orderDao.searchByID(orderID);
            if(orderPO!=null){
                userID = orderPO.getUserID();
                orderValue = orderPO.getTrueValue();

                CreditRecordVO creditRecordVO = new CreditRecordVO(userID,new Date(),orderID,
                        CreditAction.delay_checkin,"+"+String.valueOf(orderValue),0);//!!!!!!credit

                CreditRecordList creditRecordList = new CreditRecordList(userID);
                creditRecordList.addCreditRecord(creditRecordVO);
                return ResultMessage.succeed;}

        }catch(RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
return null;
    }

    // 网站营销人员查询异常订单
    public ArrayList<OrderVO> browseAbnormal(){
        ArrayList<OrderVO> selectedList = new ArrayList<OrderVO>();

        try{
            ArrayList<OrderPO> orders = orderDao.searchByState(StateOfOrder.abnormal);
            for(int i=0;i<orders.size();i++)
                selectedList.add(this.transformPOToVO(orders.get(i)));
            return selectedList;
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
        hotelInfoService.changeRoomAvail(orderPO.getRoom().getRoomType(),
                true,orderPO.getRoomNumber(),orderPO.getCheckIn(),orderPO.getCheckOut());

        // 增加用户信用值（全部/一半）
        double halfOrFull = 1/2;
        if(!IsHalf)
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
    // 完成从PO到VO的操作
    private OrderVO transformPOToVO(OrderPO orderPO){
        String orderID = orderPO.getOrderID();
        String userID = orderPO.getUserID();
        String userName = orderPO.getUserName();
        String hotelID = orderPO.getHotelID();
        String hotelName = orderPO.getHotelName();
        StateOfOrder state = orderPO.getState();
        RoomNormVO room = orderPO.getRoom();
        int roomNumber = orderPO.getRoomNumber();
        double roomPrice = orderPO.getRoomPrice();
        int peopleNumber = orderPO.getPeopleNumber();
        boolean withChild = orderPO.getWithChild();

        double originValue = orderPO.getOriginValue();
        double trueValue = orderPO.getTrueValue();
        String promotion =  orderPO.getPromotion();
        String comment = orderPO.getComment();
        int grade = orderPO.getGrade();

        Date checkIn = orderPO.getCheckIn();
        Date checkOut = orderPO.getCheckOut();
        Date hotelDDL = orderPO.getHotelDDL();
        Date generationDate = orderPO.getGenerationDate();
        Date actualCheckIn = orderPO.getActualCheckIn();
        Date actualCheckOut = orderPO.getActualCheckOut();
        Date cancelTime = orderPO.getCancelTime();
        Date cancelAbnormalTime = orderPO.getCancelAbnormalTime();

        OrderVO orderVO = new OrderVO(orderID, userID, userName, hotelID, hotelName, state,
                room, roomPrice, roomNumber, peopleNumber, withChild,
                originValue, trueValue, promotion,
                comment, grade, checkIn, checkOut, hotelDDL, generationDate,
                actualCheckIn, actualCheckOut, cancelTime, cancelAbnormalTime);
        return orderVO;
    }
}

