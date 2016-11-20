package bl.webstaffserviceimpl;

import constant.ResultMessage;
import data.dao.webstaffdao.WebManagerDao;
import po.WebManagerPO;
import rmi.RemoteHelper;
import rmi.WebStaffRemoteHelper;

import java.rmi.Remote;

/**
 * 网站管理人员类
 * 单一对象类，全系统中只有一个网站管理人员对象
 * 账号为十位0；
 * @author aa
 *
 */
public class WebManager {

//	private static final int  MAXNUM= 1;// 网站管理人员的最大数量
	private static WebManager webManager = null;
	private static String ID="0000000000";
	private String password=null;

	private static WebManagerDao webManagerDao=WebStaffRemoteHelper.getInstance();
	
	private WebManager(String tempPassword){
		password = tempPassword;
	}

	/**
	 *
	 * @param tempPass
	 * @return
	 */
	public static ResultMessage register(String id,String tempPass){
		if(webManager==null){
			webManager=WebManager.getInstance();
			if(webManager!=null)
				return ResultMessage.fail;
			webManager=new WebManager(tempPass);
			webManager.update();
			return ResultMessage.fail;
		}
		else {
			return ResultMessage.fail;
		}
	}

	/**
	 * 需要数据层中提取数据，判断是否已经初始化
	 * @return
	 */
	public static WebManager getInstance(){;
		if(webManager==null){
			WebManagerPO  webManagerPO = webManagerDao.getManagerInstance(ID);
			String tempPassword = webManagerPO.getPassword();
			if(tempPassword==null)
				return null;
			else
				return new WebManager(tempPassword);
		}
		else{
			return webManager;
		}
	}

	/**
	 *
	 * @param oldPassword
	 * @param newPassword
	 * @return 是否成功
	 */
	public ResultMessage changePassword(String oldPassword, String newPassword){
		if(webManager==null){
			webManager = WebManager.getInstance();
			if(webManager==null)
				return ResultMessage.fail;
		}
		if (oldPassword==password){
			password=newPassword;
			return this.update();
		}
		else{
			return ResultMessage.fail;
		}
	}
	
	/**
	 * 在数据层增加
	 * @return
	 */
	private ResultMessage update() {
		if(webManager==null)
			return ResultMessage.fail;
		return	webManagerDao.updateManager(ID,password);
	}
}
