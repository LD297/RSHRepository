package bl.userserviceimpl;

import constant.ResultMessage;
import vo.CreditRecordVO;

public class MockCreditRecordList extends CreditRecordList{

	public MockCreditRecordList(String userid) {
		super(userid);
	}
	/**
	 * 增加用户信用变化记录
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		return ResultMessage.success;
	}
	/**
	 * 检验该用户的信用值，返回该用户是否可以下订单
	 * @return
	 */
	public boolean canOrder(){
		return false;
	}

}
