package po;

import java.io.Serializable;

public class HotelStaffPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String hotelID;
	String tel;
	public String getHotelID(){
		return hotelID;
	}
	public String getTel(){
		return tel;
	}
	
	public HotelStaffPO(String hotelID, String tel) {
		super();
		this.hotelID = hotelID;
		this.tel = tel;
	}
	
}
