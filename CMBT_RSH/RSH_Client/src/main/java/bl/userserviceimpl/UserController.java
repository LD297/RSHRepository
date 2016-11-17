package bl.userserviceimpl;

import java.util.ArrayList;

import bl.userservice.UserService;
import constant.ResultMessage;
import vo.CreditRecordVO;
import vo.UserVO;

/**
 * 处理用户界面包的逻辑
 * @author john
 *
 */
public class UserController implements UserService{

	/**
	 * 获取用户基本信息
	 */
	public UserVO getInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 更新用户的基本信息
	 */
	public ResultMessage update(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 增加信用变化记录（用户信用充值的时候）
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 用户信用记录列表（用户查看信用记录的时候）
	 */
	public ArrayList<CreditRecordVO> getCreditRecordList(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 注册普通会员
	 */
	public ResultMessage registerMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 注册企业会员
	 */
	public ResultMessage registerMember(String userid, String commerceName) {
		// TODO Auto-generated method stub
		return null;
	}

}
