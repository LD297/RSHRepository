package vo;

import po.HotelPO;

public class HotelVO {
	/**
	 * 酒店账号
	 */
	public String hotelID;
	private String password;
	/**
	 * 酒店工作人员联系方式（客服）
	 */
	public String tel;
	/**
	 * 酒店名称
	 */
	public String name;
	/**
	 * 酒店地址
	 */
	public String addr;
	public String district;
	public String briefIntro;
	/**
	 * 酒店（基础）设施（WiFi available？……）
	 */
	public String facility;
	/**
	 * 酒店等级（五星级酒店？）
	 */
	public int level;
	/**
	 * 酒店评分（根据每次用户评分加权计算后取整）
	 */
	public double grade;
	/**
	 * 标准间价格（酒店价格排序标准）
	 */
	public double standardRoomPrice;
	/**
	 * 最晚入住时间
	 */
	public String latestCheckinTime;
	
	public HotelVO(String id) {
		this.hotelID = id;
	}

	//构造方法重载 (不含密码信息)
	public HotelVO(String id, String tel, String name, String addr, String district,
					String briefIntro, String facility, int level,double grade, String latestCheckinTime){
		this.hotelID =  id;
		this.tel = tel;
		this.name = name;
		this.addr = addr;
		this.district = district;
		this.briefIntro = briefIntro;
		this.facility = facility;
		this.level = level;
		this.grade = grade;
		this.latestCheckinTime  = latestCheckinTime;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


	public HotelPO changeIntoPO(){
		HotelPO hotelPO = new HotelPO(hotelID, password, tel, name, addr, district, briefIntro, facility, level, grade, standardRoomPrice);
		return hotelPO;
	}
}
