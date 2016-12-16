package po;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class RoomPO implements Serializable{
	public String id;//hotelid
	public Date date;
	public String type;
	public int amountAvailable;
	public int amountTotal;
	public double price;
	public Boolean basicOrSpecial;
	public ArrayList<Integer> aList;
	public RoomPO(String id,Date date,String type,int amountAvailable,int amountTotal,double price,Boolean basicOrSpecial,ArrayList<Integer> aList) {
		this.id = id;
		this.date = date;
		this.type = type;
		this.amountAvailable = amountAvailable;
		this.amountTotal = amountTotal;
		this.price = price;
		this.basicOrSpecial = basicOrSpecial;
		this.aList = aList;
	}
	public RoomPO(String id, String type, int amountTotal, double price, boolean basicOrSpecial) {
		this.id = id;
		this.type = type;
		this.amountTotal = amountTotal;
		this.price = price;
		this.basicOrSpecial = basicOrSpecial;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
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

	public boolean getBasicOrSpecial() {
		return basicOrSpecial;
	}

	public void setBasicOrSpecial(boolean basicOrSpecial) {
		this.basicOrSpecial = basicOrSpecial;
	}

}
