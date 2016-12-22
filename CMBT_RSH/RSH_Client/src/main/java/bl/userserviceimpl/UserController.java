package bl.userserviceimpl;

import bl.BLHelper;
import bl.userservice.UserService;
import constant.ResultMessage;
import data.dao.userdao.UserDao;
import rmi.RemoteHelper;
import vo.CreditRecordVO;
import vo.UserVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * 处理用户界面包的逻辑
 * @author john
 *
 */
public class UserController implements UserService{
	
	private static UserDao userDao = null;
	
	private static void initRemote(){
		if(userDao==null){
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
			userDao = remoteHelper.getUserDao();
		}
	}
	
	/**
	 * 获取用户基本信息
	 */
	@Override
	public UserVO getInfo(String userid) {
		User user = new User(userid);
		return user.getInfo();
	}

	/**
	 * 更新用户的基本信息
	 */
	@Override
	public ResultMessage update(UserVO userVO)	{
		User user = new User(userVO.getId());
		return user.update(userVO);
	}

	/**
	 * 订单状态发生变化产生的信用记录变化
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		CreditRecordList creditRecordList = new CreditRecordList(vo.getUserid());
		return creditRecordList.addCreditRecord(vo);
	}
	
	/**
	 * 用户信用记录列表（用户查看信用记录的时候）
	 */
	@Override
	public Iterator<CreditRecordVO> getCreditRecordList(String userid) {
		CreditRecordList creditRecordList = new CreditRecordList(userid);
		return creditRecordList.getCreditRecordList();
	}

	/**
	 * 注册普通会员
	 */
	@Override
	public ResultMessage registerMember(String userid) {
		Member member = new Member(userid);
		return member.registerMember();
	}

	/**
	 * 注册企业会员
	 */
	@Override
	public ResultMessage registerMember(String userid, String commerceName) {
		Member member = new Member(userid);
		return member.registerMember(commerceName);
	}

	@Override
	public ResultMessage setMemberStandard(int[] boundariesForLevels) {
		Member member = new Member();
		return member.setMemberStandard(boundariesForLevels);
	}

	@Override
	public int[] getMemberStandard() {
		Member member = new Member();
		return member.getMemberStandard();
	}


	@Override
	public int getMemberLevel(int credit) {
		if(credit<=0)
			return 0;
		Member member = new Member();
		return member.getMemberLevel(credit);
	}


	/**
	 * 登陆模块调用
	 * @param userid
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public ResultMessage changePassword(String userid, String oldPassword, String newPassword) {
		User user = new User(userid);
		return	user.changePassword(oldPassword,newPassword);
	}

	/**
	 * 登陆模块调用
	 * @param id
	 * @param password
	 * @return
	 */
	public ResultMessage checkPassword(String id,String password) {
		User user = new User(id);
		return user.checkPassword(password);
	}

	@Override
	public ArrayList<UserVO> getUserVOS() {
		// TODO Auto-generated method stub
		User user = new User();
		return null;
	}


	@Override
	public ResultMessage addCredit(int value, String userID) {
		// TODO Auto-generated method stub
		CreditRecordList creditRecordList = new CreditRecordList(userID);
		return creditRecordList.add(value);
	}

	public boolean hasReserved(String userID, String hotelID) {
		// TODO Auto-generated method stub
		return false;
	}

}
