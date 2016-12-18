package po;

import java.io.Serializable;

public class WebSalesmanPO implements Serializable{

	String webSalesmanID;
	String password;
	String name;
	String district;//6位编码
	public WebSalesmanPO(String webSalesmanID,String password,String name,String district){
		this.webSalesmanID = webSalesmanID;
		this.password = password;
		this.name = name;
		this.district = district;
	}
	public String getID(){
		return this.webSalesmanID;
	}
	public String getPassword(){
		return this.password;
	}
	public String getDistrict(){
		return this.district;
	}
	public String getName(){
		return this.name;
	}
}
