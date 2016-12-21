package vo;

import po.WebSalesmanPO;

public class WebSalesmanVO {
	
	String webSalesmanID;
	String district;
	String password = "sadghgfhj";
	String name;
	
	/**
	 * these will be get from district
	 */
	String province;
	String city;
	String area;
	
	public WebSalesmanVO(String webSalesmnaID,String province,String city,String area,String name){
		this.webSalesmanID  = webSalesmnaID;
		this.province = province;
		this.city = city;
		this.area = area;
		this.name = name;
	}
	
	public WebSalesmanVO(String webSalesmanID,String district,String password,String name) {
		this.webSalesmanID = webSalesmanID;
		this.password = password;
		this.name = name;
		DistrictHelper districtHelper = new DistrictHelper(district);
		province = districtHelper.getProvince();
		city = districtHelper.getCity();
		area = districtHelper.getArea();
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

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String webSalesmanID) {
		this.webSalesmanID = webSalesmanID;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public WebSalesmanPO changeIntoPO(){
		WebSalesmanPO webSalesmanPO = new WebSalesmanPO(webSalesmanID, district, password, name);
		return webSalesmanPO;
	}
}
