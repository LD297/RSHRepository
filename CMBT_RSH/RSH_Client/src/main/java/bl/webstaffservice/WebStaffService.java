package bl.webstaffservice;


import constant.ResultMessage;
import vo.WebSalesmanVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface WebStaffService {

	// TODO

	
	public String getIDForWebsalesman();
	
	public ResultMessage addWebSalesman(WebSalesmanVO webSalesmanVO);
	
	/**
	 * 网站管理人员调用所有营销人员信息
	 * @return
	 */
	public ArrayList<WebSalesmanVO> getWebSalesmanInfo();
	
	public ResultMessage changePassword(String ID,String oldPassword, String newPassword);
	
	/**
	 * 更新网站营销人员信息
	 * @param ID
	 * @param password
	 * @return
	 */
	public ResultMessage updateWebSalesman(WebSalesmanVO webSalesmanVO);
	

}
