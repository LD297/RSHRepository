package presentation.tools;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import bl.hotelservice.HotelService;
import bl.hotelservice.SearchHotelService;
import bl.hotelserviceimpl.HotelService_Stub;
import bl.hotelserviceimpl.SearchHotelService_Stub;
import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginController;
import bl.loginserviceimpl.LoginService_Stub;
import bl.orderservice.OrderForHotel;
import bl.orderservice.OrderForUser;
import bl.orderserviceimpl.OrderForHotel_Stub;
import bl.orderserviceimpl.OrderForUser_Stub;
import bl.orderserviceimpl.OtherOrderController;
import bl.promotionServiceimpl.PromotionService_Stub;
import bl.promotionservice.PromotionService;
import bl.userservice.UserService;
import bl.userserviceimpl.UserService_Stub;
import constant.MemberType;
import constant.ResultMessage;
import constant.Role;
import constant.Sexuality;
import constant.SortBy;
import constant.SortMethod;
import constant.StateOfOrder;
import vo.CreditRecordVO;
import vo.HotelVO;
import vo.OrderVO;
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
     * 当前hotel的id，在规定的地址和商圈内唯一标识酒店
     */
    private String hotelID = null;
public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	//	private String hotelName = null;
    private String hotelAddress = null;
    private String hotelArea = null;
    private String orderID = null;
//    private UserVO userVO = null;
    // use stub
    private UserService userService = new UserService_Stub();
    private LoginService loginService = new LoginService_Stub();
    // use stub
    private SearchHotelService searchHotelService = new SearchHotelService_Stub();
    private HotelService hotelService = new HotelService_Stub();
    private OrderForUser orderForUser = new OrderForUser_Stub();
    private OrderForHotel orderForHotel = new OrderForHotel_Stub();
    private PromotionService promotionService = new PromotionService_Stub();
//    private OtherOrderService otherOrderService = new OtherOrderController();
  
//    private ArrayList<HotelVO> hotelVOs = null;
    
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
         ResultMessage resultMessage = loginService.checkOnline(Role.user,userID,password);
         if(resultMessage == ResultMessage.succeed){
        	 this.userID = userID;
 //       	 userVO = userService.getInfo(userID);
         }
         return resultMessage;
    }
    

    /**
     * 搜索界面调用，设置当前地址和商圈
     * @param hotelArea
     * @param hotelAddress
     */
    public void setHotelAreaAndAddress(String hotelArea,String hotelAddress) {
        this.hotelArea = hotelArea;
        this.hotelAddress = hotelAddress;
 //       hotelVOs = searchHotelService.getHotelList(hotelAddress, hotelArea);
    }
    
    public ArrayList<HotelVO> getHotelVOs(){
    	ArrayList<HotelVO> hotelVOs = searchHotelService.getHotelList(hotelAddress, hotelArea);
    	return hotelVOs;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserPassword(){
    	UserVO userVO = userService.getInfo(userID);
        return userVO.getPassword();
    }
    
    public UserVO getUserVO() {
    	UserVO userVO = userService.getInfo(userID);
		return userVO;
	}

    /**
     * 修改密码界面调用
     * @param password
     */
    public void modifyUserPassword(String password){
    	UserVO userVO = userService.getInfo(userID);
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
    	UserVO userVO = userService.getInfo(userID);
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
    	//得到当前酒店浏览界面的hotelvolist
    	ArrayList<HotelVO> hotelVOs = UserUIFXMLFactory.getUserUIFXMLFactory().getBrowseHotelUIController().getHotelVOsOfBrowsehotel();
    	//把得到的hotelvolist传给逻辑层筛选
    	hotelVOs = searchHotelService.select(hotelVOs,selectConditionVO);
    }
    
    /**
     * 筛选界面调用
     */
    public void sortHotel(SortBy sortBy,SortMethod sortMethod) {
    	//得到当前酒店浏览界面的hotelvolist
    	ArrayList<HotelVO> hotelVOs = UserUIFXMLFactory.getUserUIFXMLFactory().getBrowseHotelUIController().getHotelVOsOfBrowsehotel();
		//把得到的hotelvolist传给逻辑层排序
    	hotelVOs = searchHotelService.sort(hotelVOs,sortBy, sortMethod);
	}
    
    /**
     * 酒店详情界面调用,根据酒店id得到酒店vo
     */
    public HotelVO getHotelVO() {
    	HotelVO hotelVO = hotelService.getHotelInfo(hotelID);
		return hotelVO;
	}
    
    /**
     * 用户视角酒店详情界面调用，得到该酒店的房间信息
     * @return
     */
    public ArrayList<RoomVO> getRoomVos() {
		ArrayList<RoomVO> roomVOs = hotelService.getRoomList();
		return roomVOs;
	}
    
    /**
     * 酒店浏览界面调用,得到某一个酒店的所有促销策略
     */
    public ArrayList<PromotionVO> getPromotionVOs(String hotelID) {
		ArrayList<PromotionVO> promotionVOs = promotionService.getPromotionOfHotel(hotelID);
		return promotionVOs;
	}
    
    /**
     * 酒店浏览界面调用，得到当前用户在该酒店的最近一笔订单状态
     */
    public StateOfOrder getOrderStateOfUser(String hotelID) {
		return orderForUser.getOrderStateOfUser(userID, hotelID);
	}
    
    /**
     * 注册普通会员,更新util里的会员信息和数据库的会员信息
     */
    //TODO 更新会员信息失败会是什么情况呢
    public ResultMessage registerCommonMember(){
    	ResultMessage resultMessage = userService.registerMember(userID);
    	return resultMessage;
    }
    
    //TODO
    /**
     * 查看评价界面调用，得到该酒店的所有有评价的订单
     */
    public ArrayList<OrderVO> getOrderVOsWithComment(){
    	ArrayList<OrderVO> orderVOs = orderForHotel.hotelClassify(hotelID, StateOfOrder.executed);
    	//筛选出所有有评价的界面
    	ArrayList<OrderVO> result = new ArrayList<OrderVO>();
    	for(int i=0;i<orderVOs.size();i++){
    		if(orderVOs.get(i).getComment()!=null&&!orderVOs.get(i).equals("")){
    			result.add(orderVOs.get(i));
    		}
    	}
		return result;
    }
    
    /**
     * 我的订单界面调用，得到该用户的所有订单
     * @return
     */
    //TODO 找到是哪个界面调用的->_<-
    public ArrayList<OrderVO> getOrderVOs(StateOfOrder stateOfOrder) {
    	ArrayList<OrderVO> orderVOs = orderForUser.userClassify(userID, stateOfOrder);
		return orderVOs;
	}
    
    
    /**
     * 我的信用记录界面调用，得到该用户的所有信用记录
     */
    public ArrayList<CreditRecordVO> getCreditRecordVOs() {
    	Iterator<CreditRecordVO> iterator = userService.getCreditRecordList(userID);
    	ArrayList<CreditRecordVO> creditRecordVOs = new ArrayList<>();
    	while (iterator.hasNext()) {
			creditRecordVOs.add(iterator.next());
		}
		return creditRecordVOs;
	}
    
    /**
     * 注册界面调用，添加用户持久化对象
     */
    public ResultMessage register(UserVO userVO) {
    	ResultMessage resultMessage = loginService.register(userVO);
    	return resultMessage;
	}
    
}
