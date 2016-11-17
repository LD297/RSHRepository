package bl.userservice;

import java.util.ArrayList;

import constant.ResultMessage;
import vo.CreditRecordVO;
import vo.UserVO;

/**
 * 处理userui对应的逻辑，所有传入的参数都需要在界面层检验输入是否合法
 * @author wxy shfbsjhf
 *
 */
public interface UserService {
	/**
	 * 返回用户基本信息
	 */
	public UserVO getInfo(String userid);
	/**
	 * 更新用户的基本信息
	 */
	public ResultMessage update(UserVO userVO);
	/**
	 * 增加信用变化记录（用户信用充值的时候）
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo);
	/**
	 * 返回用户信用记录列表（用户查看信用记录的时候）
	 */
	public ArrayList<CreditRecordVO> getCreditRecordList(String userid);
	/**
	 * 注册普通会员
	 */
	public ResultMessage registerMember(String userid);
	/**
	 * 注册企业会员
	 */
	public ResultMessage registerMember(String userid,String commerceName);
}
