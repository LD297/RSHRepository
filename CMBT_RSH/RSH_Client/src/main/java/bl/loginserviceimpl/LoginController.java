package bl.loginserviceimpl;

import bl.loginservice.LoginService;
import constant.ResultMessage;
import constant.Role;
import vo.UserVO;
import vo.WebManagerVO;

public class LoginController implements LoginService{

	/**
	 * 为用户注册，若该用户名没有被注册过，则增加该用户的持久化对象
	 */
	public ResultMessage register(UserVO vo) {
		// TODO Auto-generated method stub
		//return MockUser.add(vo);
		return null;
	}

	/**
	 * 为网站管理人员注册，则增加该网管的持久化对象
	 */
	public ResultMessage register(WebManagerVO vo) {
		// TODO Auto-generated method stub
		//return MockManager.add(vo);
		return null;
	}

	/**
	 * 检查用户名和密码是否匹配，以及是否有登陆冲突。若都符合要求，则增加该在线人员记录持久化对象
	 */
	public ResultMessage checkOnline(Role role, String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 删除该在线人员记录持久化对象
	 */
	public ResultMessage logout(Role role, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
