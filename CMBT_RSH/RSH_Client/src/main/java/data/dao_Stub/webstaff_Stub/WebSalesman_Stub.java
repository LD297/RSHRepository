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
	public String getNewID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insert(WebSalesmanPO webSalesmanPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(WebSalesmanPO webSalesmanPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebSalesmanPO findByID(String SalesmanID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WebSalesmanPO> findByDistrict(String district) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WebSalesmanPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
