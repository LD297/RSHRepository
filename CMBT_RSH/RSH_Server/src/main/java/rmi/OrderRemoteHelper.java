package rmi;

import data.daoimpl.orderdaoimpl.OrderDaoImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by sky-PC on 2016/11/27.
 */
public class OrderRemoteHelper {
    public OrderRemoteHelper() {
        initServer();
    }

    private void initServer() {
        OrderDaoImpl orderDaoImpl = null;
        try{
            orderDaoImpl = new OrderDaoImpl();
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/OrderDaoImpl",orderDaoImpl );
        } catch (RemoteException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully register a remote order obj ");

    }
}
