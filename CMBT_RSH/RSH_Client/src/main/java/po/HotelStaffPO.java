package po;

public class HotelStaffPO {

	private String hotelID;
	private String tel;
	
	public HotelStaffPO(String hotelID, String tel) {
		this.hotelID = hotelID;
		this.tel = tel;
	}

	public String getHotelID() {
		return hotelID;
	}

	public String getTel() {
		return tel;
	}
}
