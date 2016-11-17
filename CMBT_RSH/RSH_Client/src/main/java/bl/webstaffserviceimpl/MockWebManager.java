package bl.webstaffserviceimpl;

import constant.ResultMessage;
import vo.WebManagerVO;

public class MockWebManager extends WebManager{
	public MockWebManager(String id, String passw) {
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
	/**
	 * 检查此账号是否存在，若不存在，创建该WebManagerPO，在数据库中增加该用户的持久化对象
	 * @param vo
	 * @return
	 */
	/*public static ResultMessage add(WebManagerVO vo) {
		return ResultMessage.success;
	}*/
}
