package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import bl.loginserviceimpl.Login;
import constant.ResultMessage;
import constant.Role;
import rmi.HotelRemoteHelper;
import rmi.RemoteHelper;

/**
 * 先根据服务名查找远程对象，再调用远程方法
 */
public class ClientRunner {
	private RemoteHelper remoteHelper;
	private HotelRemoteHelper hotelRemoteHelper;// by 297
	
	public ClientRunner() {
		linkToServer();
//		initGUI();
	}
	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/DataRemoteObject"));

			hotelRemoteHelper = HotelRemoteHelper.getInstance();//by 297
			hotelRemoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/HotelRemoteObject"));

			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	/*private void initGUI() {
	}*/
	
	public void test(){
//		if(Login.checkOnline(Role.user, "129817465", "sfkgkssghkgh")==ResultMessage.succeed);
	//		System.out.println("成功");
	}
	
	public static void main(String[] args){
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}

