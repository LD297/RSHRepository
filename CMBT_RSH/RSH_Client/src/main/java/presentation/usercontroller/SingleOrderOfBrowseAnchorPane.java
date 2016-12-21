package presentation.usercontroller;

import constant.StateOfOrder;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import presentation.tools.ImageFactory;
import presentation.tools.Locator;
import presentation.tools.MyDateFormat;
import presentation.usercontrollertools.UIJumpTool;
import presentation.usercontrollertools.UserInfoUtil;
import vo.OrderVO;

public class SingleOrderOfBrowseAnchorPane extends AnchorPane{
	private Label weekLabel = null;
	private Label dateLabel = null;
	private Label orderIDLabel = null;
	private Label hotelNameLabel = null;
	/**
	 * set进信用价值（具体的数值）
	 */
	private Label orderValueLabel = null;
	/**
	 * 信用价值（提示）
	 */
	private Label orderValue = null;
	private ImageView orderStateImage = null;
	private Label forMoreLabel = null;
	public SingleOrderOfBrowseAnchorPane(OrderVO orderVO) {
		orderStateImage = new ImageView();
		weekLabel = new Label(MyDateFormat.getInstance().getWeek(orderVO.getGenerationDate()));
		dateLabel = new Label(MyDateFormat.getInstance().toString(orderVO.getGenerationDate()));
		orderIDLabel = new Label(orderVO.getOrderID());
		hotelNameLabel = new Label(orderVO.getHotelName());
		orderValueLabel = new Label(String.valueOf(orderVO.getTrueValue()));
		orderValue = new Label("信用价值");
		StateOfOrder stateOfOrder = orderVO.getState();
		ImageFactory imageFactory = ImageFactory.getImageFactory();
		//如果是异常订单
		if (stateOfOrder==StateOfOrder.abnormal) {
			orderStateImage.setImage(imageFactory.getAbmormalOrderImage());
		//未执行订单
		}else if (stateOfOrder==StateOfOrder.unexecuted) {
			orderStateImage.setImage(imageFactory.getUnexecutedOrderImage());
		//撤销订单
		}else if (stateOfOrder==StateOfOrder.canceled) {
			orderStateImage.setImage(imageFactory.getCancelAbnormalImage());
		//执行订单
		}else{
			orderStateImage.setImage(imageFactory.getOrderExecutedImage());
		}
		forMoreLabel = new Label("更多>");
		
		//设置组件属性
		orderStateImage.setFitHeight(20.0);
		orderStateImage.setFitWidth(20.0);
		weekLabel.setStyle("-fx-text-fill: rgba(0,0,0,0.55)");
		weekLabel.setFont(Font.font("Times New Roman", 14));
		dateLabel.setStyle("-fx-text-fill: rgba(0,0,0,0.55)");
		dateLabel.setFont(Font.font("Times New Roman", 14));
		orderIDLabel.setStyle("-fx-text-fill: rgba(0,0,0,0.55)");
		orderIDLabel.setFont(Font.font("Times New Roman", 14));
		hotelNameLabel.setStyle("-fx-text-fill: rgba(0,0,0,0.55)");
		hotelNameLabel.setFont(Font.font("Times New Roman", 16));
		orderValueLabel.setFont(Font.font("Times New Roman", 16));
		orderValue.setFont(Font.font("Times New Roman", 16));
		forMoreLabel.setStyle("-fx-text-fill: #bababa");
		forMoreLabel.setFont(Font.font("Times New Roman", 14));
		
		//添加组件
		this.getChildren().add(weekLabel);
		this.getChildren().add(dateLabel);
		this.getChildren().add(hotelNameLabel);
		this.getChildren().add(orderIDLabel);
		this.getChildren().add(orderStateImage);
		this.getChildren().add(orderValueLabel);
		this.getChildren().add(orderValue);
		this.getChildren().add(forMoreLabel);
		
		//设置组件位置
		Locator locator = Locator.getLocator();
		locator.setLocation(weekLabel, 20.0,50.0,14.0,439.0);
		locator.setLocation(dateLabel, 46.0,20.0,14.0,439.0);
		locator.setLocation(hotelNameLabel, 18.0,48.0,102.0,180.0);
		locator.setLocation(orderStateImage, 46.0,20.0,102.0,379.0);
		locator.setLocation(orderIDLabel, 41.0,15.0,133.0,180.0);
		locator.setLocation(orderValueLabel, 18.0,48.0,414.0,21.0);
		locator.setLocation(orderValue, 18.0, 48.0, 333.0, 90.0);
		locator.setLocation(forMoreLabel, 46.0,20.0,333.0,120.0);
		
		//为组件添加监听
		forMoreLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//跳转到订单详情界面
			@Override
			public void handle(MouseEvent event) {
				//set当前的订单编号
				UserInfoUtil.getInstance().setOrderID(orderVO.getOrderID());
				UIJumpTool.getUiJumpTool().changeToOrderInfo();
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
}
