package presentation.webmanagercontrollertools;

import java.util.ArrayList;

import bl.hotelservice.HotelService;
import bl.hotelservice.ManagerHotelService;
import bl.hotelservice.SearchHotelService;
import bl.hotelserviceimpl.SearchHotelController;
import bl.hotelserviceimpl.SearchHotelService_Stub;
import bl.hotelserviceimpl.controller.HotelController;
import bl.hotelserviceimpl.controller.HotelService_Stub;
import bl.hotelserviceimpl.controller.ManageHotelService_Stub;
import bl.hotelserviceimpl.controller.ManagerHotelController;
import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginController;
import bl.loginserviceimpl.LoginService_Stub;
import bl.userservice.UserService;
import bl.userserviceimpl.UserController;
import bl.userserviceimpl.UserService_Stub;
import bl.webstaffservice.WebStaffService;
import bl.webstaffserviceimpl.WebStaffController;
import bl.webstaffserviceimpl.WebStaffService_Stub;
import constant.ResultMessage;
import constant.Role;
import vo.DistrictHelper;
import vo.HotelVO;
import vo.UserVO;
import vo.WebSalesmanVO;

public class WebManagerInfoUtil {
	private static WebManagerInfoUtil webManagerInfoUtil = null;
/*	private LoginService loginService = new LoginService_Stub();
	private UserService userService = new UserService_Stub();
	private SearchHotelService searchHotelService = new SearchHotelService_Stub();
	private WebStaffService webStaffService = new WebStaffService_Stub();
	private ManagerHotelService managerHotelService = new ManageHotelService_Stub();
	private HotelService hotelService = new HotelService_Stub();*/
	private LoginService loginService = new LoginController();
	private UserService userService = new UserController();
	private SearchHotelService searchHotelService = new SearchHotelController();
	private WebStaffService webStaffService = new WebStaffController();
	private ManagerHotelService managerHotelService = new ManagerHotelController();
	private HotelService hotelService = new HotelController();
	private String managerid = null;
	private String password = null;
	
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
	 * setid
	 */
	public void setID(String id) {
		this.managerid = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getManagerid() {
		return managerid;
	}
	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}
	public String getPassword() {
		return password;
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
		return webStaffService.getAllWebSalesmen();
	}
	
	/**
	 * 修改用户信息界面调用
	 */
	public ResultMessage updateUser(UserVO userVO) {
		return userService.update(userVO);
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
	/**
	 * 添加酒店界面调用，得到酒店的Id
	 */
	public String getHotelID(String province,String city,String district) {
		String districtID = DistrictHelper.getAreaID(province, city, district);
		return managerHotelService.getHotelID(districtID);
	}
	/**
	 * 添加酒店界面调用，返回省市区
	 */
	public ArrayList<String> getPCD(String district) {
		DistrictHelper districtHelper = new DistrictHelper(district);
		ArrayList<String> pcd = new ArrayList<>();
		pcd.add(districtHelper.getProvince());
		pcd.add(districtHelper.getCity());
		pcd.add(districtHelper.getArea());
		return pcd;
	}
	
	/**
	 * 添加酒店和修改酒店界面调用，根据省市区得到6位编码
	 */
	public String getDistrictID(String province,String city,String district) {
		String districtID = DistrictHelper.getDistrict(province, city, district);
		return districtID;
	}
	
	/**
	 * 修改酒店信息
	 */
	public ResultMessage modifyHotel(HotelVO hotelVO) {
		return hotelService.updateHotel(hotelVO);
	}
	/**
	 * 修改网站营销人员信息
	 */
	public ResultMessage modifyWebSalesman(WebSalesmanVO webSalesmanVO) {
		return webStaffService.updateWebSalesman(webSalesmanVO);
	}
	/**
	 * 添加网站营销人员界面调用，得到网站营销人员的账号
	 */
	public String getWebSalesmanID() {
		return webStaffService.getIDForWebsalesman();
	}
	/**
	 * 添加网站营销人员界面调用，添加网站营销人员
	 */
	public ResultMessage addWebSalesman(WebSalesmanVO webSalesmanVO) {
		return webStaffService.addWebSalesman(webSalesmanVO);
	}
	/**
	 * 网站管理人员修改自己的密码
	 */
	public ResultMessage changePassword(String newPassword) {
		return webStaffService.changePassword(managerid, password, newPassword);
	}
}
