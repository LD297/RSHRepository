package data.daoimpl.webstaffdaoimpl;

import constant.ResultMessage;
import data.dao.webstaffdao.WebManagerDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.WebManagerDaoHelper;
import data.daohelperimpl.DaoHelperFactoryImpl;
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

    private WebManagerDaoImpl()throws  RemoteException{
        daoHelperFactory = new DaoHelperFactoryImpl();
        webManagerDaoHelper = daoHelperFactory.getWebManagerDaoHelper();
    }


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


    public ResultMessage update(WebManagerPO po) throws RemoteException {
        return webManagerDaoHelper.update(po);
    }

    public WebManagerPO getManagerInfo(String webmanagerid)throws RemoteException{
        return webManagerDaoHelper.getManagerInfo(webmanagerid);
    }
}
