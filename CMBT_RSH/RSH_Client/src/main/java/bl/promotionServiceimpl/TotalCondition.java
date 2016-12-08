package bl.promotionServiceimpl;

import constant.ConditionType;

/**
 * 总额要求
 * @author aa
 *
 */
public class TotalCondition extends Condition {

	int total;
	
	public TotalCondition(int t){
		total=t;
	}

	@Override
	public ConditionType getType() {
		return ConditionType.TOTAL;
	}

	@Override
	public int getNum() {
		return total;
	}

	public boolean check(int cNum){
		if(cNum>=total)
			return true;
		else return false;
	}
}
