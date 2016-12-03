package data.daohelperimpl.webstaffdaohelperimpl;

import constant.ResultMessage;
import po.WebManagerPO;

import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class WebManagerDaoHelperMySql {
    public ResultMessage updateManager (String managerID, String password)throws RemoteException {
        return  ResultMessage.succeed;
    }


    public WebManagerPO getManagerInstance(String managerID)throws RemoteException{
        return null;
    }
}
