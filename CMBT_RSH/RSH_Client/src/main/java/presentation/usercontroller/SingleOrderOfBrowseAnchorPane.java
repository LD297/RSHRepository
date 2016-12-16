package presentation.usercontroller;

import constant.StateOfOrder;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import presentation.tools.ImageFactory;
import presentation.tools.Locator;
import presentation.tools.MyDateFormat;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInfoUtil;
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
//	private CheckBox checkBox = null;
	private Label forMoreLabel = null;
//	private Button commentButton = null;
	private OrderVO orderVO = null;
	public SingleOrderOfBrowseAnchorPane(OrderVO orderVO) {
		this.orderVO = orderVO;
		orderStateImage = new ImageView();
		weekLabel = new Label(MyDateFormat.getInstance().getWeek(orderVO.getGenerationDate()));
		dateLabel = new Label(MyDateFormat.getInstance().toString(orderVO.getGenerationDate()));
		orderIDLabel = new Label(orderVO.getOrderID());
//		hotelNameLabel = new Label(orderVO.getHotelID())
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
//		checkBox = new CheckBox();
//		commentButton = new Button("评价");
		
		
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
//		commentButton.setStyle("-fx-background-color:#ff5a5f;-fx-text-fill: #ffffff");
//		commentButton.setFont(Font.font("Times New Roman", 14));
		
		//添加组件
		this.getChildren().add(weekLabel);
		this.getChildren().add(dateLabel);
		this.getChildren().add(hotelNameLabel);
		this.getChildren().add(orderIDLabel);
		this.getChildren().add(orderStateImage);
		this.getChildren().add(orderValueLabel);
		this.getChildren().add(orderValue);
//		this.getChildren().add(checkBox);
//		this.getChildren().add(commentButton);
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
//		locator.setLocation(checkBox, 20.0,50.0,477.0,3.0);
//		locator.setLocation(commentButton, 43.0, 17.0, 415.0,23.0);
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
/*		commentButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//点击评价按钮，跳转到添加评价界面
			@Override
			public void handle(MouseEvent event) {
				//首先设置工具类里面的当前的orderid
				UserInfoUtil.getInstance().setOrderID(orderVO.getOrderID());
				//跳转到添加评价界面
				UIJumpTool.getUiJumpTool().changeUserOrderToAddComment();
			}
		});*/
	}
}
