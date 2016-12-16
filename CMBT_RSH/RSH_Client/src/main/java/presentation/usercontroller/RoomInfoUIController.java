package presentation.usercontroller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import presentation.tools.ImageFactory;
import presentation.tools.Locator;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInfoUtil;
import vo.RoomVO;

/**
 * 酒店详情下的客房信息界面
 * @author john
 *
 */
public class RoomInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridPaneFilledWithSingleRoom;
    
    private ArrayList<RoomVO> roomVOs = null;
    private int maxPages = 0;
    private int roomVOsPointer = -1;
    private int presentPage = 1;
    
    private class SingleRoomInfoAnchorPane extends AnchorPane{
    	private ImageView roonImageView = null;
    	private Label roomTypeLabel = null;
    	private Label priceLabel = null;
    	private Button reserveButton = null;
    	private ImageView arrow = null;
    	private boolean left = true;
    	private RoomVO roomVO = null;
    	
    	public SingleRoomInfoAnchorPane(RoomVO roomVO,boolean left) {
			this.left = left;
			this.roomVO = roomVO;
			init();
		}
    	
    	private void init() {
    		//TODO get房间图片
			roonImageView = new ImageView(ImageFactory.getImageFactory().getHotelImage());
			roomTypeLabel = new Label(roomVO.type);
			priceLabel = new Label("￥"+String.valueOf(roomVO.price)+"/晚");
			reserveButton = new Button("预定");
			if(left){
				arrow = new ImageView(ImageFactory.getImageFactory().getLastImageArrow());
			}else {
				arrow = new ImageView(ImageFactory.getImageFactory().getNextImageArrow());
			}
			
			//设置组件属性
			roonImageView.setPreserveRatio(false);
			roonImageView.setFitWidth(400.0);
			roonImageView.setFitHeight(240.0);
			arrow.setFitWidth(60.0);
			arrow.setFitHeight(119.0);
			arrow.setPreserveRatio(false);
			//设置房间类型、价格字体Times New Roman，大小18，颜色白色
			roomTypeLabel.setStyle("-fx-text-fill: white");
			roomTypeLabel.setFont(Font.font("Times New Roman", 18));
			priceLabel.setStyle("-fx-text-fill: white");
			priceLabel.setFont(Font.font("Times New Roman", 18));
			//预定按钮字体半透明，颜色白色
			reserveButton.setStyle("-fx-background-color: rgba(0,0,0,0.5);-fx-text-fill: white");
			
			//添加组件
			this.getChildren().add(roonImageView);
			this.getChildren().add(roomTypeLabel);
			this.getChildren().add(reserveButton);
			this.getChildren().add(priceLabel);
			this.getChildren().add(arrow);
			
			//设置组件位置
			Locator locator = Locator.getLocator();
			locator.setLocation(roomTypeLabel, 14.0, 204.0, 14.0, 218.0);
			locator.setLocation(priceLabel, 36.0, 182.0, 14.0, 218.0);
			if(left){
				locator.setLocation(arrow, 58.0, 63.0, 14.0, 326.0);
			}else{
				locator.setLocation(arrow, 58.0, 63.0, 326.0,14.0);
			}
			locator.setLocation(reserveButton, 194.0, 14.0, 300.0, 14.0);
			
			//设置组件的监听
			arrow.setOnMouseClicked(new EventHandler<MouseEvent>() {
				//鼠标点击箭头，切换图片和对应的房间类型
				@Override
				public void handle(MouseEvent event) {
					if(left){
						changeToLastPage();
					}else {
						changeToNextPage();
					}
				}
			});
			reserveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					//TDDO 将该房间类型set进新建订单界面
					UIJumpTool.getUiJumpTool().changeToCreateOrder();
				}
			});
		}
    }

    private void changeToLastPage(){
    	if(presentPage-1>=1){
			presentPage--;
			gridPaneFilledWithSingleRoom.getChildren().clear();
			changeToSpecificPage(presentPage);
		}
    }
   
    private void changeToNextPage(){
    	if(presentPage+1<=maxPages){
    		presentPage++;
    		gridPaneFilledWithSingleRoom.getChildren().clear();
    		changeToSpecificPage(presentPage);
    	}
    }
    
    private void changeToSpecificPage(int page){
		// 直接跳转到最后一页
		if (page >= maxPages) {
			roomVOsPointer = (maxPages - 1) * 2;
		} else {
			roomVOsPointer = (page - 1) * 2;
		}
		int count = 0;
		while (count < 2) {// 一个界面上有2个格子
			boolean left = false;
			if (count % 2 == 0) {
				left = true;
			}
			if(roomVOsPointer==roomVOs.size()){
				break;
			}
			SingleRoomInfoAnchorPane singleRoomInfoAnchorPane = new SingleRoomInfoAnchorPane(
					roomVOs.get(roomVOsPointer), left);
			switch (count) {
			case 0:
				gridPaneFilledWithSingleRoom.add(singleRoomInfoAnchorPane, 0, 0);
				break;
			case 1:
				gridPaneFilledWithSingleRoom.add(singleRoomInfoAnchorPane, 1, 0);
				break;
			default:
				break;
			}
			roomVOsPointer++;
			count++;
		}
    }
    
    private void initRoomInfo() {
    	UserInfoUtil userInfoUtil = UserInfoUtil.getInstance();
		roomVOs = userInfoUtil.getRoomVos();
		maxPages = (roomVOs.size()+1)/2;
		changeToSpecificPage(1);
	}
    
    @FXML
    void initialize() {
        assert gridPaneFilledWithSingleRoom != null : "fx:id=\"gridPaneFilledWithSingleRoom\" was not injected: check your FXML file '客房信息.fxml'.";
        initRoomInfo();
    }
}
