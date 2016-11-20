package bl.hotelserviceimpl;

import bl.hotelservice.WMHotelService;
import constant.ResultMessage;
import vo.*;

public class WMHotelController implements WMHotelService{

	WMHotel webManageHotel;

	public WMHotelController(WMHotel webManageHotel) {
		this.webManageHotel = webManageHotel;
	}

	@Override
	public int getHotelNum(String address) {
		return webManageHotel.getHotelNum(address);
	}

	@Override
	public ResultMessage addHotel(String id, String password) {
		return webManageHotel.addHotel(id, password);
	}

	@Override
	public ResultMessage deleteHotel(String id) {
		return webManageHotel.deleteHotel(id);
	}

	@Override
	public ResultMessage updateHotelStaff(HotelStaffVO hotelStaffVO) {
		return webManageHotel.updateHotelStaff(hotelStaffVO);
	}

}
