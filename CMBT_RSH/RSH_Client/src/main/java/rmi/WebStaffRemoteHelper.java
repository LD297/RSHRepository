package rmi;

import bl.webstaffserviceimpl.WebManager;
import bl.webstaffserviceimpl.WebStaffController;
import constant.ResultMessage;
import data.dao.webstaffdao.WebManagerDao;
import data.dao.webstaffdao.WebSalesmanDao;
import po.WebManagerPO;
import po.WebSalesmanPO;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Created by aa on 2016/11/20.
 */
public class WebStaffRemoteHelper implements WebManagerDao,WebSalesmanDao{

    private RemoteHelper remoteHelper;
    private Remote remote;
    private static WebStaffRemoteHelper webStaffRemoteHelper=null;

    private WebStaffRemoteHelper(){
        remoteHelper = RemoteHelper.getInstance();
        remote = remoteHelper.getRemote();
    }
    public static WebStaffRemoteHelper getInstance(){
        if(webStaffRemoteHelper==null){
            webStaffRemoteHelper = new WebStaffRemoteHelper();
        }
        return webStaffRemoteHelper;
    }
    @Override
    public ResultMessage addWebSalesman(WebSalesmanPO webSalesmanPO) {
        return null;
    }

    @Override
    public ResultMessage updateWebSalesman(WebSalesmanPO webSalesmanPO) {
        return null;
    }

    @Override
    public ResultMessage delWebSalesman(WebSalesmanPO webSalesmanPO) {
        return null;
    }

    @Override
    public WebSalesmanPO getSalesmanInstance(String SalesmanID) {
        return (WebSalesmanPO)remote;
    }

    @Override
    public ArrayList<WebSalesmanPO> finds(String district) {
        return (ArrayList<WebSalesmanPO>)remote;
    }

    @Override
    public ArrayList<WebSalesmanPO> getAll() {
        return (ArrayList<WebSalesmanPO>)remote;
    }

    @Override
    public ResultMessage updateManager(String managerID, String password) {
        return null;
    }

    @Override
    public WebManagerPO getManagerInstance(String managerID) {
        return (WebManagerPO) remote;
    }
}
