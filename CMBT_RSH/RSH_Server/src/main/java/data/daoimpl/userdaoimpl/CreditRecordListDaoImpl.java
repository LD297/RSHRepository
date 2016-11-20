package data.daoimpl.userdaoimpl;

import constant.ResultMessage;
import data.dao.userdao.CreditRecordListDao;
import po.CreditRecordPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;

public class CreditRecordListDaoImpl extends UnicastRemoteObject implements CreditRecordListDao{

	public CreditRecordListDaoImpl() throws RemoteException {
	}

	public Iterator<CreditRecordPO> getCreditRecordList(String userid) throws RemoteException {
		return null;
	}

	public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
