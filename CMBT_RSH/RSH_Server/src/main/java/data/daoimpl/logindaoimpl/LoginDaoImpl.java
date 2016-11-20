package data.daoimpl.logindaoimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import constant.ResultMessage;
import constant.Role;
import data.dao.logindao.LoginDao;
import po.OnlinePersonPO;

public class LoginDaoImpl extends UnicastRemoteObject implements LoginDao{

	public LoginDaoImpl() throws RemoteException {
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
