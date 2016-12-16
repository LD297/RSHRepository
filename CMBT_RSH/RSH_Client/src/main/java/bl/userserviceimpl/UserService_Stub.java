package bl.userserviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import bl.userservice.UserService;
import constant.CreditAction;
import constant.MemberType;
import constant.ResultMessage;
import constant.Sexuality;
import vo.CreditRecordVO;
import vo.UserVO;

public class UserService_Stub implements UserService{

	@Override
	public UserVO getInfo(String userid) {
		// TODO Auto-generated method stub
		return new UserVO(userid, "123", "bob",
				  "233", LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang",
				  Sexuality.female, "xiaoer@ahh.com",100,"bilibili");
	}

	@Override
	public ResultMessage update(UserVO userVO) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public Iterator<CreditRecordVO> getCreditRecordList(String userid) {
		ArrayList<CreditRecordVO> creditRecordVOs = new ArrayList<CreditRecordVO>();
		CreditRecordVO cVo1 = new CreditRecordVO(userid, new Date(), "17235412647553465",
				CreditAction.abnormal, "+700",100);
		CreditRecordVO cVo2 = new CreditRecordVO(userid, new Date(), "17235412647553465",
				CreditAction.bymoney, "+600",100);
		CreditRecordVO cVo3 = new CreditRecordVO(userid, new Date(), "17235412647553465",
				CreditAction.cancel, "+7100",100);
		CreditRecordVO cVo4 = new CreditRecordVO(userid, new Date(), "17235412647553465",
				CreditAction.cancel_abnomal, "+70",100);
		CreditRecordVO cVo5 = new CreditRecordVO(userid, new Date(), "17235412647553465",
				CreditAction.delay_checkin, "+7020",100);
		CreditRecordVO cVO6 = new CreditRecordVO(userid, new Date(), "17235412647553465",
				CreditAction.execute, "+900",100);
		CreditRecordVO cVo7 = new CreditRecordVO(userid, new Date(), "17235412647553465",
				CreditAction.execute, "+6010",100);
		CreditRecordVO cVo8 = new CreditRecordVO(userid, new Date(), "17235412647553465",
				CreditAction.delay_checkin, "+7020",100);
		CreditRecordVO cVo9 = new CreditRecordVO(userid, new Date(), "17235412647553465",
				CreditAction.delay_checkin, "+7020",100);
		creditRecordVOs.add(cVo1);
		creditRecordVOs.add(cVo9);
		creditRecordVOs.add(cVo8);
		creditRecordVOs.add(cVo7);
		creditRecordVOs.add(cVO6);
		creditRecordVOs.add(cVo5);
		creditRecordVOs.add(cVo4);
		creditRecordVOs.add(cVo3);
		creditRecordVOs.add(cVo2);
		Iterator<CreditRecordVO> cIterator = creditRecordVOs.iterator();
		return cIterator;
	}

	@Override
	public ResultMessage registerMember(String userid) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage registerMember(String userid, String commerceName) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public ResultMessage setMemberStandard(int[] boundariesForLevels) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	@Override
	public int[] getMemberStandard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMemberLevel(int credit) {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public ResultMessage changePassword(String userid, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}



}
