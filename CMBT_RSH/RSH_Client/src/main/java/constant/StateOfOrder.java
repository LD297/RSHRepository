package constant;

public enum StateOfOrder {
	unexecuted("未执行"),
	executed("已执行"),
	abnormal("异常"),
	canceled("已撤销");
	
private String s;
	
	private StateOfOrder(String s) {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public static StateOfOrder getType(String ss) {
		if (ss.equals("未执行")) {
			return StateOfOrder.unexecuted;
		}
		if (ss.equals("已执行")) {
			return StateOfOrder.executed;
		}
		if (ss.equals("已撤销")) {
			return StateOfOrder.canceled;
		}
		if (ss.equals("异常")) {
			return StateOfOrder.abnormal;
		}
		return null;
	}


}
