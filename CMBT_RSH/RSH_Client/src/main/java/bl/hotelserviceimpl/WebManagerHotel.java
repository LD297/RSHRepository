package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import rmi.RemoteHelper;
import vo.HotelStaffVO;
import vo.HotelVO;

import java.rmi.RemoteException;

import javax.naming.InitialContext;

public class WebManagerHotel{

	private static HotelDao hotelDao = null;

	private static void initRemote(){
		if(hotelDao==null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			hotelDao = remoteHelper.getHotelDao();
		}		
	}

	public static String getHotelID(String district) {
		String hotelID = null;
		initRemote();
		try {
			hotelID = hotelDao.getNewHotelID(district);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return hotelID;
	}

}
