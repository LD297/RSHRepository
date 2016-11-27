package bl.webstaffserviceimpl;

import bl.webstaffservice.WebStaffService;
import constant.ResultMessage;
import vo.WebSalesmanVO;

import java.util.ArrayList;
/**
 * 网站工作人员总控
 * @author aa
 *
 */
public class WebStaffController implements WebStaffService{

	
	@Override
	public ResultMessage addWebSalesman(String ID, String password) {
		// TODO Auto-generated method stub
		WebSalesman webSalesman= new WebSalesman(ID,password);
		return null;
	}

	@Override
	public ResultMessage delWebSalesman(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WebSalesmanVO> getWebSalesman() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage changePassword(String ID, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		if(ID=="0000000000"){
			WebManager manager = WebManager.getInstance();
			return manager.changePassword(oldPassword,newPassword);
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



}
