package data.daoimpl.webstaffdaoimpl;

import constant.ResultMessage;
import data.dao.webstaffdao.WebManagerDao;
import po.WebManagerPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by aa on 2016/11/22.
 */
public class WebManagerDaoImpl extends UnicastRemoteObject implements WebManagerDao {
    public WebManagerDaoImpl()throws  RemoteException{}


    public ResultMessage updateManager (String managerID, String password)throws RemoteException{
        return  ResultMessage.succeed;
    }


    public WebManagerPO getManagerInstance(String managerID)throws RemoteException{
        return null;
    }
}
