package bl.loginserviceimpl;

import bl.loginservice.LoginService;
import bl.userserviceimpl.User;
import bl.userserviceimpl.UserController;
import bl.webstaffserviceimpl.MockWebManager;
import constant.ResultMessage;
import constant.Role;
import vo.UserVO;
import vo.WebManagerVO;

public class LoginController implements LoginService{

	/**
	 * 为用户注册，若该用户名没有被注册过，则增加该用户的持久化对象
	 */
	public ResultMessage register(UserVO vo) {
		UserController userController = new UserController();
		return userController.add(vo);
	}

	

	/**
	 * 检查用户名和密码是否匹配，以及是否有登陆冲突。若都符合要求，则增加该在线人员记录持久化对象
	 */
	public ResultMessage checkOnline(Role role, String id, String password) {
		return Login.checkOnline(role, id, password);
	}

	/**
	 * 删除该在线人员记录持久化对象
	 */
	public ResultMessage logout(Role role, String id) {
		return Login.logout(role, id);
	}

}
