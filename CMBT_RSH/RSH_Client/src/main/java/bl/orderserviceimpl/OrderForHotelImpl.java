package bl.orderserviceimpl;

import bl.orderservice.OrderForHotel;
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
public class OrderForHotelImpl implements OrderForHotel{
    private OrderDao orderDao;
    public void setOrderDao(OrderDao orderDao){
        this.orderDao = orderDao;
    }
    /**
     * 酒店分类查看订单
     * @param hotelID
     * @param state
     * @return
     */
    public ArrayList<OrderVO> hotelClassify(String hotelID, StateOfOrder state){
        ArrayList<OrderVO> list = this.getOrderOfHotel(hotelID);
        if(state==null)
            return list;
        else{
            for(int i=0;i<list.size();i++)
                if(list.get(i).getState()!=state)
                    list.remove(i);
        }
        return list;
    }
    /**
     * 酒店执行订单时调用
     * 根据订单id，在逻辑层记下该订单实际入住时间（日期＋时间）
     * 更新数据库中该订单信息（状态及实际入住时间）
     * 更新用户信用记录
     * @param orderID
     * @return
     */
    public ResultMessage execute(String orderID){
        Date actCheckIn = new Date();
        OrderPO orderPO ;
        try{
            orderPO = orderDao.searchByID(orderID);
            orderDao.stateUpdate(orderID,StateOfOrder.executed);
            orderDao.actCheckInUpdate(orderID,actCheckIn);
        }catch (RemoteException e){
            return ResultMessage.fail;
        }
        // 订单执行->增加信用值
        String userID = orderPO.getUserID();
        int change = (int)orderPO.getTrueValue();
        CreditRecordList creditRecordList = new CreditRecordList(userID);
        int credit = creditRecordList.getCredit();

        CreditRecordVO creditRecordVO = new CreditRecordVO(userID,actCheckIn,orderID,
                CreditAction.execute,"+"+String.valueOf(change),change+credit);
        creditRecordList.addCreditRecord(creditRecordVO);

        return ResultMessage.succeed;
    }

    /**
     * 用户离开酒店时调用
     * 根据订单id，在逻辑层记下该订单实际离开时间（日期＋时间）
     * 更新数据库中该订单信息（实际离开时间）
     * @param orderID
     * @return
     */
    public ResultMessage leaveUpdate(String orderID){
        Date actCheckOut = new Date();
        try{
            return orderDao.actCheckOutUpdate(orderID,actCheckOut);
        }catch(RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
    }

    /**
     * 场景：酒店撤销异常订单（手动补登记）
     *      前提：在用户订单预计离开日期之前->用户交付订单实际价值
     *      后置：更新订单实际入住时间（日期＋时间）
     *            改变订单状态 ；（abnormal->executed）
     *            恢复用户被扣除的信用值
     *            置为已执行->增加信用值
     * @param orderID
     * @return
     * 如果 在预计离开时间之后补登记 返回timeout
     *      抛异常 返回fail
     */
    public ResultMessage hotelCancelAbnormal(String orderID){
        OrderPO orderPO ;
        try{
            orderPO = orderDao.searchByID(orderID);
        }catch(RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }

        Date actCheckIn = new Date();
        Date checkOut = orderPO.getCheckOut();
        Date checkOutTime;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try{
            checkOutTime = df.parse(sdf.format(checkOut)+" 12:00:00");
        }catch(ParseException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }

        // 判断：补登记时间是否超过预计离开时间
        if(checkOutTime.getTime()-actCheckIn.getTime()<0)
            return ResultMessage.timeOut;

        // 改变订单状态:异常->已执行
        try{
            orderDao.stateUpdate(orderID,StateOfOrder.executed);
            orderDao.actCheckInUpdate(orderID,actCheckIn);
        }catch(RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }

        // 信用值二次更新
        String userID = orderPO.getUserID();
        double orderValue = orderPO.getTrueValue();

        CreditRecordList creditRecordList = new CreditRecordList(userID);
        int credit = creditRecordList.getCredit();
        CreditRecordVO creditRecordVO ;
        credit += (int)orderValue;
        // 恢复用户被扣除的信用值
        creditRecordVO = new CreditRecordVO(userID,actCheckIn,orderID,
                CreditAction.delay_checkin,"+"+String.valueOf(orderValue),credit);
        creditRecordList.addCreditRecord(creditRecordVO);
        credit += (int)orderValue;
        // 订单执行 信用值增加
        creditRecordVO = new CreditRecordVO(userID,actCheckIn,orderID,
                CreditAction.execute,"+"+String.valueOf(orderValue),credit);
        creditRecordList.addCreditRecord(creditRecordVO);

        return ResultMessage.succeed;
    }

    // 得到该酒店的所有订单
    private ArrayList<OrderVO> getOrderOfHotel(String hotelID){
        ArrayList<OrderPO> list;
        try{
            list = orderDao.searchByHotel(hotelID);
        }catch(RemoteException e){
            e.printStackTrace();
            return null;
        }
        ArrayList<OrderVO> listTrans = new ArrayList<OrderVO>();
        if(list!=null){
            for(int i=0;i<list.size();i++){
                listTrans.add(list.get(i).transformPOToVO());
            }
        }
        return listTrans;
    }
}
