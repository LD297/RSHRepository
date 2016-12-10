package presentation.hotelcontroller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.sun.deploy.association.Action;
import com.sun.glass.ui.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import po.OrderPO;

public class CheckOrderUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView background;

    @FXML
    private ImageView telescope;

    @FXML
    private Button executeButton;

    @FXML
    private Label roomNumLabel1;

    @FXML
    private TextField actualCheckoutTimeTextField;

    @FXML
    private Label expectedCheckoutTimeLabel;

    @FXML
    private Label userLabel1;

    @FXML
    private AnchorPane unexecutedPane;

    @FXML
    private DatePicker actualCheckinDate;

    @FXML
    private TextField actualCheckinTimeTextField1;

    @FXML
    private DatePicker actualCheckinDate11;

    @FXML
    private GridPane unexecutedTabGridPane;

    @FXML
    private Tab exceptionalTab;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private DatePicker actualCheckoutDate1;

    @FXML
    private AnchorPane unexecutedPane011;

    @FXML
    private Tab unexecutedTab;

    @FXML
    private TextField actualCheckinTimeTextField;

    @FXML
    private Label nextPageLabel;

    @FXML
    private Label expectedCheckinDateLabel;

    @FXML
    private Label expectedCheckoutTimeLabel11;

    @FXML
    private Label roomNumLabel11;

    @FXML
    private Label roomTypeLabel;

    @FXML
    private Label valueLabel1;

    @FXML
    private Tab executedTab;

    @FXML
    private Label oderNumberLabel11;

    @FXML
    private Label expectedCheckinDateLabel1;

    @FXML
    private AnchorPane unexecutedTabAnchorPane;

    @FXML
    private Label roomTypeLabel1;

    @FXML
    private DatePicker actualCheckoutDate11;

    @FXML
    private Tab revokedTab;

    @FXML
    private Label valueLabel;

    @FXML
    private Label generationDateLabel11;

    @FXML
    private Label oderNumberLabel1;

    @FXML
    private Label expectedCheckoutDateLabel1;

    @FXML
    private Label expectedCheckoutTimeLabel1;

    @FXML
    private Label expectedCheckinDateLabel11;

    @FXML
    private TextField actualCheckoutTimeTextField1;

    @FXML
    private Label userLabel;

    @FXML
    private Label expectedCheckinTimeLabel;

    @FXML
    private TextField actualCheckinTimeTextField11;

    @FXML
    private Label generationDateLabel;

    @FXML
    private Label roomTypeLabel11;

    @FXML
    private Label expectedCheckoutDateLabel11;

    @FXML
    private Label prePageLabel;

    @FXML
    private DatePicker actualCheckoutDate;

    @FXML
    private Button backButton;

    @FXML
    private TextField actualCheckoutTimeTextField11;

    @FXML
    private DatePicker actualCheckinDate1;

    @FXML
    private Label expectedCheckinTimeLabel1;

    @FXML
    private Label oderNumberLabel;

    @FXML
    private Label generationDateLabel1;

    @FXML
    private Button executeButton11;

    @FXML
    private Button executeButton1;

    @FXML
    private Label expectedCheckoutDateLabel;

    @FXML
    private Label userLabel11;

    @FXML
    private Label valueLabel11;

    @FXML
    private Label expectedCheckinTimeLabel11;

    @FXML
    private AnchorPane unexecutedPane1;

    @FXML
    private AnchorPane unexecutedPane11;

    @FXML
    private Label roomNumLabel;

    @FXML
    private TabPane tabPane;

    private AnchorPane prePane;

    /**
     * 未执行订单的tab可选吗？
     */
    boolean isUnExeSelectable = true;

    /**
     * 已执行订单的tab可选吗？
     */
    boolean isExeSelectable = true;

    /**
     * 异常订单的tab可选吗？
     */
    boolean isExcSelectable = true;
    /**
     * 已撤销订单的tab可选吗？
     */
    boolean isRevoSelectable = true;


    private ArrayList<OrderPO> unexecutedOrder;

    // 指向当前tab对应的order数组（未执行？已执行？异常？已撤销？）
    private ArrayList<OrderPO> currentOrder;

    private static final int NUM_OF_ORDERS_SHOWN = 3;

    // 存放当前页面显示的order
    private OrderPO[] orderOnShow = new OrderPO[NUM_OF_ORDERS_SHOWN];

    // 当前tab对应的order共几页
    int fullPageNum;
    // 最后剩下几条不满一页的order
    int remainderOrderNum;
    // 当前页数
    int currentPage=0;

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }

    public void setUnexecutedOrder() {

        // TODO 实例化这些orders
        ArrayList<OrderPO> hotelAllOrder = new ArrayList<OrderPO>();
        ArrayList<OrderPO> unexecutedOrder = new ArrayList<OrderPO>();
        ArrayList<OrderPO> executedOrder = new ArrayList<OrderPO>();
        ArrayList<OrderPO> exceptionalOrder = new ArrayList<OrderPO>();
        ArrayList<OrderPO> revokedOreder = new ArrayList<OrderPO>();

        unexecutedOrder.add(DataFactory.getOrderPO());
        unexecutedOrder.add(DataFactory.getOrderPO());
        unexecutedOrder.add(DataFactory.getOrderPO());
        unexecutedOrder.add(DataFactory.getOrderPO());
        unexecutedOrder.add(DataFactory.getOrderPO());

        this.unexecutedOrder = unexecutedOrder;
    }

    @FXML
    void unexecutedTabSelected() {
        setUnexecutedOrder();
        if(isUnExeSelectable ){
            System.out.println("unexecuted");
            currentOrder = unexecutedOrder;
//            System.out.println(unexecutedOrder==null);
//            setfullPageNum();
//            setRemainderOrderNum();
            // 判断页数0，1，最大？倒数第二？
//            setOrderOnShow();
            showOrder();
        }


        // TODO 想办法提取一个方法，统一判断
        isUnExeSelectable = false;
        isExeSelectable = true;
        isExcSelectable = true;
        isRevoSelectable = true;
    }

    private void showOrder() {
        orderOnShow[0] = currentOrder.get(0);
        OrderPO po = orderOnShow[0];
        
    }

    private void setOrderOnShow() {
        for(int i=0; i<NUM_OF_ORDERS_SHOWN; i++){
            /**
             * 根据当前页码获得当前页数的orders，并依次存入orderOnShow数组
             */
            orderOnShow[i] = currentOrder.get(currentPage*NUM_OF_ORDERS_SHOWN+i);
        }
    }

    private void setRemainderOrderNum() {
//        remainderOrderNum = currentOrder.size()%NUM_OF_ORDERS_SHOWN;
    }

    private void setfullPageNum() {
//        fullPageNum = currentOrder.size()/NUM_OF_ORDERS_SHOWN;
    }

    @FXML
    void executedTabSelected(){
        if(isExeSelectable)
            System.out.println("executed");

        isUnExeSelectable = true;
        isExeSelectable = false;
        isExcSelectable = true;
        isRevoSelectable = true;
    }

    @FXML
    void exceptionalTabSelected(){
        if(isExcSelectable)
            System.out.println("exceptional");
        isUnExeSelectable = true;
        isExeSelectable = true;
        isExcSelectable = false;
        isRevoSelectable = true;
    }

    @FXML
    void revokedTabSelected(){
        if(isRevoSelectable)
            System.out.println("revoked");
        isUnExeSelectable = true;
        isExeSelectable = true;
        isExcSelectable = true;
        isRevoSelectable = false;

    }

    @FXML
    void executeButton0Clicked(MouseEvent event) {

    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void nextPageLabelClicked(MouseEvent event) {

    }

    @FXML
    void prePageLabelClicked(MouseEvent event) {

    }





    @FXML
    void initialize() {
        assert executeButton != null : "fx:id=\"executeButton\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel1 != null : "fx:id=\"roomNumLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeTextField != null : "fx:id=\"actualCheckoutTimeTextField\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel != null : "fx:id=\"expectedCheckoutTimeLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel1 != null : "fx:id=\"userLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedPane != null : "fx:id=\"unexecutedPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDate != null : "fx:id=\"actualCheckinDate\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeTextField1 != null : "fx:id=\"actualCheckinTimeTextField1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDate11 != null : "fx:id=\"actualCheckinDate11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedTabGridPane != null : "fx:id=\"unexecutedTabGridPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert exceptionalTab != null : "fx:id=\"exceptionalTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDate1 != null : "fx:id=\"actualCheckoutDate1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedPane011 != null : "fx:id=\"unexecutedPane011\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedTab != null : "fx:id=\"unexecutedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeTextField != null : "fx:id=\"actualCheckinTimeTextField\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel != null : "fx:id=\"expectedCheckinDateLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel11 != null : "fx:id=\"expectedCheckoutTimeLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel11 != null : "fx:id=\"roomNumLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel != null : "fx:id=\"roomTypeLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel1 != null : "fx:id=\"valueLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executedTab != null : "fx:id=\"executedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel11 != null : "fx:id=\"oderNumberLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel1 != null : "fx:id=\"expectedCheckinDateLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedTabAnchorPane != null : "fx:id=\"unexecutedTabAnchorPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel1 != null : "fx:id=\"roomTypeLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDate11 != null : "fx:id=\"actualCheckoutDate11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert revokedTab != null : "fx:id=\"revokedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel != null : "fx:id=\"valueLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel11 != null : "fx:id=\"generationDateLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel1 != null : "fx:id=\"oderNumberLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel1 != null : "fx:id=\"expectedCheckoutDateLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel1 != null : "fx:id=\"expectedCheckoutTimeLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel11 != null : "fx:id=\"expectedCheckinDateLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeTextField1 != null : "fx:id=\"actualCheckoutTimeTextField1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel != null : "fx:id=\"userLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel != null : "fx:id=\"expectedCheckinTimeLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeTextField11 != null : "fx:id=\"actualCheckinTimeTextField11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel != null : "fx:id=\"generationDateLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel11 != null : "fx:id=\"roomTypeLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel11 != null : "fx:id=\"expectedCheckoutDateLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDate != null : "fx:id=\"actualCheckoutDate\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeTextField11 != null : "fx:id=\"actualCheckoutTimeTextField11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDate1 != null : "fx:id=\"actualCheckinDate1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel1 != null : "fx:id=\"expectedCheckinTimeLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel != null : "fx:id=\"oderNumberLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel1 != null : "fx:id=\"generationDateLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton11 != null : "fx:id=\"executeButton11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton1 != null : "fx:id=\"executeButton1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel != null : "fx:id=\"expectedCheckoutDateLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel11 != null : "fx:id=\"userLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel11 != null : "fx:id=\"valueLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel11 != null : "fx:id=\"expectedCheckinTimeLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedPane1 != null : "fx:id=\"unexecutedPane1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedPane11 != null : "fx:id=\"unexecutedPane11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel != null : "fx:id=\"roomNumLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";


    }
}
