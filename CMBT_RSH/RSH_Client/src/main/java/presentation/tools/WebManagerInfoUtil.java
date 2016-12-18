package presentation.tools;

import java.util.ArrayList;

import bl.hotelservice.ManagerHotelService;
import bl.hotelservice.SearchHotelService;
import bl.hotelserviceimpl.ManageHotelService_Stub;
import bl.hotelserviceimpl.SearchHotelService_Stub;
import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginService_Stub;
import bl.userservice.UserService;
import bl.userserviceimpl.UserService_Stub;
import bl.webstaffservice.WebStaffService;
import bl.webstaffserviceimpl.WebStaffService_Stub;
import constant.ResultMessage;
import constant.Role;
import vo.DistrictHelper;
import vo.HotelVO;
import vo.UserVO;
import vo.WebSalesmanVO;

public class WebManagerInfoUtil {
	private static WebManagerInfoUtil webManagerInfoUtil = null;
	private LoginService loginService = new LoginService_Stub();
	private UserService userService = new UserService_Stub();
	private SearchHotelService searchHotelService = new SearchHotelService_Stub();
	private WebStaffService webStaffService = new WebStaffService_Stub();
	private ManagerHotelService managerHotelService = new ManageHotelService_Stub();
	
	private WebManagerInfoUtil(){}
	public static WebManagerInfoUtil getInstance() {
		if(webManagerInfoUtil==null){
			webManagerInfoUtil = new WebManagerInfoUtil();
		}
		return webManagerInfoUtil;
	}
	
	/**
	 * 网管登陆界面调用，检查账号和密码是否匹配
	 */
	public ResultMessage checkOnLine(String id,String password) {
		ResultMessage resultMessage = loginService.checkOnline(Role.webmanager, id, password);
		return resultMessage;
	}
	
	/**
	 * 管理用户界面调用，得到所有用户的list
	 */
	public ArrayList<UserVO> getUserVOs() {
		return userService.getUserVOS();
	}
	/**
	 * 管理酒店界面调用，得到所有酒店的list
	 */
	public ArrayList<HotelVO> getHotelVOs() {
		return searchHotelService.getHotelList();
	}
	/**
	 * 管理网站营销人员界面调用
	 */
	public ArrayList<WebSalesmanVO> getWebSalesmanVOs() {
		return webStaffService.getWebSalesmanInfo();
	}
	/**
	 * 查看用户信息界面、管理用户信息界面调用
	 */
	public String resetPassword(String userid) {
		return userService.resetPassword(userid);
	}
	/**
	 * 添加酒店界面调用，的到所有的省
	 */
	public ArrayList<String> getProvinces(){
		return DistrictHelper.getProvinces();
	}
	/**
	 * 添加酒店界面调用，根据省得到所有的市
	 */
	public ArrayList<String> getCitys(String province) {
		return DistrictHelper.getCities(province);
	}
	/**
	 * 添加酒店界面调用，根据省市得到所有的区
	 */
	public ArrayList<String> getDistricts(String province,String city) {
		return DistrictHelper.getAreas(province, city);
	}
	
	/**
	 * 添加酒店界面调用，添加酒店
	 */
	public ResultMessage addHotel(HotelVO hotelVO) {
		return managerHotelService.addHotel(hotelVO);
	}
}
