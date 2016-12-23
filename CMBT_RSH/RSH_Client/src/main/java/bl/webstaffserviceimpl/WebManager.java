package bl.webstaffserviceimpl;

import constant.ResultMessage;
import data.dao.webstaffdao.WebManagerDao;
import po.WebManagerPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;


/**
 * 网站管理人员类
 * 单一对象类，全系统中只有一个网站管理人员对象
 * 账号为十位0；
 * @author aa
 *
 */
public class WebManager {

	private static WebManager webManager = null;
	private static final String webManagerID = "0000000000";
	private String password;
	private static WebManagerDao webManagerDao = null;
	
	private static void initRemote(){
		if(webManagerDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			webManagerDao = remoteHelper.getWebManagerDao();
		}
	}

	/**
	 * 需要数据层中提取数据，判断是否已经初始化
	 * @return
	 */
	public static WebManager getInstance(){;
		if(webManager == null){
			initRemote();
			WebManagerPO webManagerPO = null;
			try {
				webManagerPO = webManagerDao.getManagerInstance(webManagerID);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			webManager = new WebManager(webManagerPO.getPassword());
		}
		return webManager;
	}

	private WebManager(String password){
		this.password = password;
	}
	
	public ResultMessage changePassword(String oldPassword, String newPassword){
		if(webManager==null){
			webManager = WebManager.getInstance();
			if(webManager==null)
				return ResultMessage.remote_fail;
		}
		if (oldPassword.equals(password)){
			password=newPassword;
			return this.updateData();
		}
		else{
			return ResultMessage.password_wrong;
		}
	}
	
	private ResultMessage updateData() {
		if(webManager==null)
			webManager = getInstance();
		initRemote();
		try {
			return	webManagerDao.updateManager(webManagerID,password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	public ResultMessage checkPassword(String password) {
		// TODO Auto-generated method stub
		if(webManager==null){
			webManager = getInstance();
		}
		if(webManager==null){
			return ResultMessage.idNotExist;
		}
		if(this.password.equals(password)){
			return ResultMessage.succeed;
		}
		else{
			return ResultMessage.password_wrong;
		}
	}
}
