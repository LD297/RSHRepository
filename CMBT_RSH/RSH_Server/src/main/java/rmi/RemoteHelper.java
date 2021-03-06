package rmi;

import data.daohelperimpl.jdbc.DBHelper;
import data.daoimpl.hoteldaoimpl.HotelDaoImpl;
import data.daoimpl.logindaoimpl.LoginDaoImpl;
import data.daoimpl.orderdaoimpl.OrderDaoImpl;
import data.daoimpl.promotiondaoimpl.PromotionDaoImpl;
import data.daoimpl.userdaoimpl.CreditRecordListDaoImpl;
import data.daoimpl.userdaoimpl.UserDaoImpl;
import data.daoimpl.webstaffdaoimpl.WebManagerDaoImpl;
import data.daoimpl.webstaffdaoimpl.WebSalesmanDaoImpl;

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
    private WebSalesmanDaoImpl webSalesmanDaoImpl = null;
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
            loginDaoImpl = LoginDaoImpl.getInstance();
            Naming.bind("rmi://localhost:8888/LoginDaoImpl", loginDaoImpl);
            creditRecordListDaoImpl = CreditRecordListDaoImpl.getInstance();
            Naming.bind("rmi://localhost:8888/CreditRecordListDaoImpl", creditRecordListDaoImpl);
            userDaoImpl = UserDaoImpl.getInstance();
            Naming.bind("rmi://localhost:8888/UserDaoImpl", userDaoImpl);
            hotelDaoImpl = HotelDaoImpl.getInstance();
            Naming.bind("rmi://localhost:8888/HotelDaoImpl", hotelDaoImpl);
            orderDaoImpl = OrderDaoImpl.getInstance();
            Naming.bind("rmi://localhost:8888/OrderDaoImpl",orderDaoImpl );
            webManagerDaoImpl = WebManagerDaoImpl.getInstance();
            Naming.bind("rmi://localhost:8888/WebManagerDaoImpl",webManagerDaoImpl );
            webSalesmanDaoImpl = WebSalesmanDaoImpl.getInstance();
            Naming.bind("rmi://localhost:8888/WebSalesmanDaoImpl", webSalesmanDaoImpl);
            promotionDaoImpl = PromotionDaoImpl.getInstance();
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
