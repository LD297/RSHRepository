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
    @Override
    public WebManagerDaoHelper getWebStaffDaoHelper() {
        WebManagerDaoHelper webManagerDaoHelper = new WebManagerDaoHelperMySql();
        return webManagerDaoHelper;
    }

    @Override
    public PromotionDaoHelper getPromotionDaoHelper() {
        PromotionDaoHelper promotionDaoHelper = new PromotionDaoHelperMySql();
        return promotionDaoHelper;
    }

    @Override
    public HotelDaoHelper getHotelDaoHelper() {
        HotelDaoHelper hotelDaoHelper = new HotelDaoHelperMySql();
        return hotelDaoHelper;
    }

    @Override
    public OrderDaoHelper getOrderDaoHelper() {
        OrderDaoHelper orderDaoHelper = new OrderDaoHelperMySql();
        return orderDaoHelper;
    }

    @Override
    public UserDaoHelper getUserDaoHelper() {
        UserDaoHelper userDaoHelper = new UserDaoHelperMySql();
        return userDaoHelper;
    }

    @Override
    public CreditRecordListDaoHelper getCrediRecordListDdaoHelper() {
        CreditRecordListDaoHelper creditRecordListDaoHelper = new CreditRecordListDaoHelperMySql();
        return creditRecordListDaoHelper;
    }

    @Override
    public LoginDaoHelper getLoginDaoHelper() {
        LoginDaoHelper loginDaoHelper = new LoginDaoHelperMySql();
        return loginDaoHelper;
    }
}
