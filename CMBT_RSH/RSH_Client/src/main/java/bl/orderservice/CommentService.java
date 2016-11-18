package bl.orderservice;

import bl.hotelserviceimpl.*;
import constant.ResultMessage;

public interface CommentService {
	//增加评论
	public static ResultMessage addComment(String hotelid,String userid, String comment) {
		return HotelController.addComment(hotelid, userid, comment);
	}
	//增加评分
	public ResultMessage updateGrade(double grade);
}
