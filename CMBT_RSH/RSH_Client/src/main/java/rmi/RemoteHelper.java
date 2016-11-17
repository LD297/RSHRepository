package rmi;

import java.rmi.Remote;

import data.dao.logindao.LoginDao;
import data.dao.userdao.CreditRecordListDao;
import data.dao.userdao.UserDao;

public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public LoginDao getLoginDao(){
		return (LoginDao)remote;
	}
	
	public CreditRecordListDao getCreditRecordListDao(){
		return (CreditRecordListDao)remote;
	}
	
	public UserDao getUserDao() {
		return (UserDao)remote;
	}
}
