package data.daoimpl;

import data.dao.DataFactory;
import data.dao.hoteldao.HotelDao;
import data.dao.webstaffdao.WebManagerDao;
import data.dao.webstaffdao.WebSalesmanDao;
import data.daoimpl.webstaffdaoimpl.WebSalesmanDaoTXTImpl;

/**
 * Created by aa on 2016/12/2.
 */
public class DataFactoryDBImpl implements DataFactory {

    public HotelDao getHotelDao() {

        return null;
    }

    public WebManagerDao getWebManagerDao() {
        return null;
    }

    public WebSalesmanDao getWebSalesmanDao() {
        WebSalesmanDao webSalesmanDao= WebSalesmanDaoTXTImpl.getWebSalesmanDaoImplInstance();
        return webSalesmanDao;
    }
}
