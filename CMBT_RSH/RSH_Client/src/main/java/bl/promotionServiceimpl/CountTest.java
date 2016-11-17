package bl.promotionServiceimpl;

import constant.RoomType;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * 测试Count类
 * @author aa
 *
 */
public class CountTest {

	MockOrder order ;
	RoomType rType ;
	Date beginDate;
	Date endDate;
	String hotelID;
	@Before
	public void setup(){
		
	}
	
	
	@Test
	public void countPromotionOfOrder(){
		assertEquals("双十一特惠#1200",Count.countPromotionOfOrder(null));
	}
	
	@Test
	public void countPromotionOfRoom(){
		assertEquals("双十一特惠#120",Count.countPromotionOfRoom(hotelID, rType, 2, beginDate,endDate));

	}
	
	
}
