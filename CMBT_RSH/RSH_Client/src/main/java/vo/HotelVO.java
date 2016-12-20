package vo;

import java.io.ObjectInputStream.GetField;

import po.HotelPO;

public class HotelVO {
	
	private static final int DISTRICT_LENGTH = 6;
	
	private String hotelID;
	private String name; //酒店名称
	private String addr;
	private String tel; 
	
	private String password;
	
	private int level = -1; 				//星级，未设置时置为-1，最大为5;
	private double grade = 0;		 	//酒店评分所有用户评分的均值
	public double standardRoomPrice ; 	//标准间价格（酒店价格排序标准）
	
	public String latestCheckinTime = "23:45:00";	//形式为 HH:mm:ss
	public String briefIntro;   		//简单介绍
	public String facility;			 	//酒店（基础）设施（WiFi available？……）
	public String imageAddress ="默认酒店图片地址";			//酒店图片

	private String district;
	private String province;
	private String city;
	private String area;
	/**
	 * 网站管理人员添加酒店时调用
	 * @param hotelID
	 * @param hotelName
	 * @param detailAddress
	 * @param tel
	 * @param password
	 */
	public HotelVO(String hotelID, String hotelName,String detailAddress,String tel,String password){
		this.hotelID = hotelID;
		this.name = hotelName;
		this.addr = detailAddress;
		this.tel = tel;
		this.password = password;
	}
	

	/**
	 * 酒店调用
	 * @param hotelID
	 * @param hotelName
	 * @param detailAddress
	 * @param tel
	 * @param password
	 * @param level
	 * @param standardRoomPrice
	 * @param latestCheckInTime
	 * @param briefIntro
	 * @param facility
	 * @param imageAddress
	 */
	public HotelVO(String hotelID, String hotelName,String detailAddress,String tel,String password,
			int level, double standardRoomPrice,
			String latestCheckInTime,String briefIntro,String facility, String imageAddress){
		this.hotelID = hotelID;
		this.name = hotelName;
		this.addr = detailAddress;
		this.tel = tel;
		this.password = password;
		
		this.level = level;
		this.standardRoomPrice = standardRoomPrice;
		this.latestCheckinTime = latestCheckInTime;
		this.briefIntro = briefIntro;
		this.facility = facility;
		this.imageAddress = imageAddress;
		
		this.district = hotelID.substring(0,DISTRICT_LENGTH);
	}
	
	public String getHotelID(){
		return hotelID;
	}
	public String getHotelName(){
		return name;
	}
	public String getDistrict(){
		return district;
	}
	public String getDetailAddress(){
		return addr;
	}
	public String getTel(){
		return tel;
	}
	public int getLevel(){
		return level;
	}
	public double getGrade(){
		return grade;
	}
	
	public String getProvince(){
		return province;
	}
	public String getCity(){
		return city;
	}
	
	public String getArea(){
		return area;
	}
	public HotelPO changeIntoPO(){
		HotelPO hotelPO = new HotelPO(hotelID, password, tel, name, addr, district, briefIntro, facility, level, grade, standardRoomPrice);
		return hotelPO;
	}
	
	
	
}
