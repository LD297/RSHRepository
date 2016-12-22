package constant;

import java.io.Serializable;

public enum MemberType implements Serializable{
	commom("普通会员"),
	commerce("企业会员"),
	not_member("非会员");
	
	private String s;
	private MemberType(String s){
		this.s = s;
	}
	public String getString(){
		return s;
	}
	public static MemberType getMemberType(String string) {
		if(string.equals("普通会员")){
			return MemberType.commom;
		}else {
			return MemberType.commerce;
		}
	}
}
