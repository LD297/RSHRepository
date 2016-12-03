package po;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

import vo.RoomNormVO;
import constant.*;

public class OrderPO implements Serializable{
	private String orderid = null;
	private String userid = null;
	private String hotelid = null;
	private StateOfOrder state = null;
	private ArrayList<RoomNormVO> norm = null;
	private double[] roomPrices =null;
	private int[] numbers = null;
	private double originvalue = 0;
	private double truevalue = 0;
	private String promotion =  null;
	private String comment = null;
	private int grade = 0;
	private Date checkIn = null;
	private Date checkOut = null;
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

	public ArrayList<RoomNormVO> getRooms(){
		return norm;
	}
	public int[] getRoomNums(){
		return numbers;
	}
	public double[] getRoomPrices(){
		return roomPrices;
	}
	public int[] getNumbers(){
		return numbers;
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

	public OrderPO(String order,String hotel,StateOfOrder s,double origin,double discounted,Date in,Date out){
		orderid = order;
		hotelid = hotel;
		originvalue = origin;
		truevalue = discounted;
		state = s;
		checkIn = in;
		checkOut = out;
	}
	public OrderPO(String order,String user,StateOfOrder s,double origin,double discounted,Date in,Date out,boolean adultonly,int peoplenum){
		orderid = order;
		userid = user;
		originvalue = origin;
		truevalue = discounted;
		state = s;
		checkIn = in;
		checkOut = out;
		adultOnly = adultonly;
		numOfPeople = peoplenum;
	}
	public OrderPO(String order,String user,String hotel,StateOfOrder s,double discounted,Date in,Date out){
		orderid = order;
		hotelid = hotel;
		userid = user;
		state = s;
		truevalue = discounted;
		checkIn = in;
		checkOut = out;
	}
	public OrderPO(String order,String user,String hotel,StateOfOrder s,
				   ArrayList<RoomNormVO> type,double[] roomprices,int[] nums,int people,boolean adultonly,
				   double origin,double discounted, String pro,
				   String com,int gra,Date in,Date out){

		orderid = order;
		userid = user;
		hotelid = hotel;

		norm = type;
		roomPrices = new double[roomprices.length];
		roomPrices = roomprices;
		numbers = new int[nums.length];
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

		state = s;
	}

}
