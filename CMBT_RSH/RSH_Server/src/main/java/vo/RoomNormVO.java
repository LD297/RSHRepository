package vo;

import constant.RoomType;

public class RoomNormVO {
	String id;
    public RoomType roomType;
	public Double price;
	
	public RoomNormVO(String id, RoomType roomType, Double price) {
		this.id = id;
		this.roomType = roomType;
		this.price = price;
	}
	
}
