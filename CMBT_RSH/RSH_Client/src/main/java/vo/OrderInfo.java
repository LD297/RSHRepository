package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OrderInfo {
	String hotelID;
	String roomType;
	int roomNum;
	Date checkInDate;
	Date checkOutDate;
	int stayDay;
	String userID;	
	double price;
	
	double originalValue;
	
	public OrderInfo(String hotelID,String roomType,int roomNum,
			Date checkInDate, Date checkOutDate,String userID,double price){
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;			
		this.userID = userID;
		this.price = price;
		stayDay = betweenDate(checkInDate, checkOutDate);
		originalValue = roomNum*price*stayDay;
	}

	public String getHotelID() {
		// TODO Auto-generated method stub
		return hotelID;
	}
	
	public String getRoomType(){
		return roomType;
	}
	
	public int getRoomNum(){
		return roomNum;
	}
	
	public Date getCheckInDate(){
		return checkInDate;
	}
	
	public Date getCheckOutDate(){
		return checkOutDate;
	}
	
	public String getUserID(){
		return userID;
	}
	
	public double getPrice(){
		return price;
	}
	
	public double getOriginalValue(){
		return originalValue;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int betweenDate(Date smdate, Date bdate){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		try {
			smdate=sdf.parse(sdf.format(smdate));
			bdate=sdf.parse(sdf.format(bdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		Calendar cal = Calendar.getInstance();    
		cal.setTime(smdate);    
		long time1 = cal.getTimeInMillis();                 
		cal.setTime(bdate);    
		long time2 = cal.getTimeInMillis();         
		int between_days=(int) ((time2-time1)/(1000*3600*24));  
		return between_days;
	}
}
