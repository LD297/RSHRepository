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
import vo.WebSalesmanVO;

public class SingleWebSalesmanAnchorPane extends AnchorPane{
	private Label idLabel = new Label("营销人员账号：");
	private Label idInfoLabel = new Label();
	private Label areaLabel = new Label("负责商圈：");
	private Label areaInfoLabel = new Label();
	private ImageView penImage = new ImageView(ImageFactory.getImageFactory().getPenImage());
	
	public SingleWebSalesmanAnchorPane(WebSalesmanVO webSalesmanVO) {
		idInfoLabel.setText(webSalesmanVO.getId());
		areaInfoLabel.setText(webSalesmanVO.getProvince()+" "+webSalesmanVO.getCity()+" "+webSalesmanVO.getArea());;
		
		//设置组件属性
		areaInfoLabel.setOpacity(0.8);
		areaLabel.setOpacity(0.8);
		idInfoLabel.setOpacity(0.8);
		idLabel.setOpacity(0.8);
		setFont(areaInfoLabel);
		setFont(areaLabel);
		setFont(idInfoLabel);
		setFont(idLabel);
		penImage.setFitHeight(23);
		penImage.setFitWidth(23);
		penImage.setPreserveRatio(false);
		
		//添加组件
		this.getChildren().add(areaInfoLabel);
		this.getChildren().add(idInfoLabel);
		this.getChildren().add(areaLabel);
		this.getChildren().add(idLabel);
		this.getChildren().add(penImage);
		
		//设置组件位置
		Locator locator = Locator.getLocator();
		locator.setLocation(idLabel, 14.0,53.0,10.0,400.0);
		locator.setLocation(idInfoLabel, 14.0,53.0, 218.0,199.0);
		locator.setLocation(areaLabel, 49.0,15.0,10.0, 452.0);
		locator.setLocation(areaInfoLabel, 49.0,15.0, 218.0,99.0);
		locator.setLocation(penImage, 14.0, 53.0, 578.0, 0.0);
		
		penImage.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				AnchorPane modifyWebSalesman = WebManagerUIFXMLFactory.getInstance().getModifyWebSalesman();
				AnchorPane manageWebSalesman = WebManagerUIFXMLFactory.getInstance().getManageWebSalesman();
				ModifyWebSalesmanUIController modifyWebSalesmanUIController = WebManagerUIFXMLFactory.getInstance().getModifyWebSalesmanUIController();
				modifyWebSalesmanUIController.init(webSalesmanVO);
		    	manageWebSalesman.getChildren().add(modifyWebSalesman);
			}
			
		});
	}
	
	private void setFont(Label label){
		label.setFont(Font.font("Times New Roman", 18));
	}
}
