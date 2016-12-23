package data.daoimpl.webstaffdaoimpl;

import constant.ResultMessage;
import data.dao.webstaffdao.WebSalesmanDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.WebManagerDaoHelper;
import data.daohelper.WebSalesmanDaoHelper;
import data.daohelperimpl.DaoHelperFactoryImpl;
import po.WebSalesmanPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by aa on 2016/11/22.
 */

public class WebSalesmanDaoImpl extends UnicastRemoteObject implements WebSalesmanDao {

    private static WebSalesmanDaoImpl webSalesmanDaoImpl;
    private WebSalesmanDaoHelper webSalesmanDaoHelper;
    private DaoHelperFactory daoHelperFactory;

    private WebSalesmanDaoImpl()throws  RemoteException{
        daoHelperFactory = new DaoHelperFactoryImpl();
        webSalesmanDaoHelper = daoHelperFactory.getWebSalesManDaoHelper();
    }

    public static WebSalesmanDaoImpl getInstance(){
        if(webSalesmanDaoImpl == null){
            try {
                webSalesmanDaoImpl = new WebSalesmanDaoImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return webSalesmanDaoImpl;
    }

    public ResultMessage insert(WebSalesmanPO po) throws RemoteException {
        return webSalesmanDaoHelper.insert(po);
    }

    public ResultMessage update(WebSalesmanPO po)throws RemoteException  {
        return webSalesmanDaoHelper.update(po);
    }

    public WebSalesmanPO findByID(String websalesmanID)throws RemoteException  {
        return webSalesmanDaoHelper.findByID(websalesmanID);
    }

    public ArrayList<WebSalesmanPO> findByDistrict(String district)throws RemoteException  {
        return webSalesmanDaoHelper.findByDistrict(district);
    }

    public ArrayList<WebSalesmanPO> getAll()throws RemoteException {
        return webSalesmanDaoHelper.getAll();
    }

	@Override
	public String getNewID() throws RemoteException {		
		return webSalesmanDaoHelper.getNewID();
	}
}
