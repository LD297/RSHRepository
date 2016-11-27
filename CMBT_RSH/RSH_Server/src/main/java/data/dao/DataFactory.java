package data.dao;
import data.dao.hoteldao.HotelDao;

/**
 * Created by a297 on 16/11/27.
 */
public interface DataFactory {
    public HotelDao getHotelDao();
}
