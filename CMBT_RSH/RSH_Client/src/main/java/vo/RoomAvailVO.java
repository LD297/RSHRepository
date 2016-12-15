package vo;

import java.util.ArrayList;
import java.util.Date;

public class RoomAvailVO extends RoomVO {
	/**
	 * 对该类型房间信息查询的时间段
	 * (只包含起止日期，起于fromTo[0]的12:00，止于fromTo[1]的11：59)
	 */
	public ArrayList<Date> fromTo;
	public Date beginDate;
	public Date endDate;
	
	
	/**
	 * 该时间段内的可用房间数量（算法处理后的结果）
	 */
	private int amountAvail;
	public RoomAvailVO(String id, String roomType, int amountTotal, double price,
					   String basicOrSpecial) {
		super(id, roomType, amountTotal, price, basicOrSpecial);
	}
	
	
	public int getAmountAvail() {
		return amountAvail;
	}
	public void setAmountAvail(int amountAvail) {
		this.amountAvail = amountAvail;
	}
	
}
