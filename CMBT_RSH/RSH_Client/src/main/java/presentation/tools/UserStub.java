package presentation.tools;

import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;

import bl.userservice.UserService;
import constant.MemberType;
import constant.ResultMessage;
import constant.Sexuality;
import vo.CreditRecordVO;
import vo.UserVO;

public class UserStub implements UserService{

	public UserVO getInfo(String userid) {
		// TODO Auto-generated method stub
		return new UserVO(userid, "123456", "ahh",
				  "", new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), 5, MemberType.commerce, "王小二",
				  Sexuality.male, "233@233.com", 450, "nju");
	}

	public ResultMessage update(UserVO userVO) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	public Iterator<CreditRecordVO> getCreditRecordList(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage registerMember(String userid) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	public ResultMessage registerMember(String userid, String commerceName) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

}
