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
    public void cancelMyOrder(String orderid){
        OrderPO orderpo;
        try {
            orderpo = orderDao.findByID(orderid);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ;
        }
        String hotelID = orderpo.getHotelid();
        RoomNormVO room =  orderpo.getRoom();
        int roomNum = orderpo.getRoomNumber();
        Date checkIn = orderpo.getTime()[0];
        Date checkOut = orderpo.getTime()[1];

        hotelInfoService = new HotelController(orderpo.getHotelid());
        String time = hotelInfoService.getCheckInDDL(orderpo.getHotelid());


        hotelInfoService.changeRoomAvail(room.roomType, false,roomNum,checkIn,checkOut);

        int day = checkIn.getDay();
        int hour = Integer.valueOf(time.substring(0, 2));
        int minute = Integer.valueOf(time.substring(3));

        Date d = new Date();
        int trueday = d.getDay();
        int truehour = d.getHours();
        int trueminute = d.getMinutes();

        if((day-trueday)*24*60+(hour-truehour)*60+(minute-trueminute)<360){
            creditRecordList = new CreditRecordList(orderpo.getUserid());
            //userid,date,orderid,creditAction,change,credit
            CreditRecordVO creditRecord = new CreditRecordVO(orderpo.getUserid(), d, orderid, null,"",(int)orderpo.getTrueValue());
            creditRecordList.addCreditRecord(creditRecord);
        }
        System.out.println("success");
        return ;
    }

    // 酒店执行订单
    public ResultMessage execute(String orderid){
        //orderdataservice update
        //orderdataservice find ->orderpo
/*		Date d = new Date();
		CreditRecordVO creditRecord = new CreditRecordVO(orderpo.getUserid(), d, orderid, null,"",(int)orderpo.getTrueValue());
		record.addCreditRecord(creditRecord);*/
        return ResultMessage.succeed;
    }

    // 用户评价订单
    public ResultMessage comment(String hotelid, String orderid, double grade, String comment){
        commentService = new CommentImpl();
        ResultMessage a = commentService.addComment(hotelid, orderid, comment);
        ResultMessage b = commentService.updateGrade(grade);

        if(a.equals(b)&&a.equals(ResultMessage.succeed))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    // 实时更新异常订单状况
    public void setAbnormal(String orderid){
        OrderPO orderpo = null;
        try {
            orderpo = orderDao.findByID(orderid);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        String time = hotelInfoService.getCheckInDDL(orderid.substring(10, 20));
        int hour = Integer.valueOf(time.substring(0, 2));
        int minute = Integer.valueOf(time.substring(3));

        Date d = new Date();
        int truehour = d.getHours();
        int trueminute = d.getMinutes();
        if(truehour>hour||(truehour==hour&&trueminute>minute)){
            System.out.println("failed");//orderdataservice->update
            creditRecordList = new CreditRecordList(orderpo.getUserid());
            //userid,date,orderid,creditAction,change,credit
            CreditRecordVO creditRecord = new CreditRecordVO("", d, orderid,null, "", 0);
            creditRecordList.addCreditRecord(creditRecord);
        }
        System.out.println("succeed");
        return ;
    }

    // 更新用户离开时间
    public ResultMessage leaveUpdate(String orderid){
        return null;
    }

    // 网站营销人员浏览未执行订单
    public ArrayList<OrderPO> browseUnexecuted(){
        try{
            return orderDao.findByState(StateOfOrder.unexecuted);
        }catch (RemoteException e){
            e.printStackTrace();
            return null;
        }
    }
}
