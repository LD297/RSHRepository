package bl.userserviceimpl;


import constant.ResultMessage;
import constant.Sexuality;
import data.dao.userdao.UserDao;
import po.UserPO;
import rmi.RemoteHelper;
import vo.UserVO;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Date;

import bl.orderservice.OrderForUser;
import bl.orderserviceimpl.OrderForUserController;

/**
 * 处理与用户界面有关的业务
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
			// TODO Auto-generated catch block
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
		if(userPO!=null) {
			return userPO.changeIntoVO();
		}
		initRemote();
		try{
			userPO = userDao.getInfo(userID);
		}catch (RemoteException e){
			e.printStackTrace();
			System.out.println("aaa");
			return null;
		}
		if(userPO == null){
			System.out.println("bucunzai");
			return null; 		//该用户不存在
		}
		return userPO.changeIntoVO();
	}

	/**
	 * 更新用户基本信息
	 * @param vo 更新后VO
	 * @return 执行后信息
	 */
	public static ResultMessage update(UserVO vo) {
		initRemote();
		try {
			if(userDao.getInfo(vo.getId())==null){
				return ResultMessage.idNotExist;
			}
			else{
				return userDao.update(vo.changeIntoPO());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	/**
	 * 检查此账号是否存在，若不存在，创建该UserPO，在数据库中增加该用户的持久化对象
	 * @param vo
	 * @return
	 */
	public static ResultMessage add(UserVO vo) {
		initRemote();
		
		//判断该账号是否存在
		try {
			if(userDao.getInfo(vo.getId())!=null){
				System.out.println("已存在");
				return ResultMessage.already_exist;
				
			}				
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
		
		//增加用户
		try {
			return userDao.insert(vo.changeIntoPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.remote_fail;
		}
	}

	public ResultMessage checkPassword(String password) {
		if(userPO==null){
			System.out.println("getinfo!!");
			return ResultMessage.idNotExist;
		}
		if(password.equals(userPO.getPassword()))
			return ResultMessage.succeed;
		return ResultMessage.password_wrong;
	}


	public ResultMessage changePassword(String oldPassword, String newPassword) {
		if(userPO==null){
			return ResultMessage.not_exist;
		}
		if(oldPassword.equals(userPO.getPassword())){
			return forceChangePassword(newPassword);
		}
		else{
			return ResultMessage.password_wrong;
		}
	}

	public ResultMessage forceChangePassword(String newPassword){
		userPO.setPassword(newPassword);
		try {
			userDao.update(userPO);
		} catch (RemoteException e) {
			return ResultMessage.remote_fail;
		}
		return ResultMessage.succeed;
	}

	public boolean canGenerateOrder(){
		if(userPO == null){
			return false;
		}
		if(userPO.getCredit()>=0)
			return true;
		else
			return false;
	}
	public boolean hasReserved(String hotelID) {
		// TODO Auto-generated method stub
		OrderForUserController orderForUserController = new OrderForUserController();
		if(orderForUserController.getOrderStateOfUser(userID, hotelID)==null){
			return false;
		}
		else{
			return true;
		}
	}
}
