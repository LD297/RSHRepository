package bl.loginserviceimpl;

import bl.hotelserviceimpl.HotelController;
import bl.userserviceimpl.UserController;
import bl.webstaffserviceimpl.MockWebSalesman;
import bl.webstaffserviceimpl.MockWebManager;
import bl.webstaffserviceimpl.MockWebSalesman;
import constant.ResultMessage;
import constant.Role;
import po.OnlinePersonPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;

//<<<<<<< Updated upstream
//=======
//>>>>>>> Stashed changes

public class Login {
	private static Login login = null;
	private Login(){}

	public static Login getInstance(){
		if(login==null){
			login = new Login();
		}
		return login;
	}

	/**
	 * 检查用户名和密码是否匹配，以及是否有登陆冲突。若都符合要求，则增加该在线人员记录持久化对象
	 */
	public ResultMessage checkOnline(Role role, String id, String password) {
		ResultMessage resultMessage = null;
		//检验用户名和密码是否匹配
		switch(role){
		case user:
			UserController userController = new UserController();
			resultMessage = userController.checkPassword(id, password);
			break;
		case hotel:
			HotelController hotelController = new HotelController();
			resultMessage = hotelController.checkPassword(id, password);
			break;
		case webmanager:
			resultMessage = MockWebManager.checkPassword(id, password);
			break;
		case websalesman:
			resultMessage = MockWebSalesman.checkPassword(id, password);
			break;
		}
		//检验是否有登陆冲突
		if(resultMessage==ResultMessage.succeed){
			try {
				OnlinePersonPO po = new OnlinePersonPO(role, id, password);
				resultMessage = RemoteHelper.getInstance().getLoginDao().addOnline(po);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
		return resultMessage;
	}

	/**
	 * 删除该在线人员记录持久化对象
	 */
	public ResultMessage logout(Role role, String id) {
		ResultMessage resultMessage = null;
		try{
			resultMessage = RemoteHelper.getInstance().getLoginDao().deleteOnline(role, id);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	
}
