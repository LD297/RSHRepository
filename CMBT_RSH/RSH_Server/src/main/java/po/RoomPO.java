package po;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;


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
	
	private String imageAddress;
	
	public RoomPO(String hotelID,String roomType,String imageAddress,int numOfRoom,double price){
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.imageAddress = imageAddress;
		this.numOfRoom = numOfRoom;
		this.price = price;
	}
	public String getID() {
		return hotelID;
	}

	public void setID(String id) {
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

	public String getImageAddress(){
		return this.imageAddress;
	}
	public void setImageAddress(String imageAddress){
		this.imageAddress = imageAddress;
	}

}
