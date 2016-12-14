package bl.orderserviceimpl.miscellaneous;

import constant.ResultMessage;

public class MockComment {
	String hotel;
	String order;
	
	public MockComment(String h,String o){
		hotel = h;
		order = o;
	}
	
	public ResultMessage addComment(String hotelid, String userid, String comment){
		// TODO
		return ResultMessage.succeed;
		
	}

}
