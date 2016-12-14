package bl.orderserviceimpl;

import bl.hotelservice.HotelInfoService;
import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.HotelController;
import bl.orderservice.OrderForUser;
import bl.promotionServiceimpl.Count;
import bl.userserviceimpl.CreditRecordList;
import bl.userserviceimpl.User;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import vo.OrderVO;
import vo.RoomNormVO;
import vo.UserVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/14.
 */
public class OrderForUserImpl implements OrderForUser{
    private OrderDao orderDao;
    public void setOrderDao(OrderDao orderDao){
        this.orderDao = orderDao;
    }
    private HotelInfoService hotelInfoService;
    public void setHotelInfoService(HotelController hotelController) {
        this.hotelInfoService = hotelController;
    }
    private HotelService hotelService;
    public void setHotelService(HotelController hotelController) {
        this.hotelService = hotelController;
    }

    /**
     * 用户分类查看订单
     * @param userID
     * @param state
     * @return 查看全部订单时：state设为null
     */
    public ArrayList<OrderVO> userClassify(String userID, StateOfOrder state){
        ArrayList<OrderVO> list = this.getOrderOfUser(userID);
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
     * 用户查看订单详情
     * @param orderID
     * @return
     */
    public OrderVO detail(String orderID){
        try{
            return orderDao.searchByID(orderID).transformPOToVO();
        }catch(RemoteException e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 用户取消未执行订单
     * @param orderID
     * @return 被扣除的信用值
     */
    public int cancelMyOrder(String orderID){
        OrderPO orderPO = null;
        try{
            orderPO = orderDao.searchByID(orderID);
        }catch (RemoteException e){
            return -1;
        }

        String hotelID = orderPO.getHotelID();
        RoomNormVO room =  orderPO.getRoom();
        int roomNum = orderPO.getRoomNumber();
        Date checkIn = orderPO.getCheckIn();
        Date checkOut = orderPO.getCheckOut();

        hotelInfoService = new HotelController();
        String time = hotelInfoService.getCheckInDDL(orderPO.getHotelID());

        hotelInfoService = new HotelController(orderPO.getHotelID());
        hotelService.minusRoomAvail(room.getRoomType(),roomNum,checkIn,checkOut);


        return 0;
    }
    /**
     * 用户查看酒店时，界面调用（显示自己在该酒店最近一笔订单的状态）
     * 返回该用户在酒店的最近订单的状态
     * @param userID
     * @param hotelID
     * @return 返回值为null：用户未在该酒店预定过
     */
    public StateOfOrder getOrderStateOfUser(String userID, String hotelID){
        try{
            ArrayList<OrderPO> orders = orderDao.searchByHotelWithUser(userID,hotelID);
            int size = orders.size();
            return orders.get(size-1).getState();
        }catch (RemoteException e){
            e.printStackTrace();
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
    public ArrayList<OrderVO> specificOrder(String userID,String hotelID){
        ArrayList<OrderPO> orders;
        try{
            orders = orderDao.searchByHotelWithUser(userID,hotelID);
        }catch(RemoteException e){
            e.printStackTrace();
            return null;
        }
        ArrayList<OrderVO> selectedList = new ArrayList<OrderVO>();
        for(int i=0;i<orders.size();i++){
            selectedList.add(orders.get(i).transformPOToVO());
        }
        return selectedList;
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
    public String getTrueValue(String userID, String hotelID, Date checkIn, Date checkOut, RoomNormVO room, int roomNum){
        User user = new User(userID);
        UserVO userVO = user.getInfo();
        double originValue = room.getPrice()*roomNum;
        return Count.countPromotionOfRoom(hotelID,room.getRoomType(),roomNum,(int)originValue,////////
                checkIn,checkOut,userVO.birthday,userVO.getMemberType(),userVO.getLevel());
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
    public ResultMessage confirmReservation(OrderVO orderVO){
        // 检查信用值

        CreditRecordList credit = new CreditRecordList(orderVO.getUserID());
        User user = new User(orderVO.getUserID());
        if(!user.canGenerateOrder())
            return ResultMessage.creditLack;

        // 检查房间信息
        hotelInfoService = new HotelController(orderVO.getHotelID());
        RoomNormVO room = orderVO.getRoom();
        int roomNum = orderVO.getRoomNumber();
        Date checkIn = orderVO.getCheckIn();
        Date checkOut = orderVO.getCheckOut();
        if(hotelInfoService.getRoomAvailNum(room.getRoomType(),checkIn,checkOut)<roomNum)
            return ResultMessage.roomNumLack;

        // 检查价格

        double price = Double.parseDouble(this.getTrueValue(orderVO.getUserID(),orderVO.getHotelID(),
                orderVO.getCheckIn(),orderVO.getCheckOut(),orderVO.getRoom(),orderVO.getRoomNumber()).split("#")[1]);
        if(orderVO.getTrueValue()<price)
            return ResultMessage.promotionLoss;

        this.add(orderVO);
        return ResultMessage.succeed;
    }
    /**
     * 用户评价订单
     * @param orderID
     * @param grade
     * @param comment
     * @return
     */
    public ResultMessage addComment(String orderID, int grade, String comment){
        hotelInfoService = new HotelController();
        try {
            if(orderDao.commentUpdate(orderID, grade, comment)==ResultMessage.succeed&&
                    hotelInfoService.updateGrade(grade)==ResultMessage.succeed)
                return ResultMessage.succeed;
        }catch(RemoteException e){
            e.printStackTrace();
            return ResultMessage.fail;
        }
        return ResultMessage.fail;
    }

    // 得到该用户的所有订单
    private ArrayList<OrderVO> getOrderOfUser(String userID){
        ArrayList<OrderPO> list;
        try{
            list = orderDao.searchByUser(userID);
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
    //根据界面信息 生成orderid完善orderpo
    private void add(OrderVO orderVO){
        OrderPO orderPO = null ;
        try{
            orderDao.insert(orderPO);
        }catch (RemoteException e){
            e.printStackTrace();
            return ;
        }
    }
}
