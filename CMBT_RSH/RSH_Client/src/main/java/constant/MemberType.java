package constant;

public enum MemberType {
	commom("普通会员"),
	commerce("企业会员");
	
	private String s;
	private MemberType(String s){
		this.s = s;
	}
	/**
	 * 返回该membertype的string用以显示
	 * @return
	 */
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
