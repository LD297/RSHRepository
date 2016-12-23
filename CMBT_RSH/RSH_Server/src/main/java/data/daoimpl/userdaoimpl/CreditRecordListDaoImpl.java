package data.daoimpl.userdaoimpl;

import constant.ResultMessage;
import data.dao.userdao.CreditRecordListDao;
import data.daohelper.CreditRecordListDaoHelper;
import data.daohelper.DaoHelperFactory;
import data.daohelperimpl.DaoHelperFactoryImpl;
import po.CreditRecordPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

public class CreditRecordListDaoImpl extends UnicastRemoteObject implements CreditRecordListDao{

	private CreditRecordListDaoHelper creditRecordListDaoHelper = null;
	private DaoHelperFactory daoHelperFactory = null;

	private CreditRecordListDaoImpl() throws RemoteException {
		if(daoHelperFactory==null)
		    daoHelperFactory = new DaoHelperFactoryImpl();
		if(creditRecordListDaoHelper==null)
	    	creditRecordListDaoHelper = daoHelperFactory.getCrediRecordListDdaoHelper();
	}
	
	public static CreditRecordListDaoImpl getInstance(){
		try {
			return new CreditRecordListDaoImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ArrayList<CreditRecordPO> getCreditRecordList(String userid) throws RemoteException {
		return creditRecordListDaoHelper.getCreditRecordList(userid);
	}
	@Override
	public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return creditRecordListDaoHelper.addCreditRecord(po);
	}

}
