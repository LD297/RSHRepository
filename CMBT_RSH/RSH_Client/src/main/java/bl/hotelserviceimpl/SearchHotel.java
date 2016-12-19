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
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;

import org.omg.CORBA.ShortHolder;

import bl.hotelservice.SearchHotelService;
import bl.userserviceimpl.User;
import bl.userserviceimpl.UserController;

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
/**
 * public String roomType;??
	public int roomNum;
	public Date begin;
	public Date end;
	public String userID;
	public Boolean reserved;
 * @param hotelVO
 * @param selectConditionVO
 * @return
 */
	private boolean match(HotelVO hotelVO, SelectConditionVO selectConditionVO) {
		// TODO Auto-generated method stub
		double standardPrice = hotelVO.standardRoomPrice;
		if(standardPrice>selectConditionVO.highestPrice)
			return false;
		if(standardPrice<selectConditionVO.lowestPrice)
			return false;
		if(hotelVO.grade<selectConditionVO.lowestGrade)
			return false;
		if(hotelVO.grade>selectConditionVO.highestGrade)
			return false;
		if(hotelVO.level!=selectConditionVO.level)
			return false;
		String hotelID = hotelVO.hotelID;
		Hotel hotel = Hotel.getInstance(hotelID);
		if(!hotel.hasEnoughRoom(selectConditionVO.roomType,selectConditionVO.roomNum
				,selectConditionVO.begin,selectConditionVO.end))
			return false;
		UserController userController = new UserController();
		if(selectConditionVO.reserved){
			if(!userController.hasReserved(selectConditionVO.userID,hotelID))
				return false;
		}
		return true;
	}
	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList,String hotelName) {
		ArrayList<HotelVO> result = new ArrayList<>();
		for(HotelVO hotelVO:hotelList){
			if(hotelVO.name.equals(hotelName)){
				result.add(hotelVO);
			}
		}
		return result;
	}
	
	@Override
	public ArrayList<HotelVO> sort(ArrayList<HotelVO> hotelList, SortBy sortBy, SortMethod sortM) {
		// TODO Auto-generated method stub
		switch (sortBy) {
		case grade:
			return sortByGrade(hotelList);
		case level:
			return sortByLevel(hotelList);
		case price:
			return sortByPrice(hotelList);
		default:
			break;
		}
		return hotelList;
	}
	
	private ArrayList<HotelVO> sortByPrice(ArrayList<HotelVO> hotelList) {
		// TODO Auto-generated method stub
		Map<Double, HotelVO>  map = null ;
		return null;
	}
	private ArrayList<HotelVO> sortByLevel(ArrayList<HotelVO> hotelList) {
		// TODO Auto-generated method stub
		return null;
	}
	private ArrayList<HotelVO> sortByGrade(ArrayList<HotelVO> hotelList) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<HotelVO> sortHelper(){
		return null;
	}
	
	@Override
	public ArrayList<HotelVO> getHotelList() {
		// TODO Auto-generated method stub
		initRemote();
		ArrayList<HotelPO> hotelPOs = new ArrayList<>();
		ArrayList<HotelVO> hotelVOs = new ArrayList<>();
		try {
			hotelPOs = hotelDao.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return hotelVOs;
		}
		for(HotelPO hotelPO:hotelPOs){
			hotelVOs.add(hotelPO.changeIntoVO());
		}
		return hotelVOs;
	}
	

	
}
