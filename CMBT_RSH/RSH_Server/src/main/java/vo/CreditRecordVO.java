package vo;

import constant.CreditAction;

import java.util.Date;

public class CreditRecordVO {
	String userid;
	Date date;
	String orderid;
	CreditAction creditAction;
	/**
	 * for example    "+200"
	 */
	String change;
	int credit;
	public CreditRecordVO(String userid,Date date,String orderid,
			CreditAction creditAction,String change,int credit) {
		this.creditAction = creditAction;
		this.date = date;
		this.change = change;
		this.credit = credit;
		this.orderid = orderid;
		this.userid = userid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
