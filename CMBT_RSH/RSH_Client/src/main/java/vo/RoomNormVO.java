package vo;

public class RoomNormVO {
	String id;
    public String roomType;
	public Double price;
	
	public RoomNormVO(String id,String roomType, Double price) {
		this.id = id;
		this.roomType = roomType;
		this.price = price;
	}
	
}
