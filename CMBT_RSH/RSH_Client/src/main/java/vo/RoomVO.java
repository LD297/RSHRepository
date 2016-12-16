package vo;

import po.RoomPO;

public class RoomVO {
	/**
	 * 酒店名称
	 */
	public String hotelID;
	/**
	 * 房间类型（单人间／标准间）
	 */
	public String roomType;
	/**
	 * 该类型房间总量
	 */
	public int numOfRoom;
	/**
	 * 该类型房间的单价（元／晚（12:00～次日11:59））
	 */
	public double price;
	/**
	 * 该类型房间是否被设为特色
	 */
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
