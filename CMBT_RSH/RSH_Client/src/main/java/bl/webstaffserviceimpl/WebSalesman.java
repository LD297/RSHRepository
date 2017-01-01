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
	
	
	public WebSalesman(String webSalesmanID, String district, String password,String name) {
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
			webSalesmanPO = webSalesmanDao.findByID(id);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(webSalesmanPO==null){
			return null;
		}
		WebSalesman webSalesman = webSalesmanPO.changeIntoWebSalesman();
		return webSalesman;
	}

	

	public ResultMessage update(){
		initRemote();
		try {
			return webSalesmanDao.update(this.changeIntoPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	

	public ResultMessage changePassword(String oldPassword, String newPassword) {
		if(password.equals(oldPassword)){
			password = newPassword;
			return update();
		}
		return ResultMessage.password_wrong;
	}

	public ResultMessage checkPassword(String password) {
		if(this.password.equals( password )){
			return ResultMessage.succeed;
		}
		else{
			return ResultMessage.password_wrong;
		}
	}

	
	public WebSalesmanPO changeIntoPO(){
		WebSalesmanPO webSalesmanPO = new WebSalesmanPO(webSalesmanID, district, password, name);
		return webSalesmanPO;
	}
	
	public WebSalesmanVO changeIntoVO(){
		WebSalesmanVO webSalesmanVO = new WebSalesmanVO(webSalesmanID, district, password, name);
		return webSalesmanVO;
	}

}
