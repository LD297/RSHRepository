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

	String id;
	UserPO userPO = null;

	private static UserDao userDao = null;
	
	public User(String id) {
		initRemote();
		this.id = id;
		try {
			userPO = userDao.getInfo(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void initRemote(){
		if(userDao==null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			userDao = remoteHelper.getUserDao();
		}	
		return;
	}

	/**
	 * 获取用户基本信息
	 */
	public UserVO getInfo(){
		if(userPO!=null) {
			return userPO.changeIntoVO();
		}
		try{
			userPO = userDao.getInfo(id);
			System.out.println(userPO.getId());
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return userPO.changeIntoVO();
	}

	/**
	 * 更新用户基本信息
	 * @param vo 更新后VO
	 * @return 执行后信息
	 */
	public ResultMessage update(UserVO vo) {
		ResultMessage resultMessage = null;
		UserPO po = vo.changeIntoPO();
		try {
			resultMessage = userDao.update(po);
		}catch (RemoteException e){
			return ResultMessage.remote_fail;
		}
		return resultMessage;
	}

	/**
	 * 检查此账号是否存在，若不存在，创建该UserPO，在数据库中增加该用户的持久化对象
	 * @param vo
	 * @return
	 */
	public ResultMessage add(UserVO vo) {
		initRemote();
		try {
			if(userDao.getInfo(vo.getId())!=null){
				System.out.println("已存在");
				return ResultMessage.already_exist;
				
			}
				
		} catch (RemoteException e) {
			System.out.println("链接错误");
			return ResultMessage.remote_fail;
		}
		ResultMessage resultMessage = null;
		try {
			resultMessage = userDao.insert(vo.changeIntoPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMessage;
	}

	public ResultMessage checkPassword(String password) {
		if(userPO==null){
			return ResultMessage.not_exist;
		}
		if(password==userPO.getPassword())
			return ResultMessage.succeed;
		return ResultMessage.password_wrong;
	}


	public ResultMessage changePassword(String oldPassword, String newPassword) {
		if(userPO==null){
			return ResultMessage.not_exist;
		}
		if(oldPassword==userPO.getPassword()){
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
		if(userPO.getCredit()>0)
			return true;
		else
			return false;
	}
	public boolean hasReserved(String hotelID) {
		// TODO Auto-generated method stub
		
		return false;
	}
}
