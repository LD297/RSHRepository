package data.daohelperimpl;

import java.rmi.RemoteException;

import data.daohelper.*;
import data.daohelperimpl.hoteldaohelperimpl.HotelDaoHelperMySql;
import data.daohelperimpl.logindaohelperimpl.LoginDaoHelperMySql;
import data.daohelperimpl.orderdaohelperimpl.OrderDaoHelperMySql;
import data.daohelperimpl.promotiondaohelperimpl.PromotionDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.CreditRecordListDaoHelperMySql;
import data.daohelperimpl.userdaohelperimpl.UserDaoHelperMySql;
import data.daohelperimpl.webstaffdaohelperimpl.WebManagerDaoHelperMySql;
import data.daohelperimpl.webstaffdaohelperimpl.WebSalesmanDaoHelperMySql;

/**
 * Created by aa on 2016/12/6.
 */
public class DaoHelperFactoryImpl implements DaoHelperFactory {

	public WebManagerDaoHelper getWebManagerDaoHelper() {
		WebManagerDaoHelper webManagerDaoHelper = null;
		webManagerDaoHelper = new WebManagerDaoHelperMySql();
		return webManagerDaoHelper;
	}

	public WebSalesmanDaoHelper getWebSalesManDaoHelper() {
		WebSalesmanDaoHelper webSalesmanDaoHelper = null;
		webSalesmanDaoHelper = new WebSalesmanDaoHelperMySql();
		return webSalesmanDaoHelper;
	}

	public PromotionDaoHelper getPromotionDaoHelper() {
		PromotionDaoHelper promotionDaoHelper = null;
		promotionDaoHelper = new PromotionDaoHelperMySql();
		return promotionDaoHelper;
	}

	public HotelDaoHelper getHotelDaoHelper() {
		HotelDaoHelper hotelDaoHelper = null;
		hotelDaoHelper = new HotelDaoHelperMySql();
		return hotelDaoHelper;
	}

	public OrderDaoHelper getOrderDaoHelper() {
		OrderDaoHelper orderDaoHelper = null;
		orderDaoHelper = new OrderDaoHelperMySql();
		return orderDaoHelper;
	}

	public UserDaoHelper getUserDaoHelper() {
		UserDaoHelper userDaoHelper = null;
		userDaoHelper = new UserDaoHelperMySql();
		return userDaoHelper;
	}

	public CreditRecordListDaoHelper getCrediRecordListDdaoHelper() {
		CreditRecordListDaoHelper creditRecordListDaoHelper = new CreditRecordListDaoHelperMySql();
		return creditRecordListDaoHelper;
	}

	public LoginDaoHelper getLoginDaoHelper() {
		LoginDaoHelper loginDaoHelper = null;
		loginDaoHelper = new LoginDaoHelperMySql();
		return loginDaoHelper;
	}
}
