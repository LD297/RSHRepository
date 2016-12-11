package presentation.tools;

import bl.loginservice.LoginService;
import constant.ResultMessage;
import constant.Role;
import vo.UserVO;
import vo.WebManagerVO;

public class LoginStub implements LoginService{

	public ResultMessage register(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage register(WebManagerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage checkOnline(Role role, String id, String password) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}

	public ResultMessage logout(Role role, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
