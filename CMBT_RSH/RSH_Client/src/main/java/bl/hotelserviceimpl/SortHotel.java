package bl.hotelserviceimpl;

import constant.SortBy;
import constant.SortMethod;
import data.dao.hoteldao.HotelDao;
import vo.HotelVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class SortHotel {
	HotelDao hotelDao;

	public SortHotel(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM) {
		ArrayList<HotelVO> hotelVOs = null;
		try {
			hotelVOs = hotelDao.sort(sortBy, sortM);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return hotelVOs;
	}
}
