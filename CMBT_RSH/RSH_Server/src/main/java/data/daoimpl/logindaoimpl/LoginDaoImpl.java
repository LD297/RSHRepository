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

	private LoginDaoHelper loginDaoHelper = null;
	private DaoHelperFactory daoHelperFactory = null;

	private LoginDaoImpl() throws RemoteException {
		if(daoHelperFactory==null)
		    daoHelperFactory = new DaoHelperFactoryImpl();
		if(loginDaoHelper==null)
		    loginDaoHelper = daoHelperFactory.getLoginDaoHelper();
	}
	public static LoginDaoImpl getInstance(){
		try {
			return new LoginDaoImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public ResultMessage addOnline(OnlinePersonPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("get");
		return loginDaoHelper.addOnline(po);
	}
	@Override
	public ResultMessage deleteOnline(Role role, String id) throws RemoteException {
		// TODO Auto-generated method stub
		return loginDaoHelper.deleteOnline(role,id);
	}

}
