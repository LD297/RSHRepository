package bl.userserviceimpl;

import constant.ResultMessage;
import data.dao.userdao.UserDao;
import rmi.RemoteHelper;

import java.rmi.RemoteException;

public class MemberHelper {

	private static UserDao userDao=null;
	private int boundaryForLevels = 0;
	private static MemberHelper memberHelper = null;
	
	private MemberHelper(){};
	
	public static MemberHelper getInstance(){
		if(memberHelper == null){
			memberHelper = new MemberHelper();
		}
		initRemote();
		try {
			memberHelper.boundaryForLevels = userDao.getMemberLevel();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		return memberHelper;
	}
	
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
	public ResultMessage setMemberStandard(int boundaryForLevel){
		this.boundaryForLevels = boundaryForLevel;
		return update();
	}

	public int getBoundaryForLevels(){
		return boundaryForLevels;
	}


	public int getMemberLevel(int credit) {
		return credit/boundaryForLevels+1;
	}
	
	public ResultMessage update(){
		initRemote();
		try {
			return userDao.setMemberLevel(boundaryForLevels);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}


	
}
