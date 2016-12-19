package bl.promotionServiceimpl.condition;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import bl.userservice.UserService;
import bl.userserviceimpl.UserController;
import constant.ConditionType;
import vo.OrderInfo;
import vo.OrderVO;
import vo.UserVO;

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
	public boolean check(OrderInfo orderVO) {
		// TODO Auto-generated method stub
		String userID = orderVO.getUserID();
		UserService userService = new UserController();
		UserVO userVO = userService.getInfo(userID);
		LocalDate birthday = userVO.birthday;
		Date beginDate = orderVO.getCheckInDate();
		Date endDate = orderVO.getCheckInDate();
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd");
		String sBirthday = sDateFormat.format(birthday);
		String sBeginDate = sDateFormat.format(beginDate);
		String sEndDate = sDateFormat.format(endDate);
		int iBirthday = Integer.parseInt(sBirthday);
		int iBeginDate = Integer.parseInt(sBeginDate);
		int iEndDate = Integer.parseInt(sEndDate);
		if(iBirthday>=iBeginDate&&iBirthday<iEndDate)
			return true;
		else
			return false;
	}
	
}

