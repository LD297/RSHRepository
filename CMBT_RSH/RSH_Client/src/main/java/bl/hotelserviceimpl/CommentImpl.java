package bl.hotelserviceimpl;

import bl.orderservice.CommentService;
import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.CommentPO;

public class CommentImpl implements CommentService{

    HotelDao hotelDao;
    CommentPO commentPO;

	public static ResultMessage addComment(String id, String userID, String comment){

        if(!comment.equals(null)){
            hotelDao.addComment();
        }
		return ;

	}

	public ResultMessage updateGrade(double grade) {
		// TODO Auto-generated method stub
		return null;
	}
}
