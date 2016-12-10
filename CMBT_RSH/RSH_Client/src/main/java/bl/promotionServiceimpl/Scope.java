package bl.promotionServiceimpl;

import constant.ScopeType;

/**
 * 优惠策略的适用范围
 * @author aa
 *
 */
public abstract class Scope {

	private ScopeType scopeType;
	private String scopeNum;

	public abstract ScopeType getType();
	public abstract String  getNum();
	public abstract String getRoomType();
	/**
	 * 测试是否符合适用范围要求
	 * @param scope
	 * @return
	 */
	public abstract boolean check(String scope,String roomType);

}
