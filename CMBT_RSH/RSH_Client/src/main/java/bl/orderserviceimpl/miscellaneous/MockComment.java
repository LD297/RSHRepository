package bl.orderserviceimpl.miscellaneous;

import bl.hotelserviceimpl.CommentImpl;
import constant.ResultMessage;

public class MockComment extends CommentImpl{
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

	@Override
	public ResultMessage updateGrade(double grade) {
		// TODO Auto-generated method stub
		return ResultMessage.succeed;
	}
}