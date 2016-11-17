package bl.orderserviceimpl;

import bl.userserviceimpl.CreditRecordList;
import vo.CreditRecordVO;
import constant.ResultMessage;

public class MockCreditRecordList extends CreditRecordList{
	
	String userid;
	
	public MockCreditRecordList(String user) {
		super(user);
	}
	
	public boolean canOrder(){
		return false;
	}
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		return ResultMessage.success;
	}
}
