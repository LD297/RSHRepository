package data.dao.webstaffdao;

import constant.ResultMessage;
import po.WebManagerPO;

import java.rmi.Remote;

/**
 * Created by aa on 2016/11/19.
 */
public interface WebManagerDao extends Remote{

    public ResultMessage updateManager (String managerID,String password);

    public WebManagerPO getManagerInstance(String managerID);

}
