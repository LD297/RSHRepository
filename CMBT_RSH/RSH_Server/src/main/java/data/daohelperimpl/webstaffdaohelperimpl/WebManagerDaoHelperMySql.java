package data.daohelperimpl.webstaffdaohelperimpl;

import constant.ResultMessage;
import data.daohelper.WebStaffDaoHelper;
import po.WebManagerPO;

import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class WebManagerDaoHelperMySql implements WebStaffDaoHelper {
    public ResultMessage updateManager (String managerID, String password)throws RemoteException {
        return  ResultMessage.succeed;
    }


    public WebManagerPO getManagerInstance(String managerID)throws RemoteException{
        return null;
    }
}
