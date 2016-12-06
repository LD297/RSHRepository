package data.daoimpl.userdaoimpl;

import constant.ResultMessage;
import data.dao.userdao.CreditRecordListDao;
import data.daohelper.CreditRecordListDaoHelper;
import data.daohelper.DaoHelperFactory;
import po.CreditRecordPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;

public class CreditRecordListDaoImpl extends UnicastRemoteObject implements CreditRecordListDao{

	private static CreditRecordListDaoImpl creditRecordListDaoImpl;
	private CreditRecordListDaoHelper creditRecordListDaoHelper;
	private DaoHelperFactory daoHelperFactory;

	public static CreditRecordListDaoImpl getInstance() {
		if(creditRecordListDaoImpl == null){
			try {
				creditRecordListDaoImpl = new CreditRecordListDaoImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return creditRecordListDaoImpl;
}
	private CreditRecordListDaoImpl() throws RemoteException {
	}

	public Iterator<CreditRecordPO> getCreditRecordList(String userid) throws RemoteException {
		return null;
	}

	public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
