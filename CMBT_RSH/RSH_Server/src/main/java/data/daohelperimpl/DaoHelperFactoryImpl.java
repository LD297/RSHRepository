package data.daohelperimpl;

import data.daohelper.*;
import data.daohelperimpl.hoteldaohelperimpl.HotelDaoHelperMySql;
import data.daohelperimpl.logindaohelperimpl.LoginDaoHelperMySql;
import data.daohelperimpl.orderdaohelperimpl.OrderDaoHelperMySql;
import data.daohelperimpl.promotiondaohelperimpl.PromotionDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.CreditRecordListDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.UserDaoHelperMySql;
import data.daohelperimpl.webstaffdaohelperimpl.WebManagerDaoHelperMySql;

/**
 * Created by aa on 2016/12/6.
 */
public class DaoHelperFactoryImpl implements DaoHelperFactory {

    public WebManagerDaoHelper getWebStaffDaoHelper() {
        WebManagerDaoHelper webManagerDaoHelper = new WebManagerDaoHelperMySql();
        return webManagerDaoHelper;
    }

    public PromotionDaoHelper getPromotionDaoHelper() {
        PromotionDaoHelper promotionDaoHelper = new PromotionDaoHelperMySql();
        return promotionDaoHelper;
    }

    public HotelDaoHelper getHotelDaoHelper() {
        HotelDaoHelper hotelDaoHelper = new HotelDaoHelperMySql();
        return hotelDaoHelper;
    }

    public OrderDaoHelper getOrderDaoHelper() {
        OrderDaoHelper orderDaoHelper = new OrderDaoHelperMySql();
        return orderDaoHelper;
    }

    public UserDaoHelper getUserDaoHelper() {
        UserDaoHelper userDaoHelper = new UserDaoHelperMySql();
        return userDaoHelper;
    }

    public CreditRecordListDaoHelper getCrediRecordListDdaoHelper() {
        CreditRecordListDaoHelper creditRecordListDaoHelper = new CreditRecordListDaoHelperMySql();
        return creditRecordListDaoHelper;
    }

    public LoginDaoHelper getLoginDaoHelper() {
        LoginDaoHelper loginDaoHelper = new LoginDaoHelperMySql();
        return loginDaoHelper;
    }
}
