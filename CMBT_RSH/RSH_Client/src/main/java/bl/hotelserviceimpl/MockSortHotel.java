package bl.hotelserviceimpl;

import java.util.ArrayList;

import constant.SortBy;
import constant.SortMethod;
import vo.HotelVO;

/**
 * 测试searchhotel对sorthotel的调用
 * @author a297
 *
 */
public class MockSortHotel extends SortHotel{
	public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM) {
		ArrayList<HotelVO> list = new ArrayList<HotelVO>();
		list.add(new HotelVO("Constant"));
		return list;
	}
}
