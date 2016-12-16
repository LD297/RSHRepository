package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import rmi.RemoteHelper;
import vo.HotelStaffVO;
import vo.HotelVO;

import java.rmi.RemoteException;

public class WebManagerHotel{

	private static HotelDao hotelDao = null;

	private void initRemote(){
		if(hotelDao==null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			hotelDao = remoteHelper.getHotelDao();
		}		
	}

	public static String getHotelID(String district) {
		String hotelID = null;
		try {
			hotelID = hotelDao.getNewHotelID(district);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return hotelID;
	}

	public static ResultMessage updateHotelStaff(HotelStaffVO hotelStaffVO) {
		// TODO Auto-generated method stub
		return null;
	}

/**
 * what is this for???
 * is there any need to transfer hotelStaffPO???
 * @param hotelStaffVO
 * @return
 */
	/**
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
*/
}
