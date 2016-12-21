package vo;

import po.WebSalesmanPO;

public class WebSalesmanVO {
	
	String webSalesmanID;
	String password ;
	String name;
	
	/**
	 * these can be converted
	 */
	String district;
	String province;
	String city;
	String area;
	
	public WebSalesmanVO(String webSalesmanID,String district,String password,String name) {
		this.webSalesmanID = webSalesmanID;
		this.password = password;
		this.name = name;
		setDistrict(district);
	}
	
	public WebSalesmanVO(String webSalesmnaID,String province,String city,String area,
			String password,String name){
		this.webSalesmanID  = webSalesmnaID;
		this.password = password;
		this.name = name;
		setDistrict(province,city,area);
	}
	
	
	public String getId() {
		return webSalesmanID;
	}
	public String getProvince() {
		return province;
	}
	public String getCity() {
		return city;
	}
	public String getArea(){
		return area;
	}
	public String getDistrict() {
		return district;
	}
	public String getName() {
		return name;
	}

	public void setDistrict(String province,String city,String area){
		this.province = province;
		this.city = city;
		this.area = area;
		DistrictHelper districtHelper = new DistrictHelper(province, city, area);
		this.district = districtHelper.getDistrict();
	}
	public void setDistrict(String district) {
		this.district = district;
		DistrictHelper districtHelper = new DistrictHelper(district);
		this.province = districtHelper.getProvince();
		this.city = districtHelper.getCity();
		this.area = districtHelper.getArea();
	}


	public WebSalesmanPO changeIntoPO(){
		WebSalesmanPO webSalesmanPO = new WebSalesmanPO(webSalesmanID, district, password, name);
		return webSalesmanPO;
	}
}
