package data.daoimpl.webstaffdaoimpl;

import constant.ResultMessage;
import data.dao.webstaffdao.WebManagerDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.WebManagerDaoHelper;
import po.WebManagerPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by aa on 2016/11/22.
 */
public class WebManagerDaoImpl extends UnicastRemoteObject implements WebManagerDao {
    private static WebManagerDaoImpl webManagerDaoImpl;
    private WebManagerDaoHelper webManagerDaoHelper;
    private DaoHelperFactory daoHelperFactory;

    private WebManagerDaoImpl()throws  RemoteException{}


    public static WebManagerDaoImpl getInstance(){
        if(webManagerDaoImpl == null){
            try {
                webManagerDaoImpl = new WebManagerDaoImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return webManagerDaoImpl;
    }


    @Override
    public ResultMessage updateManager(WebManagerPO webManagerPO) throws RemoteException {
        return null;
    }

    public WebManagerPO getManagerInstance(String managerID)throws RemoteException{
        return null;
    }
}
