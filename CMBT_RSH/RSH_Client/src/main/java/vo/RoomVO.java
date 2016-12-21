package vo;

import po.RoomPO;

public class RoomVO {
	public String hotelID;
	public String roomType;
	public int numOfRoom;   		//该酒店该种类型房间总数量
	public double price;
	public String basicOrSpecial;

	public RoomVO(String hotelID, String roomType, int numOfRoom, double price, String basicOrSpecial) {
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.numOfRoom = numOfRoom;
		this.price = price;
		this.basicOrSpecial = basicOrSpecial;
	}

	public RoomPO changeIntoPO() {
		// TODO Auto-generated method stub
		RoomPO roomPO = new RoomPO(hotelID, roomType, numOfRoom, price, basicOrSpecial);
		return roomPO;
	}


}
