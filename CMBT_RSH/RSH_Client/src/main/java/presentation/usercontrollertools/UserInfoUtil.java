package presentation.usercontrollertools;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import bl.hotelservice.HotelInfoService;
import bl.hotelservice.HotelService;
import bl.hotelservice.SearchHotelService;
import bl.hotelserviceimpl.SearchHotel;
import bl.hotelserviceimpl.SearchHotelService_Stub;
import bl.hotelserviceimpl.controller.HotelController;
import bl.hotelserviceimpl.controller.HotelInfoController;
import bl.hotelserviceimpl.controller.HotelInfoService_Stub;
import bl.hotelserviceimpl.controller.HotelService_Stub;
import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginController;
import bl.loginserviceimpl.LoginService_Stub;
import bl.orderservice.OrderForHotel;
import bl.orderservice.OrderForUser;
import bl.orderserviceimpl.OrderForHotelController;
import bl.orderserviceimpl.OrderForHotel_Stub;
import bl.orderserviceimpl.OrderForUserController;
import bl.orderserviceimpl.OrderForUser_Stub;
import bl.promotionServiceimpl.PromotionController;
import bl.promotionServiceimpl.PromotionService_Stub;
import bl.promotionservice.PromotionService;
import bl.userservice.UserService;
import bl.userserviceimpl.UserController;
import bl.userserviceimpl.UserService_Stub;
import constant.ResultMessage;
import constant.Role;
import constant.Sexuality;
import constant.SortBy;
import constant.SortMethod;
import constant.StateOfOrder;
import vo.CreditRecordVO;
import vo.HotelVO;
import vo.OrderInfo;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomNormVO;
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
    private String province = null;
    private String city = null;
    private String area = null;
    private String orderID = null;
    // use stub
/*  private UserService userService = new UserService_Stub();
    private LoginService loginService = new LoginService_Stub();
    private SearchHotelService searchHotelService = new SearchHotelService_Stub();
    private HotelService hotelService =  new HotelService_Stub();
    private OrderForUser orderForUser = new OrderForUser_Stub();
    private OrderForHotel orderForHotel = new OrderForHotel_Stub();
    private PromotionService promotionService = new PromotionService_Stub();
    private HotelInfoService hotelInfoService = new HotelInfoService_Stub();*/
    
//替换stub
    private UserService userService = new UserController();
    private LoginService loginService = new LoginController();
    private SearchHotelService searchHotelService = new SearchHotel();
    private HotelService hotelService =  new HotelController();
    private OrderForUser orderForUser = new OrderForUserController();
    private OrderForHotel orderForHotel = new OrderForHotelController();
    private PromotionService promotionService = new PromotionController();
    private HotelInfoService hotelInfoService = new HotelInfoController();
    
    
    
    
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
    public void setHotelAreaAndAddress(String province,String city,String area) {
       this.province = province;
       this.city = city;
       this.area = area;
 //       hotelVOs = searchHotelService.getHotelList(hotelAddress, hotelArea);
    }
    
    public ArrayList<HotelVO> getHotelVOs(){
    	ArrayList<HotelVO> hotelVOs = searchHotelService.getHotelList(province,city,area);
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
     * 图片工厂得到，得到该用户的头像地址
     * @param userID
     * @return
     */
    public String getUserHeadImageUrl(String userID) {
		String url = userService.getInfo(userID).imageAddress;
		return url;
	}

    /**
     * 修改密码界面调用
     * @param password
     */
    //TODO 直接修改密码
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
    public void modifyUserInfo(String nickName, String name, Sexuality sexuality, LocalDate birthday, String userID, String email){
    	UserVO userVO = userService.getInfo(userID);
    	userVO.birthday = birthday;
    	userVO.eMail = email;
    	userVO.userID = userID;
    	userVO.eMail = email;
    	userVO.sexuality = sexuality;
    	userVO.nickName = nickName;
    	userVO.name = name;
    	userService.update(userVO);
    }
    /**
     * 我的信息界面调用，更换头像
     */
    public void modifyHeadImage(String url) {
		UserVO userVO = userService.getInfo(userID);
		userVO.imageAddress = url;
		userService.update(userVO);
	}
    
    /**
     * 筛选条件界面调用
     */
    public ArrayList<HotelVO> selectHotel(ArrayList<HotelVO> hotelVOs,SelectConditionVO selectConditionVO){
    	selectConditionVO.userID = userID;
    	//把得到的hotelvolist传给逻辑层筛选
    	hotelVOs = searchHotelService.select(hotelVOs,selectConditionVO);
    	return hotelVOs;
    }
    
    /**
     * 筛选界面调用
     */
    public ArrayList<HotelVO> sortHotel(ArrayList<HotelVO> hotelVOs,SortBy sortBy,SortMethod sortMethod) {
		//把得到的hotelvolist传给逻辑层排序
    	hotelVOs = searchHotelService.sort(hotelVOs,sortBy, sortMethod);
    	return hotelVOs;
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
		ArrayList<RoomVO> roomVOs = hotelService.getRoomList(hotelID);
		return roomVOs;
	}
    
    /**
     * 生成订单界面调用，得到符合该日期和该房间类型的房间数量
     */
    public int getAvailRoomNum(String roomType,Date checkIn,Date checkOut) {
    	int avilRoomNum = hotelInfoService.getRoomAvailNum(hotelID, roomType, checkIn, checkOut);
		return avilRoomNum;
	}
    
    /**
     * 生成订单界面调用，得到该房间类型的房间价格
     */
    public double getRoomPrice(String roomtype) {
		ArrayList<RoomNormVO> roomNormVOs = hotelInfoService.getRoomNorm(hotelID);
		for(int i=0;i<roomNormVOs.size();i++){
			if(roomNormVOs.get(i).getRoomType().equals(roomtype)){
				return roomNormVOs.get(i).getPrice();
			}
		}
		return 0;
	}
    
    /**
     * 生成订单界面调用，得到酒店的所有房间类型
     */
    public ArrayList<String> getRoomTypes(){
    	ArrayList<String> res = new ArrayList<>();
    	ArrayList<RoomNormVO> roomNormVOs = hotelInfoService.getRoomNorm(hotelID);
    	for(int i=0;i<roomNormVOs.size();i++){
    		res.add(roomNormVOs.get(i).getRoomType());
    	}
		return res;
    }
    
    /**
     * 生成订单界面调用，得到该订单的总价值
     */
    public String getOrderPriceAndPromotion(OrderInfo orderInfo){
    	orderInfo.setHotelID(hotelID);
    	orderInfo.setUserID(userID);
    	return orderForUser.getTrueValue(orderInfo);
    }
    
    /**
     * 生成订单界面调用，如果可以生成订单，则在数据库中添加一条订单持久化对象；否则（信用值不足）,生成订单失败
     */
	public ResultMessage confirmOrder(String roomType, double roomPrice, boolean withChild, int peopleNumber,
			int roomNumber, double totalPrice,String promotion,Date checkIn,Date checkOut,Date generationDate) {
		UserVO userVO = getUserVO();
		HotelVO hotelVO = getHotelVO();
		RoomNormVO roomNormVO = new RoomNormVO(hotelID, roomType, roomPrice);
		OrderVO orderVO = new OrderVO(orderID, userID, userVO.name, hotelID, hotelVO.getHotelName(),
    			null, roomNormVO, roomPrice, roomNumber, peopleNumber, 
    			withChild, roomPrice*roomNumber, totalPrice, promotion, null, -1, 
    			checkIn, checkOut, hotelVO.getLatestCheckInTime(), generationDate, null, 
    			null, null, null);
    	return orderForUser.confirmReservation(orderVO);
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
     * 图片工厂调用，得到一个酒店的所有图片地址
     */
    public ArrayList<String> getImageUrls(String hotelID) {
    	ArrayList<String> urls = hotelService.getImageAddresses(hotelID);
    	return urls;
	}
    /**
     * 图片工厂调用，得到一个酒店的某个房间类型的地址,这个时候hotelid已经被设置过了
     */
    public String getImageUrl(String roomType) {
		return hotelService.getImageAddress(hotelID, roomType);
	}
    
    /**
     * 注册普通会员,更新util里的会员信息和数据库的会员信息
     */
    //TODO 更新会员信息失败会是什么情况呢
    public ResultMessage registerCommonMember(){
    	ResultMessage resultMessage = userService.registerMember(userID);
    	return resultMessage;
    }
    
    /**
     * 注册企业会员
     */
    public ResultMessage registerCommerceMember(String commerceName) {
		ResultMessage resultMessage = userService.registerMember(userID, commerceName);
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
     * 添加评价界面调用，得到该用户对该订单的评价
     */
    
    public OrderVO getOrderVO() {
		OrderVO orderVO = orderForUser.detail(orderID);
		return orderVO;
	}
    
    /**
     * 添加评价界面调用，为用户增加评价
     */
    public ResultMessage addComment(String comment,String grade) {
		ResultMessage resultMessage = orderForUser.addComment(orderID,(int) Double.parseDouble(grade), comment);
		return resultMessage;
    }
    
    /**
     * 我的订单界面调用，得到该用户的所有订单
     * @return
     */
    public ArrayList<OrderVO> getOrderVOs(StateOfOrder stateOfOrder) {
    	ArrayList<OrderVO> orderVOs = orderForUser.userClassify(userID, stateOfOrder);
		return orderVOs;
	}
    
    /**
     * 我的订单界面调用，得到用户在某个酒店的订单
     */
    public ArrayList<OrderVO> getOrderVOsOfOneHotel() {
		ArrayList<OrderVO> orderVOs = orderForUser.specificOrder(userID, hotelID);
		return orderVOs;
	}
    /**
     * 撤销订单,订单详情界面调用
     */
    public void cancelOrder() {
		orderForUser.cancelMyOrder(orderID);
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
    /**
     * 退出时，删除在线人员持久化对象
     */
    public ResultMessage logout() {
		ResultMessage resultMessage = loginService.logout(Role.user, userID);
		if(resultMessage == ResultMessage.succeed){
			userID = null;
		}
		return resultMessage;
	}
}
