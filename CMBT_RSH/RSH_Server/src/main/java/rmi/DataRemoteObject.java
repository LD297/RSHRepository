package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import constant.ResultMessage;
import constant.Role;
import data.dao.logindao.LoginDao;
import data.dao.userdao.CreditRecordListDao;
import data.dao.userdao.UserDao;
import data.daoimpl.logindaoimpl.LoginDaoImpl;
import data.daoimpl.userdaoimpl.CreditRecordListDaoImpl;
import data.daoimpl.userdaoimpl.UserDaoImpl;
import po.CreditRecordPO;
import po.OnlinePersonPO;
import po.UserPO;

public class DataRemoteObject extends UnicastRemoteObject implements LoginDao,CreditRecordListDao,UserDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private LoginDao loginDao;
	private CreditRecordListDao creditRecordListDao;
	private UserDao userDao;
	protected DataRemoteObject() throws RemoteException {
		loginDao = new LoginDaoImpl();
		creditRecordListDao = new CreditRecordListDaoImpl();
		userDao = new UserDaoImpl();
	}
	public UserPO getInfo(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.getInfo(id);
	}
	public ResultMessage update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.update(po);
	}
	public ResultMessage add(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.add(po);
	}
	public ResultMessage checkPassword(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.checkPassword(id, password);
	}
	public ResultMessage register(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.register(id);
	}
	public ResultMessage register(String id, String commerceName) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.register(id,commerceName);
	}
	public ResultMessage setMemberLevel(int[][] gradeWithCredit) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.setMemberLevel(gradeWithCredit);
	}
	public ArrayList<CreditRecordPO> getCreditRecordList() throws RemoteException {
		// TODO Auto-generated method stub
		return creditRecordListDao.getCreditRecordList();
	}
	public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return creditRecordListDao.addCreditRecord(po);
	}
	public ResultMessage addOnline(OnlinePersonPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return loginDao.addOnline(po);
	}
	public ResultMessage deleteOnline(Role role, String id) throws RemoteException {
		// TODO Auto-generated method stub
		return loginDao.deleteOnline(role, id);
	}

	
}
