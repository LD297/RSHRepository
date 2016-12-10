package constant;

public enum SortMethod {
	ascend("从低到高"),dscend("从高到低");
	private String string;
	private SortMethod(String string){
		this.string = string;
	}
	public String getString() {
		return string;
	}
	public static SortMethod getSortMethod(String s) {
		if(s.equals("从低到高")){
			return SortMethod.ascend;
		}else {
			return SortMethod.dscend;
		}
	}
}
