package bl.orderserviceimpl;

import bl.hotelservice.HotelInfoService;
import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.HotelController;
import bl.hotelserviceimpl.HotelInfoController;
import bl.orderservice.OrderForHotel;
import bl.orderservice.OrderForUser;
import bl.promotionServiceimpl.Count;
import bl.userserviceimpl.CreditRecordList;
import bl.userserviceimpl.User;
import constant.CreditAction;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import rmi.RemoteHelper;
import vo.CreditRecordVO;
import vo.OrderInfo;
import vo.OrderVO;
import vo.RoomNormVO;
import vo.UserVO;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/14.
 */
public class OrderForUserController implements OrderForUser{

    private static OrderDao orderDao = null;
    private HotelInfoService hotelInfoService = new HotelInfoController();
    private HotelService hotelService = new HotelController();

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
        OrderPO orderPO;
        Date cancelTime = new Date();
        initRemote();
        try{
            orderPO = orderDao.searchByID(orderID);
        }catch (RemoteException e){
            return -1;
        }
        if(orderPO==null){
        	return -1;
        }
        // 检查订单状态
        if(orderPO.getState()!=StateOfOrder.unexecuted)
            return -1;

        // 得到订单信息
        String userID = orderPO.getUserID();
        String hotelID = orderPO.getHotelID()                  ;
        RoomNormVO room =  orderPO.getRoom();
        int roomNum = orderPO.getRoomNumber();
        double orderValue = orderPO.getTrueValue();
        Date checkIn = orderPO.getCheckIn();
        Date checkOut = orderPO.getCheckOut();

        // 酒店可用客房数量增加
        // 增加量=订单中预定的客房数量
        HotelService hotelService = new HotelController();
        hotelService.plusRoomAvail(hotelID,room.getRoomType(),roomNum,checkIn,checkOut);
        // 订单状态置为已撤销
        orderPO.setState(StateOfOrder.canceled);        
        initRemote();
        try{
            orderDao.update(orderPO);
        }catch (RemoteException e){
            return -1;
        }

        int deducted = 0;
        // 判断是否超时：成立->扣除信用值（订单价值一半）
        String deadline = hotelInfoService.getCheckInDDL(hotelID);
        if(OrderForUserController.isOvertime(checkOut,deadline,cancelTime)){
            CreditRecordList creditRecordList = new CreditRecordList(userID);
            int credit = creditRecordList.getCredit();
            credit += (int)orderValue/2;
            CreditRecordVO creditRecordVO = new CreditRecordVO(userID,cancelTime,orderID,
                    CreditAction.cancel,"-"+String.valueOf((int)orderValue/2),credit);
            creditRecordList.addCreditRecord(creditRecordVO);
            deducted = (int)orderValue/2;
        }

        return deducted;
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
        String userID = orderVO.getUserID();
        String hotelID= orderVO.getHotelID();
        
        // 检查信用值
        User user = User.getInstance(userID);
        if(user==null){
        	return ResultMessage.idNotExist;
        }
        if(!user.canGenerateOrder())
            return ResultMessage.creditLack;

        // 检查房间信息
        RoomNormVO room = orderVO.getRoom();
        int roomNum = orderVO.getRoomNumber();
        Date checkIn = orderVO.getCheckIn();
        Date checkOut = orderVO.getCheckOut();
        double roomPrice = orderVO.getRoomPrice();
        if(hotelService.numOfRoomAvail(hotelID, room.getRoomType(), checkIn, checkOut)< roomNum)
            return ResultMessage.roomNumLack;

        // 检查价格
        double price = Double.parseDouble(this.getTrueValue(new OrderInfo(hotelID, room.getRoomType(), roomNum, checkIn, checkOut, userID,roomPrice)).split("#")[1]);
        if(orderVO.getTrueValue()<price)
            return ResultMessage.promotionLoss;

        return this.add(orderVO);
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
        // 检查订单状态是否为已执行
    	OrderPO orderPO;
    	initRemote();
        try{
        	orderPO = orderDao.searchByID(orderID);
            if(orderPO.getState()!=StateOfOrder.executed)
                return ResultMessage.fail;
        }catch (RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        // 订单评分评论更新
        // 酒店评分更新
       orderPO.setComment(comment);
       initRemote();
        try {
            if(orderDao.update(orderPO)==ResultMessage.succeed
                    &&hotelInfoService.updateGrade(orderID.substring(0,10), grade)==ResultMessage.succeed)
                return ResultMessage.succeed;
        }catch(RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        return ResultMessage.fail;
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
     *  数据库新增可持久化对象
     *  类内部调用
     * @param orderVO
     * @return
     */
  
    private ResultMessage add(OrderVO orderVO){
    	initRemote();
        try{
            orderDao.insert(orderVO.changeIntoPO());
            return ResultMessage.succeed;
        }catch (RemoteException e){
            e.printStackTrace();
            return ResultMessage.remote_fail;
        }
    }


    /**
     * 计算时间差 单位：秒
     * 类内部调用
     * @param checkOut
     * @param deadline
     * @param cancelTime
     * @return
     */
    private static boolean isOvertime(Date checkOut,String deadline,Date cancelTime){
        long seconds;

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String checkOutDate = sdf.format(checkOut);
        initRemote();
        try{   //hh->12hour  HH->24hour
            Date checkOutTime = df.parse(checkOutDate+" "+deadline);
            long diff = checkOutTime.getTime() - cancelTime.getTime();
            seconds = diff/1000;
        }catch (Exception e){
            return false;
        }
        // 距离最晚执行时间大于等于6h
        if(seconds>=6*60*60)
            return false;
        else
            return true;
    }

	@Override
	public int getCreditReduced(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return 200;
	}

}
