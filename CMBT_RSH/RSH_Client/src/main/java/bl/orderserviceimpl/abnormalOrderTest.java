package bl.orderserviceimpl;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import po.OrderPO;
import vo.RoomNormVO;
import constant.ResultMessage;
import constant.RoomType;

public class abnormalOrderTest {
    @Test
	public void testwebCancelAbnormal() throws ParseException{
    	MockCreditRecordList mockCredit = new MockCreditRecordList("123456789");
    	abnormalOrder abnormal = new abnormalOrder();
    	abnormal.setCreditRecordList(mockCredit);
    	
    	SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
    	String strin = "2016-11-07";
    	String strout = "2016-11-11";
    	Date in = format.parse(strin);
    	Date out = format.parse(strout);
    	
    	ArrayList<RoomNormVO> type = new ArrayList<RoomNormVO>();
    	type.add(new RoomNormVO("2153001234",RoomType.singleRoom,120.0));
    	type.add(new RoomNormVO("2153001234",RoomType.doubleRoom,200.0));
    	 
    	int nums[] = {1,3};
    	OrderPO order = new OrderPO("2016-11-072153001234000000","123456789","2153001234",type,nums,0,0,"","��������",0,in,out);
       
    	abnormal.setOrder(order);
    	
    	assertEquals(ResultMessage.success,abnormal.webCancelAbnormal("2016-11-072153001234000000"));
    }
}
