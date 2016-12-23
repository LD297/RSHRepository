package data.daohelper;

import constant.ResultMessage;
import po.CreditRecordPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by aa on 2016/12/6.
 */
public interface CreditRecordListDaoHelper {

	public void init();
	
    public ArrayList<CreditRecordPO> getCreditRecordList(String userid) throws RemoteException ;

    public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException ;
}
