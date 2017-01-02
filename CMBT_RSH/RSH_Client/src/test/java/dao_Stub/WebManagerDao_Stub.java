package dao_Stub;

import java.rmi.RemoteException;

import constant.ResultMessage;
import data.dao.webstaffdao.WebManagerDao;
import po.WebManagerPO;

/**
 * 
 * @author aa
 *
 */
public class WebManagerDao_Stub implements WebManagerDao{

	@Override
	public ResultMessage updateManager(String managerID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebManagerPO getManagerInstance(String managerID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
