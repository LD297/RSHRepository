package bl.userserviceimpl;


import constant.ResultMessage;
import po.UserPO;
import vo.UserVO;

/**
 * 处理与用户界面有关的业务
 * @author john
 *
 */
public class User {
	String id;
	public User(String id) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 获取用户基本信息
	 */
	public UserVO getInfo(){
		return null;
	}
	/**
	 * 更新用户基本信息
	 * @param vo
	 * @return
	 */
	public ResultMessage update(UserVO vo) {
		return ResultMessage.success;
	}

	/**
	 * 检查此账号是否存在，若不存在，创建该UserPO，在数据库中增加该用户的持久化对象
	 * @param vo
	 * @return
	 */
	public static ResultMessage add(UserVO vo) {
		return null;
	}
	/**
	 * 检查该账号是否存在，若存在，检查账号与密码是否匹配
	 * @param id
	 * @param password
	 * @return
	 */
	public static ResultMessage checkPassword(String id,String password) {
		return null;
	}
	/**
	 * 生成用户基本信息持久化对象
	 * @param vo
	 * @return
	 */
	private UserPO create(UserVO vo) {
		return null;
	}
	/**
	 * 解包用户基本信息持久化对象
	 * @param po
	 * @return
	 */
	private UserVO unpackedPO(UserPO po) {
		return null;
	}
	
}
