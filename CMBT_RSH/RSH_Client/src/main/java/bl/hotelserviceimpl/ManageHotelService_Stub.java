package bl.hotelserviceimpl;

import bl.hotelservice.ManagerHotelService;
import constant.ResultMessage;
import vo.HotelStaffVO;
import vo.HotelVO;

public class ManageHotelService_Stub implements ManagerHotelService{

	@Override
	public String getHotelID(String district) {
		// TODO Auto-generated method stub
		return "1100110010";
	}

	@Override
	public ResultMessage addHotel(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage updateHotelStaff(HotelStaffVO hotelStaffVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
