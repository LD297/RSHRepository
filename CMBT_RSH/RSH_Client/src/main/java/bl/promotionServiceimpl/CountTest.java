package bl.promotionServiceimpl;

import static org.junit.Assert.*;

import java.util.Date;

import constant.MemberType;
import org.junit.Before;
import org.junit.Test;

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
		assertEquals("#200",Count.countPromotionOfRoom(hotelID, rType, 2,100, beginDate,endDate,
				null, MemberType.commerce,3));

	}
	
	
}
