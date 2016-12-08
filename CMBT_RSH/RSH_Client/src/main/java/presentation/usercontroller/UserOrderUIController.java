package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import presentation.tools.UIJumpTool;

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
    private Label dayOfTodayLabel;

    @FXML
    private Label mothyearOfToday;

    @FXML
    private Label weekOfToday;

    @FXML
    private Label weekOfline1;

    @FXML
    private Label weekOfline5;

    @FXML
    private Label weekOfline4;

    @FXML
    private Label weekOfline3;

    @FXML
    private Label weekOfline2;

    @FXML
    private Label monthyearOfline1;

    @FXML
    private Label monthyearOfline2;

    @FXML
    private Label monthyearOfline3;

    @FXML
    private Label monthyearOfline4;

    @FXML
    private Label monthyearOfline5;

    @FXML
    private Label ordervaluelabelOfLine1;

    @FXML
    private Label orderValueOfLine1;

    @FXML
    private Label hotelNameOfLine5;

    @FXML
    private Label hotelNameOfLine4;

    @FXML
    private Label hotelNameOfLine3;

    @FXML
    private Label hotelNameOfLine2;

    @FXML
    private Label orderValueOfLine5;

    @FXML
    private Label orderValueOfLine4;

    @FXML
    private Label orderValueOfLine3;

    @FXML
    private Label orderValueOfLine2;

    @FXML
    private Label ordervaluelabelOfLine5;

    @FXML
    private Label ordervaluelabelOfLine4;

    @FXML
    private Label ordervaluelabelOfLine3;

    @FXML
    private Label ordervaluelabelOfLine2;

    @FXML
    private Label orderIDOfLine1;

    @FXML
    private Label orderIDOfLine5;

    @FXML
    private Label orderIDOfLine4;

    @FXML
    private Label orderIDOfLine3;

    @FXML
    private Label orderIDOfLine2;

    @FXML
    private ImageView orderTypeImageOfLine3;

    @FXML
    private ImageView orderTypeImageOfLine4;

    @FXML
    private ImageView orderTypeImageOfLine5;

    @FXML
    private ImageView orderTypeImageOfLine1;

    @FXML
    private Label lastPagelabel;

    @FXML
    private TextField pageField;

    @FXML
    private Label nextPageLabel;

    @FXML
    private TextField orderIDField;

    @FXML
    private ImageView orderTypeImageOfLine2;

    @FXML
    private Label hotelNameOfLine1;

    @FXML
    private Button commentButtonOfLine1;

    @FXML
    private Button commentButtonOfLine5;

    @FXML
    private Button commentButtonOfLine4;

    @FXML
    private Button commentButtonOfLine3;

    @FXML
    private Button commentButtonOfLine2;

    @FXML
    private Label moreInfoOfLine1;

    @FXML
    private Label moreInfoOfLine5;

    @FXML
    private Label moreInfoOfLine4;

    @FXML
    private Label moreInfoOfLine3;

    @FXML
    private Label moreInfoOfLine2;

    @FXML
    private Button cancelOrderButton;

    @FXML
    private CheckBox checkboxOfLine1;

    @FXML
    private CheckBox checkboxOfLine5;

    @FXML
    private CheckBox checkboxOfLine4;

    @FXML
    private CheckBox checkboxOfLine3;

    @FXML
    private CheckBox checkboxOfLine2;

    @FXML
    private AnchorPane orderlistAnchorPane;


    //鼠标离开
    @FXML
    void changeTextFillToBlack(MouseEvent event) {
        Label label = (Label)event.getSource();
        if(!label.isUnderline()){
            label.setTextFill(Color.valueOf("#000000"));
        }
    }
    //鼠标离开“更多”
    @FXML
    void changeTextFillToGray(MouseEvent event) {
        Label label = (Label)event.getSource();
        label.setTextFill(Color.valueOf("#bcbcbc"));
    }

    //鼠标进入
    @FXML
    void changeTextFillToGreen(MouseEvent event) {
        ((Label)event.getSource()).setTextFill(Color.valueOf("#00a699"));
    }

    //点击评价按钮
    @FXML
    void changeToAddComment(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeUserOrderToAddComment();
    }

    //点击撤销订单按钮
    @FXML
    void cancelOrder(MouseEvent event) {

    }


    @FXML
    void changeToLastPage(MouseEvent event) {

    }

    @FXML
    void changeToNextPage(MouseEvent event) {

    }

    @FXML
    void changeToSpecificPage(ActionEvent event) {

    }

    //输入订单编号，敲击回车键
    @FXML
    void orderIDEntered(ActionEvent event) {
        UIJumpTool.getUiJumpTool().changeToOrderInfo();
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

    //点击“更多”label
    @FXML
    void changeToOrderInfo(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToOrderInfo();
    }

    public AnchorPane getOrderlistAnchorPane(){
        return orderlistAnchorPane;
    }

    @FXML
    void initialize() {
        assert yearLabel != null : "fx:id=\"yearLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert executedOrderLabel != null : "fx:id=\"executedOrderLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert unexecutedOrderLabel != null : "fx:id=\"unexecutedOrderLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert abnormalOrderLabel != null : "fx:id=\"abnormalOrderLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert canceledorderLabel != null : "fx:id=\"canceledorderLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert allOrderLabel != null : "fx:id=\"allOrderLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert dayOfTodayLabel != null : "fx:id=\"dayOfTodayLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert mothyearOfToday != null : "fx:id=\"mothyearOfToday\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert weekOfToday != null : "fx:id=\"weekOfToday\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert weekOfline1 != null : "fx:id=\"weekOfline1\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert weekOfline5 != null : "fx:id=\"weekOfline5\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert weekOfline4 != null : "fx:id=\"weekOfline4\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert weekOfline3 != null : "fx:id=\"weekOfline3\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert weekOfline2 != null : "fx:id=\"weekOfline2\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert monthyearOfline1 != null : "fx:id=\"monthyearOfline1\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert monthyearOfline2 != null : "fx:id=\"monthyearOfline2\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert monthyearOfline3 != null : "fx:id=\"monthyearOfline3\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert monthyearOfline4 != null : "fx:id=\"monthyearOfline4\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert monthyearOfline5 != null : "fx:id=\"monthyearOfline5\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert ordervaluelabelOfLine1 != null : "fx:id=\"ordervaluelabelOfLine1\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderValueOfLine1 != null : "fx:id=\"orderValueOfLine1\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert hotelNameOfLine5 != null : "fx:id=\"hotelNameOfLine5\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert hotelNameOfLine4 != null : "fx:id=\"hotelNameOfLine4\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert hotelNameOfLine3 != null : "fx:id=\"hotelNameOfLine3\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert hotelNameOfLine2 != null : "fx:id=\"hotelNameOfLine2\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderValueOfLine5 != null : "fx:id=\"orderValueOfLine5\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderValueOfLine4 != null : "fx:id=\"orderValueOfLine4\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderValueOfLine3 != null : "fx:id=\"orderValueOfLine3\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderValueOfLine2 != null : "fx:id=\"orderValueOfLine2\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert ordervaluelabelOfLine5 != null : "fx:id=\"ordervaluelabelOfLine5\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert ordervaluelabelOfLine4 != null : "fx:id=\"ordervaluelabelOfLine4\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert ordervaluelabelOfLine3 != null : "fx:id=\"ordervaluelabelOfLine3\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert ordervaluelabelOfLine2 != null : "fx:id=\"ordervaluelabelOfLine2\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderIDOfLine1 != null : "fx:id=\"orderIDOfLine1\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderIDOfLine5 != null : "fx:id=\"orderIDOfLine5\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderIDOfLine4 != null : "fx:id=\"orderIDOfLine4\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderIDOfLine3 != null : "fx:id=\"orderIDOfLine3\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderIDOfLine2 != null : "fx:id=\"orderIDOfLine2\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderTypeImageOfLine3 != null : "fx:id=\"orderTypeImageOfLine3\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderTypeImageOfLine4 != null : "fx:id=\"orderTypeImageOfLine4\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderTypeImageOfLine5 != null : "fx:id=\"orderTypeImageOfLine5\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderTypeImageOfLine1 != null : "fx:id=\"orderTypeImageOfLine1\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert lastPagelabel != null : "fx:id=\"lastPagelabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderIDField != null : "fx:id=\"orderIDField\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert orderTypeImageOfLine2 != null : "fx:id=\"orderTypeImageOfLine2\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert hotelNameOfLine1 != null : "fx:id=\"hotelNameOfLine1\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert commentButtonOfLine1 != null : "fx:id=\"commentButtonOfLine1\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert commentButtonOfLine5 != null : "fx:id=\"commentButtonOfLine5\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert commentButtonOfLine4 != null : "fx:id=\"commentButtonOfLine4\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert commentButtonOfLine3 != null : "fx:id=\"commentButtonOfLine3\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert commentButtonOfLine2 != null : "fx:id=\"commentButtonOfLine2\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert moreInfoOfLine1 != null : "fx:id=\"moreInfoOfLine1\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert moreInfoOfLine5 != null : "fx:id=\"moreInfoOfLine5\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert moreInfoOfLine4 != null : "fx:id=\"moreInfoOfLine4\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert moreInfoOfLine3 != null : "fx:id=\"moreInfoOfLine3\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert moreInfoOfLine2 != null : "fx:id=\"moreInfoOfLine2\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert cancelOrderButton != null : "fx:id=\"cancelOrderButton\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert checkboxOfLine1 != null : "fx:id=\"checkboxOfLine1\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert checkboxOfLine5 != null : "fx:id=\"checkboxOfLine5\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert checkboxOfLine4 != null : "fx:id=\"checkboxOfLine4\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert checkboxOfLine3 != null : "fx:id=\"checkboxOfLine3\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";
        assert checkboxOfLine2 != null : "fx:id=\"checkboxOfLine2\" was not injected: check your FXML file '订单浏览（用户视角）.fxml'.";

    }
}

