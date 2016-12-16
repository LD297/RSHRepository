package presentation.tools;

import java.util.ArrayList;

import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginService_Stub;
import constant.ResultMessage;
import constant.Role;
import vo.UserVO;

public class WebManagerInfoUtil {
	private static WebManagerInfoUtil webManagerInfoUtil = null;
	private LoginService loginService = new LoginService_Stub();
	private WebManagerInfoUtil(){}
	public static WebManagerInfoUtil getInstance() {
		if(webManagerInfoUtil==null){
			webManagerInfoUtil = new WebManagerInfoUtil();
		}
		return webManagerInfoUtil;
	}
	
	/**
	 * 网管登陆界面调用，检查账号和密码是否匹配
	 */
	public ResultMessage checkOnLine(String id,String password) {
		ResultMessage resultMessage = loginService.checkOnline(Role.webmanager, id, password);
		return resultMessage;
	}
	
	/**
	 * 管理用户界面调用，得到所有用户的list
	 */
	public ArrayList<UserVO> getUserVOs() {
		return null;
	}
}
