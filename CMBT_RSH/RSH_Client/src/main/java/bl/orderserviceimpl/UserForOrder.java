package bl.orderserviceimpl;

import java.util.Date;

import constant.ResultMessage;

public interface UserForOrder {

	public int getCredit(String userID);
	
	public ResultMessage addCreditRecordForExecute(String userID, String orderID, int trueValue, Date executeTime);
	
	public ResultMessage addCreditRecordForCancelAbnormal(String userID,String orderID, int value, Date cancelTime);
	
	public ResultMessage minusCreditRecordForCancel(String userID,String orderID, int value,Date cancelTime);

	public boolean canGenerate(String userID);
	
}
