package bl.loginserviceimpl;


import constant.ResultMessage;
import constant.Role;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {
	LoginController loginController = new LoginController();

	@Test
	public void testCheckOnline(){
		ResultMessage resultMessage1 = loginController.checkOnline(Role.user, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.succeed,resultMessage1);
		ResultMessage resultMessage2 = loginController.checkOnline(Role.hotel, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.succeed,resultMessage2);
		ResultMessage resultMessage3 = loginController.checkOnline(Role.websalesman, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.succeed,resultMessage3);
		ResultMessage resultMessage4 = loginController.checkOnline(Role.webmanager, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.succeed,resultMessage4);
	}
}
