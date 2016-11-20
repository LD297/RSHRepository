package bl.userserviceimpl;

import constant.ResultMessage;
import rmi.*;

import java.rmi.RemoteException;

public class Member {
	String userid;
	public Member(String userid) {
		this.userid = userid;
	}
	/**
	 * 注册普通会员
	 */
	public ResultMessage registerMember() {
		ResultMessage resultMessage = null;
		try{
			resultMessage = RemoteHelper.getInstance().getUserDao().register(userid);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}

	/**
	 * 注册企业会员
	 */
	public ResultMessage registerMember(String commerceName) {
		ResultMessage resultMessage = null;
		try{
			resultMessage = RemoteHelper.getInstance().getUserDao().register(userid,commerceName);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
	/**
	 * 更新所有会员的会员等级
	 * @param gradeWithCredit
	 * @return
	 */
	public static ResultMessage setMemberLevel(int[][] gradeWithCredit){
		ResultMessage resultMessage = null;
		try{
			resultMessage = RemoteHelper.getInstance().getUserDao().setMemberLevel(gradeWithCredit);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return resultMessage;
	}
}
