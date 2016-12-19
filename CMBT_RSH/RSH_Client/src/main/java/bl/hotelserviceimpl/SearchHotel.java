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

	public ArrayList<HotelVO> getHotelList(String province, String city, String area) {
		ArrayList<HotelPO> hotelPOs = new ArrayList<>();
		ArrayList<HotelVO> hotelVOs = new ArrayList<>();
		try {
			hotelPOs = hotelDao.getHotelList(province);
		}catch (RemoteException e){
			e.printStackTrace();
			return hotelVOs;
		}
		hotelVOs = new ArrayList<>();
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
	public ArrayList<HotelVO> sort(ArrayList<HotelVO> hotelVOs, SortBy sortBy, SortMethod sortM) {
		// TODO Auto-generated method stub
		ArrayList<HotelVO> newHotelVOs = new ArrayList<>();
		for(HotelVO hotelVO1:hotelVOs){
			boolean hasBeenSet = false;
			for(HotelVO hotelVO2:newHotelVOs){
				if(compare(hotelVO1,hotelVO2,sortBy,sortM)){
					newHotelVOs.add(newHotelVOs.indexOf(hotelVO2), hotelVO1);
					hasBeenSet = true;
				}			
			}
			if(!hasBeenSet){
				newHotelVOs.add(hotelVO1);
			}	
		}
		return newHotelVOs;
	}
	
	/**
	 * if return true,
	 * hotelVO1 will be added just before hotelVO2
	 * @param hotelVO1
	 * @param hotelVO2
	 * @param sortBy
	 * @param sortM
	 * @return
	 */
	private boolean compare(HotelVO hotelVO1, HotelVO hotelVO2, SortBy sortBy, SortMethod sortM) {
		// TODO Auto-generated method stub
		double difference = 0;
		switch (sortBy) {
		case price:
			difference = hotelVO2.standardRoomPrice-hotelVO1.standardRoomPrice;
			break;	
		case level:
			difference = hotelVO2.level-hotelVO1.level;
			break;
		case grade:
			difference= hotelVO2.grade-hotelVO1.grade;
			break;
		default:
			break;
		}
		if(sortM==SortMethod.dscend){
			difference=difference*-1;
		}
		if(difference>0)
			return true;
		else
			return false;
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
