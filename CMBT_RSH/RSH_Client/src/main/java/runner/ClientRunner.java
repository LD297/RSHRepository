package runner;

import rmi.HotelRemoteHelper;
import rmi.RemoteHelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/master
import constant.ResultMessage;
import rmi.RemoteHelper;

>>>>>>> origin/master
/**
 * 先根据服务名查找远程对象，再调用远程方法
 */
public class ClientRunner {

	public void test(){
		ResultMessage resultMessage = null;
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		try{
			resultMessage = remoteHelper.getUserDao().checkPassword("fdsf","sfsag");
		}catch(RemoteException e){
			e.printStackTrace();
		}
		if(resultMessage==ResultMessage.succeed){
			System.out.println("成功");
		}
//		if(Login.checkOnline(Role.user, "129817465", "sfkgkssghkgh")==ResultMessage.succeed);
	//		System.out.println("成功");
	}
	
	public static void main(String[] args){
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}

