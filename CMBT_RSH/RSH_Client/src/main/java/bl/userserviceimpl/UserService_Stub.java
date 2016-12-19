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
				"http://p1.bpimg.com/567571/246972e244c7580b.png",
				LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang", Sexuality.female, "xiaoer@ahh.com", 100,
				"bilibili");
	}

	@Override
	public ResultMessage update(UserVO userVO) {
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

	@Override
	public ArrayList<UserVO> getUserVOS() {
		UserVO userVO1 = new UserVO("12321678909", "123", "bob",
				  "233", LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang",
				  Sexuality.female, "xiaoer@ahh.com",100,"bilibili");
		UserVO userVO2 = new UserVO("12124235346", "123", "assd",
				  "233", LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang",
				  Sexuality.male, "xiaoer@ahh.com",100,"bilibili");
		UserVO userVO3 = new UserVO("12678789800", "123", "bob",
				  "233", LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang",
				  Sexuality.female, "xiaoer@ahh.com",100,"bilibili");
		UserVO userVO4 = new UserVO("13547658769", "123", "rrey",
				  "233", LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang",
				  Sexuality.male, "xiaoer@ahh.com",100,"bilibili");
		UserVO userVO5 = new UserVO("54634667899", "123", "bob",
				  "233", LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang",
				  Sexuality.female, "xiaoer@ahh.com",100,"bilibili");
		UserVO userVO6 = new UserVO("126878909", "123", "214",
				  "233", LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang",
				  Sexuality.male, "xiaoer@ahh.com",100,"bilibili");
		UserVO userVO7 = new UserVO("12379685619", "123", "bob",
				  "233", LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang",
				  Sexuality.female, "xiaoer@ahh.com",100,"bilibili");
		UserVO userVO8 = new UserVO("12345678909", "123", "air",
				  "233", LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang",
				  Sexuality.male, "xiaoer@ahh.com",100,"bilibili");
		UserVO userVO9 = new UserVO("12345678909", "123", "bob",
				  "233", LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang",
				  Sexuality.female, "xiaoer@ahh.com",100,"bilibili");
		UserVO userVO0 = new UserVO("12308656434", "123", "bob",
				  "233", LocalDate.now(), 5, MemberType.commerce, "Xiaoer Wang",
				  Sexuality.male, "xiaoer@ahh.com",100,"bilibili");
		ArrayList<UserVO> userVOs = new ArrayList<>();
		userVOs.add(userVO0);
		userVOs.add(userVO9);
		userVOs.add(userVO8);
		userVOs.add(userVO7);
		userVOs.add(userVO6);
		userVOs.add(userVO5);
		userVOs.add(userVO4);
		userVOs.add(userVO3);
		userVOs.add(userVO2);
		userVOs.add(userVO1);
		return userVOs;
	}

	@Override
	public String resetPassword(String userid) {
		return "hdgfjf_2565472";
	}

	@Override
	public ResultMessage addCredit(int value, String userID) {
		// TODO Auto-generated method stub
		return null;
	}
}
