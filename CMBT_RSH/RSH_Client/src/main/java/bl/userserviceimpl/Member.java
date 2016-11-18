package bl.userserviceimpl;

import constant.ResultMessage;

public class Member {
	String userid;
	public Member(String userid) {
		this.userid = userid;
	}
	/**
	 * 注册普通会员
	 */
	public ResultMessage registerMember() {
		return null;
	}

	/**
	 * 注册企业会员
	 */
	public ResultMessage registerMember(String commerceName) {
		return null;
	}
	/**
	 * 更新所有会员的会员等级
	 * @param gradeWithCredit
	 * @return
	 */
	public static ResultMessage setMemberLevel(int[][] gradeWithCredit){
		return null;
	}
}
