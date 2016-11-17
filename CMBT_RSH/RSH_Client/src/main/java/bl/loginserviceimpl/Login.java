package bl.loginserviceimpl;

import java.rmi.RemoteException;

import javax.swing.text.AttributeSet.CharacterAttribute;

import bl.hotelserviceimpl.MockHotel;
import bl.userserviceimpl.MockUser;
import bl.webstaffserviceimpl.MockWebSalesman;
import bl.webstaffserviceimpl.MockWebManager;
import constant.ResultMessage;
import constant.Role;
import po.OnlinePersonPO;
import rmi.RemoteHelper;

public class Login {
	/**
	 * 检查用户名和密码是否匹配，以及是否有登陆冲突。若都符合要求，则增加该在线人员记录持久化对象
	 */
	public static ResultMessage checkOnline(Role role, String id, String password) {
		ResultMessage resultMessage = null;
		switch(role){
		case user:
			if(MockUser.checkPassword(id, password)!=ResultMessage.success){
				resultMessage =  ResultMessage.failure;
			}
			break;
		case hotel:
			if(MockHotel.checkPassword(id, password)!=ResultMessage.success){
				resultMessage = ResultMessage.failure;
			}
			break;
		case webmanager:
			if(MockWebManager.checkPassword(id, password)!=ResultMessage.success){
				resultMessage = ResultMessage.failure;
			}
			break;
		case websalesman:
			if(MockWebSalesman.checkPassword(id, password)!=ResultMessage.success){
				resultMessage = ResultMessage.failure;
			}
			break;
		}
		if(resultMessage!=ResultMessage.failure){
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
	public static ResultMessage logout(Role role, String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
