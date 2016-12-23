package data.dao.webstaffdao;

import constant.ResultMessage;
import po.WebSalesmanPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by aa on 2016/11/19.
 */
public interface WebSalesmanDao extends Remote {

	public String getNewID() throws RemoteException;
	
    public ResultMessage insert(WebSalesmanPO webSalesmanPO)throws RemoteException;

    public ResultMessage update(WebSalesmanPO webSalesmanPO)throws RemoteException;

   public WebSalesmanPO findByID(String SalesmanID)throws RemoteException;

    public ArrayList<WebSalesmanPO> findByDistrict(String district)throws RemoteException;

    public ArrayList<WebSalesmanPO> getAll()throws RemoteException;
}
