package bl.orderservice;

import po.OrderPO;
import vo.RoomNormVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/11/20.
 */
public interface InitialOrderService {
    //根据酒店得到房间规模（房间类型和价格）
    public ArrayList<RoomNormVO> getHotelRoom(String hotelid);

    //根据时间得到可用客房数量
    public int[] getRoomInfo(String hotelid, Date checkIn, Date checkOut);

    //根据界面得到orderpo     是提供给计算价格的方法
    public OrderPO getOrder(String userid,String hotelid,Date checkIn,Date checkOut,ArrayList<RoomNormVO> rooms,int roomNums[]);

    //根据初始orderpo得到优惠后价格完善orderpo
    public double getDiscounted(String userid, String hotelid, Date checkIn, Date checkOut, ArrayList<RoomNormVO> rooms, int roomNums[]);

    //根据界面 生成orderid  得到orderpo
    public void add(OrderPO order);
}