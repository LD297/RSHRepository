package bl.hotelserviceimpl;

import bl.orderservice.CommentService;
import constant.ResultMessage;
import data.dao.hoteldao.HotelDao;
import po.CommentPO;

import java.rmi.RemoteException;

public class CommentImpl implements CommentService{

    CommentPO commentPO;
    HotelDao hotelDao;

    /**
     * 增加用户对酒店的评论
     * @param id 酒店id
     * @param userID
     * @param comment 评论内容
     * @return
     */
	public ResultMessage addComment(String id, String userID, String comment){
        if(!comment.equals(null)){
            ResultMessage resultMessage = null;
            try{
                resultMessage = hotelDao.addComment(new CommentPO(id, userID,  comment));
            }catch (RemoteException e){
                e.printStackTrace();
            }
            return resultMessage;
        }
        return ResultMessage.emptyComment;
	}

    /**
     * 更新数据库中酒店的评分
     * @param grade 用户打分（范围0~5，闭区间，加权计算后界面输出星级）
     * @return
     */
	public ResultMessage updateGrade(double grade) {
		ResultMessage resultMessage = null;
        try {
            resultMessage = hotelDao.updateGrade(grade);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return resultMessage;
	}
}
