package bl.userserviceimpl;

import bl.userservice.UserService;
import constant.MemberType;
import constant.ResultMessage;
import data.dao.userdao.UserDao;
import po.UserPO;
import rmi.RemoteHelper;
import vo.CreditRecordVO;
import vo.UserVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import org.hamcrest.internal.ArrayIterator;

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
	public UserVO getInfo(String userID) {
		User user = User.getInstance(userID);
		return user.getInfo();
	}

	/**
	 * 更新用户的基本信息
	 */
	@Override
	public ResultMessage update(UserVO userVO)	{
		return User.update(userVO);
	}

	/**
	 * 订单状态发生变化产生的信用记录变化
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		CreditRecordList creditRecordList = CreditRecordList.getInstance(vo.getUserid());
		if(creditRecordList==null){
			return null;
		}
		return creditRecordList.addCreditRecord(vo);
	}
	
	/**
	 * 用户信用记录列表（用户查看信用记录的时候）
	 */
	@Override
	public Iterator<CreditRecordVO> getCreditRecordList(String userID) {
		CreditRecordList creditRecordList = CreditRecordList.getInstance(userID);
		if(creditRecordList==null){
			return null;
		}
		return creditRecordList.getCreditRecordList();
	}

	/**
	 * 注册普通会员
	 */
	@Override
	public ResultMessage registerMember(String userID) {
		Member member = new Member(userID);
		return member.registerCommonMember();
	}

	/**
	 * 注册企业会员
	 */
	@Override
	public ResultMessage registerMember(String userID, String commerceName) {
		Member member = new Member(userID);
		return member.registerCommerceMember(commerceName);
	}

	@Override
	public ResultMessage setMemberStandard(int boundaryForLevel) {
		return Member.setMemberStandard(boundaryForLevel);
	}

	@Override
	public int getMemberStandard() {
		return Member.getBoundaryForLevels();
	}


	@Override
	public int getMemberLevel(int credit) {
		if(credit<=0)
			return 0;
		return Member.getMemberLevel(credit);
	}


	/**
	 * 登陆模块调用
	 * @param userid
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public ResultMessage changePassword(String userID, String oldPassword, String newPassword) {
		User user = User.getInstance(userID);
		return	user.changePassword(oldPassword,newPassword);
	}

	/**
	 * 登陆模块调用
	 * @param userID
	 * @param password
	 * @return
	 */
	public ResultMessage checkPassword(String userID,String password) {
		User user = User.getInstance(userID);
		return user.checkPassword(password);
	}

	@Override
	public ArrayList<UserVO> getUserVOS() {
		// TODO Auto-generated method stub
		initRemote();  
		ArrayList<UserVO> userVOs = new ArrayList<>();
		ArrayList<UserPO> userPOs = new ArrayList<>();
		try {
			userPOs = userDao.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return userVOs;
		}
		for(UserPO userPO:userPOs){
			userVOs.add(userPO.changeIntoVO());
		}
		return userVOs;
	}


	@Override
	public ResultMessage addCredit(int value, String userID) {
		// TODO Auto-generated method stub
		CreditRecordList creditRecordList = CreditRecordList.getInstance(userID);
		if(creditRecordList==null){
			return ResultMessage.idNotExist;
		}
		return creditRecordList.add(value);
	}

	public boolean hasReserved(String userID, String hotelID) {
		// TODO Auto-generated method stub
		User user = User.getInstance(userID);
		if(user==null){
			return false;
		}
		return user.hasReserved(hotelID);
	}
	
	public ResultMessage add(UserVO userVO){
		return User.add(userVO);
	}

}
