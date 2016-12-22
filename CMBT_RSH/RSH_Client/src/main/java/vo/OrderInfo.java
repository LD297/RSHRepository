package vo;

import java.util.Date;

public class OrderInfo {
	String hotelID;
	String roomType;
	int roomNum;
	Date checkInDate;
	Date checkOutDate;
	String userID;
	
	double price;
	double originalValue;
	
	public OrderInfo(String hotelID,String roomType,int roomNum,
			Date checkInDate, Date checkOutDate,String userID){
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.userID = userID;
		
		H
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

	

}
