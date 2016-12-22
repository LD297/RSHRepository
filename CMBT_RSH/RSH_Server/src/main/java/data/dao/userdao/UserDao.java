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
    // 根据用户编号 得到用户信息
	public UserPO getInfo(String userID) throws RemoteException;
    // 根据用户编号 更新用户信息
	public ResultMessage update(UserPO userPO) throws RemoteException;
    // 新增用户信息
	// if userID with conflict ,return idAlreadyExist
	public ResultMessage insert(UserPO userPO) throws RemoteException;
    // 制定会员等级策略
	public ResultMessage setMemberLevel(int[] gradeWithCredit) throws RemoteException;
	public int getMemberLevel() throws RemoteException;
	// 网站管理人员 得到用户信息
	public ArrayList<UserPO> getAll()throws RemoteException;
}
