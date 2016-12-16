package data.daohelper;

import constant.ResultMessage;
import po.UserPO;

import java.rmi.RemoteException;

/**
 * Created by aa on 2016/12/3.
 */
public interface UserDaoHelper {

    public UserPO getInfo(String id) throws RemoteException ;

    public ResultMessage update(UserPO po) throws RemoteException ;

    public ResultMessage insert(UserPO po) throws RemoteException ;

    public ResultMessage setMemberLevel(int[] gradeWithCredit) throws RemoteException ;
}
