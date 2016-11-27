package po;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

import vo.RoomNormVO;
import constant.*;

public class OrderPO implements Serializable{
	public String orderid;
	public String userid;
	public String hotelid;
	public StateOfOrder state;
	public ArrayList<RoomNormVO> norm;
	public int[] numbers;
	public double originvalue;
	public double truevalue;
	public String promotion;
	public String comment;
	public int grade;
	public Date checkIn;
	public Date checkOut;
	public int numOfPeople;
	public boolean adultOnly;
	
	public void setTrueValue(double discounted){
		truevalue = discounted;
	}
	public OrderPO(String order,String user,String hotel,
				   ArrayList<RoomNormVO> type,int[] nums,int people,boolean adultonly,
				   double origin,double discounted,String pro,
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
