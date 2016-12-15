package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import po.HotelStaffPO;
import vo.HotelStaffVO;

import java.rmi.RemoteException;

public class ManagerHotel{

	HotelDao hotelDao;

	public ManagerHotel(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public String getHotelID(String district) {
		String hotelID = null;
		try {
			hotelID = hotelDao.getHotelID(district);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return hotelID;
	}

	public ResultMessage addHotel(String id, String password) {
		HotelPO newHotelPO = new HotelPO(id);
		newHotelPO.setPassword(password);
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.addHotel(newHotelPO);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}


	public ResultMessage updateHotelStaff(HotelStaffVO hotelStaffVO) {
		HotelStaffPO hotelStaffPO = new HotelStaffPO(hotelStaffVO.hotelID, hotelStaffVO.tel);
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.updateHotelStaff(hotelStaffPO);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}

}
