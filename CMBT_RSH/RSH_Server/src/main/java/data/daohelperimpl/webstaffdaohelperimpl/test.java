package data.daohelperimpl.webstaffdaohelperimpl;

import static org.junit.Assert.*;
import constant.ResultMessage;
import data.daohelper.WebSalesmanDaoHelper;
import po.WebManagerPO;
import po.WebSalesmanPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class test {
    WebSalesmanDaoHelperMySql salesDao = new WebSalesmanDaoHelperMySql() ;
    @Test
    public void testinsert()throws RemoteException{
    	String id = salesDao.getNewID();
        WebSalesmanPO webSalesmanPO = new WebSalesmanPO(id,"123456","李峰","215300");
        ResultMessage result = salesDao.insert(webSalesmanPO);
        String id2 = salesDao.getNewID();
        WebSalesmanPO anotherPO = new WebSalesmanPO(id2,"1234**56","李洛克","215300");
        salesDao.insert(anotherPO);
        assertEquals(result,ResultMessage.succeed);
    }
    @Test
    public void testsalseupdate()throws RemoteException{
    	String id = "2016000001";
        WebSalesmanPO webSalesmanPO = new WebSalesmanPO(id,"765442","周延","215300");
        ResultMessage result = salesDao.update(webSalesmanPO) ;
        assertEquals(result,ResultMessage.succeed);
    }
    @Test
    public void testfindByID()throws RemoteException{
        String id = "2016000001";
        WebSalesmanPO po = salesDao.findByID(id);
        assertEquals(po.getDistrict(),"215300");
    }
    @Test
    public void testfindByDistrict()throws RemoteException{
        String district = "215300";
        ArrayList<WebSalesmanPO> list = salesDao.findByDistrict(district);
        assertEquals(list.get(1).getName(),"李峰");
    }
    @Test
    public void testgetAll()throws RemoteException{
        ArrayList<WebSalesmanPO> list = salesDao.getAll();
        assertEquals(list.get(0).getName(),"周延");
    }
    WebManagerDaoHelperMySql managerDao = new WebManagerDaoHelperMySql();
    @Test
    public void testupdate ()throws RemoteException{
        ResultMessage result = managerDao.update("2016000001","1234567890");
        assertEquals(result,ResultMessage.succeed);
    }
    @Test
    public void testgetManagerInfo()throws RemoteException{
        String managerID = "0000000000";
        WebManagerPO po = managerDao.getManagerInfo(managerID);
        assertEquals(po.getPassword(),"123456");
    }


}
