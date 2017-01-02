package dao_Stub;

import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.orderdao.OrderDao;
import po.OrderPO;
import vo.RoomNormVO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a297 on 16/12/9.
 */
public class OrderDao_Stub implements OrderDao {
    @Override
    public OrderPO searchByID(String orderID) throws RemoteException {
        RoomNormVO room = new RoomNormVO("0123456789","singleRoom",120.0);
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str="2011-5-31 14:40:50";
        try {
            Date checkIn = sim.parse("2016-01-31");
            Date checkOut = sim.parse("2016-02-05");
            String hotelDDL = "23:15:00";
            Date generationDate = sim.parse("2016-01-28");
            Date actualCheckIn = sim.parse("2016-01-31 15:22:09");
            Date actualCheckOut = sim.parse("2016-02-06 10:10:23");
            Date cancelTime = null;
            Date cancelAbnormalTime = null;
            return new OrderPO(orderID,"15935142165", "slt","0123456789","有间旅馆",StateOfOrder.unexecuted,
                    room, 100, 1, 1, false,
                    120, 100, "任性优惠八折",
                    "睡得很香",4, checkIn,checkOut,hotelDDL,generationDate,
                    actualCheckIn, actualCheckOut, cancelTime, cancelAbnormalTime);

        }catch (ParseException e){
            return null;
        }
    }

    @Override
    public ArrayList<OrderPO> searchByUser(String userID) throws RemoteException {
        RoomNormVO room = new RoomNormVO("0123456789","singleRoom",120.0);
        ArrayList<OrderPO> list = new ArrayList<OrderPO>();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str="2011-5-31 14:40:50";
        try {
            Date checkIn = sim.parse("2016-01-31");
            Date checkOut = sim.parse("2016-02-05");
            String hotelDDL = "23:15:00";
            Date generationDate = sim.parse("2016-01-28");
            Date actualCheckIn = sim.parse("2016-01-31-15-22-09");
            Date actualCheckOut = sim.parse("2016-02-06-10-10-23");
            Date cancelTime = null;
            Date cancelAbnormalTime = null;
            list.add( new OrderPO("01234567890123456789012345","15105182135", "slt","0123456789","有间旅馆",StateOfOrder.unexecuted,
                    room, 100, 1, 1, false,
                    120, 100, "任性优惠",
                    "睡得很香",4, checkIn,checkOut,hotelDDL,generationDate,
                    actualCheckIn, actualCheckOut, cancelTime, cancelAbnormalTime));
            return list;
        }catch (ParseException e){
            return null;
        }
    }
    @Override
    public ArrayList<OrderPO> searchByUserWithHotel(String userID, String hotelID)throws RemoteException{
        RoomNormVO room = new RoomNormVO("0123456789","singleRoom",120.0);
        ArrayList<OrderPO> list = new ArrayList<OrderPO>();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str="2011-5-31 14:40:50";
        try {
            Date checkIn = sim.parse("2016-01-31");
            Date checkOut = sim.parse("2016-02-05");
            String hotelDDL = "23:15:00";
            Date generationDate = sim.parse("2016-01-28");
            Date actualCheckIn = sim.parse("2016-01-31-15-22-09");
            Date actualCheckOut = sim.parse("2016-02-06-10-10-23");
            Date cancelTime = null;
            Date cancelAbnormalTime = null;
            list.add( new OrderPO("01234567890123456789012345","15105182135", "slt","0123456789","有间旅馆",StateOfOrder.unexecuted,
                    room, 100, 1, 1, false,
                    120, 100, "任性优惠",
                    "睡得很香",4, checkIn,checkOut,hotelDDL,generationDate,
                    actualCheckIn, actualCheckOut, cancelTime, cancelAbnormalTime));
            return list;
        }catch (ParseException e){
            return null;
        }
    }

    @Override
    public ArrayList<OrderPO> searchByHotel(String hotelID) throws RemoteException {
        RoomNormVO room = new RoomNormVO("0123456789","singleRoom",120.0);
        ArrayList<OrderPO> list = new ArrayList<OrderPO>();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str="2011-5-31 14:40:50";
        try {
            Date checkIn = sim.parse("2016-01-31");
            Date checkOut = sim.parse("2016-02-05");
            String hotelDDL = "23:15:00";
            Date generationDate = sim.parse("2016-01-28");
            Date actualCheckIn = sim.parse("2016-01-31-15-22-09");
            Date actualCheckOut = sim.parse("2016-02-06-10-10-23");
            Date cancelTime = null;
            Date cancelAbnormalTime = null;
            list.add( new OrderPO("01234567890123456789012345","15105182135", "slt","0123456789","有间旅馆",StateOfOrder.unexecuted,
                    room, 100, 1, 1, false,
                    120, 100, "任性优惠",
                    "睡得很香",4, checkIn,checkOut,hotelDDL,generationDate,
                    actualCheckIn, actualCheckOut, cancelTime, cancelAbnormalTime));
            return list;
        }catch (ParseException e){
            return null;
        }
    }

    @Override
    public ArrayList<OrderPO> searchByState(StateOfOrder state) throws RemoteException {
        RoomNormVO room = new RoomNormVO("0123456789","singleRoom",120.0);
        ArrayList<OrderPO> list = new ArrayList<OrderPO>();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str="2011-5-31 14:40:50";
        try {
            Date checkIn = sim.parse("2016-01-31");
            Date checkOut = sim.parse("2016-02-05");
            String hotelDDL = "23:15:00";
            Date generationDate = sim.parse("2016-01-28");
            Date actualCheckIn = sim.parse("2016-01-31-15-22-09");
            Date actualCheckOut = sim.parse("2016-02-06-10-10-23");
            Date cancelTime = null;
            Date cancelAbnormalTime = null;
            list.add( new OrderPO("01234567890123456789012345","15105182135", "slt","0123456789","有间旅馆",StateOfOrder.unexecuted,
                    room, 100, 1, 1, false,
                    120, 100, "任性优惠",
                    "睡得很香",4, checkIn,checkOut,hotelDDL,generationDate,
                    actualCheckIn, actualCheckOut, cancelTime, cancelAbnormalTime));
            return list;
        }catch (ParseException e){
            return null;
        }
    }

    @Override
    public ResultMessage insert(OrderPO orderPO) throws RemoteException {
        return null;
    }

	@Override
	public ResultMessage update(OrderPO orderPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
