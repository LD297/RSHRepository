package data.daohelperimpl.orderdaohelperimpl;


import data.daohelperimpl.hoteldaohelperimpl.HotelDaoHelperMySql;
import data.daohelperimpl.logindaohelperimpl.LoginDaoHelperMySql;
import data.daohelperimpl.promotiondaohelperimpl.PromotionDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.CreditRecordListDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.UserDaoHelperMySql;

import java.rmi.RemoteException;
import java.text.ParseException;

/**
 * Created by sky-PC on 2016/12/2.
 */

public class test {

    public static void main(String[] args) throws RemoteException ,ParseException{
        /*SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        String strin = "2016-11-07";
        String strout = "2016-11-11";
        Date in = format.parse(strin);
        Date out = format.parse(strout);

        ArrayList<RoomNormVO> type = new ArrayList<RoomNormVO>();
        type.add(new RoomNormVO("2153001234", "singleRoom", 120.0));
        type.add(new RoomNormVO("2153001234", "doubleRoom", 200.0));
        double price[] = {110,180};
        int nums[] = {1,3};
        OrderPO order = new OrderPO("2016-11-062153001234000000","123456789","2153001234",StateOfOrder.unexecuted,
                type,price,nums,3,false,0,0,"","GOOD",0,in,out);


        OrderDaoHelperMySql orderdao = new OrderDaoHelperMySql();
        Date d = new Date();
        orderdao.insert(order);*/
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

    }

}