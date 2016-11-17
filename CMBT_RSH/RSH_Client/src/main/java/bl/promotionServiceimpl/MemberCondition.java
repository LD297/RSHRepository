package bl.promotionServiceimpl;

/**
 * 对会员等级的要求
 * @author aa
 *
 */
public class MemberCondition extends ConditionType{

	int Class;
	
	public MemberCondition(int c){
		Class=c;
	}
	
	public boolean check(int clss){
		boolean result = false;
		
		return result;
	}
}
