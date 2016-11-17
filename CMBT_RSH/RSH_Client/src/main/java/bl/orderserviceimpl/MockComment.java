package bl.orderserviceimpl;

import constant.ResultMessage;
import bl.hotelserviceimpl.CommentImpl;

public class MockComment extends CommentImpl{
	String hotel;
	String order;
	
	public MockComment(String h,String o){
		hotel = h;
		order = o;
	}
	
	public static ResultMessage addComment(String hotelid, String userid, String comment){
		// TODO
		return ResultMessage.success;
		
	}

	@Override
	public ResultMessage updateGrade(double grade) {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}
}
