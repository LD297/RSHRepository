package bl.hotelserviceimpl;

import static org.junit.Assert.*;

import org.junit.Test;


public class SearchHotelTest {

	SearchHotel searchHotel = new SearchHotel();
	public SearchHotelTest(){
		
		searchHotel.setSort(new MockSortHotel());
		searchHotel.setSelect(new MockSelectHotel());
		
	}
	
	@Test
	public void sortTest(){
		assertEquals("Constant", searchHotel.sort(null, null).get(0).id);
	}
	
	@Test
	public void selectTest(){
		assertEquals("TinyTimes", searchHotel.select(null).get(0).id);
	}

}
