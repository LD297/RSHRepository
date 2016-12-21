package vo;

import po.HotelPO;

public class HotelVO {

	private static final int DISTRICT_LENGTH = 6;

	private String hotelID;
<<<<<<< HEAD
	public String name; //酒店名称
	private String addr;
	public String tel;

	private String password;

	private int level = -1; 				//星级，未设置时置为-1，最大为5;
	private double grade = 0;		 	//酒店评分所有用户评分的均值
	public double standardRoomPrice ; 	//标准间价格（酒店价格排序标准）

	public String latestCheckinTime = "23:45:00";	//形式为 HH:mm:ss
	public String briefIntro;   		//简单介绍
	public String facility;			 	//酒店（基础）设施（WiFi available？……）
	public String imageAddress ="默认酒店图片地址";			//酒店图片
=======
	private String detailAddress;
	public String hotelName; 
	public String tel; 
	
	private String password;
	
	private double grade = 0;		 				//酒店评分所有用户评分的均值
	private int level = -1; 						//星级，未设置时置为-1，最大为5;
	private double standardRoomPrice ; 				//标准间价格（酒店价格排序标准）
	
<<<<<<< HEAD
	public String latestCheckInTime = "23:45:00";			//形式为 HH:mm:ss
	public String briefIntro;   							//简单介绍
	public String facility = "0000";			 			//酒店（基础）设施（WiFi available？……）
	public String imageAddress ="默认酒店图片地址";			//酒店图片地址
>>>>>>> origin/master
=======
	private String latestCheckInTime = "23:45:00";			//形式为 HH:mm:ss
	private String briefIntro;   							//简单介绍
	private String facility = "0000";			 			//酒店（基础）设施（WiFi available？……）
	private String imageAddress ="默认酒店图片地址";			//酒店图片地址
>>>>>>> origin/master

	/**
	 * these will be get from hotelID and the detailAddress;
	 */
	private String district;
	private String province;
	private String city;
	private String area;
	private String fullAddress;
	
	/**
	 * these will be get from the facility String 
	 */
	private boolean hasWIFI = false;
	private boolean hasSwimmingPool = false;
	private boolean hasPark = false;
	private boolean hasCanteen = false;
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
		this.hotelName = hotelName;
		this.detailAddress = detailAddress;
		this.tel = tel;
		this.password = password;
<<<<<<< HEAD
	}

=======
		
		constructHelper();
		}
	
>>>>>>> origin/master

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
		this.hotelName = hotelName;
		this.detailAddress = detailAddress;
		this.tel = tel;
		this.password = password;

		this.level = level;
		this.standardRoomPrice = standardRoomPrice;
		this.latestCheckInTime = latestCheckInTime;
		this.briefIntro = briefIntro;
		this.facility = facility;
		this.imageAddress = imageAddress;
<<<<<<< HEAD

		this.district = hotelID.substring(0,DISTRICT_LENGTH);
=======
		
		constructHelper();
	}
	
	private void constructHelper(){
		this.district = hotelID.substring(0, DISTRICT_LENGTH);
		DistrictHelper districtHelper = new DistrictHelper(district);
		this.province = districtHelper.getProvince();
		this.city = districtHelper.getCity();
		this.area = districtHelper.getArea();
		this.fullAddress = province+city+area+detailAddress;
	
		if(!facility.equals("0000")){
			if(facility.charAt(0)=='1')hasWIFI = true;
			if(facility.charAt(1)=='1')hasSwimmingPool = true;
			if(facility.charAt(2)=='1')hasPark = true;
			if(facility.charAt(3)=='1')hasCanteen = true;
		}
>>>>>>> origin/master
	}

	public String getHotelID(){
		return hotelID;
	}
	public String getHotelName(){
		return hotelName;
	}
	public String getDetailAddress(){
		return detailAddress;
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
<<<<<<< HEAD

=======
	public double getStandardRoomPrice(){
		return standardRoomPrice;
	}
	
	public String getLatestCheckInTime(){
		return latestCheckInTime;
	}
	public String getBriefIntro(){
		return briefIntro;
	}
	public String getFacility(){
		return facility;
	}
	public String getImageAddress(){
		return imageAddress;
	}
	
	public String getDistrict(){
		return district;
	}
>>>>>>> origin/master
	public String getProvince(){
		return province;
	}
	public String getCity(){
		return city;
	}
<<<<<<< HEAD

=======
>>>>>>> origin/master
	public String getArea(){
		return area;
	}
	public String getFullAddress(){
		return fullAddress;
	}
	
	public boolean hasWIFI(){
		return hasWIFI;
	}
	public boolean hasSwimmingPool(){
		return hasSwimmingPool;
	}
	public boolean hasPark(){
		return hasPark;
	}
	public boolean hasCanteen(){
		return hasCanteen;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	public void setLatestCheckInTime(String latestCheckInTime){
		this.latestCheckInTime = latestCheckInTime;
	}
	public void setBriefIntro(String briefIntro){
		this.briefIntro = briefIntro;
	}
	public void setFacility(String facility){
		this.facility = facility;
	}
	public void setImageAddress(String imageAddress){
		this.imageAddress = imageAddress;
	}
	
	
	public HotelPO changeIntoPO(){
		HotelPO hotelPO = new HotelPO(hotelID, password, tel, hotelName, detailAddress, district, briefIntro, facility, level, grade, standardRoomPrice);
		return hotelPO;
	}


	public void setPassword(String password) {
		this.password = password;
	}



}