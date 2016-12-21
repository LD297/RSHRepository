package runner;

import presentation.Main.Launcher;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import constant.ResultMessage;
import constant.Role;
import po.OnlinePersonPO;

/**
 * 先根据服务名查找远程对象，再调用远程方法
 */
public class ClientRunner {

	public void test(){
		ResultMessage resultMessage = null;
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		try{
			OnlinePersonPO onlinePersonPO = new OnlinePersonPO(Role.user, "shgf");
			resultMessage = remoteHelper.getLoginDao().addOnline(onlinePersonPO);
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
	//	new Launcher().startLaunch(args);
	}
}

