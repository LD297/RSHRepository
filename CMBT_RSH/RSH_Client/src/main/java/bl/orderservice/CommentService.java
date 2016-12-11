package bl.orderservice;

import constant.ResultMessage;

public interface CommentService {
	// 增加评论
	public ResultMessage addComment(String hotelid,String userid, String comment);
	// 增加评分
	public ResultMessage updateGrade(double grade);

}
