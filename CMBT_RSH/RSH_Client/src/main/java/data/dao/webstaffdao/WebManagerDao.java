package data.dao.webstaffdao;

import constant.ResultMessage;
import po.WebManagerPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by aa on 2016/11/19.
 */
public interface WebManagerDao extends Remote{

    public ResultMessage updateManager (String managerID,String password)throws RemoteException;

    public WebManagerPO getManagerInstance(String managerID)throws RemoteException;

}
