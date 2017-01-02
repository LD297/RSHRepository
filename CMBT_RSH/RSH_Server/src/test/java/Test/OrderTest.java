package Test;


import static org.junit.Assert.*;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.daohelper.WebSalesmanDaoHelper;
import data.daohelperimpl.hoteldaohelperimpl.HotelDaoHelperMySql;
import data.daohelperimpl.jdbc.DBHelper;
import data.daohelperimpl.logindaohelperimpl.LoginDaoHelperMySql;
import data.daohelperimpl.orderdaohelperimpl.OrderDaoHelperMySql;
import data.daohelperimpl.promotiondaohelperimpl.PromotionDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.CreditRecordListDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.UserDaoHelperMySql;
import data.daohelperimpl.webstaffdaohelperimpl.WebManagerDaoHelperMySql;
import data.daohelperimpl.webstaffdaohelperimpl.WebSalesmanDaoHelperMySql;

import org.junit.Test;

import po.HotelPO;
import po.OrderPO;
import po.RoomNormPO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sky-PC on 2016/12/2.
 */

public class OrderTest {
// success
    static OrderDaoHelperMySql orderDao = new OrderDaoHelperMySql();
    
    //  success
    @Test// 新建订单
    public void testinsert() throws RemoteException,ParseException{
        String room = "标准大床间";
        SimpleDateFormat simm=new SimpleDateFormat("yyyy-MM-dd");

        Date checkIn = simm.parse("2016-12-27");
        Date checkOut = simm.parse("2016-12-31");
        String hotelDDL = "23:15:00";
        Date generationDate = simm.parse("2016-12-19");
        
        Date cancelTime = null;
        Date cancelAbnormalTime = null;
        OrderPO orderPO = new OrderPO(null,"15935142165", "slt","2153000001","有间旅馆",StateOfOrder.unexecuted,
                    room, 100, 1, 1, false,
                    100, 80, "任性优惠八折",
                    null,0, checkIn,checkOut,hotelDDL,generationDate,
                    null,null, cancelTime, cancelAbnormalTime);
        ResultMessage result = orderDao.insert(orderPO);
        assertEquals(result,ResultMessage.succeed);

    }

    // 根据订单编号查找订单
    @Test
    public void testsearchByID() throws RemoteException{
        String orderID = "2016-01-282153000001000001";
        orderDao = new OrderDaoHelperMySql();
        OrderPO orderPO = orderDao.searchByID(orderID);
        assertEquals(orderPO.getOriginValue(),120.0,0.1);

    }
    // 根据用户编号查找订单
    @Test
    public void  testsearchByUser() throws RemoteException{
        String userID = "11111111111";
        ArrayList<OrderPO> list = orderDao.searchByUser(userID);
        assertEquals(list.get(0).getRoomPrice(),120.0,0.1);
    }
    // 根据用户编号、酒店编号查找订单
    @Test
    public void searchByUserWithHotel() throws RemoteException{
        String userID = "11111111111";
        String hotelID = "2153000001";
        ArrayList<OrderPO> list = orderDao.searchByUserWithHotel(userID,hotelID);
        assertEquals(list.size(),2);
    }
    // 根据酒店编号查找订单
    @Test
    public void searchByHotel() throws RemoteException{
        String hotelID = "2153000001";
        ArrayList<OrderPO> list = orderDao.searchByHotel(hotelID);
        assertEquals(list.size(),4);
    }
    // 根据状态编号查找订单
    @Test
    public void searchByState() throws RemoteException{
        StateOfOrder state = StateOfOrder.executed;
        ArrayList<OrderPO> list = orderDao.searchByState(state);
        assertEquals(list.size(),2);
    }
    
    
  
    
    
    // success
    @Test// 更新订单
    public void update() throws RemoteException, ParseException{
    	String room = "标准大床间";
        SimpleDateFormat simm=new SimpleDateFormat("yyyy-MM-dd");

        Date checkIn = simm.parse("2016-12-27");
        Date checkOut = simm.parse("2016-12-31");
        String hotelDDL = "23:15:00";
        Date generationDate = simm.parse("2016-12-19");
        
        Date cancelTime = null;
        Date cancelAbnormalTime = null;
        OrderPO orderPO = new OrderPO("2016-12-192153000001000001","15935142165", "slt","2153000001","有间旅馆",StateOfOrder.unexecuted,
                    room, 100, 1, 1, false,
                    100, 80, "任性优惠八折",
                    null,0, checkIn,checkOut,hotelDDL,generationDate,
                    null,null, cancelTime, cancelAbnormalTime);
        orderPO.setState(StateOfOrder.executed);
        
        
        ResultMessage result = orderDao.update(orderPO);
        assertEquals(result,ResultMessage.succeed);
    }
    
    
    


}