package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import constant.RoomType;

public class RoomPO implements Serializable{
	/**
	 * 酒店名称
	 */
	public String id;
	/**
	 * 房间类型（单人间／标准间）
	 */
	public RoomType type;
	/**
	 * 该类型房间总量
	 */
	private int amountTotal;
	/**
	 * 该类型房间的单价（元／晚（12:00～次日11:59））
	 */
	private double price;
	/**
	 * 该类型房间是否被设为特色
	 */
	private String basicOrSpecial;
	
	public RoomPO(String id, RoomType type, ArrayList<Date> fromTo) {
		this.id = id;
		this.type = type;
	}
	public int getAmountTotal() {
		return amountTotal;
	}
	public void setAmountTotal(int amountTotal) {
		this.amountTotal = amountTotal;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBasicOrSpecial() {
		return basicOrSpecial;
	}
	public void setBasicOrSpecial(String basicOrSpecial) {
		this.basicOrSpecial = basicOrSpecial;
	}
}
