package bl.hotelserviceimpl;

import constant.ResultMessage;


public class MockHotel extends Hotel{
	MockHotel(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 检查该账号是否存在，若存在，检查账号与密码是否匹配
	 * @param id
	 * @param password
	 * @return
	 */
	public static ResultMessage checkPassword(String id, String password) {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}
}
