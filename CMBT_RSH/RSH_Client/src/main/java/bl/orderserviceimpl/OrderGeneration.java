package bl.orderserviceimpl;

/**
 * Created by sky-PC on 2016/12/4.
 */

import bl.hotelserviceimpl.HotelController;
import bl.orderservice.HotelInfoService;
import bl.promotionServiceimpl.Count;
import bl.userserviceimpl.CreditRecordList;
import constant.ResultMessage;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import vo.RoomNormVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class OrderGeneration {

    private HotelInfoService hotelInfoService;
    private Count count;
    private OrderDao orderDao;

    public void setHotelInfoService(HotelInfoService hotelInfoService) {
        this.hotelInfoService = hotelInfoService;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    //根据酒店得到房间规模（酒店编号、房间类型、原始价格）
    public ArrayList<RoomNormVO> getHotelRoom(String hotelID){
        hotelInfoService = new HotelController(hotelID);
        ArrayList<RoomNormVO> rooms = hotelInfoService.getRoomNorms();
        return rooms;
    }

    //根据时间得到所有房间类型可用客房数量
    public int[] getRoomInfo(String hotelID, Date checkIn, Date checkOut){
        ArrayList<RoomNormVO> rooms = this.getHotelRoom(hotelID);
        int availNum[] = new int[rooms.size()];

        hotelInfoService = new HotelController(hotelID);
        for(int i=0;i<rooms.size();i++){
            availNum[i] = hotelInfoService.numOfRoomAvail(rooms.get(i).getRoomType(), checkIn, checkOut);
        }
        return availNum;
    }

    // 根据界面得到orderpo
    // 是提供给计算价格的方法
    // order,user,hotel,ArrayList<RoomNormVO> type,nums,origin,discounted,pro,com, gra,in,out
    public OrderPO getOrder(String userID, String hotelID, Date checkIn, Date checkOut,
                            RoomNormVO room, int roomNum){
        double originRoomPrice = room.getPrice();
        double originOrderValue = originRoomPrice*roomNum;

        return new OrderPO(userID,hotelID,room,roomNum,checkIn,checkOut);
    }

    // 根据orderpo得到计算总价和显示策略的信息
    // 优惠策略形式：String#double
    // 返回形式：pro1&pro2&...#value
    public String getDiscount(OrderPO orderPO){
        String hotelID = orderPO.getHotelID();
        RoomNormVO room = orderPO.getRoom();
        int roomNum = orderPO.getRoomNumber();

        hotelInfoService = new HotelController(hotelID);

        String promotion = null;
        return promotion;

    }

    //根据（用户信用值信息）判断是否可以提交
    //（再次检查可用数量 会员信息 优惠政策是否存在）出现出入 返回信息提示
    protected ResultMessage check(OrderPO orderpo){
        //检查信用值
        CreditRecordList credit = new CreditRecordList(orderpo.getUserID());
        if(credit.canOrder()==false)
            return ResultMessage.fail;
        hotelInfoService = new HotelController(orderpo.getHotelID());

        //检查房间信息
        RoomNormVO room = orderpo.getRoom();
        int roomNum = orderpo.getRoomNumber();
        Date checkIn = orderpo.getCheckIn();
        Date checkOut = orderpo.getCheckOut();
        if(hotelInfoService.numOfRoomAvail(room.getRoomType(),checkIn,checkOut)<roomNum)
                return ResultMessage.fail;


        //检查价格
        OrderGeneration initial = new OrderGeneration();
        double price = Double.parseDouble(initial.getDiscount(orderpo).split("#")[1]);
        if(orderpo.getTrueValue()<price)
            return ResultMessage.fail;

        return ResultMessage.succeed;
    }

    //根据界面信息 生成orderid完善orderpo
    public void add(OrderPO orderpo){
        OrderGeneration initial = new OrderGeneration();
        LocalDate A;
        if(initial.check(orderpo).equals(ResultMessage.succeed)){
            //dataservice;
        }
        return;
    }
}

