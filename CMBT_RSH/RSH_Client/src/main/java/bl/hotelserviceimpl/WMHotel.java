package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.*;
import vo.*;

public class WMHotel{

	HotelDao hotelDao;

	public int getHotelNum(String address) {
		return hotelDao.getHotelNum(address);
	}

	public ResultMessage addHotel(String id, String password) {
		HotelPO newHotelPO = new HotelPO(id);
		newHotelPO.setPassword(password);
		return hotelDao.addHotel(newHotelPO);
	}

	public ResultMessage deleteHotel(String id) {
		return hotelDao.deleteHotel(id);
	}

	public ResultMessage updateHotelStaff(HotelStaffVO hotelStaffVO) {
		HotelStaffPO hotelStaffPO = new HotelStaffPO(hotelStaffVO.hotelID, hotelStaffVO.tel);
		return hotelDao.updateHotelStaff(hotelStaffPO);
	}

}
