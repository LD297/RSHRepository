package bl.hotelservice;

import constant.*;
import vo.*;

public interface WMHotelService {
	public int getHotelNum(String address);
	public ResultMessage addHotel(String id,String password);
	public ResultMessage deleteHotel(String id);
	public ResultMessage updateHotelStaff(HotelStaffVO hotelStaffVO);
}
