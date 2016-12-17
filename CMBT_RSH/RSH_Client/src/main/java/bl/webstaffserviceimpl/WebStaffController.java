package bl.webstaffserviceimpl;

import bl.webstaffservice.WebStaffService;
import constant.ResultMessage;
import vo.WebSalesmanVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 * 网站工作人员总控
 * @author aa
 *
 */
public class WebStaffController implements WebStaffService{

	
	public ResultMessage addWebSalesman(String ID, String password) {
		// TODO Auto-generated method stub
		WebSalesman webSalesman= new WebSalesman(ID,password);
		return null;
	}

	public ResultMessage delWebSalesman(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<WebSalesmanVO> getWebSalesman() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIDForNewWebSalesman() {
		return null;
	}

	
	public static ResultMessage checkPassword(String ID, String password) {
		return null;
	}



	public ResultMessage forceChangePassword(String ID, String password) {
		return null;
	}


	@Override
	public ResultMessage changePassword(String ID, String oldPassword,String newPassword) {
		// TODO Auto-generated method stub
		if(ID=="0000000000"){
			WebManager manager = null;
			try {
				manager = WebManager.getInstance();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				return manager.changePassword(oldPassword,newPassword);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResultMessage.remote_fail;
			}
		}
		else{

		}
		return null;
	}

	@Override
	public ResultMessage addWebManager(String ID, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIDForWebsalesman() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addWebSalesman(WebSalesmanVO webSalesmanVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WebSalesmanVO> getWebSalesmanInfo() {
		// TODO Auto-generated method stub
		return null;
	}



}
