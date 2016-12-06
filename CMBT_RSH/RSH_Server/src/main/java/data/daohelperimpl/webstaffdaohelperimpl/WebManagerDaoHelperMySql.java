package data.daohelperimpl.webstaffdaohelperimpl;

import constant.ResultMessage;
import data.daohelper.WebManagerDaoHelper;
import po.WebManagerPO;

import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/12/3.
 * WebManager has only one id is"0000000000",can set the password as 123456
 * or can save with webstaff;
 * 
 */
public class WebManagerDaoHelperMySql implements WebManagerDaoHelper {
    public ResultMessage updateManager (String managerID, String password)throws RemoteException {
        return  ResultMessage.succeed;
    }


    public WebManagerPO getManagerInstance(String managerID)throws RemoteException{
        return null;
    }
}
