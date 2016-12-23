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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		return userDaoHelper.getInfo(userid);
	}

	public ResultMessage update(UserPO po) throws RemoteException {
		return userDaoHelper.update(po);
	}
	@Override
	public ResultMessage insert(UserPO po) throws RemoteException {
		System.out.print("get into daoimpl");
		return userDaoHelper.insert(po);
	}

	public ResultMessage setMemberLevel(int[] gradeWithCredit) throws RemoteException {
		return null;
	}
	public ArrayList<UserPO> getAll()throws RemoteException{
		return userDaoHelper.getAll();
	}

	@Override
	public int getMemberLevel() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage setMemberLevel(int gradeWithCredit) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
