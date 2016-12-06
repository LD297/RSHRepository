package data.daohelperimpl.webstaffdaohelperimpl;

import constant.ResultMessage;
import data.daohelper.WebManagerDaoHelper;
import po.WebManagerPO;

import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class WebManagerDaoHelperMySql implements WebManagerDaoHelper{
    // with websalesman

    public ResultMessage updateManager (String managerID, String password)throws RemoteException {
        return  ResultMessage.succeed;
    }


    public WebManagerPO getManager(String managerID)throws RemoteException{
        return null;
    }
}
