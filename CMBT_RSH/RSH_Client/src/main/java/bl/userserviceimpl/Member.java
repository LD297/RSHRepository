package bl.userserviceimpl;

import constant.MemberType;
import constant.ResultMessage;
import data.dao.userdao.UserDao;
import po.UserPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;

public class Member {

	private static UserDao userDao=null;
	private static int boundaryForLevels = 0;

	private String userID;
	private UserPO userPO = null;
	private int level;
	private int credit;
	private String commerceName;

	public  Member(String userid){
		initRemote();
		this.userID = userid;
		try {
			userPO = userDao.getInfo(userid);
			level = userPO.getLevel();
			credit = userPO.getCredit();
			commerceName = userPO.getCommerceName();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public Member(){
		initRemote();
	}


	private static void initRemote(){
		if(userDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			userDao = remoteHelper.getUserDao();
			try {
				boundaryForLevels = userDao.getMemberLevel();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 注册普通会员
	 */
	public ResultMessage registerCommonMember() {
		level = getMemberLevel(credit);
		userPO.setLevel(level);
		userPO.setMemberType(MemberType.commom);
		initRemote();
		try{
			return userDao.update(userPO);
		}catch(RemoteException e){
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	
	}

	/**
	 * 注册企业会员
	 */
	public ResultMessage registerCommerceMember(String commerceName) {

		level = getMemberLevel(credit);
		userPO.setLevel(level);
		this.commerceName = commerceName;
		userPO.setLevel(level);
		userPO.setCommerceName(commerceName);
		userPO.setMemberType(MemberType.commerce);
		initRemote();
		try{
			return userDao.update(this.userPO);
		}catch(RemoteException e){
			e.printStackTrace();
			return ResultMessage.remote_fail;
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
			Member.boundaryForLevels = boundaryForLevel;
		}
		return resultMessage;
	}

	public static int getBoundaryForLevels(){
		initRemote();
		try {
			boundaryForLevels = userDao.getMemberLevel();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return boundaryForLevels;
	}


	public static int getMemberLevel(int credit) {
		return credit/boundaryForLevels+1;
	}
	
	
}
