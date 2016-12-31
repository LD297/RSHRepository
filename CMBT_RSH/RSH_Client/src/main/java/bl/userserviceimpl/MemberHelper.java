package bl.userserviceimpl;

import constant.ResultMessage;
import data.dao.userdao.UserDao;
import rmi.RemoteHelper;

import java.rmi.RemoteException;

public class MemberHelper {

	private static UserDao userDao=null;
	private static int boundaryForLevels = 0;
	
	private MemberHelper(){
		
	};
	
	private static void initRemote(){
		if(userDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			userDao = remoteHelper.getUserDao();
		}
	}
	
	/**
	 * 网站营销人员更新所有会员的会员等级
	 * @param boundaryForLevel
	 * @return
	 */
	public static ResultMessage setMemberStandard(int boundaryForLevel){
		initRemote();
		ResultMessage resultMessage = null;
		try{
			resultMessage = userDao.setMemberLevel(boundaryForLevel);
		}catch(RemoteException e){
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
		if(resultMessage == ResultMessage.succeed){
			MemberHelper.boundaryForLevels = boundaryForLevel;
		}
		return resultMessage;
	}

	public static int getBoundaryForLevels(){
		initRemote();
		try {
			boundaryForLevels = userDao.getMemberLevel();
		} catch (RemoteException e) {
			e.printStackTrace();
			return -1;
		}
		return boundaryForLevels;
	}


	public static int getMemberLevel(int credit) {
		return credit/boundaryForLevels+1;
	}


	
}
