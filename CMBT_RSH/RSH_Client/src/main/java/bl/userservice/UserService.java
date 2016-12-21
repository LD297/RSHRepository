package bl.userservice;

import constant.ResultMessage;
import vo.CreditRecordVO;
import vo.UserVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author John
 *
 */
public interface UserService {
	
	public UserVO getInfo(String userID);
	
	public ArrayList<UserVO> getUserVOS();

	public ResultMessage update(UserVO userVO);
	
	/**
	 * 增加用户信用充值的记录
	 */
	public ResultMessage addCredit(int value, String userID);
	
	/**
	 * 返回用户信用记录列表（用户查看信用记录的时候）
	 */
	public Iterator<CreditRecordVO> getCreditRecordList(String userID);
	/**
	 * 注册普通会员
	 */
	public ResultMessage registerMember(String userID);
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
