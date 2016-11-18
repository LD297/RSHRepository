package data.dao.webstaffdao;

import java.rmi.Remote;
import java.util.ArrayList;

import constant.ResultMessage;
import po.WebManagerPO;
import po.WebSalesmanPO;

/**
 * 
 * @author aa
 *
 */
public interface WebStaffDao extends Remote{

	public ResultMessage insertWebSalesman (WebSalesmanPO po);
	
	public ResultMessage delWebSalesman (String id);
	
	public ResultMessage updateWebSalesman(WebSalesmanPO po);
	
	public WebSalesmanPO findWebSalesman(String id);
	
	/**
	 * 可根据负责的地区搜索并返回网站营销人员po
	 * @param district
	 * @return
	 */
	public ArrayList<WebSalesmanPO> findsWebSalesman(String district);
	
	/**
	 * 网站管理人员只可以修改密码
	 * @param po
	 * @return
	 */
	public ResultMessage updateWebManager(WebManagerPO po);
	
}
