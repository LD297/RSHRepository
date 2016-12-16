package data.daohelperimpl.webstaffdaohelperimpl;

import constant.ResultMessage;
import data.daohelper.WebSalesmanDaoHelper;
import po.WebManagerPO;
import po.WebSalesmanPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by sky-PC on 2016/12/12.
 */
public class test {
    WebSalesmanDaoHelperMySql salesDao = new WebSalesmanDaoHelperMySql() ;
    public void testinsert()throws RemoteException{
        WebSalesmanPO webSalesmanPO = new WebSalesmanPO("","123456","215300");
        ResultMessage result = salesDao.insert(webSalesmanPO);
    }

    public void testsalseupdate()throws RemoteException{
        WebSalesmanPO webSalesmanPO = new WebSalesmanPO("","765442","215300");
        ResultMessage result = salesDao.update(webSalesmanPO) ;
    }

    public void testdelete()throws RemoteException{
        String id = "";
        ResultMessage result = salesDao.delete(id);
    }

    public void testfindByID()throws RemoteException{
        String id = "";
        WebSalesmanPO po = salesDao.findByID(id);
    }

    public void testfindByDistrict()throws RemoteException{
        String district = "";
        ArrayList<WebSalesmanPO> list = salesDao.findByDistrict(district);
    }

    public void testgetAll()throws RemoteException{
        ArrayList<WebSalesmanPO> list = salesDao.getAll();
    }
    WebManagerDaoHelperMySql managerDao = new WebManagerDaoHelperMySql();
    public void testupdate ()throws RemoteException{
        WebManagerPO webManagerPO = new WebManagerPO("","123456");
        ResultMessage result = managerDao.update(webManagerPO);
    }

    public void testgetManagerInfo()throws RemoteException{
        String managerID = "";
        WebManagerPO po = managerDao.getManagerInfo(managerID);
    }


}
