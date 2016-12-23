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
// 给daoimpl
	WebManagerDaoHelper webManagerDaoHelper = null;
	WebSalesmanDaoHelper webSalesmanDaoHelper = null;
	PromotionDaoHelper promotionDaoHelper = null;
	HotelDaoHelper hotelDaoHelper = null;
	OrderDaoHelper orderDaoHelper = null;
	UserDaoHelper userDaoHelper = null;
	CreditRecordListDaoHelper creditRecordListDaoHelper = null;
	LoginDaoHelper loginDaoHelper = null;
	
	public WebManagerDaoHelper getWebManagerDaoHelper() {
		if(webManagerDaoHelper==null){
		    webManagerDaoHelper = new WebManagerDaoHelperMySql();
		    webManagerDaoHelper.init();    
		}
		return webManagerDaoHelper;
	}

	public WebSalesmanDaoHelper getWebSalesManDaoHelper() {
		if(webSalesmanDaoHelper==null){
		    webSalesmanDaoHelper = new WebSalesmanDaoHelperMySql();
		    webSalesmanDaoHelper.init();    
		}
		return webSalesmanDaoHelper;
	}

	public PromotionDaoHelper getPromotionDaoHelper() {
		if(promotionDaoHelper==null){
		    promotionDaoHelper = new PromotionDaoHelperMySql();
			promotionDaoHelper.init();
		}
		return promotionDaoHelper;
	}

	public HotelDaoHelper getHotelDaoHelper() {
		if(hotelDaoHelper==null){
		    hotelDaoHelper = new HotelDaoHelperMySql();
			hotelDaoHelper.init();
	    }
		return hotelDaoHelper;
	}

	public OrderDaoHelper getOrderDaoHelper() {
		if(orderDaoHelper==null){
		    orderDaoHelper = new OrderDaoHelperMySql();
			orderDaoHelper.init();
		}
		return orderDaoHelper;
	}

	public UserDaoHelper getUserDaoHelper() {
		if(userDaoHelper==null){
		    userDaoHelper = new UserDaoHelperMySql();
			userDaoHelper.init();
		}
		return userDaoHelper;
	}

	public CreditRecordListDaoHelper getCrediRecordListDdaoHelper() {
		if(creditRecordListDaoHelper==null){
			creditRecordListDaoHelper = new CreditRecordListDaoHelperMySql();
			creditRecordListDaoHelper.init();
		}
		return creditRecordListDaoHelper;
	}

	public LoginDaoHelper getLoginDaoHelper() {
		if(loginDaoHelper==null){
    		loginDaoHelper = new LoginDaoHelperMySql();
    	    loginDaoHelper.init();
		}
		return loginDaoHelper;
	}
}
