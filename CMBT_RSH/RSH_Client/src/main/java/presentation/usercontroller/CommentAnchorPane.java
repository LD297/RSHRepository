package presentation.usercontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import presentation.tools.ImageFactory;
import presentation.tools.Locator;
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
	private DateFormat dateFormat = null;
	
	//传入的参数后期会改为commentvo
	public CommentAnchorPane(OrderVO orderVO) {
		headImage = new ImageView(ImageFactory.getImageFactory().getHeadImage(orderVO.getUserID()));
		backGroundHeadImage = new ImageView(ImageFactory.getImageFactory().getHeadImagebackground());
		nickNameLabel = new Label(orderVO.getUserName());
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");//yyyy-MM-dd hh:mm:ss
		dateLabel = new Label(dateFormat.format(orderVO.getActualCheckIn()));
		roomTypeLabel = new Label(orderVO.getRoom().getRoomType());
		commentArea = new TextArea(orderVO.getComment());
		
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
		
		//添加组件
		this.getChildren().add(headImage);
		this.getChildren().add(backGroundHeadImage);
		this.getChildren().add(nickNameLabel);
		this.getChildren().add(dateLabel);
		this.getChildren().add(roomTypeLabel);
		this.getChildren().add(commentArea);
		
		//设置组件位置
		Locator locator = Locator.getLocator();
		locator.setLocation(headImage, 0.0,23.0 ,31.0,687.0);
		locator.setLocation(backGroundHeadImage, 0.0,23.0  ,31.0,687.0);
		locator.setLocation(nickNameLabel, 84.0, 6.0,34.0,690.0);
		locator.setLocation(dateLabel,84.0, 6.0,179.0, 558.0);
		locator.setLocation(roomTypeLabel, 84.0, 6.0, 271.0,447.0);
		locator.setLocation(commentArea, 6.0,27.0, 152.0,87.0);
		
	}
	
}
