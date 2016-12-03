package data.daohelperimpl.logindaohelperimpl;

import constant.ResultMessage;
import constant.Role;
import po.OnlinePersonPO;

import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class LoginDaoHelperMySql {

    public ResultMessage addOnline(OnlinePersonPO po) throws RemoteException {
        // TODO Auto-generated method stub
        return ResultMessage.succeed;
    }

    public ResultMessage deleteOnline(Role role, String id) throws RemoteException {
        // TODO Auto-generated method stub
        return ResultMessage.succeed;
    }
}
