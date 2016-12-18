package bl.webstaffserviceimpl;

import java.rmi.RemoteException;

import constant.ResultMessage;
import data.dao.webstaffdao.WebSalesmanDao;
import po.WebSalesmanPO;
import rmi.RemoteHelper;
import vo.WebSalesmanVO;

public class WebSalesman {

	private static WebSalesmanDao webSalesmanDao = null;
	String name;
	String webSalesmanID;
	String password;
	String district;

	private static void initRemote(){
		if(webSalesmanDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			webSalesmanDao = remoteHelper.getWebSalesmanDao();
		}
	}
	
	
	private WebSalesman(String webSalesmanID, String district, String password,String name) {
		// TODO Auto-generated constructor stub
		this.webSalesmanID = webSalesmanID;
		this.district = district;
		this.password = password;
		this.name = name;
	}

	public static WebSalesman getInstance(String id){
		initRemote();
		WebSalesmanPO webSalesmanPO = null;
		try {
			webSalesmanPO = webSalesmanDao.getSalesmanInstance(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebSalesman webSalesman = new WebSalesman(webSalesmanPO.getID(), 
				webSalesmanPO.getDistrict(),webSalesmanPO.getPassword(),webSalesmanPO.getName());
		return webSalesman;
	}

	public ResultMessage insert(WebSalesmanVO webSalesmanVO){
		WebSalesmanPO webSalesmanPO = webSalesmanVO.changeIntoPO();
		return webSalesmanPO;
	}

	public ResultMessage update(){
		
		return null;
	}

}
