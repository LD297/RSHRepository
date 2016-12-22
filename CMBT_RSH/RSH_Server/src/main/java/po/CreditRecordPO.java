package po;

import java.io.Serializable;
import java.util.Date;

import constant.CreditAction;

public class CreditRecordPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String userID;
	Date date;
	String orderID;
	CreditAction creditAction;
	/**
	 * for example    "+200"
	 */
	String change;
	int credit;
	public CreditRecordPO(String userID,Date date,String orderID,
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
	public String getOrderID() {
		// TODO Auto-generated method stub
		return orderID;
	}
	
	
}
