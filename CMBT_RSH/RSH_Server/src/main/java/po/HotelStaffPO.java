package po;

public class HotelStaffPO {

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
