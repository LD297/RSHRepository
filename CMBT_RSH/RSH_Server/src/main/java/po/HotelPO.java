package po;

import java.io.Serializable;


public class HotelPO implements Serializable{
	public String id;
	public String password;
	public int phoneNumber;
	public String name;
	public String addr;
	public String businessArea;
	public String briefIntro;
	public String facility;
	public int level;
	public int grade;
	public int latestCheckinTime;
	public HotelPO(String id,String password,int phoneNumber,String name,String addr,String businessArea,String briefIntro,String facility,int level,int grade,int latestCheckinTime) {
		this.id = id;
		this.addr = addr;
		this.briefIntro = briefIntro;
		this.businessArea = businessArea;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.grade = grade;
		this.businessArea = businessArea;
		this.facility = facility;
		this.level = level;
		this.latestCheckinTime = latestCheckinTime;
	}
}
