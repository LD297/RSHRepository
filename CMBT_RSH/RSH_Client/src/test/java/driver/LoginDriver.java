package driver;

import java.time.LocalDate;

import bl.loginserviceimpl.LoginController;
import constant.Role;
import constant.Sexuality;
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
	
	String hotelID = "2153000001";
	String userID = "15105182135";
	
	UserVO userVO = new UserVO(userID, "123456", "TINA",LocalDate.now(),"李未",Sexuality.male,"120@qq.com");
	public void test(){
		LoginController loginController = new LoginController();
		System.out.println("begin");
		System.out.println(loginController.register(userVO));
		System.out.println(loginController.checkOnline(role, userID, "123456").toString());
		//System.out.println(loginController.logout(role2,userID).toString());
		System.out.println("end");
	}
}
