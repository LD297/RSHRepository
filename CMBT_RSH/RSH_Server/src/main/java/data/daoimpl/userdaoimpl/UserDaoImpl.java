package data.daoimpl.userdaoimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import constant.ResultMessage;
import data.dao.userdao.UserDao;
import po.UserPO;

public class UserDaoImpl extends UnicastRemoteObject implements UserDao{

	public UserDaoImpl() throws RemoteException {
	}

	public UserPO getInfo(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage checkPassword(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage register(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage register(String id, String commerceName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage setMemberLevel(int[][] gradeWithCredit) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
