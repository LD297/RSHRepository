package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import po.HotelStaffPO;
import vo.HotelStaffVO;

import java.rmi.RemoteException;

public class WMHotel{

	HotelDao hotelDao;

	public WMHotel(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public int getHotelNum(String address) {
		int hotelNum = 0;
		try {
			hotelNum = hotelDao.getHotelNum(address);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return hotelNum;
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

	public ResultMessage deleteHotel(String id) {
		ResultMessage resultMessage = null;
		try {
			resultMessage = hotelDao.deleteHotel(id);
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
