package bl.webstaffservice;


import constant.ResultMessage;
import vo.WebSalesmanVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface WebStaffService {

	public ResultMessage addWebSalesman(String ID,String password);
	
	public ResultMessage delWebSalesman(String ID);
	
	public ArrayList<WebSalesmanVO> getWebSalesman();

	public String getIDForNewWebSalesman();

	public boolean checkPassword(String ID, String password);

	public ResultMessage changePassword(String ID,String oldPassword, String newPassword)throws RemoteException;

	public ResultMessage forceChangePassword(String ID, String password);

	public ResultMessage addWebManager(String ID,String password);
	

}
