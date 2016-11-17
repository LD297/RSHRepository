package bl.userserviceimpl;

import java.util.ArrayList;

import constant.ResultMessage;
import po.CreditRecordPO;
import vo.CreditRecordVO;

public class CreditRecordList {
	String userid;
	public CreditRecordList(String userid) {
		this.userid = userid;
	}
	/**
	 * 增加用户信用变化记录
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		return ResultMessage.success;
	}
	/**
	 * 获取用户信用记录列表
	 * @return
	 */
	public ArrayList<CreditRecordVO> getCreditRecordList() {
		return null;
	}
	/**
	 * 检验该用户的信用值，返回该用户是否可以下订单
	 * @return
	 */
	public boolean canOrder(){
		return false;
	}
	/**
	 * 生成信用记录持久化对象
	 * @param vo
	 * @return
	 */
	private CreditRecordPO create(CreditRecordVO vo) {
		return null;
	}
	/**
	 * 解包信用记录持久化对象
	 * @param po
	 * @return
	 */
	private CreditRecordVO unpackedPO(CreditRecordPO po) {
		return null;
	}
}
