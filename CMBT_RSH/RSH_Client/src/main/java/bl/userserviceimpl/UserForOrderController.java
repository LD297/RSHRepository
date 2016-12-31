package bl.userserviceimpl;

import java.util.Date;

import bl.orderserviceimpl.UserForOrder;
import constant.CreditAction;
import constant.ResultMessage;
import po.UserPO;

public class UserForOrderController implements UserForOrder{

	@Override
	public int getCredit(String userID) {
		User user = User.getInstance(userID);
		UserPO userPO = user.userPO;
		return userPO.getCredit();
	}

	@Override
	public ResultMessage addCreditRecordForExecute(String userID, String orderID, int change, Date executeTime) {
		CreditRecordList creditRecordList = CreditRecordList.getInstance(userID);
		if(creditRecordList==null){
			return ResultMessage.idNotExist;
		}
		return creditRecordList.addCreditRecord(CreditAction.execute,orderID,change,executeTime);		
	}

	@Override
	public ResultMessage addCreditRecordForCancelAbnormal(String userID, String orderID, int change, Date cancelTime) {
		CreditRecordList creditRecordList =CreditRecordList.getInstance(userID);
		if(creditRecordList==null){
			return ResultMessage.idNotExist;
		}
		return creditRecordList.addCreditRecord(CreditAction.cancel_abnomal, orderID, change, cancelTime);
	}

	@Override
	public ResultMessage minusCreditRecordForCancel(String userID, String orderID, int value, Date cancelTime) {
		CreditRecordList creditRecordList = CreditRecordList.getInstance(userID);
		if(creditRecordList==null){
			return ResultMessage.idNotExist;
		}
		return creditRecordList.addCreditRecord(CreditAction.cancel, orderID, -value, cancelTime);
	}

}
