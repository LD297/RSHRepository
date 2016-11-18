package vo;

import constant.RoomType;

public class RoomVO {
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
	
	public RoomVO(String id, RoomType type) {
		this.id = id;
		this.type = type;
	}
	public int getAmountTotal() {
		return amountTotal;
	}
	protected void setAmountTotal(int amountTotal) {
		this.amountTotal = amountTotal;
	}
	public double getPrice() {
		return price;
	}
	protected void setPrice(double price) {
		this.price = price;
	}
	public String getBasicOrSpecial() {
		return basicOrSpecial;
	}
	protected void setBasicOrSpecial(String basicOrSpecial) {
		this.basicOrSpecial = basicOrSpecial;
	}
	
}
