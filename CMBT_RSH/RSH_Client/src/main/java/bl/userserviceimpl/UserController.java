package bl.userserviceimpl;

import java.util.ArrayList;
import java.util.Iterator;

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
		return new User(userid).getInfo();
	}

	/**
	 * 更新用户的基本信息
	 */
	public ResultMessage update(UserVO userVO) {
		return new User(userVO.getId()).update(userVO);
	}

	/**
	 * 增加信用变化记录（用户信用充值的时候）
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		return new CreditRecordList(vo.getUserid()).addCreditRecord(vo);
	}
	
	/**
	 * 用户信用记录列表（用户查看信用记录的时候）
	 */
	public Iterator<CreditRecordVO> getCreditRecordList(String userid) {
		return new CreditRecordList(userid).getCreditRecordList();
	}

	/**
	 * 注册普通会员
	 */
	public ResultMessage registerMember(String userid) {
		return new Member(userid).registerMember();
	}

	/**
	 * 注册企业会员
	 */
	public ResultMessage registerMember(String userid, String commerceName) {
		return new Member(userid).registerMember(commerceName);
	}

}
