package bl.orderserviceimpl;

import static org.junit.Assert.*;

import org.junit.Test;

import constant.ResultMessage;

public class normalOrderTest {
	@Test
	public void testComment(){
        MockComment mockComment = new MockComment("2153001234","123456789");
        normalOrder normal= new normalOrder();
        
        normal.setCommentImpl(mockComment);
        assertEquals(ResultMessage.fail,normal.comment("2153001234","2016-11-062153001234000000",80,"������"));
    }
 /*   @Test
	public void testcancelMyOrder(){
		MockCreditRecordList mockCredit = new MockCreditRecordList("123456789");
		normalOrder normal = new normalOrder();
		normal.setCreditRecordList(mockCredit);
		
		normal.cancelMyOrder("2016-11-072153001234000000");
	}
*/
	@Test
	public void testexecute(){
		MockCreditRecordList mockCredit = new MockCreditRecordList("123456789");
		normalOrder normal = new normalOrder();
		normal.setCreditRecordList(mockCredit);
		
		assertEquals(ResultMessage.succeed,normal.execute("2016-11-072153001234000000"));
		   
	}
/*  @Test
	public void testsetAbnormal(String orderid){
		MockCreditRecordList mockCredit = new MockCreditRecordList("123456789");
		normalOrder normal = new normalOrder();
		normal.setCreditRecordList(mockCredit);
		
		normal.setAbnormal("2016-11-072153001234000000");
	}
*/
}
