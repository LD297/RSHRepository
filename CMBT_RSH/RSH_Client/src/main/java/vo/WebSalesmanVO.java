package vo;

public class WebSalesmanVO {
	String id;
	String province;
	String city;
	String district;
	String password;
	public WebSalesmanVO(String id,String province,String city,String district,String password) {
		this.id = id;
		this.province = province;
		this.city = city;
		this.district = district;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
