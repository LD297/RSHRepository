package data.dao.databasefactory;

import data.dao.hoteldao.HotelDao;
import data.dao.logindao.LoginDao;
import data.dao.orderdao.OrderDao;
import data.dao.promotiondao.PromotionDao;
import data.dao.userdao.UserDao;
import data.dao.webstaffdao.WebStaffDao;

import java.rmi.RemoteException;
/**
 * Created by sky-PC on 2016/11/27.
 */
public interface DatabaseFactory {
    public HotelDao getHotelDatabase ()throws RemoteException;
    public LoginDao getLoginDatabase()throws RemoteException;
    public OrderDao getOrderDatabase()throws RemoteException;
//    public PromotionDao getPromotionDatabase()throws RemoteException;
    public UserDao getUserDatabase()throws RemoteException;
//    public WebStaffDao getWebStaffDatabase()throws RemoteException;
}
