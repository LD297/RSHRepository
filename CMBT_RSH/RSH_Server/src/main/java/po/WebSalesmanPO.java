package po;

public class WebSalesmanPO {

	String ID;
	String Password;
	String District;
	public WebSalesmanPO(String id,String password,String district){
		this.ID = id;
		this.Password = password;
		this.District = district;
	}
	public String getID(){
		return this.ID;
	}
	public String getPassword(){
		return this.Password;
	}
	public String getDistrict(){
		return this.District;
	}
}
