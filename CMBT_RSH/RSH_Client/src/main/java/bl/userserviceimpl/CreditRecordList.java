package bl.userserviceimpl;

import constant.CreditAction;
import constant.ResultMessage;
import data.dao.userdao.CreditRecordListDao;
import po.CreditRecordPO;
import rmi.RemoteHelper;
import vo.CreditRecordVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class CreditRecordList {
	private String userID;
	int credit;
	ArrayList<CreditRecordVO> creditRecordVOArrayList;

	private static CreditRecordListDao creditRecordListDao = null;

	private static void initRemote() {
		if (creditRecordListDao == null) {
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			creditRecordListDao = remoteHelper.getCreditRecordListDao();
		}
	}

	protected CreditRecordList(String userID) {
		this.userID = userID;
		creditRecordVOArrayList = getCreditRecords();
		credit = getCredit();
	}

	
	protected static CreditRecordList getInstance(String userID) {
		CreditRecordList creditRecordList = new CreditRecordList(userID);
		return creditRecordList;
	}

	/*
	 * 用以在初始化对象的时候从数据库获得信用记录列表
	 */
	private ArrayList<CreditRecordVO> getCreditRecords() {
		ArrayList<CreditRecordPO> creditRecordPOS = new ArrayList<>();
		ArrayList<CreditRecordVO> creditRecordVOs = new ArrayList<>();
		initRemote();
		try {
			creditRecordPOS = creditRecordListDao.getCreditRecordList(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return creditRecordVOs;
		}
		for (CreditRecordPO creditRecordPO : creditRecordPOS) {
			creditRecordVOs.add(creditRecordPO.changeIntoVO());
		}
		return creditRecordVOs;
	}

	public ResultMessage add(int value) {
		credit += value;
		CreditRecordVO creditRecordVO = new CreditRecordVO(userID, new Date(), null, CreditAction.bymoney, "+" + value,
				credit);
		return addCreditRecord(creditRecordVO);
	}

	

	/**
	 * 获取用户信用记录列表
	 * 
	 * @return
	 */
	public Iterator<CreditRecordVO> getCreditRecordList() {
		return creditRecordVOArrayList.iterator();
	}

	

	/**
	 * 获取用户信用值
	 * @return
	 */
	public int getCredit() {
		int pos = creditRecordVOArrayList.size();
		if (pos == 0)
			return 0;
		else
			pos--;
		CreditRecordVO creditRecordVO = creditRecordVOArrayList.get(pos);
		return creditRecordVO.getCredit();
	}

	public ResultMessage addCreditRecord(CreditAction creditAction, String orderID, int change, Date changeTime) {
		credit = credit + change;
		CreditRecordVO creditRecordVO = new CreditRecordVO(userID, changeTime, orderID, creditAction,
				String.valueOf(change), credit);
		return addCreditRecord(creditRecordVO);
	}
	/**
	 * 增加用户信用变化记录
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		ResultMessage resultMessage = null;
		initRemote();
		try {
			resultMessage = creditRecordListDao.addCreditRecord(vo.changeIntoPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
		if (resultMessage == ResultMessage.succeed) {
			creditRecordVOArrayList.add(vo);
			credit = vo.getCredit();
			User user = User.getInstance(userID);
			user.changeCredit(credit);
		}
		
		return resultMessage;
	}
}
