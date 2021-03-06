package po;

import constant.StateOfOrder;
import java.io.Serializable;
import java.util.Date;

public class OrderPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 注：一笔订单允许一种房间类型
	private String orderID = null;
	private String userID = null;
	private String userName = null;
	private String hotelID = null;
    private String hotelName = null;
	private StateOfOrder state = null;
    // 酒店，类型，原始价格
	private String roomType = null;
	private int roomNumber = 0;
    // 计算后的单间房间实际价格
    private double roomPrice = 0;
    private int peopleNumber = 0;
    private boolean withChild = false;

	private double originValue = 0;
	private double trueValue = 0;
	private String promotion =  null;
	private String comment = null;
	// 评分：0，1，2，3，4，5
	private int grade = 0;
	/**
	 * 预计入住日期（含时间）（用户操作）
	 * 预计离开日期（含时间）（用户操作）
	 */
	private Date checkIn = null;
	private Date checkOut = null;
	private String hotelDDL = null;
    /**
     * 订单生成日期（界面暂时不显示时间，但可以保存以备需求变更）
     */
    private Date generationDate = null;
	/**
	 * 实际入住日期（含时间）（酒店操作）
	 * 实际离开日期（含时间）（酒店操作）
	 */
	private Date actualCheckIn = null;
	private Date actualCheckOut = null;
    /**
     *  记录撤销订单时间
     *  和撤销异常时间
     */
	private Date cancelTime = null;
    private Date cancelAbnormalTime = null;




	public void setTrueValue(double trueValue){
		this.trueValue = trueValue;
	}
	public void setState(StateOfOrder state){
		this.state = state;
	}
    /**
     * order调用promotion方法时传递的参数
     * @param userID
     * @param hotelID
     * @param roomType
     * @param roomNum
     * @param checkIn
     * @param checkOut
     */
    public OrderPO(String userID,String hotelID,String roomType,int roomNum,Date checkIn,Date checkOut){
        this.userID = userID;
        this.hotelID = hotelID;
        this.roomType = roomType;
        this.roomNumber = roomNum;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    /**
     * 酒店视角
     * @param orderID
     * @param userID
     * @param userName
     * @param state
     * @param roomType
     * @param roomNumber
     * @param peopleNumber
     * @param withChild
     * @param originValue
     * @param trueValue
     * @param checkIn
     * @param checkOut
     * @param generationDate
     * @param actualCheckIn
     * @param actualCheckOut
     */
	public OrderPO(String orderID, String userID, String userName, StateOfOrder state,
                   String roomType, int roomNumber,int peopleNumber, boolean withChild,
                   double originValue, double trueValue, Date checkIn, Date checkOut,
                   Date generationDate, Date actualCheckIn, Date actualCheckOut){
		this.orderID = orderID;
		this.userID = userID;
		this.userName = userName;
        this.state = state;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.peopleNumber = peopleNumber;
        this.withChild = withChild;
		this.originValue = originValue;
		this.trueValue = trueValue;
		this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.generationDate = generationDate;
        this.actualCheckIn = actualCheckIn;
        this.actualCheckOut = actualCheckOut;
	}

    /**
     * 订单详情：返回所有信息
     * @param orderID
     * @param userID
     * @param userName
     * @param hotelID
     * @param state
     * @param roomType
     * @param roomPrice
     * @param roomNumber
     * @param peopleNumber
     * @param withChild
     * @param originValue
     * @param trueValue
     * @param promotion
     * @param comment
     * @param grade
     * @param checkIn
     * @param checkOut
     * @param generationDate
     * @param actualCheckIn
     * @param actualCheckOut
     * @param cancelTime
     * @param cancelAbnormalTime
     */
	public OrderPO(String orderID, String userID, String userName,String hotelID, String hotelName, StateOfOrder state,
                   String roomType, double roomPrice, int roomNumber, int peopleNumber, boolean withChild,
                   double originValue, double trueValue, String promotion,
                   String comment, int grade, Date checkIn, Date checkOut,String hotelDDL,Date generationDate,
                   Date actualCheckIn, Date actualCheckOut, Date cancelTime, Date cancelAbnormalTime){

		this.orderID = orderID;
		this.userID = userID;
        this.userName = userName;
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.state = state;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomNumber = roomNumber;
        this.peopleNumber = peopleNumber;
        this.withChild = withChild;
        this.originValue = originValue;
        this.trueValue = trueValue;
        this.promotion = promotion;
        this.comment = comment;
        this.grade = grade;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
		this.hotelDDL = hotelDDL;
        this.generationDate = generationDate;
        this.actualCheckIn = actualCheckIn;
        this.actualCheckOut = actualCheckOut;
        this.cancelTime = cancelTime;
        this.cancelAbnormalTime = cancelAbnormalTime;
	}
	public OrderPO(){

	}
    public String getOrderID(){
        return orderID;
    }
    public String getUserID(){
        return userID;
    }
    public void setUserID(String userID){
    	this.userID = userID;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
    	this.userName = userName;
    }
    public String getHotelID(){
        return hotelID;
    }
    public String getHotelName(){
        return hotelName;
    }
    public StateOfOrder getState(){
        return state;
    }
    public String getRoom(){
        return roomType;
    }
    public double getRoomPrice(){
        return roomPrice;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public int getPeopleNumber(){
        return peopleNumber;
    }
    public boolean getWithChild(){
        return withChild;
    }
    public double getOriginValue(){
        return originValue;
    }
    public double getTrueValue(){
        return trueValue;
    }
    public String getPromotion(){
        return promotion;
    }
    public String getComment(){
        return comment;
    }
    public int getGrade(){
        return grade;
    }
    public Date getCheckIn(){
        return checkIn;
    }
    public Date getCheckOut(){
        return checkOut;
    }
    public String getHotelDDL(){
        return hotelDDL;
    }
    public Date getGenerationDate(){
        return generationDate;
    }
    public Date getActualCheckIn(){
        return actualCheckIn;
    }
    public Date getActualCheckOut(){
        return actualCheckOut;
    }
    public Date getCancelTime(){
        return cancelTime;
    }
    public Date getCancelAbnormalTime(){
        return cancelAbnormalTime;
    }
}
