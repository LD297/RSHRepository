package bl.promotionServiceimpl.condition;

import java.text.ParseException;
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
		
		String userID = orderVO.getUserID();
		UserController userController = new UserController();
		UserVO userVO = userController.getInfo(userID);
		LocalDate birthday = userVO.birthday;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		Date dBirthday = null;
		try {
			dBirthday = simpleDateFormat.parse(simpleDateFormat.format(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date beginDate = orderVO.getCheckInDate();
		Date endDate = orderVO.getCheckInDate();
		
		if(beginDate.after(dBirthday))
			return false;
		if(endDate.before(dBirthday))
			return false;
		
		return true;
	}
	
}

