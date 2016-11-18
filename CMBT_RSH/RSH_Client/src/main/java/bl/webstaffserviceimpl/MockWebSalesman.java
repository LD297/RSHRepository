package bl.webstaffserviceimpl;

import constant.ResultMessage;

public class MockWebSalesman extends WebSalesman{
	public MockWebSalesman(String id, String passw) {
		super(id, passw);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 检查该账号是否存在，若存在，检查账号与密码是否匹配
	 * @param id
	 * @param password
	 * @return
	 */
	public static ResultMessage checkPassword(String id,String password) {
		return ResultMessage.success;
	}
}
