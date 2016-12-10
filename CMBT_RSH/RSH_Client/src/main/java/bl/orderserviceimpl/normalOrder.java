package bl.orderserviceimpl;

import bl.hotelserviceimpl.CommentImpl;
import bl.hotelserviceimpl.HotelController;
import bl.orderservice.CommentService;
import bl.orderservice.HotelInfoService;
import bl.userserviceimpl.CreditRecordList;
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
 * Created by sky-PC on 2016/11/27.
 */
public class NormalOrder {
    HotelInfoService hotelInfoService;
    OrderDao orderDao;

    CommentService commentService ;
    CreditRecordList creditRecordList;

    public void setHotelInfoService(HotelInfoService hotelInfoService) {
        this.hotelInfoService = hotelInfoService;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setCommentService(CommentImpl commentImpl){
        commentService = commentImpl;
    }

    public void setCreditRecordList(CreditRecordList creditRecordList){
        creditRecordList = creditRecordList;
    }

    // 用户撤销未执行订单
    public void cancelMyOrder(String orderID){
        OrderPO orderpo;
        try {
            orderpo = orderDao.searchByID(orderID);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ;
        }
        String hotelID = orderpo.getHotelID();
        RoomNormVO room =  orderpo.getRoom();
        int roomNum = orderpo.getRoomNumber();
        Date checkIn = orderpo.getCheckIn();
        Date checkOut = orderpo.getCheckOut();

        hotelInfoService = new HotelController(orderpo.getHotelID());
        String time = hotelInfoService.getCheckInDDL(orderpo.getHotelID());


        hotelInfoService.changeRoomAvail(room.getRoomType(), false,roomNum,checkIn,checkOut);

        int day = checkIn.getDay();
        int hour = Integer.valueOf(time.substring(0, 2));
        int minute = Integer.valueOf(time.substring(3));

        Date d = new Date();
        int trueday = d.getDay();
        int truehour = d.getHours();
        int trueminute = d.getMinutes();

        if((day-trueday)*24*60+(hour-truehour)*60+(minute-trueminute)<360){
            creditRecordList = new CreditRecordList(orderpo.getUserID());
            //userid,date,orderid,creditAction,change,credit
            CreditRecordVO creditRecord = new CreditRecordVO(orderpo.getUserID(), d, orderID, null,"",(int)orderpo.getTrueValue());
            creditRecordList.addCreditRecord(creditRecord);
        }
        System.out.println("success");
        return ;
    }

    // 酒店执行订单
    public ResultMessage execute(String orderID){
        //orderdataservice update
        //orderdataservice find ->orderpo
/*		Date d = new Date();
		CreditRecordVO creditRecord = new CreditRecordVO(orderpo.getUserid(), d, orderid, null,"",(int)orderpo.getTrueValue());
		record.addCreditRecord(creditRecord);*/
        return ResultMessage.succeed;
    }

    // 用户评价订单
    public ResultMessage comment(String hotelID, String orderID, double grade, String comment){
        commentService = new CommentImpl();
        ResultMessage a = commentService.addComment(hotelID, orderID, comment);
        ResultMessage b = commentService.updateGrade(grade);

        if(a.equals(b)&&a.equals(ResultMessage.succeed))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    // 实时更新异常订单状况
    public void setAbnormal(String orderID){
        OrderPO orderpo = null;
        try {
            orderpo = orderDao.searchByID(orderID);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        String time = hotelInfoService.getCheckInDDL(orderID.substring(10, 20));
        int hour = Integer.valueOf(time.substring(0, 2));
        int minute = Integer.valueOf(time.substring(3));

        Date d = new Date();
        int truehour = d.getHours();
        int trueminute = d.getMinutes();
        if(truehour>hour||(truehour==hour&&trueminute>minute)){
            System.out.println("failed");//orderdataservice->update
            creditRecordList = new CreditRecordList(orderpo.getUserID());
            //userid,date,orderid,creditAction,change,credit
            CreditRecordVO creditRecord = new CreditRecordVO("", d, orderID,null, "", 0);
            creditRecordList.addCreditRecord(creditRecord);
        }
        System.out.println("succeed");
        return ;
    }

    // 更新用户离开时间
    public ResultMessage leaveUpdate(String orderID){
        return null;
    }

    // 网站营销人员浏览未执行订单
    public ArrayList<OrderVO> browseUnexecuted(){
        ArrayList<OrderVO> selectedList = new ArrayList<OrderVO>();
        try{
            ArrayList<OrderPO> orders = orderDao.searchByState(StateOfOrder.unexecuted);
            for(int i=0;i<orders.size();i++)
                selectedList.add(this.transformPOToVO(orders.get(i)));
            return selectedList;
        }catch (RemoteException e){
            e.printStackTrace();
            return null;
        }
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
