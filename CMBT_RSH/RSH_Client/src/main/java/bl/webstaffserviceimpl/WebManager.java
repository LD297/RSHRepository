package bl.webstaffserviceimpl;

import constant.ResultMessage;

/**
 * 网站管理人员类
 * @author aa
 *
 */
public class WebManager {

	String ID;
	String password;
	
	public WebManager(String id,String passw){
		ID = id;
		password = passw;
	}
	/**
	 * 修改密码
	 * @param password
	 * @return
	 */
	public ResultMessage changePassword(String password){
		
		return null;
	}
	
	/**
	 * 在数据层增加
	 * @return
	 */
	public ResultMessage add(){
		
		return null;
	}
	
	/**
	 * 在数据层中删除
	 * @param id
	 * @return
	 */
	public static ResultMessage del(String id){
		
		return null;
	}
}
