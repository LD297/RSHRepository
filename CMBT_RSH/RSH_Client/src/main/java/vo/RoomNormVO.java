package vo;

public class RoomNormVO {
	private String hotelID;
    private String roomType;
	private double price;
	
	public RoomNormVO(String hotelID,String roomType, Double price) {
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.price = price;
	}
	public String getHotelID(){
		return hotelID;
	}
	public String getRoomType(){
		return roomType;
	}
	public double getPrice(){
		return price;
	}
	
}
