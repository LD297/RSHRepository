package bl.orderserviceimpl;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.CommentImpl;
import bl.hotelserviceimpl.HotelController;
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
    HotelService hotelService;
    OrderDao orderDao;

    CommentService commentService ;
    CreditRecordList creditRecordList;

    public void setHotelInfoService(HotelService hotelInfoService) {
        this.hotelService = hotelService;
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

        hotelService = new HotelController(orderpo.getHotelID());
        String time = hotelService.getCheckInDDL(orderpo.getHotelID());


        hotelService.minusRoomAvail(room.getRoomType(),roomNum,checkIn,checkOut);

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
    public ResultMessage addComment(String orderID, double grade, String comment){
        commentService = new CommentImpl();
        ResultMessage a = commentService.addComment(orderID.substring(0,10), orderID, comment);
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
        String time = hotelService.getCheckInDDL(orderID.substring(10, 20));
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
                selectedList.add(orders.get(i).transformPOToVO());
            return selectedList;
        }catch (RemoteException e){
            e.printStackTrace();
            return null;
        }
    }

}
