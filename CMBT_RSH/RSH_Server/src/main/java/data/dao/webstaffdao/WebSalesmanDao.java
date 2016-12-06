package data.dao.webstaffdao;

import constant.ResultMessage;
import po.WebSalesmanPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by aa on 2016/11/22.
 */
public interface WebSalesmanDao extends Remote{

    public ResultMessage insertWebSalesman(WebSalesmanPO webSalesmanPO)throws RemoteException;

    public ResultMessage updateWebSalesman(WebSalesmanPO webSalesmanPO)throws RemoteException;

    public ResultMessage delWebSalesman(WebSalesmanPO webSalesmanPO)throws RemoteException;

    public WebSalesmanPO getSalesmanInstance(String SalesmanID)throws RemoteException;

    public ArrayList<WebSalesmanPO> finds(String district)throws RemoteException;

    public ArrayList<WebSalesmanPO> getAll()throws RemoteException;

}
