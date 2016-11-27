package bl.hotelserviceimpl;

import constant.SortBy;
import constant.SortMethod;
import data.dao.hoteldao.HotelDao;
import vo.HotelVO;
import vo.SelectConditionVO;

import java.util.ArrayList;

public class SearchHotel {

	HotelDao hotelDao;
	
	private SortHotel sortHotel;
	private SelectHotel selectHotel;
	
	public void setSort(SortHotel sort) {
		this.sortHotel = sort;
	}

	public void setSelect(SelectHotel select) {
		this.selectHotel = select;
	}

	public void setHotelDao(HotelDao hotelDao){this.hotelDao = hotelDao;}

	public ArrayList<HotelVO> getHotelList(String address, String businessArea) {
		return hotelDao.getHotelList(address, businessArea);
	}

	public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM) {
		return sortHotel.sort(sortBy, sortM);
	}

	public ArrayList<HotelVO> select(SelectConditionVO vo) {
		return selectHotel.select(vo);
	}

	public HotelVO getHotelInfo(String id) {
		HotelVO hotelVO = HotelVO.createHotelVO(hotelDao.getHotelInfo(id));
		return hotelVO;
	}
}
