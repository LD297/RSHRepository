package bl.loginserviceimpl;

import bl.loginservice.LoginService;
import constant.ResultMessage;
import constant.Role;
import vo.UserVO;
import vo.WebManagerVO;

public class LoginService_Stub implements LoginService{

	@Override
	public ResultMessage register(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage register(WebManagerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage checkOnline(Role role, String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage logout(Role role, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
