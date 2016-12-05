package data.daoimpl.databasefactoryimpl;

import data.dao.databasefactory.DatabaseFactory;
import data.dao.hoteldao.HotelDao;
import data.dao.logindao.LoginDao;
import data.dao.orderdao.OrderDao;
import data.dao.promotiondao.PromotionDao;
import data.dao.userdao.UserDao;
import data.dao.webstaffdao.WebManagerDao;
import data.dao.webstaffdao.WebSalesmanDao;
import data.daoimpl.hoteldaoimpl.HotelDaoImpl;
import data.daoimpl.logindaoimpl.LoginDaoImpl;
import data.daoimpl.orderdaoimpl.OrderDaoImpl;
import data.daoimpl.userdaoimpl.UserDaoImpl;
import data.daoimpl.webstaffdaoimpl.WebManagerDaoImpl;
import data.daoimpl.promotiondaoimpl.PromotionDaoImpl;
import data.daoimpl.webstaffdaoimpl.WebSalesmanDaoTXTImpl;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/11/27.
 */
public class DatabaseFactoryImpl implements DatabaseFactory {

    public DatabaseFactoryImpl()throws RemoteException{
        // 建立数据库
        //path表示你所创建文件的路径
        String path = "D:\\360downloads";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        // fileName表示你创建的文件名；
        String fileName = "Test.db";
        File file = new File(f,fileName);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    public PromotionDao getPromotionDatabase()throws RemoteException{
        PromotionDao promotionDatabase = new PromotionDaoImpl();
        return promotionDatabase;
    };


    public UserDao getUserDatabase()throws RemoteException{
        UserDao userDatabase = new UserDaoImpl();
        return userDatabase;
    };

    public WebManagerDao getWebManagerDatabase()throws RemoteException{
        WebManagerDao webManagerDatabase = new WebManagerDaoImpl();
        return webManagerDatabase;
    };

    public WebSalesmanDao getWebSalesmanDatabase()throws RemoteException{
        WebSalesmanDao webSalesmanDatabase = new WebSalesmanDaoTXTImpl();
        return webSalesmanDatabase;
        }
    }

