package vo;

import java.util.ArrayList;
import java.util.Date;

public class RoomAvailVO  {
	
	String hotelID;
	String roomType;
	public Date beginDate;
	public Date endDate;
	private int numOfAvailRoom;
	
	double price;
	String basicOrSpecial;
	public RoomAvailVO(String id, String roomType, int amountTotal, double price,
					   String basicOrSpecial) {
//		super(id, roomType, amountTotal, price, basicOrSpecial);
		this.hotelID = id;
		this.roomType = roomType;
		this.numOfAvailRoom = amountTotal;
		this.price = price;
		this.basicOrSpecial = basicOrSpecial;
	}
	
	public RoomAvailVO(String hotelID,String roomType,Date beginDate,Date endDate,int numOfAvailRoom){
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.numOfAvailRoom = numOfAvailRoom;
	}
	
	public int getAmountAvail() {
		return numOfAvailRoom;
	}
	public void setAmountAvail(int amountAvail) {
		this.numOfAvailRoom = amountAvail;
	}

	public String getBasicOrSpecial() {
		// TODO Auto-generated method stub
		return this.basicOrSpecial;
	}

	public String getRoomType() {
		// TODO Auto-generated method stub
		return roomType;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	
	
}
