package bl.userservice;

import constant.ResultMessage;
import vo.CreditRecordVO;
import vo.UserVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

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
	 * 网站管理人员为用户重置密码
	 * @return
	 */
	public String resetPassword(String userid);
	
	public ArrayList<UserVO> getUserVOS();

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
	public Iterator<CreditRecordVO> getCreditRecordList(String userid);
	/**
	 * 注册普通会员
	 */
	public ResultMessage registerMember(String userid);
	/**
	 * 注册企业会员
	 */
	public ResultMessage registerMember(String userid,String commerceName);

	/**
	 * 网站营销人员制定会员等级
	 * 数组i位置存放i级最小值，0位置存0；
	 */
	public ResultMessage setMemberStandard(int[] boundariesForLevels);

	public int[] getMemberStandard();

	/**
	 * credit变动后计算会员等级
	 */
	public int getMemberLevel(int credit);

	public ResultMessage changePassword(String userid, String oldPassword, String newPassword);
}
