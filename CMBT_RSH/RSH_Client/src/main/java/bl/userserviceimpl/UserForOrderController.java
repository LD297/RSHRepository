package bl.userserviceimpl;

import java.util.Date;

import bl.orderserviceimpl.UserForOrder;
import constant.CreditAction;
import constant.ResultMessage;

public class UserForOrderController implements UserForOrder{

	@Override
	public int getCredit(String userID) {
		// TODO Auto-generated method stub
		CreditRecordList creditRecordList = new CreditRecordList(userID);
		return creditRecordList.getCredit();
	}

	@Override
	public ResultMessage addCreditRecordForExecute(String userID, String orderID, int change, Date executeTime) {
		// TODO Auto-generated method stub
		CreditRecordList creditRecordList = new CreditRecordList(userID);
		return creditRecordList.addCreditRecord(CreditAction.execute,orderID,change,executeTime);		
	}

	@Override
	public ResultMessage addCreditRecordForCancel(String userID, String orderID, int change, Date cancelTime) {
		// TODO Auto-generated method stub
		CreditRecordList creditRecordList = new CreditRecordList(userID);
		return creditRecordList.addCreditRecord(CreditAction.cancel_abnomal, orderID, change, cancelTime);
	}

}
