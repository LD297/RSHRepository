package data.dao.webstaffdao;

import constant.ResultMessage;
import po.WebSalesmanPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by aa on 2016/11/22.
 */
public interface WebSalesmanDao extends Remote{
    // 增加网站营销人员（注销用户 暂不考虑）
    public ResultMessage insert(WebSalesmanPO webSalesmanPO)throws RemoteException;
    // 根据websalesmanpo的ID 更新网站营销人员
    public ResultMessage update(WebSalesmanPO webSalesmanPO)throws RemoteException;
    // 根据ID 得到网站营销人员
    public WebSalesmanPO findByID(String webSalesmanID)throws RemoteException;
    // 根据地址 得到辖区内的网站营销人员
    public ArrayList<WebSalesmanPO> findByDistrict(String district)throws RemoteException;
    // 得到所有网站营销人员
    public ArrayList<WebSalesmanPO> getAll()throws RemoteException;

}
