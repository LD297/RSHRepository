package po;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import constant.MemberType;
import constant.Sexuality;

public class UserPO implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String userID;
	String password;
	String nickName;
	String imageAddress;
	int level;
	MemberType memberType;
	String name;
	Sexuality sexuality;
	String eMail;
	int credit;
	LocalDate birthday;
	String commerceName;

	public UserPO(String id, String password, String nickName, String imageAddress,
				  LocalDate birth,int level, MemberType memberType, int credit,
				  String name, Sexuality sexuality, String eMail,String commerceName) {
		this.userID = id;
		this.nickName = nickName;
		this.imageAddress = imageAddress;
		this.birthday = birth;
		this.level = level;
		this.memberType = memberType;
		this.name = name;
		this.sexuality = sexuality;
		this.eMail = eMail;
		this.credit = credit;
		this.password = password;
		this.commerceName = commerceName;
	}
	public String getCommerceName() {
		return commerceName;
	}
	public String getId() {
		return userID;
	}
	public String getNickName() {
		return nickName;
	}
	public String getImageAddress() {
		return imageAddress;
	}
	public LocalDate getBirthday(){
		return birthday;
	}
	public int getLevel() {
		return level;
	}
	public MemberType getMemberType() {
		return memberType;
	}
	public String getName() {
		return name;
	}
	public Sexuality getSexuality() {
		return sexuality;
	}
	public String geteMail() {
		return eMail;
	}
	public int getCredit() {
		return credit;
	}
	public String getPassword() {
		return password;
	}
	public void setId(String userID) {
		this.userID = userID;
	}
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}


	
}
