package bl.webstaffservice;


import constant.ResultMessage;
import vo.WebSalesmanVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface WebStaffService {

	// TODO

	/**
	 * 网站管理人员添加网站营销人员时调用，生成id
	 * @return
	 */
	public String getIDForWebsalesman();
	/**
	 * 网站营销人员初始化密码后，完成注册调用
	 * @param webSalesmanVO
	 * @return
	 */
	public ResultMessage addWebSalesman(WebSalesmanVO webSalesmanVO);
	/**
	 * 网站管理人员查询网站营销人员信息
	 * @return
	 */
	public ArrayList<WebSalesmanVO> getWebSalesmanInfo();
	/**
	 * 网站管理人员更改网站营销人员信息（修改密码）
	 * @param ID
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage changePassword(String ID,String oldPassword, String newPassword)throws RemoteException;
	
	public ResultMessage addWebManager(String ID,String password);
	

}
