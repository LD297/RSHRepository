package bl.userserviceimpl;


import constant.MemberType;
import constant.ResultMessage;
import data.dao.userdao.UserDao;
import po.UserPO;
import rmi.RemoteHelper;
import vo.UserVO;

import java.rmi.RemoteException;


/**
 * 处理与用户有关的业务
 * @author john
 *
 */
public class User {

	String userID;
	UserPO userPO ;

	private static UserDao userDao = null;
	private static void initRemote(){
		if(userDao == null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			userDao = remoteHelper.getUserDao();
		}
	}

	private User(String userID) {
		this.userID = userID;
	}

	public static User getInstance(String userID){
		User user = new User(userID);
		initRemote();
		try {
			user.userPO = userDao.getInfo(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(user.userPO == null){
			return null;
		}
		return user;
	}
	
	
	/**
	 * 获取用户基本信息
	 */
	public UserVO getInfo(){
		return userPO.changeIntoVO();
	}


	/**
	 * 检查此账号是否存在，若不存在，创建该UserPO，在数据库中增加该用户的持久化对象
	 * @param userVO
	 * @return
	 */
	public static ResultMessage add(UserVO userVO) {
		ResultMessage resultMessage = null;
		
		initRemote();
		
		//判断该账号是否存在
		try {
			if(userDao.getInfo(userVO.getId())!=null){
				return ResultMessage.already_exist;				
			}				
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
		
		//增加用户
		try {
			return userDao.insert(userVO.changeIntoPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	public ResultMessage checkPassword(String password) {
		if(password.equals(userPO.getPassword()))
			return ResultMessage.succeed;
		return ResultMessage.password_wrong;
	}


	public ResultMessage changePassword(String oldPassword, String newPassword) {
		if(checkPassword(oldPassword)==ResultMessage.succeed){
			userPO.setPassword(newPassword);
			return update();
		}
		else{
			return ResultMessage.password_wrong;
		}
	}

	public boolean canGenerateOrder(){
		if(userPO.getCredit()>=0)
			return true;
		else
			return false;
	}

	public ResultMessage registerMember() {
		int level = MemberHelper.getInstance().getMemberLevel(userPO.getCredit());
		userPO.setLevel(level);
		userPO.setMemberType(MemberType.commom);
		return update();
	}

	public ResultMessage registerMember(String commerceName) {
		int level = MemberHelper.getInstance().getMemberLevel(userPO.getCredit());
		userPO.setLevel(level);
		userPO.setCommerceName(commerceName);
		userPO.setMemberType(MemberType.commerce);
		return update();
	}


	public void changeCredit(int credit) {
		userPO.setCredit(credit);
		if(userPO.geMemberType()!= MemberType.not_member){
			userPO.setLevel(MemberHelper.getInstance().getMemberLevel(credit));			
		}
		update();
	}	
	
	private ResultMessage update(){
		initRemote();
		try {
			return userDao.update(userPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}
}
