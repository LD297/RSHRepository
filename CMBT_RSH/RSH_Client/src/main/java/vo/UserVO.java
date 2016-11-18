package vo;

import constant.MemberType;
import constant.Sexuality;

public class UserVO {
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
	
	public UserVO(String id, String password, String nickName, 
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

