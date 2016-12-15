package bl.hotelserviceimpl.hotel_stub;

import java.util.ArrayList;

import bl.hotelservice.SearchHotelService;
import constant.SortBy;
import constant.SortMethod;
import vo.HotelVO;
import vo.SelectConditionVO;

public class SearchHotelService_Stub implements SearchHotelService{

	@Override
	public ArrayList<HotelVO> getHotelList(String address, String businessArea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelVO> sort(ArrayList<HotelVO> hotelList, SortBy sortBy, SortMethod sortM) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList, SelectConditionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList, String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}

}
