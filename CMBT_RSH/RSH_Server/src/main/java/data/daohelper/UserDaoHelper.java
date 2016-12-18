package data.daohelper;

import constant.ResultMessage;
import po.UserPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by aa on 2016/12/3.
 */
public interface UserDaoHelper {

    public UserPO getInfo(String id) throws RemoteException ;

    public ResultMessage update(UserPO po) throws RemoteException ;

    public ResultMessage insert(UserPO po) throws RemoteException ;

    public ResultMessage setMemberLevel(int[] gradeWithCredit) throws RemoteException ;
    
    // 网站管理人员 得到用户信息
 	public ArrayList<UserPO> getAll()throws RemoteException;
}
