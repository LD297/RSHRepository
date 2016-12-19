package data.dao_Stub.webstaff_Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import constant.ResultMessage;
import data.dao.webstaffdao.WebSalesmanDao;
import po.WebSalesmanPO;

/**
 * 
 * @author aa
 *
 */
public class WebSalesman_Stub implements WebSalesmanDao{

	@Override
	public String getIDForNewWebSalesman(String year) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addWebSalesman(WebSalesmanPO webSalesmanPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateWebSalesman(WebSalesmanPO webSalesmanPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebSalesmanPO getSalesmanInstance(String SalesmanID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WebSalesmanPO> finds(String district) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WebSalesmanPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
