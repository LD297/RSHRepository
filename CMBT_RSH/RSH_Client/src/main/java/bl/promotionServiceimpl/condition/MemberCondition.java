package bl.promotionServiceimpl.condition;

import bl.userserviceimpl.UserController;
import constant.ConditionType;
import constant.MemberType;
import vo.OrderInfo;
import vo.OrderVO;
import vo.UserVO;

/**
 * 对会员等级的要求
 * 等级为100时为企业会员
 * @author aa
 *
 */
public class MemberCondition extends Condition {

	MemberType memberType;
	int memberLevel;
	
	public MemberCondition(double memberLevel){
		this.memberLevel = (int)memberLevel;
	}

	@Override
	public ConditionType getType() {
		if(memberLevel>100)
			return ConditionType.COMMERCE;
		return ConditionType.MEMBER;
	}

	@Override
	public double getNum() {
		return memberLevel;
	}

	

	@Override
	public boolean check(OrderInfo orderVO) {
		// TODO Auto-generated method stub
		String userID = orderVO.getUserID();
		UserController userController = new UserController();
		UserVO userVO = userController.getInfo(userID);
		if(userVO.getMemberType()!=memberType.commom){
			return false;
		}
		if(userVO.level<memberLevel){
			return false;
		}
		return true;
	}


}
