package presentation.tools;

import java.time.LocalDate;
import java.util.ArrayList;

import bl.hotelservice.HotelService;
import bl.hotelservice.SearchHotelService;
import bl.hotelserviceimpl.HotelController;
import bl.hotelserviceimpl.SearchHotelController;
import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginController;
import bl.orderservice.OtherOrderService;
import bl.orderserviceimpl.OtherOrderController;
import bl.promotionservice.PromotionService;
import bl.promotionServiceimpl.PromotionController;
import bl.userservice.UserService;
import bl.userserviceimpl.UserController;
import constant.MemberType;
import constant.ResultMessage;
import constant.Role;
import constant.Sexuality;
import constant.SortBy;
import constant.SortMethod;
import constant.StateOfOrder;
import vo.HotelVO;
import vo.PromotionVO;
import vo.RoomVO;
import vo.SelectConditionVO;
import vo.UserVO;

/**
 * Created by john on 2016/12/8.
 * 该类专门用来从逻辑层拿数据，并且存储当前用户id,当前地址和商圈，以及当前酒店名称（如果有的话）。
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

    /**
     * 登陆界面调用，如果登陆成功，设置当前userID，并且得到该用户的信息；不成功，直接返回
     * @param userID
     * @param password
     * @return
     */
    public ResultMessage login(String userID,String password){
    	 LoginService loginService = new LoginController();
         ResultMessage resultMessage = loginService.checkOnline(Role.user,userID,password);
         if(resultMessage == ResultMessage.succeed){
        	 this.userID = userID;
        	 userVO = userService.getInfo(userID);
         }
         return resultMessage;
    }
    
    
    
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * 搜索界面调用，设置当前地址和商圈
     * @param hotelArea
     * @param hotelAddress
     */
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

    /**
     * 修改密码界面调用
     * @param password
     */
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
    
    /**
     * 筛选条件界面调用
     */
    public void selectHotel(SelectConditionVO selectConditionVO){
    	selectConditionVO.userID = userID;
    	hotelVOs = searchHotelService.select(selectConditionVO);
    }
    
    /**
     * 筛选界面调用
     */
    public void sortHotel(SortBy sortBy,SortMethod sortMethod) {
		hotelVOs = searchHotelService.sort(sortBy, sortMethod);
	}
    
    /**
     * 酒店详情界面调用
     */
    public HotelVO getHotelVO() {
		for(int i=0;i<hotelVOs.size();i++){
			if(hotelVOs.get(i).name.equals(hotelName)){
				return hotelVOs.get(i);
			}
		}
		return null;
	}
    
    /**
     * 用户视角酒店详情界面调用，得到该酒店的房间信息
     * @return
     */
    public ArrayList<RoomVO> getRoomVos() {
    	String hotelID = null;
    	for(int i=0;i<hotelVOs.size();i++){
			if(hotelVOs.get(i).name.equals(hotelName)){
				hotelID = hotelVOs.get(i).id;
			}
		}
		HotelService hotelService = new HotelController(hotelID);
		ArrayList<RoomVO> roomVOs = hotelService.getRoomList();
		return roomVOs;
	}
    
    /**
     * 酒店浏览界面调用,得到某一个酒店的所有促销策略
     */
    public ArrayList<PromotionVO> getPromotionVOs(String hotelID) {
    	PromotionService promotionService = new PromotionController();
		ArrayList<PromotionVO> promotionVOs = promotionService.getPromotionOfHotel(hotelID);
		return promotionVOs;
	}
    
    /**
     * 酒店浏览界面调用，得到当前用户在该酒店的最近一笔订单状态
     */
    public StateOfOrder getOrderStateOfUser(String hotelID) {
    	OtherOrderService otherOrderService = new OtherOrderController();
		StateOfOrder stateOfOrder = otherOrderService.getOrderStateOfUser(userID,
				hotelID);
		return stateOfOrder;
	}
    
    /**
     * 注册普通会员,更新util里的会员信息和数据库的会员信息
     */
    public ResultMessage registerCommonMember(){
    	ResultMessage resultMessage = userService.registerMember(userID);
    	if(resultMessage==ResultMessage.succeed){
    		userVO.memberType = MemberType.commom;
    		userVO.level = 1;
    	}
    	return resultMessage;
    }
    
    //TODO
    /**
     * 查看评价界面调用，得到该酒店的所有评价
     */
}
