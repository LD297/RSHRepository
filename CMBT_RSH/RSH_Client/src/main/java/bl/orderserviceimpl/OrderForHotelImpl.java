package bl.orderserviceimpl;

import bl.orderservice.OrderForHotel;
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
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/14.
 */
public class OrderForHotelImpl implements OrderForHotel{
    private OrderDao orderDao=null;
    
    private void initRemote(){
    	if(orderDao==null){
    		RemoteHelper remoteHelper = RemoteHelper.getInstance();
    		orderDao = remoteHelper.getOrderDao();
    	}
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
     * @param orderID 根据订单id，在逻辑层记下该订单实际入住时间（日期＋时间），并更新数据库中该订单信息（状态及实际入住）
     * @return
     */
    public ResultMessage execute(String orderID){
       
    }
    /**
     * 用户离开酒店时调用
     * 根据订单id，在逻辑层记下该订单实际离开时间（日期＋时间），并更新数据库中该订单信息（实际离开时间）
     */
    public ResultMessage leaveUpdate(String orderID){
        Date date = new Date();
        try{
            return orderDao.actCheckOutUpdate(orderID,date);
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
