package bl.loginservice;

import constant.ResultMessage;
import constant.Role;
import vo.UserVO;
import vo.WebManagerVO;

/**
 * 处理与登陆、注册界面有关的逻辑，所有传入的参数必须在界面层检验是否合法
 * @author john
 *
 */
public interface LoginService {
	/**
	 * 为用户注册，若该用户名没有被注册过，则增加该用户的持久化对象
	 */
	public ResultMessage register(UserVO vo);
	/**
	 * 为网站管理人员注册，则增加该网管的持久化对象
	 */
	public ResultMessage register(WebManagerVO vo) ;
	/**
	 * 检查用户名和密码是否匹配，以及是否有登陆冲突。若都符合要求，则增加该在线人员记录持久化对象
	 */
	public ResultMessage checkOnline(Role role, String id, String password);
	/**
	 * 删除该在线人员记录持久化对象
	 */
	public ResultMessage logout(Role role, String id);
	
}
