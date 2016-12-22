package data.daoimpl.logindaoimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import constant.ResultMessage;
import constant.Role;
import data.dao.logindao.LoginDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.LoginDaoHelper;
import data.daohelperimpl.DaoHelperFactoryImpl;
import po.OnlinePersonPO;

public class LoginDaoImpl extends UnicastRemoteObject implements LoginDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static LoginDaoImpl loginDaoImpl;
	private LoginDaoHelper loginDaoHelper;
	private DaoHelperFactory daoHelperFactory;
	
	private LoginDaoImpl() throws RemoteException {
		daoHelperFactory = new DaoHelperFactoryImpl();
		loginDaoHelper = daoHelperFactory.getLoginDaoHelper();
	}

	public static LoginDaoImpl getInstance(){
		if(loginDaoImpl == null){
			try {
				loginDaoImpl = new LoginDaoImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return loginDaoImpl;
	}

	public ResultMessage addOnline(OnlinePersonPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("get");
		return loginDaoHelper.addOnline(po);
	}

	public ResultMessage deleteOnline(Role role, String id) throws RemoteException {
		// TODO Auto-generated method stub
		return loginDaoHelper.deleteOnline(role,id);
	}

}
