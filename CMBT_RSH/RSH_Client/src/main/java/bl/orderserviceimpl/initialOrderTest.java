package bl.orderserviceimpl;

/**
 * Created by sky-PC on 2016/12/4.
 */

import po.OrderPO;
import vo.RoomNormVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by john on 2016/11/27.
 */
public class InitialOrderTest {
    @Test
    public void testgetDiscounted() throws ParseException {//promotion

        InitialOrder initial = new InitialOrder();

        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        String strin = "2016-11-07";
        String strout = "2016-11-11";
        Date in = format.parse(strin);
        Date out = format.parse(strout);

        ArrayList<RoomNormVO> type = new ArrayList<RoomNormVO>();
        type.add(new RoomNormVO("2153001234", "singleRoom",120.0));
        type.add(new RoomNormVO("2153001234","doubleRoom",200.0));

        int nums[] = {1,3};
        OrderPO order = null;

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


