package po;

import java.io.Serializable;
import java.util.Date;

import constant.CreditAction;

public class CreditRecordPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -163720997980736608L;
	String userID;
	Date date;
	String orderID;
	CreditAction creditAction;
	/**
	 * for example"+200"
	 */
	String change;
	/**
	 * 变化后的信用值
	 */
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
	public void setUserid(String userID) {
		this.userID = userID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public CreditAction getCreditAction() {
		return creditAction;
	}
	public void setCreditAction(CreditAction creditAction) {
		this.creditAction = creditAction;
	}
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
}
