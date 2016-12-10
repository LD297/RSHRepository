package presentation.usercontroller;

import java.util.ArrayList;

import bl.orderservice.OtherOrderService;
import bl.orderserviceimpl.OtherOrderController;
import bl.promotionServiceimpl.PromotionController;
import bl.promotionservice.PromotionService;
import constant.StateOfOrder;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import presentation.tools.ImageFactory;
import presentation.tools.Locator;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInfoUtil;
import vo.HotelVO;
import vo.PromotionVO;

/**
 * 用来放在酒店浏览界面（用户视角）的gridpane的格子里，以实现翻页的功能
 * @author john
 *
 */
public class BrowseHotelAnchorPane extends AnchorPane{
	private static final double WIDTH = 400.0;
	private HotelVO hotelVO = null;
	private ImageView hotelImageView = null;
	private Label labelOnHotelImage = null;
	private ImageView lastImageArrow = null;
	private ImageView nextImageArrow = null;
	private Label hotelNameLabel = null;
	private Button createOrderButton = null;
	private Label priceLabel = null;
	private ArrayList<Label> promotionLabels = null;
	private Label orderStateLabel = null;
	private boolean left = true;
	public BrowseHotelAnchorPane(HotelVO hotelVO,boolean left) {
		this.hotelVO = hotelVO;
		this.left = left;
		init();
	}
	
	private void init(){
		hotelImageView = new ImageView(ImageFactory.getImageFactory().getHotelImage());
		labelOnHotelImage = new Label();
		lastImageArrow = new ImageView(ImageFactory.getImageFactory().getLastImageArrow());
		nextImageArrow = new ImageView(ImageFactory.getImageFactory().getNextImageArrow());
		hotelNameLabel = new Label(hotelVO.name);
		createOrderButton = new Button("新建订单");
		//TODO 在逻辑层添加get酒店最低价格的方法
		priceLabel = new Label("￥2340/晚");
		//TODO 得到的促销策略应该适用于当前日期
		//TODO bL层单利？？？？？？？
		ArrayList<PromotionVO> promotionVOs = UserInfoUtil.getInstance().getPromotionVOs(hotelVO.id);
		for(int i=0;i<2;i++){
			if(promotionVOs.size()<=i){
				break;
			}
			Label label = new Label(promotionVOs.get(i).reason);
			promotionLabels.add(label);
		}
		//从数据层拿到该用户最近一笔订单的状态
		orderStateLabel = new Label(UserInfoUtil.getInstance().getOrderStateOfUser(hotelVO.id).toString());
		
		
		//设置组件的属性
		//图片比例
		hotelImageView.setPreserveRatio(false);
		//图片上蒙的label半透明
		labelOnHotelImage.setStyle("-fx-background-color:rgba(3,3,3,0.2)");
		//酒店名称label字体Times New Roman，大小18，颜色白色
		hotelNameLabel.setStyle("-fx-text-fill: white");
		hotelNameLabel.setFont(Font.font("Times New Roman", 18));
		//新建订单按钮背景半透明，字体颜色白色,字体Times New Roman，大小14
		createOrderButton.setStyle("-fx-background-color:rgba(0,0,0,0.5);-fx-text-fill: white");
		createOrderButton.setFont(Font.font("Times New Roman", 14));
		//价格的字体Agency FB，大小14
		priceLabel.setFont(Font.font("Agency FB", 14));
		//promotionLabel的背景颜色为#ff5a5f，字体颜色白色,字体Times New Roman，大小14
		for(int i=0;i<promotionLabels.size();i++){
			promotionLabels.get(i).setStyle("-fx-background-color:#ff5a5f;-fx-text-fill: white");
			promotionLabels.get(i).setFont(Font.font("Times New Roman", 14));
		}
		//最近一笔订单状态label字体颜色#00a699,字体Times New Roman，大小14
		orderStateLabel.setStyle("-fx-text-fill: #00a699");
		orderStateLabel.setFont(Font.font("Times New Roman", 14));
		
		//添加组件
		this.getChildren().add(hotelImageView);
		this.getChildren().add(labelOnHotelImage);
		this.getChildren().add(lastImageArrow);
		this.getChildren().add(nextImageArrow);
		this.getChildren().add(hotelNameLabel);
		this.getChildren().add(createOrderButton);
		this.getChildren().add(priceLabel);
		this.getChildren().add(orderStateLabel);
		for(int i=0;i<promotionLabels.size();i++){
			this.getChildren().add(promotionLabels.get(i));
		}
		double begin;
		//设置组件的位置
		Locator locator = Locator.getLocator();
		if(left){
			locator.setLocation(hotelImageView, 14.0, 56.0, 56.0, 14.0);
			locator.setLocation(labelOnHotelImage, 14.0, 56.0, 56.0, 14.0);
			locator.setLocation(lastImageArrow, 81.0, 123.0, 56.0, 279.0);
			locator.setLocation(nextImageArrow, 81.0, 123.0, 321.0, 14.0);
			locator.setLocation(hotelNameLabel, 26.0, 241.0, 67.0, 159.0);
			locator.setLocation(createOrderButton, 197.0, 170.0, 281.0, 23.0);
			locator.setLocation(priceLabel, 243.0, 30.0, 56.0, 280.0);
			locator.setLocation(orderStateLabel, 243.0, 30.0, 338.0, 14.0);
			begin = 56.0;
		}else{
			locator.setLocation(hotelImageView, 14.0, 56.0, 14.0, 56.0);
			locator.setLocation(labelOnHotelImage, 14.0, 56.0, 14.0, 56.0);
			locator.setLocation(lastImageArrow, 81.0, 123.0, 14.0, 321.0);
			locator.setLocation(nextImageArrow, 81.0, 123.0, 279.0, 56.0);
			locator.setLocation(hotelNameLabel, 26.0, 241.0, 26.0, 200.0);
			locator.setLocation(createOrderButton, 197.0, 170.0, 240.0, 64.0);
			locator.setLocation(priceLabel, 243.0, 30.0, 14.0, 321.0);
			locator.setLocation(orderStateLabel, 243.0, 30.0, 296.0, 56.0);
			begin = 14.0;
		}
		for(int i=0;i<promotionLabels.size();i++){
			double width = 14*promotionLabels.get(i).getText().length() + 20;
			locator.setLocation(promotionLabels.get(i), 269.0, 4.0, begin, WIDTH-begin-width);
			begin = begin + width + 2;
		}
		
		//设置组件的监听
		labelOnHotelImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//点击图片上蒙的label跳转到酒店详情界面
			public void handle(MouseEvent event) {
				UserInfoUtil.getInstance().setHotelName(hotelVO.name);
				UIJumpTool.getUiJumpTool().changeBrowseHotelToHotelInfo();
			}
		});
		createOrderButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//点击新建订单按钮跳转到新建订单界面
			@Override
			public void handle(MouseEvent event) {
				UserInfoUtil.getInstance().setHotelName(hotelVO.name);
			    UIJumpTool.getUiJumpTool().changeToCreateOrder();				
			}
		});
		lastImageArrow.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//跳转到该酒店的上一张图片
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		nextImageArrow.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//跳转到该酒店的下一张图片
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	
	
}
