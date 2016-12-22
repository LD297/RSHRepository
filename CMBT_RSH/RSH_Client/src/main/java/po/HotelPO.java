package po;

import vo.HotelVO;

import java.io.Serializable;

import bl.hotelserviceimpl.Hotel;

public class HotelPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hotelID;
	private String password;
	/**
	 * 酒店工作人员联系方式（客服）
	 */
	private String tel;
	/**
	 * 酒店名称
	 */
	private String name;
	/**
	 * 酒店地址
	 */
	private String detailAddress;
	private String district;
	private String briefIntro;
	
	private String facility;
	
	private int level;
	
	private double grade;
	
	public double standardPrice;
	private String latestCheckinTime;

	String imageAddress;
	public HotelPO(String hotelID,String password,String tel,
			String name,String addr,String district,String briefIntro,String facility,
			int level,double grade, double standardRoomPrice){
		this.hotelID = hotelID;
		this.password = password;
		this.tel = tel;
		this.name = name;
		this.detailAddress = addr;
		this.district = district;
		this.briefIntro = briefIntro;
		this.facility = facility;
		this.level = level;
		this.grade = grade;
		this.standardPrice = standardRoomPrice;
	}

	public String getId() {
		return hotelID;
	}

	public String getPassword() {
		return password;
	}

	public String getTel() {
		return tel;
	}

	public String getName() {
		return name;
	}


	public String getAddr() {
		return detailAddress;
	}


	public String getDistrict() {
		return district;
	}

	public String getBriefIntro() {
		return briefIntro;
	}

	public String getFacility() {
		return facility;
	}

	public int getLevel() {
		return level;
	}

	public double getGrade() {
		return grade;
	}

	public double getStandardRoomPrice(){
		return this.standardPrice;
	}

	public String getLatestCheckinTime() {
		return latestCheckinTime;
	}
	
	public static Hotel changeIntoHotel(HotelPO PO){
		Hotel hotel = Hotel.getInstance(PO.getId());
		return hotel;
	}
	
	public HotelVO changeIntoVO(){
		HotelVO hotelVO = new HotelVO(hotelID, name, detailAddress, hotelID, password, level, standardPrice, latestCheckinTime, briefIntro, facility, imageAddress);
		return hotelVO;
	}

}