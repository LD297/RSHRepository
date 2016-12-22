package data.daohelperimpl.orderdaohelperimpl;


import static org.junit.Assert.*;
import constant.ResultMessage;
import constant.StateOfOrder;
import data.daohelper.WebSalesmanDaoHelper;
import data.daohelperimpl.hoteldaohelperimpl.HotelDaoHelperMySql;
import data.daohelperimpl.logindaohelperimpl.LoginDaoHelperMySql;
import data.daohelperimpl.promotiondaohelperimpl.PromotionDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.CreditRecordListDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.UserDaoHelperMySql;
import data.daohelperimpl.webstaffdaohelperimpl.WebManagerDaoHelperMySql;
import data.daohelperimpl.webstaffdaohelperimpl.WebSalesmanDaoHelperMySql;

import org.junit.Test;

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

public class test {
// success
   static OrderDaoHelperMySql orderDao = new OrderDaoHelperMySql();
    

/*
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
        String userID = "15935142165";
        ArrayList<OrderPO> list = orderDao.searchByUser(userID);
        assertEquals(list.get(0).getRoomPrice(),120.0,0.1);
    }
    // 根据用户编号、酒店编号查找订单
    @Test
    public void searchByUserWithHotel() throws RemoteException{
        String userID = "15935142165";
        String hotelID = "2153000001";
        ArrayList<OrderPO> list = orderDao.searchByUserWithHotel(userID,hotelID);
        assertEquals(list.get(0).getRoomPrice(),120.0,0.1);
    }
    // 根据酒店编号查找订单
    @Test
    public void searchByHotel() throws RemoteException{
        String hotelID = "2153000001";
        ArrayList<OrderPO> list = orderDao.searchByHotel(hotelID);
        assertEquals(list.get(0).getRoomPrice(),120.0,0.1);
    }
    // 根据状态编号查找订单
    @Test
    public void searchByState() throws RemoteException{
        StateOfOrder state = StateOfOrder.executed;
        ArrayList<OrderPO> list = orderDao.searchByState(state);
        assertEquals(list.get(0).getRoomPrice(),120.0,0.1);
    }
    
    // 订单状态更新 success
    @Test
    public void teststateUpdate() throws RemoteException{
        String orderID = "2016-01-282153000001000001";
        StateOfOrder newState = StateOfOrder.executed;
        ResultMessage result = orderDao.stateUpdate(orderID,newState);
        assertEquals(result,ResultMessage.noChangeMade);
    }
    
  
    */
    // 新建订单 success
    @Test
    public void testinsert() throws RemoteException,ParseException{
        String room = "标准大床间";
        SimpleDateFormat simm=new SimpleDateFormat("yyyy-MM-dd");

        Date checkIn = simm.parse("2016-12-27");
        Date checkOut = simm.parse("2016-12-31");
        String hotelDDL = "23:15:00";
        Date generationDate = simm.parse("2016-12-19");
        
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
     //   Date actualCheckIn = sim.parse("2016-12-27 15:22:09");
     //   Date actualCheckOut = sim.parse("2016-12-31 10:10:23");
        Date cancelTime = null;
        Date cancelAbnormalTime = null;
        OrderPO orderPO = new OrderPO(null,"15935142165", "slt","2153000001","有间旅馆",StateOfOrder.unexecuted,
                    room, 120, 1, 1, false,
                    120, 100, "任性优惠八折",
                    "睡得很香",4, checkIn,checkOut,hotelDDL,generationDate,
                    null,null, cancelTime, cancelAbnormalTime);
        ResultMessage result = orderDao.insert(orderPO);
        assertEquals(result,ResultMessage.succeed);

    }
    /*
    // 评价订单 success
    @Test
    public void commentUpdate() throws RemoteException{
        String orderID="2016-01-282153000001000001";
        int grade=4;
        String comment="强推这个酒店里的大床间！！";
        ResultMessage result = orderDao.commentUpdate(orderID,grade,comment);
        assertEquals(result,ResultMessage.succeed);
    }
    
    
    // 订单实际入住时间更新 success
    @Test
    public void actCheckInUpdate() throws RemoteException{
        String orderID="2016-01-282153000001000001";
        Date actCheckIn=new Date();
        ResultMessage result = orderDao.actCheckInUpdate(orderID,actCheckIn);
        assertEquals(result,ResultMessage.succeed);
    }
    
    
    // 订单实际离开时间更新 success
    @Test
    public void actCheckOutUpdate() throws RemoteException{
        String orderID="2016-01-282153000001000001";
        Date actCheckOut=new Date();
        ResultMessage result = orderDao.actCheckOutUpdate(orderID,actCheckOut);
        assertEquals(result,ResultMessage.succeed);
    }
    
    
    // 订单撤销时间更新 success
    @Test
    public void cancelTimeUpdate() throws RemoteException{
        String orderID="2016-01-282153000001000001";
        Date cancelTime = new Date();
        ResultMessage result = orderDao.cancelTimeUpdate(orderID,cancelTime);
        assertEquals(result,ResultMessage.succeed);
    }
    
    
    // 订单撤销异常时间更新 success
    @Test
    public void cancelAbTimeUpdate() throws RemoteException{
        String orderID="2016-01-282153000001000001";
        Date cancelAbTime = new Date();
        ResultMessage result = orderDao.cancelAbTimeUpdate(orderID,cancelAbTime);
        assertEquals(result,ResultMessage.succeed);
    }
    */

/*

    public static void main(String[] args) throws RemoteException {
       
        OrderDaoHelperMySql orderdao = new OrderDaoHelperMySql();
        orderdao.init();
        HotelDaoHelperMySql hoteldao = new HotelDaoHelperMySql();
        hoteldao.init();
        LoginDaoHelperMySql logindao = new LoginDaoHelperMySql();
        logindao.init();
        PromotionDaoHelperMySql promotiondao = new PromotionDaoHelperMySql();
        promotiondao.init();
        UserDaoHelperMySql userdao = new UserDaoHelperMySql();
        userdao.init();
        CreditRecordListDaoHelperMySql cdao = new CreditRecordListDaoHelperMySql();
        cdao.init();
        WebSalesmanDaoHelperMySql websalesmandao = new WebSalesmanDaoHelperMySql();
        websalesmandao.init();
        WebManagerDaoHelperMySql webmanagerdao = new WebManagerDaoHelperMySql();
        webmanagerdao.init();
        
        orderdao.finish(); hoteldao.finish(); logindao.finish(); promotiondao.finish();
        userdao.finish(); cdao.finish(); websalesmandao.finish();
        
        
       }*/
}