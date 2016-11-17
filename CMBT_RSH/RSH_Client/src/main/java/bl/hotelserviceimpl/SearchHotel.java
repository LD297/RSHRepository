package bl.hotelserviceimpl;

import java.util.ArrayList;

import constant.SortBy;
import constant.SortMethod;
import vo.HotelVO;
import vo.SelectConditionVO;

public class SearchHotel {
	
	private SortHotel sortHotel;
	private SelectHotel selectHotel;
	
	public void setSort(SortHotel sort) {
		this.sortHotel = sort;
	}

	public void setSelect(SelectHotel select) {
		this.selectHotel = select;
	}

	public ArrayList<HotelVO> getHotelList(String address, String businessArea) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM) {
		return sortHotel.sort(sortBy, sortM);
	}

	public ArrayList<HotelVO> select(SelectConditionVO vo) {
		return selectHotel.select(vo);
	}

	public HotelVO getHotelInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
