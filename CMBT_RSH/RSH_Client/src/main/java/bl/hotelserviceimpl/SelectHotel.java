package bl.hotelserviceimpl;

import java.util.ArrayList;

import data.dao.hoteldao.HotelDao;
import vo.HotelVO;
import vo.SelectConditionVO;

public class SelectHotel{
	HotelDao hotelDao;
	public ArrayList<HotelVO> select(SelectConditionVO vo) {
		return hotelDao.select(vo);
	}
	
}
