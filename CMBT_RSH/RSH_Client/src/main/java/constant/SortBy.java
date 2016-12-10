package constant;

public enum SortBy {
	grade("评分"),level("星级"),price("价格");
	private String string;
	private SortBy(String string){
		this.string = string;
	}
	
	public String getString() {
		return string;
	}
	
	public static SortBy getSortBy(String s) {
		if(s.equals("评分")){
			return SortBy.grade;
		}else if (s.equals("星级")) {
			return SortBy.level;
		}else {
			return SortBy.price;
		}
	}
}
