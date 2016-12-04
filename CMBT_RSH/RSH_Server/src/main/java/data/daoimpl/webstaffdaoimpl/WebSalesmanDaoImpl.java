package data.daoimpl.webstaffdaoimpl;

import constant.ResultMessage;
import data.dao.webstaffdao.WebSalesmanDao;
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

 //   private static WebSalesmanDaoImpl webSalesmanDaoImpl;
    public WebSalesmanDaoImpl()throws RemoteException{
    }

 /*   public static WebSalesmanDaoImpl getWebSalesmanDaoImplInstance(){
        if(webSalesmanDaoImpl ==null) {
            try {
                webSalesmanDaoImpl = new WebSalesmanDaoImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return webSalesmanDaoImpl;
    }*/


    public ResultMessage addWebSalesman(WebSalesmanPO webSalesmanPO) {
        return null;
    }

    public ResultMessage updateWebSalesman(WebSalesmanPO webSalesmanPO) {
        return null;
    }

    public ResultMessage delWebSalesman(WebSalesmanPO webSalesmanPO) {
        return null;
    }

    public WebSalesmanPO getSalesmanInstance(String SalesmanID) {
        return null;
    }

    public ArrayList<WebSalesmanPO> finds(String district) {
        return null;
    }

    public ArrayList<WebSalesmanPO> getAll() {
        return null;
    }
}
