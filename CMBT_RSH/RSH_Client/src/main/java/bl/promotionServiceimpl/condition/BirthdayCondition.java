package bl.promotionServiceimpl.condition;

import bl.userservice.UserService;
import bl.userserviceimpl.UserController;
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
	public double getNum() {
		return 0;
	}
	
	@Override
	public boolean check(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		String userID = orderInfo.userID;
		UserService userService = new UserController();
		
		return false;
	}


}
