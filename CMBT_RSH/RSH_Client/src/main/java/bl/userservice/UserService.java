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
	
	/**
	 * 用户界面查看信息
	 * @param userID
	 * @return
	 */
	public UserVO getInfo(String userID);
	
	/**
	 * 网管界面得到所有用户信息
	 * @return
	 */
	public ArrayList<UserVO> getUserVOS();

	/**
	 * 用户、网管修改用户信息
	 * @param userVO
	 * @return
	 */
	public ResultMessage update(UserVO userVO);
	
	/**
	 * 网站营销人员信用充值
	 * @param value
	 * @param userID
	 * @return
	 */
	public ResultMessage addCredit(int value, String userID);
	
	/**
	 * 返回用户信用记录列表（用户查看信用记录的时候）
	 */
	public Iterator<CreditRecordVO> getCreditRecordList(String userID);
	
	/**
	 * 用户界面注册普通会员
	 */
	public ResultMessage registerMember(String userID);
	
	/**
	 * 用户界面注册企业会员
	 */
	public ResultMessage registerMember(String userid,String commerceName);

	/**
	 * 网站营销人员制定会员等级
	 * 
	 */
	public ResultMessage setMemberStandard(int num);

	/**
	 * 网站营销人员查看已制定的会员等级
	 * @return
	 */
	public int getMemberStandard();

	/**
	 * credit变动后计算会员等级
	 */
	public int getMemberLevel(int credit);

	
	
}
