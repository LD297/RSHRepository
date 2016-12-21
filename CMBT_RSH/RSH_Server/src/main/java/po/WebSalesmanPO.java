package po;

import java.io.Serializable;

public class WebSalesmanPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String webSalesmanID;
	String password;
	String district;//6位编码
	public WebSalesmanPO(String webSalesmanID,String password,String district){
		this.webSalesmanID = webSalesmanID;
		this.password = password;
		this.district = district;
	}
	public String getID(){
		return this.webSalesmanID;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getDistrict(){
		return this.district;
	}
}
