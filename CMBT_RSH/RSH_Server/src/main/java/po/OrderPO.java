package po;

import constant.StateOfOrder;
import vo.RoomNormVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class OrderPO implements Serializable{
	private String orderid = null;
	private String userid = null;
	private String userName = null;
	private String hotelid = null;
	private StateOfOrder state = null;
	private RoomNormVO norm = null;
	private double roomPrice = 0;//计算后
	private int roomNumber = 0;
	private double originvalue = 0;
	private double truevalue = 0;
	private String promotion =  null;
	private String comment = null;
	private int grade = 0;
	/**
	 * 预计入住日期（含时间）（用户操作）
	 */
	private Date checkIn = null;
	/**
	 * 预计离开日期（含时间）（用户操作）
	 */
	private Date checkOut = null;
	/**
	 * 实际入住日期（含时间）（酒店操作）
	 */
	private Date actualCheckIn = null;
	/**
	 * 实际离开日期（含时间）（酒店操作）
	 */
	private Date actualCheckOut = null;
	/**
	 * 订单生成日期（界面暂时不显示时间，但可以保存以备需求变更）
	 */
	private Date generationDate = null;

	private int numOfPeople = 0;
	private boolean adultOnly = false;

	public  String getOrderid(){
		return orderid;
	}
	public String getUserid(){
		return userid;
	}
	public String getHotelid(){
		return hotelid;
	}
	public StateOfOrder getState(){
		return state;
	}

	public RoomNormVO getRoom(){
		return norm;
	}
	public int getRoomNumber(){
		return roomNumber;
	}
	public double getRoomPrice(){
		return roomPrice;
	}
	public double getOriginvalue(){
		return originvalue;
	}
	public double getTrueValue(){
		return truevalue;
	}
	public String getPromotion(){
		return promotion;
	}
	public Date[] getTime(){
		return new Date[]{checkIn,checkOut};
	}
	public int getNumOfPeople(){
		return numOfPeople;
	}
	public boolean getAdultOnly(){
		return adultOnly;
	}

	public void setTrueValue(double discounted){
		truevalue = discounted;
	}
	public void setState(StateOfOrder condition){
		state = condition;
	}

	/**
	 *
	 * @param order
	 * @param hotel
	 * @param s
	 * @param origin
	 * @param discounted
	 * @param in
	 * @param out
	 */
	public OrderPO(String order, String hotel, StateOfOrder s, double origin, double discounted, Date in, Date out){
		orderid = order;
		hotelid = hotel;
		originvalue = origin;
		truevalue = discounted;
		state = s;
		checkIn = in;
		checkOut = out;
	}

	// 酒店视角
	public OrderPO(String orderid, String userid, String username, StateOfOrder state,
				   double origin, double discounted, RoomNormVO type, int num,
                   Date in, Date out, Date actualIn, Date actualOut, Date generationDate,
                   boolean adultonly, int peoplenum){
		this.orderid = orderid;
		this.userid = userid;
		this.userName = userName;
		this.originvalue = origin;
		this.truevalue = discounted;
		this.state = state;
		checkIn = in;
		checkOut = out;
		actualCheckIn = actualIn;
		actualCheckOut = actualOut;
		this.generationDate = generationDate;
		adultOnly = adultonly;
		numOfPeople = peoplenum;
	}

	public OrderPO(String order, String user, String hotel, StateOfOrder s, double discounted, Date in, Date out){
		orderid = order;
		hotelid = hotel;
		userid = user;
		state = s;
		truevalue = discounted;
		checkIn = in;
		checkOut = out;
	}

	/**
	 *
	 * @param order
	 * @param user
	 * @param hotel
	 * @param s
	 * @param type
	 * @param roomprice
	 * @param num
	 * @param people
	 * @param adultonly
	 * @param origin
	 * @param discounted
	 * @param pro
	 * @param com
	 * @param gra
	 * @param in
	 * @param out
	 */
	public OrderPO(String order, String user, String hotel, StateOfOrder s,
                   RoomNormVO type, double roomprice, int num, int people, boolean adultonly,
                   double origin, double discounted, String pro,
                   String com, int gra, Date in, Date out){

		orderid = order;
		userid = user;
		hotelid = hotel;

		norm = type;
		roomPrice = roomprice;
		roomNumber = num;
		numOfPeople = people;
		adultOnly = adultonly;

		originvalue = origin;
		truevalue = discounted;
		promotion = pro;

		comment = com;
		grade = gra;
		checkIn = in;
		checkOut = out;

		state = s;
	}

}
