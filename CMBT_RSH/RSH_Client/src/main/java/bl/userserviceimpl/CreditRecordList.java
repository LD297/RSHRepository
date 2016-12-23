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
	private String userid ;
	int credit;
	ArrayList<CreditRecordVO> creditRecordVOArrayList ;

	private static CreditRecordListDao creditRecordListDao = null;

	private static void initRemote(){
		if(creditRecordListDao==null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			creditRecordListDao = remoteHelper.getCreditRecordListDao();			
		}
	}

	public CreditRecordList(String userid) {
		initRemote();
		this.userid = userid;
		credit = getCredit();
		creditRecordVOArrayList = getCreditRecords();
	}
	/*
	用以在初始化对象的时候从数据库获得信用记录列表
	 */
	private ArrayList<CreditRecordVO> getCreditRecords() {
		ArrayList<CreditRecordPO> creditRecordPOS= new ArrayList<CreditRecordPO>();
		ArrayList<CreditRecordVO> creditRecordVOs = new ArrayList<>();
		initRemote();
		try {
			creditRecordPOS=creditRecordListDao.getCreditRecordList(userid);
		}catch (RemoteException e){
			e.printStackTrace();
			return creditRecordVOs;
		}
		for(CreditRecordPO creditRecordPO:creditRecordPOS){
			creditRecordVOs.add(creditRecordPO.changeIntoVO());
		}
		return creditRecordVOArrayList;
	}

	public ResultMessage add(int value){
		credit +=value;
		CreditRecordVO creditRecordVO = new CreditRecordVO
				(userid, new Date(), null , CreditAction.bymoney,"+"+value, credit);
		return addCreditRecord(creditRecordVO);
	}
	
	
	
	/**
	 * 增加用户信用变化记录	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		ResultMessage resultMessage = null;
		initRemote();
		try {
			resultMessage = creditRecordListDao.addCreditRecord(vo.changeIntoPO());
		}catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
		if(resultMessage==ResultMessage.succeed){
			creditRecordVOArrayList.add(vo);
			credit = vo.getCredit();
		}
		return resultMessage;
	}
	/**
	 * 获取用户信用记录列表
	 * @return
	 */
	public Iterator<CreditRecordVO> getCreditRecordList() {
		return creditRecordVOArrayList.iterator();
	}
	/**
	 * 检验该用户的信用值，返回该用户是否可以下订单
	 * @return
	 */

	/**
	 * 获取用户信用值
	 * @return
	 */
	public int getCredit(){
		int pos = creditRecordVOArrayList.size();
		if(pos==0)
			return 0;
		else
			pos--;
		CreditRecordVO creditRecordVO = creditRecordVOArrayList.get(pos);
		return creditRecordVO.getCredit();
	}

}
