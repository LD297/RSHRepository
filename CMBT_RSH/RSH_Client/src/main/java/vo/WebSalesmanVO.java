package vo;

import po.WebSalesmanPO;

public class WebSalesmanVO {
	String id;
	String province;
	String city;
	String area;
	String district;
	String password;
	String name;
	
	public WebSalesmanVO(String webSalesmnaID,String province,String city,String area,String name){
		this.id  = webSalesmnaID;
		this.province = province;
		this.city = city;
		this.area = area;
		this.name = name;
	}
	
	public WebSalesmanVO(String webSalesmanID,String district,String password,String name) {
		this.id = webSalesmanID;
		this.password = password;
		this.name = name;
		province = DistrictHelper.getProvince(district);
		city = DistrictHelper.getCity(district);
		area = DistrictHelper.getArea(district);
	}
	public String getId() {
		return id;
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
	
	public String getPassword() {
		return password;
	}
	
	public WebSalesmanPO changeIntoPO(){
		WebSalesmanPO webSalesmanPO = new WebSalesmanPO(id, district, password, name);
		return webSalesmanPO;
	}
}
