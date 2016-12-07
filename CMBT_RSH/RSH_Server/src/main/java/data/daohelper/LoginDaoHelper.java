package data.daohelper;

import constant.ResultMessage;
import constant.Role;
import po.OnlinePersonPO;

import java.rmi.RemoteException;

/**
 * Created by aa on 2016/12/3.
 */
public interface LoginDaoHelper {
    public ResultMessage addOnline(OnlinePersonPO po) throws RemoteException ;

    public ResultMessage deleteOnline(Role role, String id) throws RemoteException;
}
