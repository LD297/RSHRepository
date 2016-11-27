package data.daoimpl.databasefactoryimpl;

import data.dao.databasefactory.DatabaseFactory;
import data.dao.hoteldao.HotelDao;
import data.dao.logindao.LoginDao;
import data.dao.orderdao.OrderDao;
import data.dao.promotiondao.PromotionDao;
import data.dao.userdao.CreditRecordListDao;
import data.dao.userdao.UserDao;
import data.dao.webstaffdao.WebStaffDao;
import data.daoimpl.hoteldaoimpl.HotelDaoImpl;
import data.daoimpl.logindaoimpl.LoginDaoImpl;
import data.daoimpl.orderdaoimpl.OrderDaoImpl;
import data.daoimpl.userdaoimpl.CreditRecordListDaoImpl;
import data.daoimpl.userdaoimpl.UserDaoImpl;


import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/11/27.
 */
public class DatabaseFactoryImpl implements DatabaseFactory {

    public DatabaseFactoryImpl()throws RemoteException{

    }
    public HotelDao getHotelDatabase()throws RemoteException{
        HotelDao hotelDatabase = new HotelDaoImpl();
        return hotelDatabase;
    }

    public LoginDao getLoginDatabase()throws RemoteException{
        LoginDao loginDatabase = new LoginDaoImpl();
        return loginDatabase;
    };

    public OrderDao getOrderDatabase()throws RemoteException{
        OrderDao orderDatabase = new OrderDaoImpl();
        return orderDatabase;
    };

/*    public PromotionDao getPromotionDatabase()throws RemoteException{
        PromotionDao promotionDatabase = new PromotionDaoImpl();
        return promotionDatabase;
    };
*/
    public CreditRecordListDao getCreditRecordDatabase()throws RemoteException{
        CreditRecordListDao creditRecordDatabase = new CreditRecordListDaoImpl();
        return creditRecordDatabase;
    }

    public UserDao getUserDatabase()throws RemoteException{
        UserDao userDatabase = new UserDaoImpl();
        return userDatabase;
    };

 /*   public WebStaffDao getWebStaffDatabase()throws RemoteException{
        WebStaffDao webstaffDatabase = new WebStaffDaoImpl();
        return webstaffDatabase;
    };
*/
}