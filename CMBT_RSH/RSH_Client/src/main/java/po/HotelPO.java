package po;

import vo.HotelVO;

import java.io.Serializable;

import bl.hotelserviceimpl.Hotel;

public class HotelPO implements Serializable{
	
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
	private String addr;
	private String businessArea;
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
	/**
	 * 标准间价格（酒店价格排序标准）
	 */
	public double standardRoomPrice;
	/**
	 * 最晚入住时间
	 */
	private String latestCheckinTime;
	
	public HotelPO(String id) {
		this.hotelID = id;
	}

	public String getId() {
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
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

	public double getStandardRoomPrice(){
		return this.standardRoomPrice;
	}

	public void setStandardRoomPrice(double standardRoomPrice){
		this.standardRoomPrice = standardRoomPrice;
	}

	public String getLatestCheckinTime() {
		return latestCheckinTime;
	}

	public void setLatestCheckinTime(String latestCheckinTime) {
		this.latestCheckinTime = latestCheckinTime;
	}

	public static HotelPO changeIntoPO(HotelVO vo){
		// 根据hotelVO封装一个新的hotelPO，传给下层
		HotelPO newHotelPO = new HotelPO(vo.id);
		newHotelPO.setPassword(vo.getPassword());
		newHotelPO.setTel(vo.tel);
		newHotelPO.setName(vo.name);
		newHotelPO.setAddr(vo.addr);
		newHotelPO.setBusinessArea(vo.businessArea);
		newHotelPO.setBriefIntro(vo.briefIntro);
		newHotelPO.setFacility(vo.facility);
		newHotelPO.setLevel(vo.level);
		newHotelPO.setGrade(vo.grade);
		newHotelPO.setLatestCheckinTime(vo.latestCheckinTime);
		return newHotelPO;
	}
	
	public static Hotel changeIntoHotel(HotelPO PO){
		Hotel hotel = Hotel.getInstance(PO.getId());
		return hotel;
	}
	
	public static HotelVO changeIntoVO(HotelPO PO){
		HotelVO hotelVO = new HotelVO(PO.hotelID,
				PO.tel, PO.name, PO.addr,PO.businessArea,
				PO.briefIntro, PO.facility,
				PO.level, PO.grade, PO.latestCheckinTime);
		return hotelVO;
	}
}