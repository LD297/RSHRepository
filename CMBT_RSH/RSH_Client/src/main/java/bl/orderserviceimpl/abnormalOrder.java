package bl.orderserviceimpl;

import bl.orderservice.HotelInfoService;
import bl.userserviceimpl.CreditRecordList;
import constant.ResultMessage;
import po.OrderPO;
import vo.RoomNormVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by john on 2016/11/27.
 */
public class AbnormalOrder {

    HotelInfoService hotelinfo;
    CreditRecordList record;
    OrderPO orderpo;

    public void setCreditRecordList(CreditRecordList re){
        record = re;
    }
    public void setOrder(OrderPO order){
        orderpo = order;
    }


    // 酒店手动补登记 改变订单状态 信用值
    public ResultMessage hotelCancelAbnormal(String orderid){
        //dataservice update
        //dataservice find
        //CreditRecordList
        return null;
    }

    // 网站营销人员查询异常订单
    public ArrayList<OrderPO> browseAbnormal(){
        //dataservice statefind
        return null;
    }

    //
    public void handleAbnormalRoom(){
        ArrayList<OrderPO> abList = this.browseAbnormal();
        for(int i=0;i<abList.size();i++){

            ArrayList<RoomNormVO> rooms = abList.get(i).getRooms();
            int size = rooms.size();
            int nums[] = new int[size];
            nums = abList.get(i).getRoomNums();
            Date checkIn = abList.get(i).getTime()[0];
            Date checkOut = abList.get(i).getTime()[1];

            for(int j=0;j<size;j++)//rooms.size
                hotelinfo.changeRoomAvail(rooms.get(j).roomType,nums[j] , checkIn, checkOut);
        }
    }

    // 网站营销人员撤销异常订单
    public ResultMessage webCancelAbnormal(String orderid){//cause:申诉->change credit

        //orderdataservice->findorderpo
/*		ArrayList<RoomNormVO> rooms =  orderpo.norm;
		int num[] = new int[rooms.size()];
		num = orderpo.numbers;
		Date checkIn = orderpo.checkIn;
		Date checkOut = orderpo.checkOut;

		for(int i=0;i<rooms.size();i++)
		    hotelinfo.changeRoomAvail(rooms.get(i).type, num[i],checkIn,checkOut);

		//userid,date,orderid,creditAction,change,credit
		Date date = new Date();
		CreditRecordVO creditRecord = new CreditRecordVO("", date, orderid,null, "", 0);
		record.addCreditRecord(creditRecord);*/
        return ResultMessage.succeed;
    }

}

