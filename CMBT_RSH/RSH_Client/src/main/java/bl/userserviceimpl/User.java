package bl.userserviceimpl;


import constant.ResultMessage;
import data.dao.userdao.UserDao;
import po.UserPO;
import rmi.RemoteHelper;
import vo.UserVO;

import java.rmi.RemoteException;

import bl.orderservice.OrderForUser;
import bl.orderserviceimpl.OrderForUserImpl;

/**
 * 处理与用户界面有关的业务
 * @author john
 *
 */
public class User {

	String id;
	UserPO userPO = null;

	private static UserDao userDao = null;

	public User(){
		initRemote();
	};
	public User(String id) {
		initRemote();
		this.id = id;
	}

	private static void initRemote(){
		if(userDao==null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			userDao = remoteHelper.getUserDao();
		}		
	}

	/**
	 * 获取用户基本信息
	 */
	public UserVO getInfo(){
		if(userPO!=null) {
			return changeIntoVO(userPO);
		}
		try{
			userPO = userDao.getInfo(id);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return changeIntoVO(userPO);
	}

	/**
	 * 更新用户基本信息
	 * @param vo 更新后VO
	 * @return 执行后信息
	 */
	public ResultMessage update(UserVO vo) {
		ResultMessage resultMessage = null;
		UserPO po = changeIntoPO(vo);
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
		UserPO po = changeIntoPO(vo);
		try {
			resultMessage = userDao.insert(po);
		}catch (RemoteException e){
			e.printStackTrace();
			System.out.println("连接一场");
			return ResultMessage.remote_fail;
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

	private UserPO changeIntoPO(UserVO vo) {
		UserPO po = new UserPO(vo.getId(), vo.getPassword(), vo.getNickName(),vo.getImageAddress(),vo.getBirthday(),
				vo.getLevel(), vo.getMemberType(), vo.getCredit(),
				vo.getName(), vo.getSexuality(), vo.geteMail() ,vo.getCommerceName()){

					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;};
		return po;
	}

	private UserVO changeIntoVO(UserPO po) {
		UserVO vo = new UserVO(po.getId(),po.getPassword(),po.getNickName(),
				po.getImageAddress(),po.getBirthday(),po.getLevel(),po.getMemberType(),po.getName(),
				po.getSexuality(),po.geteMail(),po.getCredit(),po.getCommerceName());
		return vo;
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
