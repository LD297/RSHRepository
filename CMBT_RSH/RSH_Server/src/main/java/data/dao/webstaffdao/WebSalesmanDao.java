package data.dao.webstaffdao;

import constant.ResultMessage;
import po.WebSalesmanPO;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Created by aa on 2016/11/22.
 */
public interface WebSalesmanDao extends Remote{

    public ResultMessage addWebSalesman(WebSalesmanPO webSalesmanPO);

    public ResultMessage updateWebSalesman(WebSalesmanPO webSalesmanPO);

    public ResultMessage delWebSalesman(WebSalesmanPO webSalesmanPO);

    public WebSalesmanPO getSalesmanInstance(String SalesmanID);

    public ArrayList<WebSalesmanPO> finds(String district);

    public ArrayList<WebSalesmanPO> getAll();

}
