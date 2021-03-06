package bl.loginserviceimpl;

import bl.hotelserviceimpl.HotelController;
import bl.userserviceimpl.UserController;
import bl.webstaffserviceimpl.WebStaffController;
import constant.ResultMessage;
import constant.Role;
import data.dao.logindao.LoginDao;
import po.OnlinePersonPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;

public class Login {
	private static LoginDao loginDao = null;

	private Login(){};
	
	private static void initRemote(){
		if(loginDao==null){
			if(loginDao == null){
				RemoteHelper remoteHelper = RemoteHelper.getInstance();
				loginDao = remoteHelper.getLoginDao();
			}
		}
	}

	/**
	 * 检查用户名和密码是否匹配，以及是否有登陆冲突。若都符合要求，则增加该在线人员记录持久化对象
	 */
	public static ResultMessage checkOnline(Role role, String id, String password) {
		ResultMessage resultMessage = null;
		//检验用户名和密码是否匹配
		switch(role){
		case user:
			UserController userController = new UserController();
			resultMessage = userController.checkPassword(id, password);
			break;
		case hotel:
			resultMessage = HotelController.checkPassword(id, password);
			break;
		case webmanager:
			if(id.equals("0000000000")){
				resultMessage = WebStaffController.checkPassword(id, password);
			}
			else{
				resultMessage = ResultMessage.fail;
			}
		case websalesman:
			resultMessage = WebStaffController.checkPassword(id, password);
			break;
		default:
			return ResultMessage.not_exist;
		}
		
		//检验是否有登陆冲突
		if(resultMessage==ResultMessage.succeed){
			initRemote();
			try {
				OnlinePersonPO po = new OnlinePersonPO(role, id);
				resultMessage = loginDao.addOnline(po);
			} catch (RemoteException e) {
				e.printStackTrace();
				return ResultMessage.remote_fail;
			}
			return resultMessage;
		}
		else{
			return resultMessage;
		}	
		
	}

	/**
	 * 删除该在线人员记录持久化对象
	 */
	public static ResultMessage logout(Role role, String id) {
		initRemote();
		try{
			return loginDao.deleteOnline(role, id);
		}catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}
	
}
