package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 创建服务器程序：
 * 1）创建注册表实例
 * 2）将远程对象注册到注册表上
 *
 * Created by a297 on 16/11/26.
 */
public class HotelRemoteHelper {
    public HotelRemoteHelper() {
        initServer();
    }

    private void initServer() {
        HotelRemoteObject hotelRemoteObject;
        try{
            hotelRemoteObject = new HotelRemoteObject();
            LocateRegistry.createRegistry(8888);
            // 服务名推荐使用"rmi//主机名：端口号/实例名"（避免很多远程对象因服务名一致引发冲突）
            Naming.bind("rmi://localhost:8888/DataRemoteObject", hotelRemoteObject);
        } catch (RemoteException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully register a remote hotel obj ");

    }
}
