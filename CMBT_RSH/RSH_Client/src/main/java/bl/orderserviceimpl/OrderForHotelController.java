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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/14.
 */
public class OrderForHotelController implements OrderForHotel{
    private static OrderDao orderDao = null;
    
    private static void initRemote(){
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
    @Override
    public ArrayList<OrderVO> hotelClassify(String hotelID, StateOfOrder state){
        ArrayList<OrderVO> list = this.getOrderOfHotel(hotelID);
        if(state==null)
            return list;
        else{
            for(int i=list.size();i>0;i--)
                if(list.get(i-1).getState()!=state)
                    list.remove(i-1);
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
    @Override
    public ResultMessage execute(String orderID){
    	Order order = Order.getInstance(orderID);
    	if(order==null){
    		return ResultMessage.idNotExist;
    	}
        return order.execute();
    }

    /**
     * 用户离开酒店时调用
     * 根据订单id，在逻辑层记下该订单实际离开时间（日期＋时间）
     * 更新数据库中该订单信息（实际离开时间）
     * @param orderID
     * @return
     */
    @Override
    public ResultMessage leaveUpdate(String orderID){
        Order order = Order.getInstance(orderID);
        return order.leaveUpdate();
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
    @Override
    public ResultMessage hotelCancelAbnormal(String orderID){
    	//此处需判断是否已超过预计离开时间
        Order order = Order.getInstance(orderID);

        ResultMessage resultMessage = order.cancelAbnormal(false);

        if(resultMessage == ResultMessage.succeed){
            return order.execute();
        }
        else{
            return resultMessage;
        }
    }

    /**
     * 得到该酒店的所有订单
     * 类内部调用
     * @param hotelID
     * @return
     */
    private ArrayList<OrderVO> getOrderOfHotel(String hotelID){
        ArrayList<OrderPO> orderPOs = new ArrayList<>();
        ArrayList<OrderVO> orderVOs = new ArrayList<>();
        initRemote();
        try{
            orderPOs = orderDao.searchByHotel(hotelID);
        }catch(RemoteException e){
            e.printStackTrace();
            return orderVOs;
        }
        for(OrderPO orderPO:orderPOs){
        	orderVOs.add(orderPO.changeIntoVO());
        }
        return orderVOs;
    }
}
