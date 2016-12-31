package vo;

import java.util.Date;

public class SelectConditionVO {
	public String roomType = null;
	public double lowestPrice = 0;
	public double highestPrice = Double.MAX_VALUE;
	public int roomNum = 0;
	public Date begin = new Date(0xFFFFFFFF);
	public Date end = new Date(0x80000000);
	public int level = -1;
	public double lowestGrade = 0;
	public double highestGrade = Double.MAX_VALUE;
	public String userID = null;
	public Boolean reserved = false;
	
	
	
	

}
