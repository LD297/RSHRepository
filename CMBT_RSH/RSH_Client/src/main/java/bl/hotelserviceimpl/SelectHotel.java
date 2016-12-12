package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import vo.HotelVO;
import vo.SelectConditionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class SelectHotel{
	HotelDao hotelDao;

	public SelectHotel(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList,SelectConditionVO vo) {
		ArrayList<HotelVO> hotelVOs = null;

		return hotelVOs;
	}


	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList,String hotelName) {
		ArrayList<HotelVO> hotelVOs = null;

		return hotelVOs;
	}
	
}
