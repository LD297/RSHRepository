package bl.userserviceimpl;

import java.util.Iterator;

import bl.userservice.UserService;
import constant.ResultMessage;
import vo.CreditRecordVO;
import vo.UserVO;

public class UserService_Stub implements UserService{

	@Override
	public UserVO getInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<CreditRecordVO> getCreditRecordList(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage registerMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage registerMember(String userid, String commerceName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public ResultMessage setMemberStandard(int[] boundariesForLevels) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getMemberStandard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMemberLevel(int credit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage changePassword(String userid, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
