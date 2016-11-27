package data.dao.userdao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import constant.ResultMessage;
import po.CreditRecordPO;

/**
 * 处理有关用户信用记录的数据
 * @author john
 *
 */
public interface CreditRecordListDao extends Remote{
	/**
	 * 返回用户信用记录列表
	 * @return ArrayList<CreditRecordPO>用户信用记录持久化对象list
	 * @throws RemoteException
	 */
	public Iterator<CreditRecordPO> getCreditRecordList(String userid) throws RemoteException;
	/**
	 * 增加用户信用记录持久化对象
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException;
}
