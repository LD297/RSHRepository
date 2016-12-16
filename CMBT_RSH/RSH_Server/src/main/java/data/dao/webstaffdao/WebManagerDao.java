package data.dao.webstaffdao;

import constant.ResultMessage;
import po.WebManagerPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by aa on 2016/11/22.
 */
public interface WebManagerDao extends Remote{
    // 更新网站管理人员密码信息
    public ResultMessage updateManager (String managerID,String password)throws RemoteException;
    // 根据网站管理人员ID 得到网站管理人员信息
    public WebManagerPO getManagerInstance(String managerID)throws RemoteException;
}
