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
	public int amountTotal;
	/**
	 * 该类型房间的单价（元／晚（12:00～次日11:59））
	 */
	public double price;
	/**
	 * 该类型房间是否被设为特色
	 */
	public String basicOrSpecial;

	public RoomVO(String id, RoomType type, int amountTotal, double price, String basicOrSpecial) {
		this.id = id;
		this.type = type;
		this.amountTotal = amountTotal;
		this.price = price;
		this.basicOrSpecial = basicOrSpecial;
	}
}
