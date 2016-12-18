package data.daohelperimpl.logindaohelperimpl;

import static org.junit.Assert.*;
import constant.ResultMessage;
import constant.Role;
import po.OnlinePersonPO;

import java.rmi.RemoteException;

import org.junit.Test;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class test {
    static LoginDaoHelperMySql loginDao = new LoginDaoHelperMySql();
    
    @Test
    public void addOnline() throws RemoteException{
    	loginDao.init();
        OnlinePersonPO po = new OnlinePersonPO(Role.user,"12345678","123456");
        ResultMessage result = loginDao.addOnline(po);
        
    
        Role role = Role.user;
        String id = "12345678";
        ResultMessage result1 = loginDao.deleteOnline(role,id);
        assertEquals(result1,ResultMessage.succeed);
    }
}
