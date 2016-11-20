package po;

/**
 * Created by a297 on 16/11/19.
 */
public class CommentPO {
    /**
     * 所评价的酒店id
     */
    String id;
    String userID;
    String comment;

    public CommentPO(String id, String userID, String comment) {
        this.id = id;
        this.userID = userID;
        this.comment = comment;
    }
}
