package bl.promotionServiceimpl.condition;

import bl.hotelserviceimpl.RoomManager;

public class OrderInfo {

	String hotelID;
	String roomType;
	double price;
	int num;
	String userID;
	
	public OrderInfo(String hotelID,String roomType, int num,Double price, String userID){
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.num = num;
		this.price = price;
		this.userID = userID;
	}

	public String getHotelID() {
		// TODO Auto-generated method stub
		return hotelID;
	}
	
	public String getRoomType(){
		return roomType;
	}
	
	public int getNum(){
		return num;
	}
	
	public double getPrice(){
		return price;
	}
}
