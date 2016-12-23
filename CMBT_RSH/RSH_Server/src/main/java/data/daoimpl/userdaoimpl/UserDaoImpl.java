package data.daoimpl.userdaoimpl;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import constant.ResultMessage;
import data.dao.userdao.UserDao;
import data.daohelper.DaoHelperFactory;
import data.daohelper.UserDaoHelper;
import data.daohelperimpl.DaoHelperFactoryImpl;
import data.daohelperimpl.userdaohelperimpl.MemberLevelTXT;
import po.UserPO;

public class UserDaoImpl extends UnicastRemoteObject implements UserDao{

	private UserDaoHelper userDaoHelper = null;
	private DaoHelperFactory daoHelperFactory = null;

	private UserDaoImpl() throws RemoteException {
		if(daoHelperFactory==null)
		    daoHelperFactory = new DaoHelperFactoryImpl();
		if(userDaoHelper==null)
		    userDaoHelper = daoHelperFactory.getUserDaoHelper();
	}
	
	public static UserDaoImpl getInstance(){
		try {
			return new UserDaoImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public UserPO getInfo(String userid) throws RemoteException {
		return userDaoHelper.getInfo(userid);
	}
	@Override
	public ResultMessage update(UserPO po) throws RemoteException {
		return userDaoHelper.update(po);
	}
	@Override
	public ResultMessage insert(UserPO po) throws RemoteException {
		return userDaoHelper.insert(po);
	}
	
	@Override
	public ResultMessage setMemberLevel(int gradeWithCredit) throws RemoteException {
		MemberLevelTXT memberLevelTXT = new MemberLevelTXT();
		try {
			return memberLevelTXT.setMemberLevel(gradeWithCredit);
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMessage.fail;
		}
	}
	@Override
	public ArrayList<UserPO> getAll()throws RemoteException{
		return userDaoHelper.getAll();
	}

	@Override
	public int getMemberLevel() throws RemoteException {
		MemberLevelTXT memberLevelTXT = new MemberLevelTXT();
		try {
			return memberLevelTXT.getMemberLevel();
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}


}
