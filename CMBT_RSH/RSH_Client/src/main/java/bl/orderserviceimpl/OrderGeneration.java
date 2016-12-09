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

import java.util.ArrayList;
import java.util.Date;

public class OrderGeneration {

//    private String hotelid;
    private HotelInfoService hotelinfo;
//    private Count count;
    private OrderDao orderDao;


    public void setHotelInfoService(HotelInfoService hotelinfo) {
        this.hotelinfo = hotelinfo;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    //根据酒店得到房间规模（房间类型和价格）
    public ArrayList<RoomNormVO> getHotelRoom(String hotelid){
        hotelinfo = new HotelController(hotelid);
        ArrayList<RoomNormVO> rooms = hotelinfo.getRoomNorms();
        return rooms;
    }

    //根据时间得到可用客房数量
    public int[] getRoomInfo(String hotelid, Date checkIn, Date checkOut){
        ArrayList<RoomNormVO> rooms = this.getHotelRoom(hotelid);
        int availNum[] = new int[rooms.size()];
        double prices[] = new double[rooms.size()];

        hotelinfo = new HotelController(hotelid);
        for(int i=0;i<rooms.size();i++){
            availNum[i] = hotelinfo.numOfRoomAvail(rooms.get(i).roomType, checkIn, checkOut);
        }
        return availNum;
    }

    //根据界面得到orderpo     是提供给计算价格的方法
    //order,user,hotel,ArrayList<RoomNormVO> type,nums,origin,discounted,pro,com, gra,in,out
    public OrderPO getOrder(String userid, String hotelid, Date checkIn, Date checkOut, ArrayList<RoomNormVO> rooms, int roomNums[]){
        double prices[] = new double[rooms.size()];
        for(int i=0;i<rooms.size();i++){
            prices[i] = hotelinfo.getRoomNorms().get(i).price;
        }
        double originValue = 0;
        for(int i=0;i<rooms.size();i++){
            originValue += roomNums[i]*prices[i];
        }

        return null;
    }

    //根据orderpo得到计算总价和显示策略的信息
    //优惠策略形式：String#double
    //返回形式：pro1&pro2&...#value
    public String getDiscount(OrderPO orderpo){/*
        String hotelid = orderpo.getHotelid();
        ArrayList<RoomNormVO> rooms = orderpo.getRooms();
        int[] nums = orderpo.getRoomNums();

        hotelinfo = new HotelController(hotelid);
        int size = rooms.size();
        double prices[] = new double[size];
        for(int i=0;i<size;i++){
            prices[i] = rooms.get(i).price;
        }

        ArrayList<String> promotion = new ArrayList<String>();
        String roomdis = "";
        for(int i=0;i<size;i++){//遍历房间优惠
            roomdis = Count.countPromotionOfRoom(hotelid, rooms.get(i).roomType, nums[i], orderpo.getInTime()[0],orderpo.getInTime()[1]);
            if(roomdis!=""){
                String[] tem = roomdis.split("#");
                if(prices[i]>Double.parseDouble(tem[1])){
                    promotion.add(tem[0]);
                    prices[i] = Double.parseDouble(tem[1]);
                }
            }
            roomdis = "";
        }
        if(promotion.size()!=0){
            double sum = 0;
            for(int i=0;i<size;i++)
                sum += prices[i]*nums[i];

            orderpo.setTrueValue(sum);
        }
        else
            orderpo.setTrueValue(orderpo.getTrueValue());

        String orderdis = Count.countPromotionOfOrder(orderpo);//总额优惠
        if(orderdis!=null){
            String tem[] = orderdis.split("#");
            promotion.add(tem[0]);
            orderpo.setTrueValue(Double.parseDouble(tem[1]));
        }
        String result = "";
        if(promotion.size()!=0)
            result = promotion.get(0);
        for(int i=1;i<promotion.size();i++)
            result += "&"+promotion.get(i);
*/
        return "pro1#1200";
//      return result+"#"+String.valueOf(orderpo.getTrueValue());
    }

    //根据（用户信用值信息）判断是否可以提交
    //（再次检查可用数量 会员信息 优惠政策是否存在）出现出入 返回信息提示
    protected ResultMessage check(OrderPO orderpo){
        //检查信用值
        CreditRecordList credit = new CreditRecordList(orderpo.getUserid());
        if(credit.canOrder()==false)
            return ResultMessage.fail;
        hotelinfo = new HotelController(orderpo.getHotelid());

        //检查房间信息
        RoomNormVO room = orderpo.getRoom();
        int roomNum = orderpo.getRoomNumber();
        Date checkIn = orderpo.getTime()[0];
        Date checkOut = orderpo.getTime()[1];
        if(hotelinfo.numOfRoomAvail(room.roomType,checkIn,checkOut)<roomNum)
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

        if(initial.check(orderpo).equals(ResultMessage.succeed)){
            //dataservice;
        }
        return;
    }
}

