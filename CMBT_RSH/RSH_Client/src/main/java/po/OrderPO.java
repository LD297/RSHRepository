package po;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

import vo.RoomNormVO;
import constant.*;

public class OrderPO implements Serializable{
	private String orderid;
	private String userid;
	private String hotelid;
	private StateOfOrder state;
	private ArrayList<RoomNormVO> norm;
	private int[] numbers;
	private double originvalue;
	private double truevalue;
	private String promotion;
	private String comment;
	private int grade;
	private Date checkIn;
	private Date checkOut;
	private int numOfPeople;
	private boolean adultOnly;

	public String getOrderid(){
		return orderid;
	}
	public String getHotelid(){
		return hotelid;
	}
	public String getUserid(){
		return userid;
	}
	public Date[] getInTime(){
		return new Date[]{checkIn,checkOut};
	}
	public ArrayList<RoomNormVO> getRooms(){
		return norm;
	}
	public int[] getRoomNums(){
		return numbers;
	}
	public double getTrueValue(){
		return truevalue;
	}

	public void setTrueValue(double discounted){
		truevalue = discounted;
	}
	public OrderPO(String order,String user,String hotel,
				   ArrayList<RoomNormVO> type,int[] nums,int people,boolean adultonly,
				   double origin,double discounted, String pro,
				   String com,int gra,Date in,Date out){
		orderid = order;
		userid = user;
		hotelid = hotel;

		norm = type;
		numbers = nums;
		numOfPeople = people;
		adultOnly = adultonly;

		originvalue = origin;
		truevalue = discounted;
		promotion = pro;

		comment = com;
		grade = gra;
		checkIn = in;
		checkOut = out;

	}

}
