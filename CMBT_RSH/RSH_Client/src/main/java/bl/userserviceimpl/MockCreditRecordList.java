package bl.userserviceimpl;

import constant.ResultMessage;
import vo.CreditRecordVO;

public class MockCreditRecordList extends CreditRecordList{

	
	protected MockCreditRecordList(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 增加用户信用变化记录
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		return ResultMessage.succeed;
	}
	/**
	 * 检验该用户的信用值，返回该用户是否可以下订单
	 * @return
	 */
	public boolean canOrder(){
		return false;
	}

}
