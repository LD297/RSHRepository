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

	public ArrayList<HotelVO> select(SelectConditionVO vo) {
		ArrayList<HotelVO> hotelVOs = null;
		try {
			hotelVOs = hotelDao.select(vo);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return hotelVOs;
	}
	
}
