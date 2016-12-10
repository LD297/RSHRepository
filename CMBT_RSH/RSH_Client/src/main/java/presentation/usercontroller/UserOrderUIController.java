package presentation.usercontroller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInfoUtil;
import vo.HotelVO;
import vo.OrderVO;

public class UserOrderUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label yearLabel;

    @FXML
    private Label executedOrderLabel;

    @FXML
    private Label unexecutedOrderLabel;

    @FXML
    private Label abnormalOrderLabel;

    @FXML
    private Label canceledorderLabel;

    @FXML
    private Label allOrderLabel;

    @FXML
    private ImageView backImage;

    @FXML
    private AnchorPane orderlistAnchorPane;

    @FXML
    private Label ordervaluelabelOfLine1;

    @FXML
    private Label ordervaluelabelOfLine5;

    @FXML
    private Label ordervaluelabelOfLine4;

    @FXML
    private Label ordervaluelabelOfLine3;

    @FXML
    private Label ordervaluelabelOfLine2;

    @FXML
    private Label lastPagelabel;

    @FXML
    private TextField pageField;

    @FXML
    private Label nextPageLabel;

    @FXML
    private TextField orderIDField;

    @FXML
    private Button cancelOrderButton;

    @FXML
    private GridPane gridpaneFilledWithOrder;

    @FXML
    private Label dayOfTodayLabel;

    @FXML
    private Label mothyearOfToday;

    @FXML
    private Label weekOfToday;
    
	private ArrayList<OrderVO> orderVOs = null;
	private int presentPage = 1;//当前页码
	private int orderVOsPointer = -1;
	private int maxPages = 0;
    
  //关闭在酒店详情界面上弹出的我的订单界面  ？？？？
    @FXML
    void backToHotelInfo(MouseEvent event) {
    	 UIJumpTool.getUiJumpTool().closeMyOrderOfOneHotel();
    }
  // TODO 点击撤销订单按钮
    @FXML
    void cancelOrder(MouseEvent event) {

    }

    @FXML
    void changeTextFillToBlack(MouseEvent event) {
    	 Label label = (Label)event.getSource();
         if(!label.isUnderline()){
             label.setTextFill(Color.valueOf("#000000"));
         }
    }

    @FXML
    void changeTextFillToGreen(MouseEvent event) {
    	 ((Label)event.getSource()).setTextFill(Color.valueOf("#00a699"));
    }


    @FXML
    void changeToLastPage(MouseEvent event) {

    }

    @FXML
    void changeToNextPage(MouseEvent event) {

    }

    @FXML
    void changeToOrderInfo(MouseEvent event) {

    }

    @FXML
    void changeToSpecificPage(ActionEvent event) {

    }
    //输入订单编号，敲击回车键
    @FXML
    void orderIDEntered(ActionEvent event) {
    	//TODO 找寻订单
    	 UIJumpTool.getUiJumpTool().changeToOrderInfo();
    }

    @FXML
    void showAllAbnormalOrder(MouseEvent event) {
    	 setPropertyOfOrderTypeLabel((Label)event.getSource());
         //TODO 显示所有不正常订单
    }

    @FXML
    void showAllCanceledOrder(MouseEvent event) {
    	 setPropertyOfOrderTypeLabel((Label)event.getSource());
         //TODO 显示所有已撤销订单
    }

    @FXML
    void showAllExecutedOrder(MouseEvent event) {
    	 setPropertyOfOrderTypeLabel((Label)event.getSource());
         //TODO 显示所有已执行订单
    }

    @FXML
    void showAllOrder(MouseEvent event) {
        setPropertyOfOrderTypeLabel((Label)event.getSource());
        //TODO 显示所有订单
    }

    @FXML
    void showAllUnexecutedOrder(MouseEvent event) {
        setPropertyOfOrderTypeLabel((Label)event.getSource());
        //TODO 显示所有未执行订单
    }

    private void setPropertyOfOrderTypeLabel(Label orderTypeLabel){
        abnormalOrderLabel.setTextFill(Color.valueOf("#000000"));
        executedOrderLabel.setTextFill(Color.valueOf("#000000"));
        unexecutedOrderLabel.setTextFill(Color.valueOf("#000000"));
        canceledorderLabel.setTextFill(Color.valueOf("#000000"));
        allOrderLabel.setTextFill(Color.valueOf("#000000"));

        abnormalOrderLabel.setUnderline(false);
        executedOrderLabel.setUnderline(false);
        unexecutedOrderLabel.setUnderline(false);
        canceledorderLabel.setUnderline(false);
        allOrderLabel.setUnderline(false);

        orderTypeLabel.setTextFill(Color.valueOf("#00a699"));
        orderTypeLabel.setUnderline(true);
    }

    public void init() {
    	UserInfoUtil userInfoUtil = UserInfoUtil.getInstance();
		orderVOs = userInfoUtil.getOrderVOs();
		if(orderVOs.size()%5==0){
			maxPages = orderVOs.size()/5;
		}else{
			maxPages = orderVOs.size()/5 + 1;
		}
		changeToSpecficPage(1);
	}
    
    //跳转到指定的页数
    private void changeToSpecficPage(int page) {
    	//直接跳转到最后一页
		if(page>=maxPages){
			orderVOsPointer = (maxPages-1)*5;
		}else{
			orderVOsPointer = (page-1)*5;
		}
		int count = 0;
		while(count<5){//一个界面上有5个格子
			if(orderVOsPointer==orderVOs.size()){
				break;
			}
			SingleOrderOfBrowseAnchorPane singleOrderOfBrowseAnchorPane = new SingleOrderOfBrowseAnchorPane(
					orderVOs.get(orderVOsPointer));
			gridpaneFilledWithOrder.add(singleOrderOfBrowseAnchorPane, 0, count);
			orderVOsPointer++;
			count ++;
		}
	}
    
    
    @FXML
    void initialize() {
        assert yearLabel != null : "fx:id=\"yearLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert executedOrderLabel != null : "fx:id=\"executedOrderLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert unexecutedOrderLabel != null : "fx:id=\"unexecutedOrderLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert abnormalOrderLabel != null : "fx:id=\"abnormalOrderLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert canceledorderLabel != null : "fx:id=\"canceledorderLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert allOrderLabel != null : "fx:id=\"allOrderLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderlistAnchorPane != null : "fx:id=\"orderlistAnchorPane\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert ordervaluelabelOfLine1 != null : "fx:id=\"ordervaluelabelOfLine1\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert ordervaluelabelOfLine5 != null : "fx:id=\"ordervaluelabelOfLine5\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert ordervaluelabelOfLine4 != null : "fx:id=\"ordervaluelabelOfLine4\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert ordervaluelabelOfLine3 != null : "fx:id=\"ordervaluelabelOfLine3\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert ordervaluelabelOfLine2 != null : "fx:id=\"ordervaluelabelOfLine2\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert lastPagelabel != null : "fx:id=\"lastPagelabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderIDField != null : "fx:id=\"orderIDField\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert cancelOrderButton != null : "fx:id=\"cancelOrderButton\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert gridpaneFilledWithOrder != null : "fx:id=\"gridpaneFilledWithOrder\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert dayOfTodayLabel != null : "fx:id=\"dayOfTodayLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert mothyearOfToday != null : "fx:id=\"mothyearOfToday\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert weekOfToday != null : "fx:id=\"weekOfToday\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";

        init();
    }
}
