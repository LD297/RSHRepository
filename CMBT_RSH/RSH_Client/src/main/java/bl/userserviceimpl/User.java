package bl.userserviceimpl;


import constant.ResultMessage;
import po.UserPO;
import rmi.RemoteHelper;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * 处理与用户界面有关的业务
 * @author john
 *
 */
public class User {
	String id;
	public User(String id) {
		this.id = id;
	}
	/**
	 * 获取用户基本信息
	 */
	public UserVO getInfo(){
		UserPO po = null;
		try{
			po = RemoteHelper.getInstance().getUserDao().getInfo(id);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return unpackedPO(po);
	}
	/**
	 * 更新用户基本信息
	 * @param vo
	 * @return
	 */
	public ResultMessage update(UserVO vo) {
		ResultMessage resultMessage = null;
		UserPO po = create(vo);
		try {
			resultMessage = RemoteHelper.getInstance().getUserDao().update(po);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}

	/**
	 * 检查此账号是否存在，若不存在，创建该UserPO，在数据库中增加该用户的持久化对象
	 * @param vo
	 * @return
	 */
	public static ResultMessage add(UserVO vo) {
		ResultMessage resultMessage = null;
		UserPO po = create(vo);
		try {
			resultMessage = RemoteHelper.getInstance().getUserDao().add(po);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	/**
	 * 检查该账号是否存在，若存在，检查账号与密码是否匹配
	 * @param id
	 * @param password
	 * @return
	 */
	public static ResultMessage checkPassword(String id,String password) {
		ResultMessage resultMessage = null;
		try {
			resultMessage = RemoteHelper.getInstance().getUserDao().checkPassword(id, password);
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	/**
	 * 生成用户基本信息持久化对象
	 * @param vo
	 * @return
	 */
	private static UserPO create(UserVO vo) {
		UserPO po = new UserPO(vo.getId(), vo.getPassword(), vo.getNickName(),
				vo.getImageAddress(), vo.getLevel(), vo.getMemberType(), vo.getName(),
				vo.getSexuality(), vo.geteMail(), vo.getCredit());
		return po;
	}
	/**
	 * 解包用户基本信息持久化对象
	 * @param po
	 * @return
	 */
	private static UserVO unpackedPO(UserPO po) {
		UserVO vo = new UserVO(po.getId(),po.getPassword(),po.getNickName(),
				po.getImageAddress(),po.getLevel(),po.getMemberType(),po.getName(),
				po.getSexuality(),po.geteMail(),po.getCredit());
		return vo;
	}
	
}
