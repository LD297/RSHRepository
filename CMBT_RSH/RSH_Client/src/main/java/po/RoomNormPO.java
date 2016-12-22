package po;

import java.io.Serializable;

import vo.RoomNormVO;

public class RoomNormPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hotelID;
	private String roomType;
	private double price;
	
	public RoomNormPO(String hotelID,String roomType,double price){
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.price = price;
	}

	public String hotelID(){
		return hotelID;
	}
	
	public String getRoomType(){
		return roomType;
	}
	
	public double getPrice(){
		return price;
	}
	
	public RoomNormVO changeIntoVO() {
		// TODO Auto-generated method stub
		RoomNormVO roomNormVO = new RoomNormVO(hotelID, roomType, price);
		return roomNormVO;
	}

}
