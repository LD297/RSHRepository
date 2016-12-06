package data.daoimpl.logindaoimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import constant.ResultMessage;
import constant.Role;
import data.dao.logindao.LoginDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.LoginDaoHelper;
import po.OnlinePersonPO;

public class LoginDaoImpl extends UnicastRemoteObject implements LoginDao{

	private static LoginDaoImpl loginDaoImpl;
	private LoginDaoHelper loginDaoHelper;
	private DaoHelperFactory daoHelperFactory;
	private LoginDaoImpl() throws RemoteException {
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
		return ResultMessage.succeed;
	}

	public ResultMessage deleteOnline(Role role, String id) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

}
