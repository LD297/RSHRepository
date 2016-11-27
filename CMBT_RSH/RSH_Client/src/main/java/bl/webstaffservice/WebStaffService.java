package bl.webstaffservice;


import constant.ResultMessage;
import vo.WebSalesmanVO;

import java.util.ArrayList;

public interface WebStaffService {

	public ResultMessage addWebSalesman(String ID,String password);
	
	public ResultMessage delWebSalesman(String ID);
	
	public ArrayList<WebSalesmanVO> getWebSalesman();
	
	public ResultMessage changePassword(String ID,String oldPassword, String newPassword);
	
	public ResultMessage addWebManager(String ID,String password);
	

}
