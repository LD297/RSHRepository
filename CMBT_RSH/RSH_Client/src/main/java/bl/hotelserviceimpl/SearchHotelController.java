package bl.hotelserviceimpl;

import constant.SortBy;
import constant.SortMethod;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import rmi.RemoteHelper;
import vo.DistrictHelper;
import vo.HotelVO;
import vo.SelectConditionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.hotelservice.SearchHotelService;
import bl.orderserviceimpl.OrderForHotelController;

/**
 * 根据条件搜索酒店, 兼顾搜索排序
 * 
 * @author aa
 *
 */
public class SearchHotelController implements SearchHotelService {
	private static HotelDao hotelDao = null;

	private void initRemote() {
		if (hotelDao == null) {
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			hotelDao = remoteHelper.getHotelDao();
		}
	}

	@Override
	public ArrayList<HotelVO> getHotelList(String province, String city, String area) {
		ArrayList<HotelPO> hotelPOs = new ArrayList<>();
		ArrayList<HotelVO> hotelVOs = new ArrayList<>();
		initRemote();
		DistrictHelper districtHelper = new DistrictHelper(province, city, area);
		try {
			hotelPOs = hotelDao.getHotelList(districtHelper.getDistrict());
		} catch (RemoteException e) {
			e.printStackTrace();
			return hotelVOs;
		}
		for (HotelPO hotelPO : hotelPOs) {
			hotelVOs.add(hotelPO.changeIntoVO());
		}
		return hotelVOs;
	}
	
	@Override
	public ArrayList<HotelVO> getHotelList() {
		initRemote();
		ArrayList<HotelPO> hotelPOs = new ArrayList<>();
		ArrayList<HotelVO> hotelVOs = new ArrayList<>();
		try {
			hotelPOs = hotelDao.getAll();
		} catch (RemoteException e) {
			e.printStackTrace();
			return hotelVOs;
		}
		for (HotelPO hotelPO : hotelPOs) {
			hotelVOs.add(hotelPO.changeIntoVO());
		}
		return hotelVOs;
	}
	
	@Override
	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList, SelectConditionVO selectConditionVO) {
		ArrayList<HotelVO> result = new ArrayList<>();
		for (HotelVO hotelVO : hotelList) {
			if (match(hotelVO, selectConditionVO)) {
				result.add(hotelVO);
			}
		}
		return result;
	}

	/**
	 * 内部调用 产看条件是否匹配
	 * 
	 * @param hotelVO
	 * @param selectConditionVO
	 * @return
	 */
	private boolean match(HotelVO hotelVO, SelectConditionVO selectConditionVO) {
		double standardPrice = hotelVO.getStandardRoomPrice();
		double grade = hotelVO.getGrade();
		if (standardPrice > selectConditionVO.highestPrice)
			return false;
		if (standardPrice < selectConditionVO.lowestPrice)
			return false;
		if (grade < selectConditionVO.lowestGrade)
			return false;
		if (grade > selectConditionVO.highestGrade)
			return false;
		if (selectConditionVO.level > 0) {
			if (selectConditionVO.level != hotelVO.getLevel()) {
				return false;
			}
		}

		String hotelID = hotelVO.getHotelID();
		if (selectConditionVO.roomNum > 0) {
			Hotel hotel = Hotel.getInstance(hotelID);
			if (!hotel.hasEnoughRoom(selectConditionVO.roomType, selectConditionVO.roomNum, selectConditionVO.begin,
					selectConditionVO.end))
				return false;
		}

		OrderForHotelController orderForHotelController = new OrderForHotelController();
		if (selectConditionVO.reserved) {
			if (!orderForHotelController.hasReserved(selectConditionVO.userID, hotelID))
				return false;
		}
		return true;
	}

	@Override
	public ArrayList<HotelVO> select(ArrayList<HotelVO> hotelList, String hotelName) {
		ArrayList<HotelVO> result = new ArrayList<>();
		for (HotelVO hotelVO : hotelList) {
			if (hotelVO.getHotelName().equals(hotelName)) {
				result.add(hotelVO);
			}
		}
		return result;
	}

	@Override
	public ArrayList<HotelVO> sort(ArrayList<HotelVO> hotelVOs, SortBy sortBy, SortMethod sortM) {
		for(int i=0;i<hotelVOs.size();i++){
			for(int j=0;j<i;j++){
				if (compare(hotelVOs.get(i), hotelVOs.get(j), sortBy, sortM)) {
					HotelVO hotelVO = hotelVOs.get(i);
					hotelVOs.remove(hotelVO);
					hotelVOs.add(j,hotelVO);
					break;
				}
			}
		}
		return hotelVOs;
	}

	/**
	 * 内部调用 if return true, hotelVO1 will be added just before hotelVO2
	 * 
	 * @param hotelVO1
	 * @param hotelVO2
	 * @param sortBy
	 * @param sortM
	 * @return
	 */
	private boolean compare(HotelVO hotelVO1, HotelVO hotelVO2, SortBy sortBy, SortMethod sortM) {
		double difference = 0;
		switch (sortBy) {
		case price:
			difference = hotelVO2.getStandardRoomPrice() - hotelVO1.getStandardRoomPrice();
			break;
		case level:
			difference = hotelVO2.getLevel() - hotelVO1.getLevel();
			break;
		case grade:
			difference = hotelVO2.getGrade() - hotelVO1.getGrade();
			break;
		default:
			break;
		}
		if (sortM == SortMethod.dscend) {
			difference = difference * -1;
		}
		if (difference > 0)
			return true;
		else
			return false;
	}

	

}
