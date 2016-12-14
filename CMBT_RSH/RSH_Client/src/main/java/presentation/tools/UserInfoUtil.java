package presentation.tools;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import bl.hotelservice.HotelInfoService;
import bl.hotelservice.HotelService;
import bl.hotelservice.SearchHotelService;
import bl.hotelserviceimpl.HotelInfoService_Stub;
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
    private HotelInfoService hotelInfoService = new HotelInfoService_Stub();
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
		ArrayList<RoomVO> roomVOs = hotelService.getRoomList();
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
    public String getOrderPriceAndPromotion(Date checkIn, Date checkOut,String roomType,double roomPrice, int roomNum){
    	RoomNormVO room = new RoomNormVO(hotelID, roomType, roomPrice);
    	return orderForUser.getTrueValue(userID, hotelID, checkIn, checkOut, room, roomNum);
    }
    
    /**
     * 生成订单界面调用，如果可以生成订单，则在数据库中添加一条订单持久化对象；否则（信用值不足）,生成订单失败
     */
	public ResultMessage confirmOrder(String roomType, double roomPrice, boolean withChild, int peopleNumber,
			int roomNumber, double totalPrice,String promotion,Date checkIn,Date checkOut,Date generationDate) {
		UserVO userVO = getUserVO();
		HotelVO hotelVO = getHotelVO();
		RoomNormVO roomNormVO = new RoomNormVO(hotelID, roomType, roomPrice);
		OrderVO orderVO = new OrderVO(orderID, userID, userVO.name, hotelID, hotelVO.name,
    			null, roomNormVO, roomPrice, roomNumber, peopleNumber, 
    			withChild, roomPrice*roomNumber, totalPrice, promotion, null, -1, 
    			checkIn, checkOut, hotelVO.latestCheckinTime, generationDate, null, 
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
