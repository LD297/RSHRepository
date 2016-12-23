package driver;

import java.time.LocalDate;

import bl.userserviceimpl.Member;
import bl.userserviceimpl.UserController;
import constant.MemberType;
import constant.Sexuality;
import vo.UserVO;

public class UserDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDriver userDriver = new UserDriver();
		userDriver.test();
	}
	String userID = "11111111116";
	String password = "123";
	String nickName = "123";
	String imageAddress = "111";
	LocalDate birth = LocalDate.now();
	int level = 2;
	MemberType memberType = MemberType.commom;
	String name = "123";
	Sexuality sexuality = Sexuality.female;
	String eMail = "234";
	int credit = 0;
	String commerceName = "123";
	UserVO userVO = new UserVO(userID, password, nickName, imageAddress, birth, level, memberType,
			name, sexuality, eMail, credit, commerceName);
	
	public void test(){
		UserController userController = new UserController();
		System.out.println(userController.add(userVO).toString());
		System.out.println(userController.checkPassword(userID, password).toString());
		System.out.println(userController.changePassword(userID, password, "456").toString());
		System.out.println(userController.checkPassword(userID, "456").toString());
		System.out.println(userController.addCredit(12, userID).toString());
		System.out.println(userController.getCreditRecordList(userID).hasNext());
		System.out.println(userController.getInfo(userID).commerceName);
	}
	

}
