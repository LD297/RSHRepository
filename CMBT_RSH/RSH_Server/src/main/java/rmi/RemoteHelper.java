package rmi;

import data.daoimpl.hoteldaoimpl.HotelDaoImpl;
import data.daoimpl.logindaoimpl.LoginDaoImpl;
import data.daoimpl.orderdaoimpl.OrderDaoImpl;
import data.daoimpl.promotiondaoimpl.PromotionDaoImpl;
import data.daoimpl.userdaoimpl.CreditRecordListDaoImpl;
import data.daoimpl.userdaoimpl.UserDaoImpl;
import data.daoimpl.webstaffdaoimpl.WebManagerDaoImpl;
import data.daoimpl.webstaffdaoimpl.WebSalesmanDaoTXTImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by john on 2016/11/27.
 */
public class RemoteHelper {
    private static RemoteHelper remoteHelper = null;
    private RemoteHelper(){}

    private LoginDaoImpl loginDaoImpl = null;
    private CreditRecordListDaoImpl creditRecordListDaoImpl = null;
    private UserDaoImpl userDaoImpl = null;
    private HotelDaoImpl hotelDaoImpl = null;
    private OrderDaoImpl orderDaoImpl = null;
    private WebManagerDaoImpl webManagerDaoImpl = null;
    private WebSalesmanDaoTXTImpl webSalesmanDaoTXTImpl = null;
    private PromotionDaoImpl   promotionDaoImpl = null;


    public static RemoteHelper getInstance(){
        if(remoteHelper==null){
            remoteHelper = new RemoteHelper();
        }
        return remoteHelper;
    }

    public void init(){
        try {
            LocateRegistry.createRegistry(8888);
            loginDaoImpl = new LoginDaoImpl();
            Naming.bind("rmi://localhost:8888/LoginDaoImpl", loginDaoImpl);
            creditRecordListDaoImpl = new CreditRecordListDaoImpl();
            Naming.bind("rmi://localhost:8888/CreditRecordListDaoImpl", creditRecordListDaoImpl);
            userDaoImpl = new UserDaoImpl();
            Naming.bind("rmi://localhost:8888/UserDaoImpl", userDaoImpl);
            hotelDaoImpl = new HotelDaoImpl();
            Naming.bind("rmi://localhost:8888/HotelDaoImpl", hotelDaoImpl);
            orderDaoImpl = new OrderDaoImpl();
            Naming.bind("rmi://localhost:8888/OrderDaoImpl",orderDaoImpl );
            webManagerDaoImpl = new WebManagerDaoImpl();
            Naming.bind("rmi://localhost:8888/WebManagerDaoImpl",webManagerDaoImpl );
            webSalesmanDaoTXTImpl = new WebSalesmanDaoTXTImpl();
            Naming.bind("rmi://localhost:8888/WebSalesmanDaoTXTImpl", webSalesmanDaoTXTImpl);
            promotionDaoImpl = new PromotionDaoImpl();
            Naming.bind("rmi://localhost:8888/PromotionDaoImpl",promotionDaoImpl);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }


}
