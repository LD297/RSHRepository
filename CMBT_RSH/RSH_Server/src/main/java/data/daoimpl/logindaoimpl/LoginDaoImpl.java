package data.daoimpl.logindaoimpl;

import java.rmi.RemoteException;

import constant.ResultMessage;
import constant.Role;
import data.dao.logindao.LoginDao;
import po.OnlinePersonPO;

public class LoginDaoImpl implements LoginDao{

	public ResultMessage addOnline(OnlinePersonPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	public ResultMessage deleteOnline(Role role, String id) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
