package vo;

import po.HotelPO;

public class HotelVO {
	/**
	 * 酒店账号
	 */
	public String id;
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
	public String businessArea;
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
	 * 最晚入住时间
	 */
	public String latestCheckinTime;
	
	public HotelVO(String id) {
		this.id = id;
	}

	//构造方法重载 (不含密码信息)
	public HotelVO(String id, String tel, String name, String addr, String businessArea,
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

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * 根据po封装一个不含密码信息的po
	 * @param hotelPO
	 * @return
	 */
	public static HotelVO createHotelVO(HotelPO hotelPO){
		HotelVO hotelVO = new HotelVO(hotelPO.getId());
		hotelVO.tel = hotelPO.getTel();
		hotelVO.name = hotelPO.getName();
		hotelVO.addr = hotelPO.getAddr();
		hotelVO.businessArea = hotelPO.getBusinessArea();
		hotelVO.briefIntro = hotelPO.getBriefIntro();
		hotelVO.facility = hotelPO.getFacility();
		hotelVO.level = hotelPO.getLevel();
		hotelVO.grade = hotelPO.getGrade();
		hotelVO.latestCheckinTime = hotelPO.getLatestCheckinTime();
		return hotelVO;
	}


}
