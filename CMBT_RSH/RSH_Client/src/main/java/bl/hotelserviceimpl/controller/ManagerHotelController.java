package bl.hotelserviceimpl.controller;

import bl.hotelservice.ManagerHotelService;
import bl.hotelserviceimpl.Hotel;
import bl.hotelserviceimpl.WebManagerHotel;
import constant.ResultMessage;
import vo.HotelStaffVO;
import vo.HotelVO;

public class ManagerHotelController implements ManagerHotelService{



	// 网站管理人员注册酒店账号时，根据地址（得到数量－>） 得到账号
	@Override
	public String getHotelID(String district){
		return WebManagerHotel.getHotelID(district);
	}

	// 网站管理人员注册酒店账号时，（初始化密码后，点击确认）注册成功，生成酒店
	@Override
	public ResultMessage addHotel(HotelVO hotelVO){
		return Hotel.addHotel(hotelVO);
	}

	// 网站管理人员更新酒店工作人员信息（酒店工作人员信息：酒店id，联系方式）
	@Override
	public ResultMessage updateHotelStaff(HotelStaffVO hotelStaffVO){
		return WebManagerHotel.updateHotelStaff(hotelStaffVO);
	}

}
