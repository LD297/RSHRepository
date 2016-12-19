package vo;

import java.util.Date;

import constant.CreditAction;
import po.CreditRecordPO;

public class CreditRecordVO {
	String userID;
	Date date;
	String orderID;
	CreditAction creditAction;
	/**
	 * for example    "+200"
	 */
	String change;
	int credit;// 计算完成之后 的信用值
	
	public CreditRecordVO(String userID,Date date,String orderID,
			CreditAction creditAction,String change,int credit) {
		this.creditAction = creditAction;
		this.date = date;
		this.change = change;
		this.credit = credit;
		this.orderID = orderID;
		this.userID = userID;
	}
	public String getUserid() {
		return userID;
	}
	public Date getDate() {
		return date;
	}
	public String getOrderid() {
		return orderID;
	}
	public CreditAction getCreditAction() {
		return creditAction;
	}
	public String getChange() {
		return change;
	}
	public int getCredit() {
		return credit;
	}
	
	public CreditRecordPO changeIntoPO(){
		CreditRecordPO creditRecordPO = new CreditRecordPO(userID, date, orderID, creditAction, change, credit);
		return creditRecordPO;
		
	}
}
