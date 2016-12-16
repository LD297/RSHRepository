package data.dao.logindao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import constant.ResultMessage;
import constant.Role;
import po.OnlinePersonPO;

/**
 * 处理login数据层
 * @author john
 *
 */
public interface LoginDao extends Remote{

    // 增加在线人员持久化对象
	public ResultMessage addOnline(OnlinePersonPO po) throws RemoteException;
	// 删除在线人员持久化对象
	public ResultMessage deleteOnline(Role role,String id) throws RemoteException;
}


