package presentation.webmanagercontroller;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import presentation.tools.ImageFactory;
import presentation.tools.Locator;
import presentation.webmanagercontrollertools.WebManagerUIFXMLFactory;
import vo.HotelVO;

public class SingleHotelAnchorPane extends AnchorPane{
	private Label nameLabel = new Label("酒店名称：");
	private Label areaLabel = new Label("所在地址:");
	private Label idLabel = new Label("酒店账号：");
	private Label nameIndoLabel = new Label();
	private Label areaInfoLabel = new Label();
	private Label idInfoLabel = new Label();
	private Label phoneInfoLabel = new Label();
	private ImageView penImage = new ImageView(ImageFactory.getImageFactory().getPenImage());
	private ImageView phoneImage = new ImageView(ImageFactory.getImageFactory().getPhoneImage());

	public SingleHotelAnchorPane(HotelVO hotelVO) {
		nameIndoLabel.setText(hotelVO.getHotelName());
		areaInfoLabel.setText(hotelVO.getFullAddress());
		idInfoLabel.setText(hotelVO.getHotelID());
		phoneInfoLabel.setText(hotelVO.getTel());
		
		//set组件属性
		penImage.setFitHeight(23);
		penImage.setFitWidth(23);
		phoneImage.setFitHeight(18);
		phoneImage.setFitWidth(18);
		penImage.setPreserveRatio(false);
		phoneImage.setPreserveRatio(false);
		setFont(areaInfoLabel);
		setFont(areaLabel);
		setFont(idInfoLabel);
		setFont(idLabel);
		setFont(nameIndoLabel);
		setFont(nameLabel);
		setFont(phoneInfoLabel);
		
		//添加组件
		this.getChildren().add(areaInfoLabel);
		this.getChildren().add(areaLabel);
		this.getChildren().add(idInfoLabel);
		this.getChildren().add(idLabel);
		this.getChildren().add(nameIndoLabel);
		this.getChildren().add(nameLabel);
		this.getChildren().add(penImage);
		this.getChildren().add(phoneImage);
		this.getChildren().add(phoneInfoLabel);
		
		//设置组件位置
		Locator locator = Locator.getLocator();
		locator.setLocation(idLabel, 13.0,73.0,40.0,470.0);
		locator.setLocation(idInfoLabel, 13.0,73.0, 151.0,200.0);
		locator.setLocation(nameLabel, 43.0,46.0, 40.0,470.0);
		locator.setLocation(nameIndoLabel, 43.0,46.0, 151.0,0.0);
		locator.setLocation(areaLabel, 73.0,13.0, 40.0,470.0);
		locator.setLocation(areaInfoLabel, 73.0,13.0, 151.0,0.0);
		locator.setLocation(penImage, 13.0,76.0,577.0,0.0);
		locator.setLocation(phoneImage, 15.0,73.0,360.0,220.0);
		locator.setLocation(phoneInfoLabel, 13.0,73.0,380.0,130.0);
		
		//为组件添加监听
		penImage.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				AnchorPane modifyHotel = WebManagerUIFXMLFactory.getInstance().getModifyHotel();
				ModifyHotelUIController modifyHotelUIController = WebManagerUIFXMLFactory.getInstance().getModifyHotelUIController();
				modifyHotelUIController.init(hotelVO);
				AnchorPane manageHotel = WebManagerUIFXMLFactory.getInstance().getManageHotel();
		    	manageHotel.getChildren().add(modifyHotel);
			}
		});
	}
	
	private void setFont(Label label){
		label.setFont(Font.font("Times New Roman", 18));
	}
}
