package presentation.usercontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import presentation.tools.ImageFactory;
import presentation.tools.Locator;
import presentation.tools.UserInfoUtil;
import vo.OrderVO;

/**
 * 酒店详情界面中的一栏评价
 * @author john
 *
 */
public class CommentAnchorPane extends AnchorPane{
	private ImageView headImage = null;
	private ImageView backGroundHeadImage = null;
	private Label nickNameLabel = null;
	private Label dateLabel = null;
	private Label roomTypeLabel = null;
	private TextArea commentArea = null;
//	private Label commentLabel = null;
//	private Rectangle rectangleAroundComment = null;
	private DateFormat dateFormat = null;
	
	//传入的参数后期会改为commentvo
	public CommentAnchorPane(OrderVO orderVO) {
		//TODO 得到用户头像
		headImage = new ImageView(ImageFactory.getImageFactory().getHeadImage());
		backGroundHeadImage = new ImageView(ImageFactory.getImageFactory().getHeadImagebackground());
		//TODO 从评价vo里面得到用户名称，因为没有getNickName
		nickNameLabel = new Label(orderVO.getUserName());
		//TODO 从commentvo得到评价的日期(我暂时set的是实际入住时间)
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");//yyyy-MM-dd hh:mm:ss
		dateLabel = new Label(dateFormat.format(orderVO.getActualCheckIn()));
		//TODO 从commentvo得到评价的房间类型
		roomTypeLabel = new Label(orderVO.getRoom().getRoomType());
		commentArea = new TextArea(orderVO.getComment());
		// TODO 从commentvo得到评价的内容
//		commentLabel = new Label(orderVO.getComment());
//		commentLabel.setText("         进门的一瞬间就给人满室的浪漫与温馨。直线条的造型，简约风格的搭配，房间干净、整齐。在十分充足的阳光下，顿时显得轻松、舒适、");

		// 设置组件属性
		headImage.setPreserveRatio(false);
		backGroundHeadImage.setPreserveRatio(false);
		headImage.setFitWidth(82.0);
		headImage.setFitHeight(82.0);
		backGroundHeadImage.setFitWidth(82.0);
		backGroundHeadImage.setFitHeight(82.0);
		nickNameLabel.setStyle("-fx-text-fill: rgba(0,0,0,0.55)");
		nickNameLabel.setFont(Font.font("Times New Roman", 12));
		dateLabel.setStyle("-fx-text-fill: rgba(0,0,0,0.55)");
		dateLabel.setFont(Font.font("Times New Roman", 12));
		roomTypeLabel.setStyle("-fx-text-fill: rgba(0,0,0,0.55)");
		roomTypeLabel.setFont(Font.font("Times New Roman", 12));
		commentArea.setFont(Font.font("Times New Roman", 12));
		commentArea.setWrapText(true);
//		commentLabel.setFont(Font.font("Times New Roman", 12));
	//	commentLabel.setWrapText(true);
//		rectangleAroundComment.setFill(new Color(232, 232, 232, 0.16));
//		rectangleAroundComment.setFill(new Color(0.9, 0.9, 0.9, 0.16));
	//	rectangleAroundComment.setStroke(new Color(0, 0, 0, 0.23));
		
		//添加组件
		this.getChildren().add(headImage);
		this.getChildren().add(backGroundHeadImage);
		this.getChildren().add(nickNameLabel);
		this.getChildren().add(dateLabel);
		this.getChildren().add(roomTypeLabel);
		this.getChildren().add(commentArea);
//		this.getChildren().add(commentLabel);
//		this.getChildren().add(rectangleAroundComment);
		
		//设置组件位置
		Locator locator = Locator.getLocator();
		locator.setLocation(headImage, 0.0,23.0 ,31.0,687.0);
		locator.setLocation(backGroundHeadImage, 0.0,23.0  ,31.0,687.0);
		locator.setLocation(nickNameLabel, 84.0, 6.0,34.0,690.0);
		locator.setLocation(dateLabel,84.0, 6.0,179.0, 558.0);
		locator.setLocation(roomTypeLabel, 84.0, 6.0, 271.0,447.0);
		locator.setLocation(commentArea, 6.0,27.0, 152.0,87.0);
//		locator.setLocation(commentLabel, 6.0,27.0, 152.0,87.0);
//		locator.setLocation(rectangleAroundComment, 6.0,27.0, 152.0,87.0);
		
	}
	
}
