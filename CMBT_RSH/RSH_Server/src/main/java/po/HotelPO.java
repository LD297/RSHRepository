package po;

import java.io.Serializable;

public class HotelPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 酒店账号
	 */
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
	private String imageAddress; 
	/**
	 * 酒店地址
	 */
	private String address;//6位编码
	private String addressDetail;
	private String briefIntro;
	/**
	 * 酒店（基础）设施（WiFi available？……）
	 */
	private String facility;
	/**
	 * 酒店等级（五星级酒店？）
	 */
	private int level;
	/**
	 * 酒店评分（根据每次用户评分加权计算后取整）
	 */
	private double grade;
	private double standardPrice;
	/**
	 * 最晚入住时间
	 */
	private String latestCheckInTime;
	
	
	public HotelPO(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getID() {
		return hotelID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getBriefIntro() {
		return briefIntro;
	}

	public void setBriefIntro(String briefIntro) {
		this.briefIntro = briefIntro;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getLatestCheckInTime() {
		return latestCheckInTime;
	}

	public void setLatestCheckInTime(String latestCheckInTime) {
		this.latestCheckInTime = latestCheckInTime;
	}
	public String getImageAddress(){
		return this.imageAddress;
	}
	public double getStandardPrice(){
		return this.standardPrice;
	}
	public void setStandardPrice(double standardPrice){
		this.standardPrice = standardPrice;
	}
	public HotelPO(String hotelID, String tel, String name,String imageAddress, String address, String addressDetail,
				   double standardPrice,String briefIntro,String facility, int level,double grade, String latestCheckInTime){
		this.hotelID =  hotelID;
		this.tel = tel;
		this.name = name;
		this.imageAddress = imageAddress;
		this.address = address;
		this.addressDetail = addressDetail;
		this.standardPrice = standardPrice;
		this.briefIntro = briefIntro;
		this.facility = facility;
		this.level = level;
		this.grade = grade;
		this.latestCheckInTime  = latestCheckInTime;
	}
	// 酒店生成时
	public HotelPO(String hotelID,String tel,String name,String address,String addressDetail,String password){
		this.hotelID = hotelID;
		this.tel = tel;
		this.name = name;
		this.address = address;
		this.addressDetail = addressDetail;
		this.password = password;
	}
}