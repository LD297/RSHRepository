package rmi;

import data.daoimpl.logindaoimpl.LoginDaoImpl;
import data.daoimpl.orderdaoimpl.OrderDaoImpl;
import data.daoimpl.userdaoimpl.CreditRecordListDaoImpl;
import data.daoimpl.userdaoimpl.UserDaoImpl;

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
    private LoginDaoImpl loginDaoImpl = null;
    private CreditRecordListDaoImpl creditRecordListDaoImpl = null;
    private UserDaoImpl userDaoImpl = null;
    private HotelRemoteObject hotelRemoteObject = null;
    private OrderDaoImpl orderDaoImpl = null;
    private RemoteHelper(){}

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
            hotelRemoteObject = new HotelRemoteObject();
            Naming.bind("rmi://localhost:8888/DataRemoteObject", hotelRemoteObject);
            orderDaoImpl = new OrderDaoImpl();
            Naming.bind("rmi://localhost:8888/OrderDaoImpl",orderDaoImpl );

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }


}
