package data.daohelperimpl.userdaohelperimpl;

import constant.ResultMessage;
import po.UserPO;

import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/12/3.
 */
public class UserDaoHelperMySql {
    public UserPO getInfo(String id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    public ResultMessage update(UserPO po) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    public ResultMessage add(UserPO po) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    public ResultMessage checkPassword(String id, String password) throws RemoteException {
        // TODO Auto-generated method stub
        return ResultMessage.succeed;
    }

    public ResultMessage register(String id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    public ResultMessage register(String id, String commerceName) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    public ResultMessage setMemberLevel(int[][] gradeWithCredit) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
}
