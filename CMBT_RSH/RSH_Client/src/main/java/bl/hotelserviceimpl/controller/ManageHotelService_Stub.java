package bl.hotelserviceimpl.controller;

import bl.hotelservice.ManagerHotelService;
import constant.ResultMessage;
import vo.HotelStaffVO;
import vo.HotelVO;

public class ManageHotelService_Stub implements ManagerHotelService{

	@Override
	public String getHotelID(String district) {
		// TODO Auto-generated method stub
		return district+"0010";
	}

	@Override
	public ResultMessage addHotel(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

}
