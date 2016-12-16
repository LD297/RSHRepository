package data.daohelper;

import constant.ResultMessage;
import po.WebManagerPO;

import java.rmi.RemoteException;

/**
 * Created by aa on 2016/12/3.
 */
public interface WebManagerDaoHelper {

    public ResultMessage update(String managerID,String password) throws RemoteException ;

    public WebManagerPO getManagerInfo(String managerID)throws RemoteException;
}
