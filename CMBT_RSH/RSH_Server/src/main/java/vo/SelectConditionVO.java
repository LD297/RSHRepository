package vo;

import java.util.Date;

public class SelectConditionVO {
	public String hotelName;
	public String roomType;
	public double lowestPrice;
	public double highestPrice;
	public int roomNum;
	public Date begin;
	public Date end;
	public int level;
	public double lowestGrade;
	public double highestGrade;
	public String userID;
	public Boolean reserved;
	public SelectConditionVO(String hotelName,String roomType,double lowestPrice,double highestPrice,int roomNum,Date begin,Date end,int level,double lowestGrade,double highestGrade,String userID,Boolean reserved) {
		this.begin = begin;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.lowestGrade = lowestGrade;
		this.highestGrade = highestGrade;
		this.roomNum = roomNum;
		this.end = end;
		this.level = level;
		this.reserved = reserved;
		this.lowestPrice = lowestPrice;
		this.highestPrice = highestGrade;
		this.userID = userID;
	}
}
