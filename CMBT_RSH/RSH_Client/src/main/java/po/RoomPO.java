package po;

import vo.RoomVO;

import java.io.Serializable;

public class RoomPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String hotelID;
	
	private String roomType;
	
	private int numOfRoom;
	/**
	 * 该类型房间的单价（元／晚（12:00～次日11:59））
	 */
	private double price;
	/**
	 * 该类型房间的图片地址
	 */
	private String roomImageAddress;

	public RoomPO(String hotelID,String roomType,int numOfRoom,double price, String roomImageAddress){
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.numOfRoom = numOfRoom;
		this.price = price;
		this.roomImageAddress = roomImageAddress;
	}
	public String getId() {
		return hotelID;
	}

	public void setId(String id) {
		this.hotelID = id;
	}

	public String getType() {
		return roomType;
	}

	public void setType(String type) {
		this.roomType = type;
	}

	public int getAmountTotal() {
		return numOfRoom;
	}

	public void setAmountTotal(int amountTotal) {
		this.numOfRoom = amountTotal;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRoomImageAddress() {
		return roomImageAddress;
	}

	public void setRoomImageAddress(String basicOrSpecial) {
		this.roomImageAddress = roomImageAddress;
	}

	public RoomVO changeIntoVO(){
		RoomVO roomVO = new RoomVO(hotelID, roomType, numOfRoom, price, roomImageAddress);
		return roomVO;
	}
}
