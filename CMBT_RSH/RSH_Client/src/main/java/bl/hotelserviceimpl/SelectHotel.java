package bl.hotelserviceimpl;

import data.dao.hoteldao.HotelDao;
import vo.HotelVO;
import vo.SelectConditionVO;

import java.util.ArrayList;

public class SelectHotel{
	HotelDao hotelDao;

	public SelectHotel(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public ArrayList<HotelVO> select(SelectConditionVO vo) {
		return hotelDao.select(vo);
	}
	
}
