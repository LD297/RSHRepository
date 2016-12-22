package vo;

import constant.MemberType;
import constant.Sexuality;
import po.UserPO;

import java.time.LocalDate;

public class UserVO {
	public String userID;
	public String password;
	public String nickName;
	public String imageAddress;
	public LocalDate birthday;

	public MemberType memberType;
	public int level;
	public int credit;
	public String commerceName;
	public String name;
	public Sexuality sexuality;
	public String eMail;

	public UserVO(String id, String password, String nickName,
				  String imageAddress,LocalDate birth, int level, MemberType memberType, String name,
				  Sexuality sexuality, String eMail, int credit,String commerceName) {
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
	public void setCommerceName(String commerceName) {
		this.commerceName = commerceName;
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
	public void setPassword(String password){this.password = password;}
	
	public UserPO changeIntoPO(){
		UserPO userPO = new UserPO(userID, password, nickName, imageAddress, birthday, level, memberType, credit, name, sexuality, eMail, commerceName);
		System.out.println(userPO.getCommerceName());
		return userPO;
	}
}

