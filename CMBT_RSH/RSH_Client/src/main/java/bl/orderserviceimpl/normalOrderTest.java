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
        assertEquals(ResultMessage.failure,normal.comment("2153001234","2016-11-062153001234000000",80,"»¹²»´í"));
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
		
		assertEquals(ResultMessage.success,normal.execute("2016-11-072153001234000000"));
		   
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
