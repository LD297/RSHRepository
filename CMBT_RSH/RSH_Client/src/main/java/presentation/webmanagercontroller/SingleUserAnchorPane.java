package presentation.webmanagercontroller;


import constant.Sexuality;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import presentation.tools.ImageFactory;
import presentation.tools.Locator;
import presentation.webmanagercontrollertools.WebManagerUIFXMLFactory;
import vo.UserVO;

public class SingleUserAnchorPane extends AnchorPane{
	private Label nameLabel;
	private Label nameInfoLabel;
	private Label nickNameLabel;
	private Label nickNameInfoLabel;
	private Label phoneInfoLabel;
	private Label creditLabel;
	private Label creditInfoLabel;
	private Label memberTypeLabel;
	private Label memberLevelLabel;
	private ImageView phoneImage;
	private ImageView sexImage;
	private Label forMoreLabel = null;
	public SingleUserAnchorPane(UserVO userVO){
		phoneImage = new ImageView(ImageFactory.getImageFactory().getPhoneImage());
		sexImage = new ImageView();
		if(userVO.sexuality==Sexuality.female){
			sexImage.setImage(ImageFactory.getImageFactory().getFemale());
		}else {
			sexImage.setImage(ImageFactory.getImageFactory().getMale());
		}
		nameLabel = new Label("姓名：");
		nameInfoLabel = new Label(userVO.name);
		nickNameLabel = new Label("昵称");
		nickNameInfoLabel = new Label(userVO.nickName);
		phoneInfoLabel = new Label(userVO.id);
		creditLabel = new Label("信用值：");
		creditInfoLabel = new Label(String.valueOf(userVO.credit));
		memberTypeLabel = new Label(userVO.getMemberType().getString());
		memberLevelLabel = new Label(String.valueOf(userVO.level));
		forMoreLabel = new Label("更多>");
		
		//设置组件属性
		setFont(creditInfoLabel);
		setFont(creditLabel);
		setFont(memberLevelLabel);
		setFont(memberTypeLabel);
		setFont(nameInfoLabel);
		setFont(nameLabel);
		setFont(phoneInfoLabel);
		setFont(nickNameLabel);
		setFont(nickNameInfoLabel);
		phoneImage.setFitHeight(23);
		phoneImage.setFitWidth(23);
		sexImage.setFitHeight(20);
		sexImage.setFitWidth(20);
		forMoreLabel.setStyle("-fx-text-fill: #bababa");
		forMoreLabel.setFont(Font.font("Times New Roman", 14));
		
		//添加组件
		this.getChildren().add(creditInfoLabel);
		this.getChildren().add(creditLabel);
		this.getChildren().add(memberLevelLabel);
		this.getChildren().add(memberTypeLabel);
		this.getChildren().add(nameInfoLabel);
		this.getChildren().add(nameLabel);
		this.getChildren().add(phoneInfoLabel);
		this.getChildren().add(phoneImage);
		this.getChildren().add(nickNameInfoLabel);
		this.getChildren().add(nickNameLabel);
		this.getChildren().add(sexImage);
		this.getChildren().add(forMoreLabel);
		
		//设置组件位置
		Locator locator = Locator.getLocator();
		locator.setLocation(creditInfoLabel,89.0, 11.0,128.0,409.0 );
		locator.setLocation(creditLabel, 89.0, 11.0,52.0,472.0);
		locator.setLocation(memberTypeLabel, 48.0,52.0, 330.0,182.0);
		locator.setLocation(memberLevelLabel, 48.0,52.0, 434.0,147.0);
		locator.setLocation(nameInfoLabel,14.0, 86.0,128.0,307.0 );
		locator.setLocation(nameLabel, 14.0, 86.0,59.0,485.0);
		locator.setLocation(phoneInfoLabel, 48.0, 52.0, 128.0,370.0);
		locator.setLocation(phoneImage, 48.0, 52.0, 63.0,514.0);
		locator.setLocation(nickNameLabel, 14.0, 86.0,330.0,182.0);
		locator.setLocation(nickNameInfoLabel, 14.0, 86.0,435.0,20.0);
		locator.setLocation(sexImage, 17.0,86.0,580.0,0.0);
		locator.setLocation(forMoreLabel, 86.0,7.0,560.0,0.0);
		
		//为组件添加监听
		forMoreLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//跳转到查看用户信息
			@Override
			public void handle(MouseEvent event) {
				AnchorPane manageUser = WebManagerUIFXMLFactory.getInstance().getManageUser();
				AnchorPane checkUserInfo = WebManagerUIFXMLFactory.getInstance().getCheckUserInfo();
				CheckUserInfoUIController checkUserInfoUIController = WebManagerUIFXMLFactory.getInstance()
						.getCheckUserInfoUIController();
				checkUserInfoUIController.init(userVO);
				manageUser.getChildren().add(checkUserInfo);
			}
		});
		forMoreLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
			//鼠标进入”更多“，颜色变为绿色
			@Override
			public void handle(MouseEvent event) {
				forMoreLabel.setTextFill(Color.valueOf("#00a699"));
			}
		});
		forMoreLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
			//鼠标离开”更多“，颜色变为灰色
			@Override
			public void handle(MouseEvent event) {
				forMoreLabel.setTextFill(Color.valueOf("#bcbcbc"));
			}
		});
	}
	
	private void setFont(Label label){
		label.setFont(Font.font("Times New Roman", 18));
	}
}
