package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import data.dao.hoteldao.HotelDao_Stub;
import org.junit.Test;
import vo.HotelStaffVO;

import static org.junit.Assert.assertEquals;

/**
 * Created by a297 on 16/11/20.
 */
public class WMHotelTest {

    WMHotel wMHotel;

    public WMHotelTest(){
        HotelDao hotelDao = new HotelDao_Stub();
        wMHotel  = new WMHotel(hotelDao);
    }

    @Test
    public void getHotelNum() {
        String address = "南京市白下区";
        assertEquals(1, wMHotel.getHotelNum(address));
    }

    @Test
    public void addHotel() {
        String id = "6666666666";
        String password = "2333";
        assertEquals(ResultMessage.succeed, wMHotel.addHotel(id, password));
    }

    @Test
    public void deleteHotel() {
        String id = "2333333333";
        assertEquals(ResultMessage.succeed, wMHotel.deleteHotel(id));
    }

    @Test
    public void updateHotelStaff() {
        HotelStaffVO hotelStaffVO = new HotelStaffVO("6666666666", "12312312312");
        assertEquals(ResultMessage.succeed, wMHotel.updateHotelStaff(hotelStaffVO));
    }
}
