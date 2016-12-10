package presentation.tools;

import java.time.LocalDate;
import java.util.ArrayList;

import bl.hotelservice.SearchHotelService;
import bl.hotelserviceimpl.SearchHotelController;
import bl.userservice.UserService;
import bl.userserviceimpl.UserController;
import constant.Sexuality;
import vo.HotelVO;
import vo.UserVO;

/**
 * Created by john on 2016/12/8.
 */
public class UserInfoUtil {
    private static UserInfoUtil userInfoUtil = null;
    private UserInfoUtil(){}
    public static UserInfoUtil getInstance(){
        if(userInfoUtil==null){
            userInfoUtil = new UserInfoUtil();
        }
        return userInfoUtil;
    }
    /**
     * 当前的userid
     */
    private String userID = null;
    /**
     * 当前hotel的名称，在规定的地址和商圈内唯一标识酒店
     */
	private String hotelName = null;
    private String hotelAddress = null;
    private String hotelArea = null;
    private String orderID = null;
    private UserVO userVO = null;
    private UserService userService = new UserController();
    private SearchHotelService searchHotelService = new SearchHotelController();
    private ArrayList<HotelVO> hotelVOs = null;
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
        userVO = userService.getInfo(userID);
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setHotelAreaAndAddress(String hotelArea,String hotelAddress) {
        this.hotelArea = hotelArea;
        this.hotelAddress = hotelAddress;
        hotelVOs = searchHotelService.getHotelList(hotelAddress, hotelArea);
    }
    
    public ArrayList<HotelVO> getHotelVOs(){
    	return hotelVOs;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserPassword(){
        return userVO.getPassword();
    }
    
    public UserVO getUserVO() {
		return userVO;
	}

    public void modifyUserPassword(String password){
        userVO.setPassword(password);
        userService.update(userVO);
    }

    /**
     * 用户编辑个人资料界面调用
     * @param nickName
     * @param name
     * @param sexuality
     * @param birthday
     * @param userID
     * @param email
     */
    public void modifyUserInfo(String nickName, String name, Sexuality sexuality, LocalDate birthday,String userID,String email){
    	userVO.birthday = birthday;
    	userVO.eMail = email;
    	userVO.id = userID;
    	userVO.eMail = email;
    	userVO.sexuality = sexuality;
    	userVO.nickName = nickName;
    	userVO.name = name;
    	userService.update(userVO);
    }
}
