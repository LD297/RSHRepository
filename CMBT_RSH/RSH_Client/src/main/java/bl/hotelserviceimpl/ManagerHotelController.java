package bl.hotelserviceimpl;

import java.rmi.RemoteException;

import bl.hotelservice.ManagerHotelService;
import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import rmi.RemoteHelper;
import vo.HotelVO;

public class ManagerHotelController implements ManagerHotelService{

	/**
	 *  网站管理人员注册酒店账号时，根据地址（得到数量－>） 得到账号
	 */
	@Override
	public String getHotelID(String district){
		String hotelID = null;
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		HotelDao hotelDao = remoteHelper.getHotelDao();
		try {
			hotelID = hotelDao.getNewHotelID(district);
		}catch (RemoteException e){
			e.printStackTrace();
			return "remote_fail";
		}
		return hotelID;
	}

	/**
	 * 网站管理人员注册酒店账号时，（初始化密码后，点击确认）注册成功，生成酒店
	 */
	@Override
	public ResultMessage addHotel(HotelVO hotelVO){
		return Hotel.addHotel(hotelVO);
	}
}
