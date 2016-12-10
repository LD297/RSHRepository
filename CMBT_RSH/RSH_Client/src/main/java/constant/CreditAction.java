package constant;

public enum CreditAction {
	bymoney("信用充值"),
	cancel("撤销订单"),
	abnormal("异常订单"),
	execute("执行订单"),
	delay_checkin("延迟入住"),
	cancel_abnomal("恢复异常订单");
	private String string;
	private CreditAction(String string){
		this.string = string;
	}
	public String toString() {
		return string;
	}
	public static CreditAction getCreditAction(String s) {
		if(s.equals("信用充值")){
			return CreditAction.bymoney;
		}else if (s.equals("撤销订单")) {
			return CreditAction.cancel;
		}else if (s.equals("异常订单")) {
			return CreditAction.abnormal;
		}else if (s.equals("执行订单")) {
			return CreditAction.execute;
		}else if(s.equals("延迟入住")){
			return CreditAction.delay_checkin;
		}else {
			return CreditAction.cancel_abnomal;
		}
	}
}
