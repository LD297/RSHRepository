package po;

import java.io.Serializable;

import bl.webstaffserviceimpl.WebSalesman;
import vo.WebSalesmanVO;

public class WebSalesmanPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String webSalesmanID;
	private String password;
	private String district;

	public WebSalesmanPO(String webSalesmanID, String district, String password,String name){
		this.webSalesmanID = webSalesmanID;
		this.district = district;
		this.password = password;
		this.name = name;
	}
	
	public String getID(){
		return webSalesmanID;
	}

	public String getPassword(){
		return password;
	}

	public String getDistrict(){
		return district;
	}

	public String getName(){
		return name;
	}
	public WebSalesmanVO changeIntoVO(){
		WebSalesmanVO webSalesmanVO = new WebSalesmanVO(webSalesmanID, district, password, name);
		return webSalesmanVO;
	}

	public WebSalesman changeIntoWebSalesman() {
		// TODO Auto-generated method stub
		WebSalesman webSalesman = new WebSalesman(webSalesmanID, district, password, name);
		return webSalesman;
	}

}
