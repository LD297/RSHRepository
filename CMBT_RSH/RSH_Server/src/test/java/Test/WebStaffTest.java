package Test;

import static org.junit.Assert.*;
import constant.ResultMessage;
import data.daohelper.WebSalesmanDaoHelper;
import data.daohelperimpl.webstaffdaohelperimpl.WebManagerDaoHelperMySql;
import data.daohelperimpl.webstaffdaohelperimpl.WebSalesmanDaoHelperMySql;
import po.WebManagerPO;
import po.WebSalesmanPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class WebStaffTest {
    WebSalesmanDaoHelperMySql salesDao =  null ;//new WebSalesmanDaoHelperMySql() ;
    @Test// 添加网站营销人员
    public void testinsert()throws RemoteException{
    	String id = salesDao.getNewID();
        WebSalesmanPO webSalesmanPO = new WebSalesmanPO(id,"123456","215300","天天");
        ResultMessage result = salesDao.insert(webSalesmanPO);
        String id2 = salesDao.getNewID();
        WebSalesmanPO anotherPO = new WebSalesmanPO(id2,"12345678","215300","欢欢");
        salesDao.insert(anotherPO);
        assertEquals(result,ResultMessage.succeed);
    }
    @Test// 更新网站营销人员
    public void testsalseupdate()throws RemoteException{
    	String id = "2016000001";
        WebSalesmanPO webSalesmanPO = new WebSalesmanPO(id,"765442","215300","李为");
        ResultMessage result = salesDao.update(webSalesmanPO) ;
        assertEquals(result,ResultMessage.succeed);
    }
    @Test
    public void testfindByID()throws RemoteException{
        String id = "2016000001";
        WebSalesmanPO po = salesDao.findByID(id);
        assertEquals(po.getDistrict(),"215300");
    }
    
    WebManagerDaoHelperMySql managerDao = new WebManagerDaoHelperMySql();
    @Test// 更新网站管理人员
    public void testupdate ()throws RemoteException{
        ResultMessage result = managerDao.update("2016000001","1234567890");
        assertEquals(result,ResultMessage.succeed);
    }
    @Test// 得到网站管理人员
    public void testgetManagerInfo()throws RemoteException{
        String managerID = "0000000000";
        WebManagerPO po = managerDao.getManagerInfo(managerID);
        assertEquals(po.getPassword(),"123456");
    }
     @Test// 得到网站营销人员
    public void testgetAll()throws RemoteException{
        ArrayList<WebSalesmanPO> list = salesDao.getAll();
        assertEquals(list.size(),3);
    }
    
    @Test
    public void testfindByDistrict()throws RemoteException{
        String district = "215300";
        ArrayList<WebSalesmanPO> list = salesDao.findByDistrict(district);
        assertEquals(list.get(1).getID(),"2016000002");
    }
   

}
