package presentation.hotelcontroller;

import constant.StateOfOrder;
import po.OrderPO;
import vo.RoomNormVO;

import java.util.Date;

/**
 * Created by a297 on 16/12/10.
 */
public class DataFactory {

    public static OrderPO getOrderPO(){
//        String orderid = "12345678912345678912345678"; 
//        String userid = "12345678912";
//        String username = "sunshine"; 
//        StateOfOrder state = StateOfOrder.unexecuted; 
//        double origin  = 5000; 
//        double discounted = 4000; 
//        RoomNormVO type = new RoomNormVO("414-2", "other", 5000.0); 
//        int num = 1; 
//        Date in = new Date(2016, 10, 9); 
//        Date out = new Date(2016, 10, 10); 
//        Date actualIn = new Date(2016, 10, 9); 
//        Date actualOut = new Date(2016, 10, 10); 
//        Date generationDate = new Date(2016, 10, 9); 
//        boolean adultonly = false; 
//        int peoplenum = 4; 
        return new OrderPO("12345678912345678912345678","12345678912","sunshine",
                StateOfOrder.unexecuted,5000,4000,new RoomNormVO("414-2", "other", 5000.0),
                1,new Date(2016, 10, 9),new Date(2016, 10, 10),new Date(2016, 10, 9),new Date(2016, 10, 10),
                new Date(2016, 10, 9), false, 4);
    }
}
