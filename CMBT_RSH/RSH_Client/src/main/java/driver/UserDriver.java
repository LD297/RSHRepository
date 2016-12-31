package driver;

import java.time.LocalDate;
import java.util.Iterator;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import bl.userserviceimpl.MemberHelper;
import bl.userserviceimpl.UserController;
import constant.MemberType;
import constant.Sexuality;
import vo.CreditRecordVO;
import vo.UserVO;

public class UserDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDriver userDriver = new UserDriver();
		userDriver.test();
	}
	String userID = "13333111116";
	String password = "123";
	String nickName = "123";
	String imageAddress = "111";
	LocalDate birth = LocalDate.now();
	int level = 2;
	MemberType memberType = MemberType.commerce;
	String name = "李薇薇";
	Sexuality sexuality = Sexuality.female;
	String eMail = "234";
	int credit = 0;
	String commerceName = "123";
	UserVO userVO = new UserVO(userID, password, nickName, imageAddress, birth, level, memberType,
			name, sexuality, eMail, credit, commerceName);
	
	public void test(){
		UserController userController = new UserController();
		userController.add(userVO);
		/*System.out.println("begin");
		System.out.println(userController.add(userVO).toString());
		System.out.println(userController.checkPassword(userID, password).toString());
		System.out.println(userController.changePassword(userID, password, "456").toString());
		System.out.println(userController.checkPassword(userID, "456").toString());
		System.out.println(userController.getCreditRecordList(userID).hasNext());
		System.out.println(userController.getInfo(userID).commerceName);
		System.out.println(Member.getBoundaryForLevels());
		System.out.println(userController.registerMember(userID).toString());
		System.out.println(userController.addCredit(2000, "44444444444").toString());
		userController.registerMember("44444444444");
		Iterator<CreditRecordVO> creditRecord = userController.getCreditRecordList("44444444444");

		System.out.println(userController.getInfo("44444444444").memberType.toString());
		while(creditRecord.hasNext()){
			CreditRecordVO creditRecordVO = creditRecord.next();
			System.out.println(creditRecordVO.getCredit());
		}*/
		
		System.out.println("end");
	}
	

}
