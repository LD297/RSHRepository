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
}
