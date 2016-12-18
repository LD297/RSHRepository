package data.daoimpl.userdaoimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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
	public UserPO getInfo(String userid) throws RemoteException {
		// TODO Auto-generated method stub
		return userDaoHelper.getInfo(userid);
	}

	public ResultMessage update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return userDaoHelper.update(po);
	}

	public ResultMessage insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return userDaoHelper.insert(po);
	}

	public ResultMessage setMemberLevel(int[] gradeWithCredit) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<UserPO> getAll()throws RemoteException{
		return userDaoHelper.getAll();
	}

}
