package po;

import java.io.Serializable;

public class HotelPO implements Serializable{
	/**
	 * 酒店账号
	 */
	private String id;
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
	 * 最晚入住时间
	 */
	private String latestCheckinTime;
	
	public HotelPO(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
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

	public String getLatestCheckinTime() {
		return latestCheckinTime;
	}

	public void setLatestCheckinTime(String latestCheckinTime) {
		this.latestCheckinTime = latestCheckinTime;
	}
	public HotelPO(String id, String tel, String name, String addr, String businessArea,
				   String briefIntro, String facility, int level,double grade, String latestCheckinTime){
		this.id =  id;
		this.tel = tel;
		this.name = name;
		this.addr = addr;
		this.businessArea = businessArea;
		this.briefIntro = briefIntro;
		this.facility = facility;
		this.level = level;
		this.grade = grade;
		this.latestCheckinTime  = latestCheckinTime;
	}
	public HotelPO(String tel,String name,String addr,String password){
		this.tel = tel;
		this.name = name;
		this.addr = addr;
		this.password = password;
	}
}