package data.daohelperimpl.logindaohelperimpl;

import constant.ResultMessage;
import constant.Role;
import po.OnlinePersonPO;

import java.rmi.RemoteException;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class test {
    LoginDaoHelperMySql loginDao = new LoginDaoHelperMySql();
    public void addOnline() throws RemoteException{
        OnlinePersonPO po = new OnlinePersonPO(Role.user,"","123456");
        ResultMessage result = loginDao.addOnline(po);
    }

    public void deleteOnline() throws RemoteException{
        Role role = Role.user;
        String id = "";
        ResultMessage result = loginDao.deleteOnline(role,id);
    }
}
