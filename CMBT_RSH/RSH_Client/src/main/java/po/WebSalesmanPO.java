package po;

import bl.webstaffserviceimpl.WebSalesman;
import vo.WebSalesmanVO;

public class WebSalesmanPO {

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
		WebSalesmanVO webSalesmanVO = new WebSalesmanVO();
		return webSalesmanVO;
	}

}
