package runner;

import presentation.Main.Launcher;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Date;

import constant.MemberType;
import constant.ResultMessage;
import constant.Role;
import constant.Sexuality;
import data.dao.logindao.LoginDao;
import data.dao.userdao.UserDao;
import po.OnlinePersonPO;
import po.UserPO;

/**
 * 先根据服务名查找远程对象，再调用远程方法
 */
public class ClientRunner {

	RemoteHelper remoteHelper = RemoteHelper.getInstance();
	String temp = "111";
	LocalDate localDate = LocalDate.now();
	Date date = new Date();
	int i = 120;
	double d = 120;
	public void test(){
		ResultMessage resultMessage = null;
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		LoginDao loginDao = remoteHelper.getLoginDao();
		try{
			OnlinePersonPO onlinePersonPO = new OnlinePersonPO(Role.user, "shgf");
			
			System.out.println(onlinePersonPO.getId());
			OnlinePersonPO onlinePersonPO2 = new OnlinePersonPO(Role.hotel, "1234567890");
			loginDao.addOnline(onlinePersonPO2);
			resultMessage = remoteHelper.getLoginDao().addOnline(onlinePersonPO);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		if(resultMessage==ResultMessage.succeed){
			System.out.println("成功");
		}
	}
	
	public void registerTest(){
		UserDao userDao = remoteHelper.getUserDao();
		UserPO userPO = new UserPO(temp, temp, temp, temp, localDate, i, MemberType.commerce, i, temp, Sexuality.female, temp, temp);
		try {
			userDao.insert(userPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ClientRunner cr = new ClientRunner();
		cr.registerTest();
		new Launcher().startLaunch(args);
	}
}

