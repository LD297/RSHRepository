package bl.orderserviceimpl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import constant.ResultMessage;
import constant.RoomType;
import po.OrderPO;
import vo.RoomNormVO;

public class InitialOrderTest {
    @Test
    public void testgetDiscounted() throws ParseException{//promotion
    	
    	InitialOrder initial = new InitialOrder();
       
    	SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
    	String strin = "2016-11-07";
    	String strout = "2016-11-11";
    	Date in = format.parse(strin);
    	Date out = format.parse(strout);
    	
    	ArrayList<RoomNormVO> type = new ArrayList<RoomNormVO>();
    	type.add(new RoomNormVO("2153001234",RoomType.singleRoom,120.0));
    	type.add(new RoomNormVO("2153001234",RoomType.doubleRoom,200.0));
    	 
    	int nums[] = {1,3};
    	OrderPO order = new OrderPO("2016-11-062153001234000000","123456789","2153001234",type,nums,3,false,0,0,"","GOOD",0,in,out);
        
    	assertEquals(1200,(int)Double.parseDouble(initial.getDiscount(order).split("#")[1]) );

    }
/*   @Test
    public void testadd(OrderPO order){//user
    	MockCreditRecordList mockCredit = new MockCreditRecordList("123456789");
    	initialOrder initial = new initialOrder(); 
    	
    	initial.setCreditRecordList(mockCredit);
    }
*/
}
