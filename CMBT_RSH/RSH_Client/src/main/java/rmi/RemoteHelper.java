package rmi;

import bl.promotionServiceimpl.Promotion;
import data.dao.hoteldao.HotelDao;
import data.dao.logindao.LoginDao;
import data.dao.orderdao.OrderDao;
import data.dao.promotiondao.PromotionDao;
import data.dao.userdao.CreditRecordListDao;
import data.dao.userdao.UserDao;
import data.dao.webstaffdao.WebManagerDao;
import data.dao.webstaffdao.WebSalesmanDao;

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
    private WebManagerDao webManagerDao = null;
    private WebSalesmanDao webSalesmanDao = null;
    private PromotionDao promotionDao = null;
    private OrderDao orderDao = null;
    public static RemoteHelper getInstance(){
        if(remoteHelper ==null){
            remoteHelper = new RemoteHelper();
        }
        return remoteHelper;
    }

    RemoteHelper() {
        initDao();
    }

    public void initDao() {
        try {
            loginDao = (LoginDao)Naming.lookup("rmi://localhost:8888/LoginDaoImpl");
            creditRecordListDao = (CreditRecordListDao)Naming.lookup("rmi://localhost:8888/CreditRecordListDaoImpl") ;
            userDao = (UserDao) Naming.lookup("rmi://localhost:8888/UserDaoImpl");
            hotelDao = (HotelDao)Naming.lookup("rmi://localhost:8888/HotelDaoImpl");
            webManagerDao = (WebManagerDao)Naming.lookup("rmi://localhost:8888/WebManagerDaoImpl");
            webSalesmanDao = (WebSalesmanDao)Naming.lookup("rmi://localhost:8888/WebSalesmanDaoImpl");
            promotionDao = (PromotionDao)Naming.lookup("rmi://localhost:8888/PromotionDaoImpl");
            orderDao = (OrderDao)Naming.lookup("rmi://localhost:8888/OrderDaoImpl");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public LoginDao getLoginDao(){
        return loginDao;
    }

    public CreditRecordListDao getCreditRecordListDao(){
        return creditRecordListDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public HotelDao getHotelDao(){
        return hotelDao;
    }

    public WebManagerDao getWebManagerDao() {
        return webManagerDao;
    }

    public WebSalesmanDao getWebSalesmanDao() {
        return webSalesmanDao;
    }

    public PromotionDao getPromotionDao(){
        return promotionDao;
    }

	public OrderDao getOrderDao() {
		// TODO Auto-generated method stub
		return null;
	}
}

