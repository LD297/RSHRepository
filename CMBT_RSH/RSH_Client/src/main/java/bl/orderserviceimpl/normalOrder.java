package bl.orderserviceimpl;

import bl.hotelserviceimpl.CommentImpl;
import bl.hotelserviceimpl.HotelController;
import bl.orderservice.CommentService;
import bl.orderservice.HotelInfoService;
import bl.userserviceimpl.CreditRecordList;
import constant.ResultMessage;
import po.OrderPO;
import vo.CreditRecordVO;
import vo.RoomNormVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/11/27.
 */
public class NormalOrder {
    HotelInfoService hotelinfo;
    OrderPO orderpo ;
    public void setOrder(OrderPO ord){
        orderpo = ord;
    }//方便测试
    CommentService com ;
    CreditRecordList record;
    public void setCommentImpl(CommentImpl comm){
        com = comm;
    }
    public void setCreditRecordList(CreditRecordList recordList){
        record = recordList;
    }

    // 用户撤销未执行订单
    public void cancelMyOrder(String orderid){
        //orderdataservice->find->orderpo
        ArrayList<RoomNormVO> rooms =  orderpo.getRooms();
        int[] num = orderpo.getRoomNums();
        Date checkIn = orderpo.getTime()[0];
        Date checkOut = orderpo.getTime()[1];

        hotelinfo = new HotelController(orderpo.getHotelid());
        String time = hotelinfo.getCheckInDDL(orderpo.getHotelid());

        for(int i=0;i<rooms.size();i++)//增加客房
            hotelinfo.changeRoomAvail(rooms.get(i).roomType, num[i],checkIn,checkOut);

        int day = checkIn.getDay();
        int hour = Integer.valueOf(time.substring(0, 2));
        int minute = Integer.valueOf(time.substring(3));

        Date d = new Date();
        int trueday = d.getDay();
        int truehour = d.getHours();
        int trueminute = d.getMinutes();

        if((day-trueday)*24*60+(hour-truehour)*60+(minute-trueminute)<360){
            record = new CreditRecordList(orderpo.getUserid());
            //userid,date,orderid,creditAction,change,credit
            CreditRecordVO creditRecord = new CreditRecordVO(orderpo.getUserid(), d, orderid, null,"",(int)orderpo.getTrueValue());
            record.addCreditRecord(creditRecord);
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
        com = new CommentImpl();
        ResultMessage a = com.addComment(hotelid, orderid, comment);
        ResultMessage b = com.updateGrade(grade);

        if(a.equals(b)&&a.equals(ResultMessage.succeed))
            return ResultMessage.succeed;
        else
            return ResultMessage.fail;
    }

    // 实时更新异常订单状况
    public void setAbnormal(String orderid){
        String time = hotelinfo.getCheckInDDL(orderid.substring(10, 20));
        int hour = Integer.valueOf(time.substring(0, 2));
        int minute = Integer.valueOf(time.substring(3));

        Date d = new Date();
        int truehour = d.getHours();
        int trueminute = d.getMinutes();
        if(truehour>hour||(truehour==hour&&trueminute>minute)){
            System.out.println("failed");//orderdataservice->update
            record = new CreditRecordList(orderpo.getUserid());
            //userid,date,orderid,creditAction,change,credit
            CreditRecordVO creditRecord = new CreditRecordVO("", d, orderid,null, "", 0);
            record.addCreditRecord(creditRecord);
        }
        System.out.println("succeed");
        return ;
    }

    // 更新用户离开时间
    public ResultMessage leaveUpdate(String orderid){
        return null;
    }

    // 网站营销人员浏览未执行订单
    public ArrayList<OrderPO> browseUnperformed(){
        return null;
    }

}

