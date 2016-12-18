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

//	private static final int  MAXNUM= 1;// 网站管理人员的最大数量
	private static WebManager webManager = null;
	private String webManagerID;
	private String password=null;
	private static WebManagerDao webManagerDao = null;
	
	private static void initRemote(){
		if(webManagerDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			webManagerDao = remoteHelper.getWebManagerDao();
		}
	}
	
	private WebManager(String password){
		webManagerID = "0000000000";
		this.password = password;
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
				webManagerPO = webManagerDao.getManagerInstance("0000000000");
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			webManager = new WebManager(webManagerPO.getPassword());
		}
		return webManager;
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
				return ResultMessage.remote_fail;
		}
		if (oldPassword==password){
			password=newPassword;
			return this.update();
		}
		else{
			return ResultMessage.password_wrong;
		}
	}
	
	/**
	 * 在数据层更新
	 * @return
	 */
	private ResultMessage update() {
		if(webManager==null)
			webManager = getInstance();
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
		if(this.password == password){
			return ResultMessage.succeed;
		}
		else{
			return ResultMessage.password_wrong;
		}
	}
}
