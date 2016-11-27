package bl.userserviceimpl;

import constant.ResultMessage;
import po.CreditRecordPO;
import rmi.RemoteHelper;
import vo.CreditRecordVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class CreditRecordList {
	private String userid = "";
	ArrayList<CreditRecordVO> creditRecordVOArrayList = null;
	public CreditRecordList(String userid) {

		this.userid = userid;
		creditRecordVOArrayList = getCreditRecords();
	}
	/*
	用以在初始化对象的时候从数据库获得信用记录列表
	 */
	private ArrayList<CreditRecordVO> getCreditRecords() {
		Iterator<CreditRecordPO> creditRecordPOIterator = null;
		try {
			creditRecordPOIterator = RemoteHelper.getInstance().
					getCreditRecordListDao().getCreditRecordList(userid);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		ArrayList<CreditRecordVO> creditRecordVOArrayList = null;
		while(creditRecordPOIterator.hasNext()){
			CreditRecordPO po = creditRecordPOIterator.next();
			CreditRecordVO vo = unpackedPO(po);
			creditRecordVOArrayList.add(vo);
		}
		return creditRecordVOArrayList;
	}
	/**
	 * 增加用户信用变化记录
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		ResultMessage resultMessage = null;
		CreditRecordPO po = create(vo);
		try {
			resultMessage = RemoteHelper.getInstance().getCreditRecordListDao().addCreditRecord(po);
		}catch (RemoteException e){
			e.printStackTrace();
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
	public boolean canOrder(){
		if(creditRecordVOArrayList.get(creditRecordVOArrayList.size()-1).getCredit()>0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 生成信用记录持久化对象
	 * @param vo
	 * @return
	 */
	private CreditRecordPO create(CreditRecordVO vo) {
		CreditRecordPO po = new CreditRecordPO(vo.getUserid(),vo.getDate(),
				vo.getOrderid(),vo.getCreditAction(),vo.getChange(),vo.getCredit());
		return po;
	}
	/**
	 * 解包信用记录持久化对象
	 * @param po
	 * @return
	 */
	private CreditRecordVO unpackedPO(CreditRecordPO po) {
		CreditRecordVO vo = new CreditRecordVO(po.getUserid(),po.getDate(),
				po.getOrderid(),po.getCreditAction(),po.getChange(),po.getCredit());
		return vo;
	}
}
