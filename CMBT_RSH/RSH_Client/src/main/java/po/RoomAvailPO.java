package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import constant.RoomType;

public class RoomAvailPO implements Serializable{

	/**
	 * 酒店名称
	 */
	public String id;
	/**
	 * 房间类型（单人间／标准间）
	 */
	public RoomType type;
	
	/**
	 * 对该类型房间信息查询的时间段(只包含起止日期，起于fromTo[0]的12:00，止于fromTo[1]的11：59)
	 */
	public ArrayList<Date> fromTo;
	
	public RoomAvailPO(String id, RoomType type, ArrayList<Date> fromTo) {
		this.id = id;
		this.type = type;
		this.fromTo = fromTo;
	}
	/**
	 * 该时间段内的可用房间数量（算法处理后的结果）
	 */
	private int amountAvail;
	
	public int getAmountAvail() {
		return amountAvail;
	}
	public void setAmountAvail(int amountAvail) {
		this.amountAvail = amountAvail;
	}
}
