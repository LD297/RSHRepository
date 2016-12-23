package driver;

import bl.loginserviceimpl.LoginController;
import constant.Role;
import junit.framework.Test;
import vo.UserVO;

public class LoginDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginDriver loginDriver = new LoginDriver();
		loginDriver.test();
	}

	Role role = Role.hotel;
	Role role2 = Role.user;
	
	String hotelID = "2016000001";
	String userID = "11111111111";
	UserVO userVO = new UserVO(userID, userID, userID, userID, null, 0, null, userID, null, userID, 0, null);
	String password = "123";
	public void test(){
		LoginController loginController = new LoginController();
		System.out.println("begin");
		loginController.register(userVO);
		System.out.println(loginController.checkOnline(role2, userID, "123").toString());
		System.out.println(loginController.logout(role, hotelID));
		System.out.println("end");
	}
}
