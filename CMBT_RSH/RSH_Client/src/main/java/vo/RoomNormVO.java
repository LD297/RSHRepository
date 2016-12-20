package vo;

/**
 * 房间类型vo，
 * 在添加订单时使用
 * @author aa
 *
 */
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
