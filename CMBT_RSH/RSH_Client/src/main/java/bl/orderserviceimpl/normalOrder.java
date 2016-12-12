package bl.orderserviceimpl;

import bl.hotelservice.HotelInfoService;
import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.HotelController;
import bl.userserviceimpl.CreditRecordList;
import constant.CreditAction;
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
    OrderDao orderDao;

    HotelInfoService hotelInfoService ;
    HotelService hotelService;
    CreditRecordList creditRecordList;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setHotelInfoService(HotelController hotelController){
        this.hotelInfoService = hotelController;
    }

    public void setCreditRecordList(CreditRecordList creditRecordList){
        creditRecordList = creditRecordList;
    }

    // 用户撤销未执行订单
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

    // 酒店执行订单
    public ResultMessage execute(String orderID){
        Date actCheckIn = new Date();
        OrderPO orderPO = null;
        try{
            orderPO = orderDao.searchByID(orderID);
            orderDao.actCheckInUpdate(orderID,actCheckIn);
        }catch (RemoteException e){
            return ResultMessage.fail;
        }

        String userID = orderPO.getUserID();
        int change = (int)orderPO.getTrueValue();
        CreditRecordList creditRecordList = new CreditRecordList(userID);
        int credit = creditRecordList.getCredit();

		CreditRecordVO creditRecordVO = new CreditRecordVO(userID,actCheckIn,orderID,
                CreditAction.execute,"+"+change,change+credit);
		creditRecordList.addCreditRecord(creditRecordVO);

        return ResultMessage.succeed;
    }

    // 用户评价订单
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
                selectedList.add(orders.get(i).transformPOToVO());
            return selectedList;
        }catch (RemoteException e){
            e.printStackTrace();
            return null;
        }
    }

}
