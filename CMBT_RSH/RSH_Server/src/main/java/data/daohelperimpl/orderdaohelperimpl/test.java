package data.daohelperimpl.orderdaohelperimpl;


import constant.ResultMessage;
import constant.StateOfOrder;
import data.dao.webstaffdao.WebManagerDao;
import data.daohelper.WebSalesmanDaoHelper;
import data.daohelperimpl.hoteldaohelperimpl.HotelDaoHelperMySql;
import data.daohelperimpl.logindaohelperimpl.LoginDaoHelperMySql;
import data.daohelperimpl.promotiondaohelperimpl.PromotionDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.CreditRecordListDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.UserDaoHelperMySql;
import data.daohelperimpl.webstaffdaohelperimpl.WebManagerDaoHelperMySql;
import data.daohelperimpl.webstaffdaohelperimpl.WebSalesmanDaoHelperMySql;
import po.OrderPO;
import vo.RoomNormVO;

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
    OrderDaoHelperMySql orderDao = new OrderDaoHelperMySql();

    public static void mian(String[] args) throws RemoteException {

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
        /*orderdao.finish(); hoteldao.finish(); logindao.finish(); promotiondao.finish();
        userdao.finish(); cdao.finish(); websalesmandao.finish();*/


    }

    // 根据订单编号查找订单
    public void testsearchByID() throws RemoteException{
        String orderID = "";
        orderDao = new OrderDaoHelperMySql();
        OrderPO orderPO = orderDao.searchByID(orderID);

    }
    // 根据用户编号查找订单
    public void  testsearchByUser() throws RemoteException{
        String userID = "";
        ArrayList<OrderPO> list = orderDao.searchByUser(userID);
    }
    // 根据用户编号、酒店编号查找订单
    public void searchByUserWithHotel() throws RemoteException{
        String userID = "";
        String hotelID = "";
        ArrayList<OrderPO> list = orderDao.searchByUserWithHotel(userID,hotelID);
    }
    // 根据酒店编号查找订单
    public void searchByHotel() throws RemoteException{
        String hotelID = "";
        ArrayList<OrderPO> list = orderDao.searchByHotel(hotelID);
    }
    // 根据状态编号查找订单
    public void searchByState() throws RemoteException{
        StateOfOrder state = StateOfOrder.unexecuted;
        ArrayList<OrderPO> list = orderDao.searchByState(state);
    }

    // 新建订单
    public void testinsert() throws RemoteException,ParseException{
        String orderID = "";
        RoomNormVO room = new RoomNormVO("0123456789","singleRoom",120.0);
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date checkIn = sim.parse("2016-01-31");
        Date checkOut = sim.parse("2016-02-05");
        String hotelDDL = "23:15:00";
        Date generationDate = sim.parse("2016-01-28");
        Date actualCheckIn = sim.parse("2016-01-31 15:22:09");
        Date actualCheckOut = sim.parse("2016-02-06 10:10:23");
        Date cancelTime = null;
        Date cancelAbnormalTime = null;
        OrderPO orderPO = new OrderPO(orderID,"15935142165", "slt","0123456789","有间旅馆",StateOfOrder.unexecuted,
                    room, 100, 1, 1, false,
                    120, 100, "任性优惠八折",
                    "睡得很香",4, checkIn,checkOut,hotelDDL,generationDate,
                    actualCheckIn, actualCheckOut, cancelTime, cancelAbnormalTime);
        ResultMessage result = orderDao.insert(orderPO);

    }
    // 订单状态更新
    public void stateUpdate() throws RemoteException{
        String orderID = "";
        StateOfOrder newState = StateOfOrder.abnormal;
        ResultMessage result = orderDao.stateUpdate(orderID,newState);
    }
    // 评价订单
    public void commentUpdate() throws RemoteException{
        String orderID="";
        int grade=4;
        String comment="";
        ResultMessage result = orderDao.commentUpdate(orderID,grade,comment);
    }
    // 订单实际入住时间更新
    public void actCheckInUpdate() throws RemoteException{
        String orderID="";
        Date actCheckIn=new Date();
        ResultMessage result = orderDao.actCheckInUpdate(orderID,actCheckIn);
    }
    // 订单实际离开时间更新
    public void actCheckOutUpdate() throws RemoteException{
        String orderID="";
        Date actCheckOut=new Date();
        ResultMessage result = orderDao.actCheckOutUpdate(orderID,actCheckOut);
    }
    // 订单撤销时间更新
    public void cancelTimeUpdate() throws RemoteException{
        String orderID="";
        Date cancelTime = new Date();
        ResultMessage result = orderDao.cancelTimeUpdate(orderID,cancelTime);
    }
    // 订单撤销异常时间更新
    public void cancelAbTimeUpdate() throws RemoteException{
        String orderID="";
        Date cancelAbTime = new Date();
        ResultMessage result = orderDao.cancelTimeUpdate(orderID,cancelAbTime);
    }

}