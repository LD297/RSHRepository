package data.dao.userdao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import constant.ResultMessage;
import po.UserPO;

/**
 * 处理有关用户基本信息的数据
 * @author john
 *
 */
public interface UserDao extends Remote{

	public UserPO getInfo(String id) throws RemoteException;

	public ResultMessage update(UserPO po) throws RemoteException;

	public ResultMessage insert(UserPO po) throws RemoteException;

	/*
	public ResultMessage checkPassword(String id,String password) throws RemoteException;

	public ResultMessage register(String id) throws RemoteException;

	public ResultMessage register(String id,String commerceName) throws RemoteException;
*/
	public ResultMessage setMemberLevel(int boundariesForLevels) throws RemoteException;

	public int getMemberLevel() throws RemoteException;
	
	public ArrayList<UserPO> getAll() throws RemoteException;

}
