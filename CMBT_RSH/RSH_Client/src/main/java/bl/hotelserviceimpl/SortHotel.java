package bl.hotelserviceimpl;

import constant.SortBy;
import constant.SortMethod;
import data.dao.hoteldao.HotelDao;
import vo.HotelVO;

import java.util.ArrayList;

public class SortHotel {
	HotelDao hotelDao;

	public SortHotel(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM) {
		return hotelDao.sort(sortBy, sortM);
	}
}
