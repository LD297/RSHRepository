package bl.loginserviceimpl;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import constant.ResultMessage;
import constant.Role;

public class LoginTest {
	@Test
	public void testCheckOnline(){
		ResultMessage resultMessage1 = Login.checkOnline(Role.user, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.succeed,resultMessage1);
		ResultMessage resultMessage2 = Login.checkOnline(Role.hotel, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.succeed,resultMessage2);
		ResultMessage resultMessage3 = Login.checkOnline(Role.websalesman, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.succeed,resultMessage3);
		ResultMessage resultMessage4 = Login.checkOnline(Role.webmanager, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.succeed,resultMessage4);
	}
}
