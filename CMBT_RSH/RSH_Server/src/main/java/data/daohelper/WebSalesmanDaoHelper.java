package data.daohelper;

import constant.ResultMessage;
import po.WebSalesmanPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by aa on 2016/12/3.
 */
public interface WebSalesmanDaoHelper {
	public void init();
	
    public ResultMessage insert(WebSalesmanPO po) throws RemoteException ;

    public ResultMessage update(WebSalesmanPO po)throws RemoteException  ;

    public WebSalesmanPO findByID(String websalesmanID)throws RemoteException  ;

    public ArrayList<WebSalesmanPO> findByDistrict(String district)throws RemoteException  ;

    public ArrayList<WebSalesmanPO> getAll()throws RemoteException ;
}
