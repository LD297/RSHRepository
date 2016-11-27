package bl.webstaffserviceimpl;

import constant.ResultMessage;
import data.dao.webstaffdao.WebSalesmanDao;
import rmi.RemoteHelper;

public class WebSalesman {

	String ID;
	String password;
	String district;

	private WebSalesmanDao webSalesmanDao = RemoteHelper.getInstance().getWebSalesmanDao();

	public WebSalesman(String id, String tempPassword) {
		// TODO Auto-generated constructor stub
		ID=id;
		password=tempPassword;
	}

	public static WebSalesman getInstance(String id){
		
		return null;
	}

	public ResultMessage insert(){

		return null;
	}

	public ResultMessage update(){
		
		return null;
	}

}
