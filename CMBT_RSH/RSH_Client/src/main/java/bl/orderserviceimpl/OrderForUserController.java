package bl.orderserviceimpl;


import bl.orderservice.OrderForUser;
import bl.promotionServiceimpl.Count;
import bl.promotionServiceimpl.PromotionController;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import rmi.RemoteHelper;
import vo.OrderInfo;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by sky-PC on 2016/12/14.
 */
public class OrderForUserController implements OrderForUser{

    private static OrderDao orderDao = null;

    private static void initRemote(){
    	if(orderDao == null){
        	RemoteHelper remoteHelper = RemoteHelper.getInstance();
        	orderDao = remoteHelper.getOrderDao();
    	}
    }

    /**
     * 用户分类查看订单
     * @param userID
     * @param state
     * @return 查看全部订单时：state设为null
     */
    @Override
    public ArrayList<OrderVO> userClassify(String userID, StateOfOrder state){
        ArrayList<OrderVO> orderVOs = this.getOrderOfUser(userID);
        if(state==null)
            return orderVOs;
        else{
            for(int i=orderVOs.size()-1;i>=0;i--)
                if(orderVOs.get(i).getState()!=state)
                    orderVOs.remove(i);
        }
        return orderVOs;
    }
    /**
     * 用户查看订单详情
     * @param orderID
     * @return
     */
    @Override
    public OrderVO detail(String orderID){
    	initRemote();
        try{
            return orderDao.searchByID(orderID).changeIntoVO();
        }catch(RemoteException e){
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 场景：用户取消未执行订单
     * 判断：距离最晚执行时间>=6h
     * 后置：？用户信用值扣除
     *       酒店可用客房数量增加
     *       订单状态改变
     * @param orderID
     * @return 被扣除的信用值(>=0 ,-1表示出错)
     * 注：出错（remote；订单状态不是unexecuted）
     */
    @Override
    public int cancelMyOrder(String orderID){
    	Order order = Order.getInstance(orderID);
    	if(order== null){
    		return -1;
    	}
    	order.cancelUnexecuted();
        return 0;
    }
   
    /**
     * 用户查看酒店时，界面调用（显示自己在该酒店最近一笔订单的状态）
     * 返回该用户在酒店的最近订单的状态
     * @param userID
     * @param hotelID
     * @return 返回值为null：用户未在该酒店预定过
     */
    @Override
    public StateOfOrder getOrderStateOfUser(String userID, String hotelID){
    	initRemote();
    	ArrayList<OrderPO> orderPOs = new ArrayList<>();
        try{
            orderPOs = orderDao.searchByUserWithHotel(userID,hotelID);           
        }catch (RemoteException e){
            e.printStackTrace();
            return null;
        } 
        int size = orderPOs.size();
        if(size>0){
        	return orderPOs.get(size-1).getState();
        }
        else{
        	return null;
        }
    }
    /**
     * 用户浏览酒店时
     * 浏览在该酒店下的所有订单
     * @param userID
     * @param hotelID
     * @return
     */
    @Override
    public ArrayList<OrderVO> specificOrder(String userID,String hotelID){
        ArrayList<OrderPO> orderPOs = new ArrayList<>();
        ArrayList<OrderVO> orderVOs = new ArrayList<>();
        initRemote();
        try{
            orderPOs = orderDao.searchByUserWithHotel(userID,hotelID);
        }catch(RemoteException e){
            e.printStackTrace();
            return orderVOs;
        }
        for(OrderPO orderPO:orderPOs){
        	orderVOs.add(orderPO.changeIntoVO());
        }
        return orderVOs;
    }
    /**
     * 选择房间类型、房间数量完成后
     * 根据用户id、酒店id、checkIn、checkOut、房间类型、房间数量
     * 上述参数实时更新后 需要实时去计算
     * 得到优惠后的价格以及优惠策略
     * @param userID
     * @param hotelID
     * @param checkIn
     * @param checkOut
     * @param room
     * @param roomNum
     * @return 优惠策略形式：String#double->promotion#truePrice
     */
    @Override
    public String getTrueValue(OrderInfo orderInfo){
    	return Count.countPromotionOfRoom(orderInfo);
    }
    /**
     * 确认订单时：
     * 界面封装orderVO（userID,userName,hotelID,hotelName,RoomNormVO,roomPrice,
     * roomNum,originValue,trueValue,withChildren,peopleNumber,checkIn,checkOut）
     * 根据（用户信用值信息）判断是否可以提交
     * 不可提交 返回信息提示
     * 再次检查可用数量 会员信息 优惠政策是否存在
     * 出现出入 返回出入信息提示
     * 生成orderid
     * 没有出入 更新数据库 返回成功
     * @param orderVO
     * @return
     */
    @Override
    public ResultMessage confirmReservation(OrderVO orderVO){
        return Order.generateOrder(orderVO);
    }
    /**
     * 用户评价订单
     * 订单评分评论更新
     * 酒店评分更新
     * @param orderID
     * @param grade
     * @param comment
     * @return
     */
    @Override
    public ResultMessage addComment(String orderID, int grade, String comment){
    	Order order = Order.getInstance(orderID);
    	if(order == null){
    		return ResultMessage.idNotExist;
    	}
    	return order.addComment(grade, comment);
    }

    /**
     * 得到该用户的所有订单
     * 类内部调用
     * @param userID
     * @return
     */
    private ArrayList<OrderVO> getOrderOfUser(String userID){
        ArrayList<OrderPO> orderPOs = new ArrayList<>();
        ArrayList<OrderVO> orderVOs = new ArrayList<>();
        initRemote();
        try{
            orderPOs = orderDao.searchByUser(userID);
        }catch(RemoteException e){
            e.printStackTrace();
            return orderVOs;
        }
        
        for(OrderPO orderPO:orderPOs){
        	orderVOs.add(orderPO.changeIntoVO());
        }
        return orderVOs;
    }

    

    /**
     * 用户撤销订单时计算会减去的信用值
     */
	@Override
	public int getCreditReduced(OrderVO orderVO) {
		return Order.getCreditReduced(orderVO);
	}

}
