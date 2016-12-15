package po;

import vo.RoomVO;

import java.io.Serializable;

public class RoomPO implements Serializable{
	/**
	 * 酒店名称
	 */
	private String id;
	/**
	 * 房间类型（单人间／标准间）
	 */
	private String type;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	public static RoomPO changeIntoPO(RoomVO vo){
		RoomPO newRoomPO  = new RoomPO();
		newRoomPO.setId(vo.id);
		newRoomPO.setType(vo.type);
		newRoomPO.setAmountTotal(vo.amountTotal);
		newRoomPO.setPrice(vo.price);
		newRoomPO.setBasicOrSpecial(vo.basicOrSpecial);
		return newRoomPO;
	}
}
