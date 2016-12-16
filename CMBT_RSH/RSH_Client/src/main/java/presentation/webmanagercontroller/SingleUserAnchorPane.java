package presentation.webmanagercontroller;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import presentation.tools.Locator;
import vo.UserVO;

public class SingleUserAnchorPane extends AnchorPane{
	private Label nameLabel;
	private Label nameInfoLabel;
	private Label phoneLabel;
	private Label phoneInfoLabel;
	private Label creditLabel;
	private Label creditInfoLabel;
	private Label memberTypeLabel;
	private Label memberLevelLabel;
	private Button resetPasswordButton;
	public SingleUserAnchorPane(UserVO userVO){
		nameLabel = new Label("姓名：");
		nameInfoLabel = new Label(userVO.name);
		phoneLabel = new Label("手机号码：");
		phoneInfoLabel = new Label(userVO.id);
		creditLabel = new Label("信用值：");
		creditInfoLabel = new Label(String.valueOf(userVO.credit));
		memberTypeLabel = new Label(userVO.getMemberType().getString());
		memberLevelLabel = new Label(String.valueOf(userVO.level));
		resetPasswordButton = new Button("重置密码");
		
		//设置组件属性
		setFont(creditInfoLabel);
		setFont(creditLabel);
		setFont(memberLevelLabel);
		setFont(memberTypeLabel);
		setFont(nameInfoLabel);
		setFont(nameLabel);
		setFont(phoneInfoLabel);
		setFont(phoneLabel);
		resetPasswordButton.setFont(Font.font("Times New Roman", 14));
		
		//添加组件
		this.getChildren().add(creditInfoLabel);
		this.getChildren().add(creditLabel);
		this.getChildren().add(memberLevelLabel);
		this.getChildren().add(memberTypeLabel);
		this.getChildren().add(nameInfoLabel);
		this.getChildren().add(nameLabel);
		this.getChildren().add(phoneInfoLabel);
		this.getChildren().add(phoneLabel);
		this.getChildren().add(resetPasswordButton);
		
		//设置组件位置
		Locator locator = Locator.getLocator();
		locator.setLocation(creditInfoLabel,89.0, 11.0,181.0,378.0 );
		locator.setLocation(creditLabel, 89.0, 11.0,59.0,439.0);
		locator.setLocation(memberLevelLabel, 14.0,86.0, 387.0,125.0);
		locator.setLocation(memberTypeLabel, 14.0,86.0, 500.0,81.0);
		locator.setLocation(nameInfoLabel,14.0, 86.0,181.0,300.0 );
		locator.setLocation(nameLabel, 14.0, 86.0,59.0,479.0);
		locator.setLocation(phoneInfoLabel, 50.0, 50.0, 181.0,300.0);
		locator.setLocation(phoneLabel, 50.0, 50.0,59.0,439.0);
		locator.setLocation(resetPasswordButton, 86.0,7.0, 443.0, 81.0);
		
		//添加监听
		resetPasswordButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO 重置密码
				
			}
		});
	}
	
	private void setFont(Label label){
		label.setFont(Font.font("Times New Roman", 18));
	}
}
