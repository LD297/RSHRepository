package bl.userserviceimpl;

import constant.ResultMessage;
import vo.UserVO;

public class MockUser extends User{
	public MockUser(String id) {
		super(id);
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
	 * 检查此账号是否存在，若不存在，创建该UserPO，在数据库中增加该用户的持久化对象
	 * @param vo
	 * @return
	 */
	/*public static ResultMessage add(UserVO vo) {
		return ResultMessage.success;
	}*/
}
