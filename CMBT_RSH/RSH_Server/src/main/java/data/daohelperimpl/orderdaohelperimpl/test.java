package data.daohelperimpl.orderdaohelperimpl;


import java.rmi.RemoteException;
import java.util.Date;

import constant.StateOfOrder;
import data.daoimpl.databasefactoryimpl.DatabaseFactoryImpl;
import po.OrderPO;

/**
 * Created by sky-PC on 2016/12/2.
 */
import constant.RoomType;
import po.OrderPO;
import vo.RoomNormVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class test {
    public static void main(String[] args) throws RemoteException ,ParseException{
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
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
        orderdao.insert(order);

    }

}