package constant;

public enum Sexuality {
	male("男"),
	female("nv");
	
	private String string;
	private Sexuality(String string){
		this.string = string;
	}
	
	public String getString() {
		return string;
	}
	
	public static Sexuality getSexuality(String s) {
		if(s.equals("男")){
			return Sexuality.male;
		}else {
			return Sexuality.female;
		}
	}
}
