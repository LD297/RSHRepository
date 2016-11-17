package bl.loginserviceimpl;



import constant.ResultMessage;
import constant.Role;

public class LoginTest {
	@Test
	public void testCheckOnline(){
		ResultMessage resultMessage1 = Login.checkOnline(Role.user, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.success,resultMessage1);
		ResultMessage resultMessage2 = Login.checkOnline(Role.hotel, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.success,resultMessage2);
		ResultMessage resultMessage3 = Login.checkOnline(Role.websalesman, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.success,resultMessage3);
		ResultMessage resultMessage4 = Login.checkOnline(Role.webmanager, "13951897687","jksggkskjg" );
		assertEquals(ResultMessage.success,resultMessage4);
	}
}
