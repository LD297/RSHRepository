package bl.webstaffservice;


import constant.ResultMessage;
import vo.WebSalesmanVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface WebStaffService {

	// TODO

	/**
	 * 网管添加营销人员
	 * @return
	 */
	public String getIDForWebsalesman();
	
	/**
	 * 网管添加营销人员
	 * @param webSalesmanVO
	 * @return
	 */
	public ResultMessage addWebSalesman(WebSalesmanVO webSalesmanVO);
	
	/**
	 * 网站管理人员调用所有营销人员信息
	 * @return
	 */
	public ArrayList<WebSalesmanVO> getAllWebSalesmen();
	
	/**
	 * 网站营销人员修改密码
	 * @param ID
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public ResultMessage changePassword(String ID,String oldPassword, String newPassword);
	
	/**
	 * 更新网站营销人员信息
	 * @param ID
	 * @param password
	 * @return
	 */
	public ResultMessage updateWebSalesman(WebSalesmanVO webSalesmanVO);
	
	/**
	 * getWebSalesman
	 * @param webSalesmanID
	 * @return
	 */
	public WebSalesmanVO webSalesmanVO(String webSalesmanID);	

}
