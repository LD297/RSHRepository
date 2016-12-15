package presentation.tools;

import java.util.ArrayList;

import vo.UserVO;

public class WebManagerInfoUtil {
	private static WebManagerInfoUtil webManagerInfoUtil = null;
	private WebManagerInfoUtil(){}
	public static WebManagerInfoUtil getInstance() {
		if(webManagerInfoUtil==null){
			webManagerInfoUtil = new WebManagerInfoUtil();
		}
		return webManagerInfoUtil;
	}
	
	/**
	 * 管理用户界面调用，得到所有用户的list
	 */
	public ArrayList<UserVO> getUserVOs() {
		return null;
	}
}
