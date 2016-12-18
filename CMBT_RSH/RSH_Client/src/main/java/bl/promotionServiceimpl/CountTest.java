package bl.promotionServiceimpl;

import static org.junit.Assert.*;

import java.util.Date;

import constant.MemberType;
import org.junit.Before;
import org.junit.Test;

import bl.orderserviceimpl.miscellaneous.MockOrder;
import bl.promotionServiceimpl.condition.OrderInfo;

/**
 * 测试Count类
 * @author aa
 *
 */
public class CountTest {

	MockOrder order ;
	String rType ;
	Date beginDate;
	Date endDate;
	String hotelID;
	@Before
	public void setup(){
		
	}

	
	@Test
	public void countPromotionOfRoom(){
		assertEquals("#200",Count.countPromotionOfRoom(
				new OrderInfo(hotelID, rType, 2, 100.0, "12345678901")));

	}
	
	
}
