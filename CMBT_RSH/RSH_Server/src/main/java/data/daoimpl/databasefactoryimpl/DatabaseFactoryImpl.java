package data.daoimpl.databasefactoryimpl;

import data.dao.databasefactory.DatabaseFactory;

import data.dao.hoteldao.HotelDao;
import data.dao.logindao.LoginDao;
import data.dao.orderdao.OrderDao;
import data.dao.promotiondao.PromotionDao;
import data.dao.userdao.CreditRecordListDao;
import data.dao.userdao.UserDao;
import data.dao.webstaffdao.WebManagerDao;
import data.dao.webstaffdao.WebSalesmanDao;

import data.daoimpl.hoteldaoimpl.HotelDaoImpl;
import data.daoimpl.logindaoimpl.LoginDaoImpl;
import data.daoimpl.orderdaoimpl.OrderDaoImpl;
import data.daoimpl.promotiondaoimpl.PromotionDaoImpl;
import data.daoimpl.userdaoimpl.CreditRecordListDaoImpl;
import data.daoimpl.userdaoimpl.UserDaoImpl;
import data.daoimpl.webstaffdaoimpl.WebManagerDaoImpl;
import data.daoimpl.webstaffdaoimpl.WebSalesmanDaoImpl;


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
    }

    @Override
    public PromotionDao getPromotionDatabase() throws RemoteException {
        PromotionDao promotionDatabase = new PromotionDaoImpl();
        return promotionDatabase;
    }

    ;
    public CreditRecordListDao getCreditRecordDatabase()throws RemoteException{
        CreditRecordListDao creditRecordDatabase = new CreditRecordListDaoImpl();
        return creditRecordDatabase;
    }

    public UserDao getUserDatabase()throws RemoteException{
        UserDao userDatabase = new UserDaoImpl();
        return userDatabase;
    }

    @Override
    public WebManagerDao getWebManagerDatabase() throws RemoteException {
        WebManagerDao webManagerDatabase = new WebManagerDaoImpl();
        return webManagerDatabase;
    }

    @Override
    public WebSalesmanDao getWebSalesmanDatabase() throws RemoteException {
        WebSalesmanDao webSalesmanDatabase = new WebSalesmanDaoImpl();
        return webSalesmanDatabase;
    }

    ;

 /*   public WebStaffDao getWebStaffDatabase()throws RemoteException{
        WebStaffDao webstaffDatabase = new WebStaffDaoImpl();
        return webstaffDatabase;
    };
*/
}
