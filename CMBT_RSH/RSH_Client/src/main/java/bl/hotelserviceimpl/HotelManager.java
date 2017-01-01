package bl.hotelserviceimpl;

import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.HotelPO;
import po.RoomPO;
import rmi.RemoteHelper;
import vo.HotelVO;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 
 * @author aa
 *
 */
public class HotelManager {

	String hotelID;
	HotelDao hotelDao = null;
	
	private void initRemote(){
		if(hotelDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			hotelDao = remoteHelper.getHotelDao();
		}
	}
	
	private HotelManager(String hotelID) {
		this.hotelID = hotelID;
	}
	
	public ResultMessage updateHotel(HotelVO vo) {
		ResultMessage resultMessage = null;
		initRemote();
		try {
			resultMessage = hotelDao.updateHotel(vo.changeIntoPO());
		}catch (RemoteException e){
			return ResultMessage.remote_fail;
		}
		return resultMessage;
	}

	public static HotelManager getInstance(String hotelID) {
		return new HotelManager(hotelID);
	}
	
	
	
}
