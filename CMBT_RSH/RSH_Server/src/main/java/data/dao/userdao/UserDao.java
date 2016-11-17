package data.dao.userdao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import constant.ResultMessage;
import po.UserPO;

/**
 * 处理有关用户基本信息的数据
 * @author john
 *
 */
public interface UserDao extends Remote{
	/**
	 * 获取用户基本信息持久化对象
	 * @param id用户id
	 * @return
	 */
	public UserPO getInfo(String id) throws RemoteException;
	/**
	 * 更新用户基本信息
	 * @param po用户持久化对象
	 * @return
	 */
	public ResultMessage update(UserPO po) throws RemoteException;
	/**
	 * 添加用户持久化对象
	 * @param po用户持久化对象
	 * @return
	 */
	public ResultMessage add(UserPO po) throws RemoteException;
	/**
	 * 检查用户id是否存在，若存在，检查密码与id是否匹配
	 * @param id用户id
	 * @param password用户密码
	 * @return
	 */
	public ResultMessage checkPassword(String id,String password) throws RemoteException;
	/**
	 * 将该用户信息更新为普通会员
	 * @param id用户id
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage register(String id) throws RemoteException;
	/**
	 * 将该用户信息更新为企业会员
	 * @param id用户id
	 * @param commerceName企业名称
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage register(String id,String commerceName) throws RemoteException;
	/**
	 * 更新所有会员的会员等级
	 * @param gradeWithCredit 会员等级制度
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage setMemberLevel(int[][] gradeWithCredit) throws RemoteException;
}
