package data.dao;
import data.dao.hoteldao.HotelDao;
import data.dao.promotiondao.PromotionDao;
import data.dao.webstaffdao.WebManagerDao;
import data.dao.webstaffdao.WebSalesmanDao;

/**
 * Created by a297 on 16/11/27.
 */
public interface DataFactory {

    public HotelDao getHotelDao();

    public WebManagerDao getWebManagerDao();

    public WebSalesmanDao getWebSalesmanDao();

}
