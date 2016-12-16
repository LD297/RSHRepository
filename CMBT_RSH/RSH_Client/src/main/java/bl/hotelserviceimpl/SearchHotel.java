package bl.hotelserviceimpl;

import constant.SortBy;
import constant.SortMethod;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import rmi.RemoteHelper;
import vo.HotelVO;
import vo.SelectConditionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.regex.Matcher;

import bl.hotelservice.SearchHotelService;

/**
 * 根据条件搜索酒店, 兼顾搜索排序
 * @author aa
 *
 */
public class SearchHotel implements SearchHotelService{
private static HotelDao hotelDao = null;
	
	private void initRemote(){
		if(hotelDao==null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			hotelDao = remoteHelper.getHotelDao();
		}
	}
	public HotelVO getHotelInfo(String hotelID) {
		Hotel hotel = Hotel.getInstance(hotelID);
		HotelVO hotelVO = hotel.getHotelInfo();
		return hotelVO;
	}

	public ArrayList<HotelVO> getHotelList(String address, String businessArea) {
		ArrayList<HotelPO> hotelPOs = null;
		try {
			hotelPOs = hotelDao.getHotelList(address, businessArea);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		ArrayList<HotelVO> hotelVOs = new ArrayList<>();
		for(HotelPO hotelPO: hotelPOs){
			hotelVOs.add(hotelPO.changeIntoVO());
		}
		return hotelVOs;
	}

	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList,SelectConditionVO selectConditionVO) {
		ArrayList<HotelVO> result = new ArrayList<>();
		for(HotelVO hotelVO:hotelList){
			if(match(hotelVO,selectConditionVO)){
				result.add(hotelVO);
			}
		}
		
		return result;
	}

	private boolean match(HotelVO hotelVO, SelectConditionVO selectConditionVO) {
		// TODO Auto-generated method stub
		return false;
	}
	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList,String hotelName) {
		ArrayList<HotelVO> result = new ArrayList<>();
		for(HotelVO hotelVO:hotelList){
			if(hotelVO.name==hotelName){
				result.add(hotelVO);
			}
		}
		return result;
	}
	
	@Override
	public ArrayList<HotelVO> sort(ArrayList<HotelVO> hotelList, SortBy sortBy, SortMethod sortM) {
		// TODO Auto-generated method stub
		ArrayList<HotelVO> result = new ArrayList<>();
		
		return result;
	}
	

	
}
