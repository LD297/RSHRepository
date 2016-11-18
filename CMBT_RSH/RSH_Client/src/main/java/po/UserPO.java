package po;

import java.io.Serializable;

import constant.MemberType;
import constant.Sexuality;

public class UserPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8288241397984958515L;
	String id;
	String password;
	String nickName;
	String imageAddress;
	int level;
	MemberType memberType;
	String name;
	Sexuality sexuality;
	String eMail;
	int credit;
	
	public UserPO(String id, String password, String nickName, 
			String imageAddress, int level, MemberType memberType, String name,
			Sexuality sexuality, String eMail, int credit) {
		this.id = id;
		this.nickName = nickName;
		this.imageAddress = imageAddress;
		this.level = level;
		this.memberType = memberType;
		this.name = name;
		this.sexuality = sexuality;
		this.eMail = eMail;
		this.credit = credit;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public String getNickName() {
		return nickName;
	}
	public String getImageAddress() {
		return imageAddress;
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
}
