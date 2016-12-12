package bl.hotelserviceimpl;

import bl.hotelservice.SearchHotelService;
import constant.SortBy;
import constant.SortMethod;
import vo.HotelVO;
import vo.SelectConditionVO;

import java.util.ArrayList;

public class SearchHotelController implements SearchHotelService {

	private SearchHotel searchHotel;

	public SearchHotelController() {
		this.searchHotel = new SearchHotel();
	}

	@Override
	public ArrayList<HotelVO> getHotelList(String address, String businessArea) {
		return searchHotel.getHotelList(address, businessArea);
	}

	@Override
	public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM) {
		return searchHotel.sort(sortBy, sortM);
	}

	@Override
	public ArrayList<HotelVO> select(SelectConditionVO vo) {
		return searchHotel.select(vo);
	}

	@Override
	public HotelVO getHotelInfo(String id) {
		return searchHotel.getHotelInfo(id);
	}

}
