package bl.hotelserviceimpl;

import constant.SortBy;
import constant.SortMethod;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import vo.HotelVO;
import vo.SelectConditionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class SearchHotel {

	HotelDao hotelDao;
	
	private SortHotel sortHotel;
	private SelectHotel selectHotel;
	
	public void setSort(SortHotel sort) {
		this.sortHotel = sort;
	}

	public void setSelect(SelectHotel select) {
		this.selectHotel = select;
	}

	public void setHotelDao(HotelDao hotelDao){this.hotelDao = hotelDao;}

	public ArrayList<HotelVO> getHotelList(String address, String businessArea) {
		ArrayList<HotelVO> hotelVOs = null;
		try {
			hotelVOs = hotelDao.getHotelList(address, businessArea);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return hotelVOs;
	}

	public ArrayList<HotelVO> sort(SortBy sortBy, SortMethod sortM) {
		return sortHotel.sort(sortBy, sortM);
	}

	public ArrayList<HotelVO> select(SelectConditionVO vo) {
		return selectHotel.select(vo);
	}

	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList,SelectConditionVO vo) {
		return selectHotel.select(hotelList,vo);
	}

	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList,String hotelName) {
		return selectHotel.select(hotelList,hotelName);
	}
	public HotelVO getHotelInfo(String id) {
		HotelPO hotelPO = null;
		try {
			hotelPO = hotelDao.getHotelInfo(id);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		HotelVO hotelVO = HotelVO.createHotelVO(hotelPO);
		return hotelVO;
	}
}
