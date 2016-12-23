package driver;

import bl.loginserviceimpl.LoginController;
import constant.Role;
import junit.framework.Test;

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
	
	String password = "123";
	public void test(){
		LoginController loginController = new LoginController();
		System.out.println("begin");
		System.out.println(loginController.checkOnline(role, hotelID, password).toString());
		System.out.println(loginController.logout(role, hotelID));
		System.out.println("end");
	}
}
