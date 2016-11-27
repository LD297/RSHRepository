package rmi;

import data.dao.hoteldao.HotelDao;
import data.dao.logindao.LoginDao;
import data.dao.userdao.CreditRecordListDao;
import data.dao.userdao.UserDao;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by john on 2016/11/27.
 */
public class RemoteHelper {
    private static RemoteHelper remoteHelper = null;
    private LoginDao loginDao = null;
    private CreditRecordListDao creditRecordListDao = null;
    private UserDao userDao = null;
    private HotelDao hotelDao = null;
    public static RemoteHelper getInstance(){
        if(remoteHelper ==null){
            remoteHelper = new RemoteHelper();
        }
        return remoteHelper;
    }

    private RemoteHelper() {
        initDao();
    }

    public void initDao() {
        try {
            loginDao = (LoginDao)Naming.lookup("rmi://localhost:8888/LoginDaoImpl");
            creditRecordListDao = (CreditRecordListDao)Naming.lookup("rmi://localhost:8888/CreditRecordListDaoImpl") ;
            userDao = (UserDao) Naming.lookup("rmi://localhost:8888/UserDaoImpl");
            hotelDao = (HotelDao)Naming.lookup("rmi://localhost:8888/HotelRemoteObject");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public LoginDao getLoginDao(){return loginDao;}

    public CreditRecordListDao getCreditRecordListDao(){
        return creditRecordListDao;
    }

    public UserDao getUserDao() {return userDao;}

    public HotelDao getHotelDao(){
        return hotelDao;
    }

}

