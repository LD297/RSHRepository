package vo;

import constant.RoomType;

import java.sql.Date;
import java.util.ArrayList;

public class RoomVO {
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
	private Boolean basicOrSpecial;
	
	public RoomVO(String id, String type) {
		this.id = id;
		this.type = type;
	}
    public RoomVO(String id, String type,int amountTotal, double price, Boolean basicOrSpecial) {
        this.id = id;
        this.type = type;
        this.amountTotal = amountTotal;
        this.price = price;
        this.basicOrSpecial = basicOrSpecial;
    }

	public String getID(){
		return id;
	}
	public String getType(){
		return type;
	}
	public int getAmountTotal() {
		return amountTotal;
	}
	public double getPrice() {
		return price;
	}
	public boolean getBasicOrSpecial() {
		return basicOrSpecial;
	}

	protected void setAmountTotal(int amountTotal) {
		this.amountTotal = amountTotal;
	}
	protected void setPrice(double price) {
		this.price = price;
	}
	protected void setBasicOrSpecial(Boolean basicOrSpecial) {
		this.basicOrSpecial = basicOrSpecial;
	}
	
}
