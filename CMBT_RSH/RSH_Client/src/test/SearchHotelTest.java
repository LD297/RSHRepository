package bl.hotelserviceimpl;

import static org.junit.Assert.*;

import data.dao.hoteldao.HotelDao;
import data.dao.hoteldao.HotelDao_Stub;
import org.junit.Test;


public class SearchHotelTest {

	SearchHotel searchHotel;

	public SearchHotelTest(){

		HotelDao hotelDao = new HotelDao_Stub();

		searchHotel = new SearchHotel();
		searchHotel.setSort(new SortHotel(hotelDao));
		searchHotel.setSelect(new SelectHotel(hotelDao));
		searchHotel.setHotelDao(hotelDao);
		
	}
	
	@Test
	public void sortTest(){
		assertEquals("2333333333", searchHotel.sort(null, null).get(0).id);
	}
	
	@Test
	public void selectTest(){
		assertEquals("2333333333", searchHotel.select(null).get(0).id);
	}

}
