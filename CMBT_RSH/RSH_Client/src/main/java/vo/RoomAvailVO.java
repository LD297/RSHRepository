package vo;

import java.util.Date;

import po.RoomAvailPO;

/**
 * 特定酒店特定房间特定日期可用房间数量
 * @author aa
 *
 */
public class RoomAvailVO  {
	
	String hotelID;
	String roomType;
	String imageAddress;
	private Date checkDate;
	private int numOfAvailRoom;
	double price;
	
	public RoomAvailVO(String hotelID,String roomType,String imageAddress,
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

	public String getRoomType() {
		// TODO Auto-generated method stub
		return roomType;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	
	public String getImageAddress(){
		return imageAddress;
	}

	public Date getCheckDate(){
		return checkDate;
	}

	public RoomAvailPO changeIntoPO(){
		RoomAvailPO roomAvailPO = new RoomAvailPO(hotelID, roomType, imageAddress, checkDate, numOfAvailRoom, price);
		return roomAvailPO;
	}

}
