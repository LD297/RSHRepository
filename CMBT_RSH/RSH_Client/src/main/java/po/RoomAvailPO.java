package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import vo.RoomAvailVO;

public class RoomAvailPO implements Serializable{

	public String hotelID;
	public String roomType;
	
	Date beginDate;
	Date endDate;

	private int numOfAvailRoom;
	public RoomAvailPO(String id, String type, ArrayList<Date> fromTo) {
		this.hotelID = id;
		this.roomType = type;
		this.beginDate = fromTo.get(0);
		this.endDate  = fromTo.get(1);
	}
	
	public RoomAvailPO(String hotelID,String roomType, Date beginDate, Date endDate, int numOfAvailRoom){
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.numOfAvailRoom = numOfAvailRoom;
	}
	public int getAmountAvail() {
		return numOfAvailRoom;
	}
	public void setAmountAvail(int amountAvail) {
		this.numOfAvailRoom = amountAvail;
	}
	public RoomAvailVO changeIntoVO() {
		// TODO Auto-generated method stub
		RoomAvailVO roomAvailVO = new RoomAvailVO(hotelID, roomType, beginDate, endDate, numOfAvailRoom);
		return roomAvailVO;
	}
}
