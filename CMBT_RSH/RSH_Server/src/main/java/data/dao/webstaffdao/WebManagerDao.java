package data.dao.webstaffdao;

import constant.ResultMessage;
import po.WebManagerPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by aa on 2016/11/22.
 */
public interface WebManagerDao extends Remote{
    public ResultMessage update (WebManagerPO webManagerPO)throws RemoteException;

    public WebManagerPO getManagerInfo(String managerID)throws RemoteException;

//    public ResultMessage insertManagerPO(WebManagerPO webManagerPO)throws RemoteException;
}
