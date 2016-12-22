package bl.userserviceimpl;

import constant.ResultMessage;
import data.dao.userdao.UserDao;
import po.UserPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;

public class Member {

	private static UserDao userDao=null;
	private static int boundaries;

	private String userid;
	private UserPO userPO = null;
	private int level;
	private int credit;
	private String commerceName;

	public  Member(String userid){
		initRemote();
		this.userid = userid;
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
				boundaries = userDao.getMemberLevel();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 注册普通会员
	 */
	public ResultMessage registerMember() {
		level = getMemberLevel(credit);
		userPO.setLevel(level);

		ResultMessage resultMessage = null;
		initRemote();
		try{
			resultMessage = userDao.update(userPO);
		}catch(RemoteException e){
			return ResultMessage.remote_fail;
		}
		return resultMessage;
	}

	/**
	 * 注册企业会员
	 */
	public ResultMessage registerMember(String commerceName) {

		level = getMemberLevel(credit);
		userPO.setLevel(level);

		this.commerceName = commerceName;
		userPO.setCommerceName(commerceName);

		ResultMessage resultMessage = null;
		initRemote();
		try{
			resultMessage = userDao.update(userPO);
		}catch(RemoteException e){
			return ResultMessage.remote_fail;
		}
		return resultMessage;
	}
	/**
	 * 网站营销人员更新所有会员的会员等级
	 * @param boundariesForLevels
	 * @return
	 */
	public ResultMessage setMemberStandard(int boundariesForLevels){

		ResultMessage resultMessage = null;
		initRemote();
		try{
			resultMessage = userDao.setMemberLevel(boundariesForLevels);
		}catch(RemoteException e){
			return ResultMessage.remote_fail;
		}
		return resultMessage;
	}

	public int	 getMemberStandard(){
		return boundaries;
	}


	public int getMemberLevel(int credit) {
		int level = 0;
		
		return level;
	}

}
