package data.daoimpl.webstaffdaoimpl;

import constant.ResultMessage;
import data.dao.webstaffdao.WebSalesmanDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.WebManagerDaoHelper;
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
    private WebManagerDaoHelper webManagerDaoHelper;
    private DaoHelperFactory daoHelperFactory;

    private WebSalesmanDaoImpl()throws  RemoteException{}

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



    @Override
    public ResultMessage insertWebSalesman(WebSalesmanPO webSalesmanPO) throws RemoteException {
        return null;
    }

    public ResultMessage updateWebSalesman(WebSalesmanPO webSalesmanPO)throws RemoteException  {
        return null;
    }

    public ResultMessage delWebSalesman(WebSalesmanPO webSalesmanPO)throws RemoteException  {
        return null;
    }

    public WebSalesmanPO getSalesmanInstance(String SalesmanID)throws RemoteException  {
        return null;
    }

    public ArrayList<WebSalesmanPO> finds(String district)throws RemoteException  {
        return null;
    }

    public ArrayList<WebSalesmanPO> getAll()throws RemoteException {
        return null;
    }
}
