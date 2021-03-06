package bl.promotionServiceimpl.condition;

import bl.userservice.UserService;
import bl.userserviceimpl.User;
import bl.userserviceimpl.UserController;
import constant.ConditionType;
import constant.MemberType;
import vo.OrderInfo;
import vo.OrderVO;
import vo.UserVO;

public class CommerceCondtion extends Condition {

	int level;
	public CommerceCondtion(int level) {
		// TODO Auto-generated constructor stub
		this.level = level;
	}

	@Override
	public ConditionType getType() {
		// TODO Auto-generated method stub
		return ConditionType.COMMERCE;
	}

	@Override
	public double getNum() {
		return level;
	}

	@Override
	public boolean check(OrderInfo orderVO) {
		String userID = orderVO.getUserID();
		UserController userController = new UserController();
		UserVO userVO = userController.getInfo(userID);
		MemberType memberType= userVO.getMemberType();
		
		if(memberType!=MemberType.commerce){
			return false;
		}
		if(userVO.getLevel()<level){
			return false;
		}
		return true;
	}

}
