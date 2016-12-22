package bl.hotelservice;

import constant.ResultMessage;
import vo.HotelStaffVO;
import vo.HotelVO;

public interface ManagerHotelService {

	/**
	 *  网站管理人员注册酒店账号时，根据商圈得到账号
	 * @param district
	 * @return
	 */
	public String getHotelID(String district);

	/**
	 * 网站管理人员注册酒店账号时，（初始化密码后，点击确认）注册成功，生成酒店
	 * @param hotelVO
	 * @return
	 */
	public ResultMessage addHotel(HotelVO hotelVO);

	/**
	 *  网站管理人员更新酒店工作人员信息（酒店工作人员信息：酒店id，联系方式）
	 * @param hotelStaffVO
	 * @return
	 */
	public ResultMessage updateHotelStaff(HotelStaffVO hotelStaffVO);
}
