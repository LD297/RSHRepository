package po;

import bl.webstaffserviceimpl.WebSalesman;

public class WebSalesmanPO {

	String id;
	String password;
	String district;

	public String getID(){
		return id;
	}

	public String getPassword(){
		return password;
	}

	public String getDistrict(){
		return district;
	}

	public static WebSalesman getInstance (String tempid){
		return null;
	}

	public static WebSalesmanPO changeIntoPo(WebSalesman tempWebSalesman){
		return null;
	}

}
