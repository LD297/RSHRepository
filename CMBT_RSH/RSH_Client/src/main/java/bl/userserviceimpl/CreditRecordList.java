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
	private String userid = "";
	int credit;
	ArrayList<CreditRecordVO> creditRecordVOArrayList = null;

	private static CreditRecordListDao creditRecordListDao = null;

	private void initRemote(){
		if(creditRecordListDao!=null)
			return;

		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		creditRecordListDao = remoteHelper.getCreditRecordListDao();
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
		try {
			creditRecordPOS=creditRecordListDao.getCreditRecordList(userid);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		Iterator<CreditRecordPO> creditRecordPOIterator= creditRecordPOS.iterator();

		ArrayList<CreditRecordVO> creditRecordVOArrayList = null;
		while(creditRecordPOIterator.hasNext()){
			CreditRecordPO po = creditRecordPOIterator.next();
			CreditRecordVO vo = changeIntoVO(po);
			creditRecordVOArrayList.add(vo);
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
	 * 增加用户信用变化记录
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		ResultMessage resultMessage = null;
		CreditRecordPO po = changeIntoPO(vo);
		try {
			creditRecordListDao.addCreditRecord(po);
		}catch (RemoteException e){
			return ResultMessage.remote_fail;
		}
		if(resultMessage==ResultMessage.succeed){
			creditRecordVOArrayList.add(vo);
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
	/*
	public boolean canOrder(){
		if(creditRecordVOArrayList.get(creditRecordVOArrayList.size()-1).getCredit()>0){
			return true;
		}else{
			return false;
		}
	}
	*/

	/**
	 * 获取用户信用值
	 * @return
	 */
	public int getCredit(){
		int pos = creditRecordVOArrayList.size()-1;
		CreditRecordVO creditRecordVO = creditRecordVOArrayList.get(pos);
		return creditRecordVO.getCredit();
	}

	private CreditRecordPO changeIntoPO(CreditRecordVO vo) {
		CreditRecordPO po = new CreditRecordPO(vo.getUserid(),vo.getDate(),
				vo.getOrderid(),vo.getCreditAction(),vo.getChange(),vo.getCredit());
		return po;
	}

	private CreditRecordVO changeIntoVO(CreditRecordPO po) {
		CreditRecordVO vo = new CreditRecordVO(po.getUserid(),po.getDate(),
				po.getOrderid(),po.getCreditAction(),po.getChange(),po.getCredit());
		return vo;
	}
}
