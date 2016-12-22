package po;

import java.io.Serializable;
import java.util.Date;


public class RoomAvailPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hotelID;
	private String roomType;
	private String imageAddress;
	
	Date checkDate;
	double price;
	private int numOfAvailRoom;
	
	public RoomAvailPO(String hotelID,String roomType,String imageAddress,
			Date checkDate,	int numOfAvailRoom,double price){
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.imageAddress = imageAddress;
		this.checkDate = checkDate;
		this.numOfAvailRoom = numOfAvailRoom;
		this.price = price;
	}
	
	public int getAmountAvail() {
		return numOfAvailRoom;
	}
	public void setAmountAvail(int amountAvail) {
		this.numOfAvailRoom = amountAvail;
	}
	
}
