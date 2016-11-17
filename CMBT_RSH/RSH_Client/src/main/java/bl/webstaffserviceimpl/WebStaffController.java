package bl.webstaffserviceimpl;

import java.util.ArrayList;

import bl.webstaffservice.WebStaffService;
import constant.ResultMessage;
import vo.WebSalesmanVO;
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
		WebManager manager = new WebManager("S","S");
		manager.changePassword(newPassword);
		return null;
	}

	@Override
	public ResultMessage addWebManager(String ID, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delWebManger(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
