package bl.promotionServiceimpl;

import constant.ConditionType;

/**
 * 生日要求
 * @author aa
 *
 */
public class BirthdayCondition extends Condition {

	public BirthdayCondition(){

	}

	@Override
	public ConditionType getType() {
		return ConditionType.BIRTHDAY;
	}

	@Override
	public int getNum() {
		return 0;
	}


	public boolean check(int isBirthday){
		if(isBirthday==1)
			return true;
		return false;
	}


}
