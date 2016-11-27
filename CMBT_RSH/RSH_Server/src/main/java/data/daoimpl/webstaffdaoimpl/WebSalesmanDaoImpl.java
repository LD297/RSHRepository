package data.daoimpl.webstaffdaoimpl;

import data.dao.webstaffdao.WebSalesmanDao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by aa on 2016/11/22.
 */
public class WebSalesmanDaoImpl extends UnicastRemoteObject implements WebSalesmanDao {
    public WebSalesmanDaoImpl()throws RemoteException{}

}
