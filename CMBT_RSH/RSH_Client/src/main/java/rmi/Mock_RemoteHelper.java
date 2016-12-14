package rmi;

import bl.hotelserviceimpl.Hotel;
import data.dao.hoteldao.HotelDao;
import data.dao.logindao.LoginDao;
import data.dao.orderdao.OrderDao;
import data.dao.promotiondao.PromotionDao;
import data.dao.userdao.UserDao;
import data.dao_Stub.logindao_Stub.LoginDao_Stub;
import data.dao_Stub.userdao_Stub.UserDao_Stub;

/**
 * Created by aa on 2016/12/13.
 */
public class Mock_RemoteHelper extends RemoteHelper{
    private Mock_RemoteHelper mock_remoteHelper = null;
    private UserDao userDao;
    private LoginDao loginDao;
    private HotelDao hotelDao;
    private OrderDao orderDao;
    private PromotionDao promotionDao;

    private Mock_RemoteHelper(){
        super();
        mock_remoteHelper = new Mock_RemoteHelper();
        userDao = UserDao_Stub.getInstance();
        loginDao = LoginDao_Stub.getInstance();
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
