package presentation.hotelcontroller;

import constant.StateOfOrder;
import vo.OrderVO;
import vo.RoomNormVO;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by a297 on 16/12/10.
 */
public class DataFactory {
    public static OrderVO getOrderVO(){
        String orderID = "12345123451234512345123456";
        String userID = "13182811957";
        String userName = "297";
        String hotelID = "1234567891";
        String hotelName = "414-2";
        StateOfOrder state = StateOfOrder.unexecuted;
        RoomNormVO room = new RoomNormVO("414-2", "其他", 40000.00);
        double roomPrice = 40000;
        int roomNumber = 1;
        int peopleNumber = 4;
        boolean withChild = false;
        double originValue = 40000;
        double trueValue = 40000;
        String promotion = null;
        String comment = "fantastic";
        int grade = 5;
        Date checkIn = new Date(2016, 12, 9, 18, 30, 0);
        Date checkOut = new Date(2016, 12, 10, 10, 30, 0);
        String hotelDDL = "23::44::59";
        Date generationDate = new Date(2016, 11, 9, 18, 30, 0);
        Date actualCheckIn = new Date(2016, 12, 9, 19, 30, 0);
        Date actualCheckOut = new Date(2016, 12, 10, 9, 30, 0);
        Date cancelTime = null;
        Date cancelAbnormalTime = null;
        return new OrderVO(orderID, userID, userName, hotelID, hotelName,
                state, room, roomPrice, roomNumber, peopleNumber,withChild,
                originValue, trueValue, promotion, comment, grade, checkIn, checkOut,
                hotelDDL, generationDate, actualCheckIn, actualCheckOut, cancelTime, cancelAbnormalTime);
    }

    public static ArrayList<OrderVO> getOrderVOList(int size){
        ArrayList<OrderVO> list = new ArrayList<OrderVO>(size);
        for(int i=0; i<size; i++){
            list.add(DataFactory.getOrderVO());
        }
        return list;
    }
}
