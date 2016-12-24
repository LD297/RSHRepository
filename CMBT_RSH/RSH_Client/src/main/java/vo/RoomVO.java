package vo;

import po.RoomPO;

public class RoomVO {
	public String hotelID;
	public String roomType;
	public int numOfRoom;   		//该酒店该种类型房间总数量
	public double price;
	public String roomImageAddress = "http://cdn.duitang.com/uploads/item/201410/05/20141005160337_RZX8W.thumb.224_0.jpeg";

	// 酒店添加房间时传入所有信息，所有信息（暂时）不得更改
	public RoomVO(String hotelID, String roomType, int numOfRoom, double price, String roomImageAddress) {
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.numOfRoom = numOfRoom;
		this.price = price;
		this.roomImageAddress = roomImageAddress;
	}

	public RoomPO changeIntoPO() {
		RoomPO roomPO = new RoomPO(hotelID, roomType, numOfRoom, price, roomImageAddress);
		return roomPO;
	}

	public String getHotelID() {
		return hotelID;
	}

	public String getRoomType() {
		return roomType;
	}


}
