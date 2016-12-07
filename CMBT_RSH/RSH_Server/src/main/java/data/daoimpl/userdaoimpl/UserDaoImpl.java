package data.daoimpl.userdaoimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import constant.ResultMessage;
import data.dao.userdao.UserDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.UserDaoHelper;
import data.daohelperimpl.DaoHelperFactoryImpl;
import po.UserPO;

public class UserDaoImpl extends UnicastRemoteObject implements UserDao{

	private static UserDaoImpl userDaoImpl;
	private UserDaoHelper userDaoHelper;
	private DaoHelperFactory daoHelperFactory;

	private UserDaoImpl() throws RemoteException {
		daoHelperFactory = new DaoHelperFactoryImpl();
		userDaoHelper = daoHelperFactory.getUserDaoHelper();
	}

	public static UserDaoImpl getInstance() {
		if(userDaoImpl == null){
			try {
				userDaoImpl = new UserDaoImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return userDaoImpl;
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
		return ResultMessage.succeed;
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
