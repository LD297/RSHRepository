package rmi;

import bl.hotelserviceimpl.Hotel;
import data.dao.hoteldao.HotelDao;
import data.dao.logindao.LoginDao;
import data.dao.orderdao.OrderDao;
import data.dao.promotiondao.PromotionDao;
import data.dao.userdao.UserDao;

/**
 * Created by aa on 2016/12/13.
 */
public class Mock_RemoteHelper extends RemoteHelper{
    private static Mock_RemoteHelper mock_remoteHelper = null;
    private UserDao userDao;
    private LoginDao loginDao;
    private HotelDao hotelDao;
    private OrderDao orderDao;
    private PromotionDao promotionDao;

    /*private Mock_RemoteHelper(){
        super();
        userDao = UserDao_Stub.getInstance();
        loginDao = LoginDao_Stub.getInstance();
    }*/

    public static Mock_RemoteHelper getInstance(){
        if(mock_remoteHelper==null){
            mock_remoteHelper = new Mock_RemoteHelper();
        }
        return mock_remoteHelper;
    }

    public UserDao getUserDao(){
        return userDao;
    }

    public LoginDao getLoginDao(){
        return loginDao;
    }

    public HotelDao getHotelDao(){
        return hotelDao;
    }
}
