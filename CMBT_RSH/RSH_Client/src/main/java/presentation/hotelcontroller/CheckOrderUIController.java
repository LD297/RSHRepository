package presentation.hotelcontroller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
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
    private AnchorPane anchorPane;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab unexecutedTab;

    @FXML
    private AnchorPane unexecutedTabAnchorPane;

    @FXML
    private GridPane unexecutedTabGridPane;

    @FXML
    private AnchorPane unexecutedPane0;

    /*
     * 格式：用户id（username）
     */
    @FXML
    private Label userLabel;

    @FXML
    private Label orderNumberLabel;

    @FXML
    private Label roomTypeLabel;

    @FXML
    private Label roomNumLabel;

    @FXML
    private Label valueLabel;

    @FXML
    private Label generationDateLabel;

    @FXML
    private Label expectedCheckinDateLabel;

    @FXML
    private Label expectedCheckoutDateLabel;

    @FXML
    private Label expectedCheckinTimeLabel;

    @FXML
    private Label expectedCheckoutTimeLabel;

    @FXML
    private DatePicker actualCheckinDate;

    @FXML
    private DatePicker actualCheckoutDate;

    @FXML
    private TextField actualCheckinTimeTextField;

    @FXML
    private TextField actualCheckoutTimeTextField;

    @FXML
    private Button executeButton;

    @FXML
    private AnchorPane unexecutedPane01;

    @FXML
    private AnchorPane unexecuredPane011;

    @FXML
    private Label prePageLabel;


    @FXML
    private Label nextPageLabel;


    @FXML
    private Button backButton;


    @FXML
    private Tab executedTab;

    @FXML
    private Tab exceptionalTab;

    @FXML
    private Tab revokedTab;


    /**
     * 上一个界面（酒店首页）根结点
     */
    private AnchorPane prePane;

    // 每个Tab每页显示几条信息
    private static final int NUM_OF_ITEMS_SHOWN = 3;

    // TODO 实例化！！！

    private ArrayList<OrderPO> unexecutedOrders;

    private ArrayList<OrderPO> executedOrders;

    private ArrayList<OrderPO> exceptionalOrders;

    private ArrayList<OrderPO> revokedOrders;

    // 指向当前Tab对应的orders数组（未执行？已执行？异常？撤销？）
    private ArrayList<OrderPO> currentOrders;
    // 存放当前页面显示的orders
    private OrderPO[] ordersInCurrentPage = new OrderPO[NUM_OF_ITEMS_SHOWN];
    // 当前Tab对应的orders共几页
    int pageNum = currentOrders.size()/NUM_OF_ITEMS_SHOWN;
    int remainder = currentOrders.size()%NUM_OF_ITEMS_SHOWN;


    /**
     *
     * 先初始化unexecutedTab。当点击别的Tab,监听响应（currentOrders->相应的orders），其他如法炮制。
     *
     * currentOrders->unexecutedOrders
     * ordersInCurrentPage在currentOrders上移动：
     * 点击一次nextPage，ordersInCurrentPage右移一个自身长度
     * 点击一次nextPage，ordersInCurrentPage左移一个自身长度
     *
     * 初始化呈现的是ordersInCurrentPage里的每个orderPO的信息
     * 每个 anchorPane 对应 一个 orderPO
     * 将每个Tab固定（每页）的 anchorPane 放进一个group
     * 形成group的子女与orderInCurrentPage的orderPO一一对应
     *
     * pageNum>1，在第1页到第(pageNum-1)页时
     * 从而用循环去setText->呈现每一个anchorePane的内容->每一页的内容
     *
     * 最后一页（或pageNum==0||pageNum==1）：
     * 如果remainder！＝0，用defaultOrderPo填满最后一页；
     * 当group的子女对应到defaultOrderPo时，相应anchorPane显示空白
     *
     *
     */
    private void initUnexecutedTab(){
        System.out.println( unexecutedTabGridPane.getChildren().get(3).getId());

//        currentOrders = unexecutedOrders;
//        for(int i=0; i<NUM_OF_ITEMS_SHOWN; i++){
//            unexecutedTabGridPane.getChildren().get(3).getId()
//        }

    }


    @FXML
    void executeButtonClicked(MouseEvent event) {
    }

    @FXML
    void editActualCheckinTime(MouseEvent event) {

    }

    @FXML
    void editActualCheckoutTime(MouseEvent event) {

    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        System.out.println(actualCheckinDate.getUserData());
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert userLabel != null : "fx:id=\"userLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel != null : "fx:id=\"expectedCheckinTimeLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton != null : "fx:id=\"executeButton\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeTextField != null : "fx:id=\"actualCheckoutTimeTextField\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel != null : "fx:id=\"expectedCheckoutTimeLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedPane01 != null : "fx:id=\"unexecutedPane01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedPane0 != null : "fx:id=\"unexecutedPane0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDate != null : "fx:id=\"actualCheckinDate\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel != null : "fx:id=\"generationDateLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecuredPane011 != null : "fx:id=\"unexecuredPane011\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert exceptionalTab != null : "fx:id=\"exceptionalTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedTab != null : "fx:id=\"unexecutedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeTextField != null : "fx:id=\"actualCheckinTimeTextField\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDate != null : "fx:id=\"actualCheckoutDate\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel != null : "fx:id=\"expectedCheckinDateLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executedTab != null : "fx:id=\"executedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert revokedTab != null : "fx:id=\"revokedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel != null : "fx:id=\"expectedCheckoutDateLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel != null : "fx:id=\"valueLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";

        initUnexecutedTab();

    }

    public void setPrePane(AnchorPane prePane){
        this.prePane = prePane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
}