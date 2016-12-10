package presentation.hotelcontroller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import constant.StateOfOrder;
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
import vo.OrderVO;
import vo.RoomNormVO;

public class CheckOrderUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label oderNumberLabel01;

    @FXML
    private Label oderNumberLabel02;

    @FXML
    private Label oderNumberLabel05;

    @FXML
    private Label oderNumberLabel03;

    @FXML
    private Label oderNumberLabel04;

    @FXML
    private AnchorPane unexecutedPane2;

    @FXML
    private Label actualCheckoutTimeLabel01;

    @FXML
    private Label actualCheckoutTimeLabel02;

    @FXML
    private AnchorPane unexecutedPane0;

    @FXML
    private Label actualCheckoutTimeLabel03;

    @FXML
    private AnchorPane unexecutedPane1;

    @FXML
    private Label actualCheckoutTimeLabel04;

    @FXML
    private DatePicker actualCheckoutDate2;

    @FXML
    private DatePicker actualCheckinDate11;

    @FXML
    private GridPane unexecutedTabGridPane;

    @FXML
    private Label showBlankLabel21;

    @FXML
    private Button executeButton21;

    @FXML
    private Tab exceptionalTab;

    @FXML
    private DatePicker actualCheckoutDate0;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private DatePicker actualCheckoutDate1;

    @FXML
    private Label expectedCheckinTimeLabel21;

    @FXML
    private Label generationDateLabel21;

    @FXML
    private Label nextPageLabel;

    @FXML
    private Label roomNumLabel11;

    @FXML
    private Tab executedTab;

    @FXML
    private Label oderNumberLabel11;

    @FXML
    private Label expectedCheckinDateLabel2;

    @FXML
    private Label expectedCheckinDateLabel1;

    @FXML
    private Label roomTypeLabel1;

    @FXML
    private Label roomTypeLabel2;

    @FXML
    private Label roomTypeLabel0;

    @FXML
    private DatePicker actualCheckinDate01;

    @FXML
    private Label expectedCheckoutDateLabel03;

    @FXML
    private Label expectedCheckoutDateLabel02;

    @FXML
    private Label expectedCheckoutDateLabel01;

    @FXML
    private Label generationDateLabel11;

    @FXML
    private Label expectedCheckoutDateLabel05;

    @FXML
    private Label expectedCheckoutDateLabel04;

    @FXML
    private Label roomNumLabel03;

    @FXML
    private ImageView telescope;

    @FXML
    private Label roomNumLabel00;

    @FXML
    private TextField actualCheckoutTimeTextField2;

    @FXML
    private TextField actualCheckoutTimeTextField1;

    @FXML
    private Label roomNumLabel02;

    @FXML
    private TextField actualCheckoutTimeTextField0;

    @FXML
    private Label roomNumLabel01;

    @FXML
    private TextField actualCheckoutTimeTextField21;

    @FXML
    private Label actualCheckinTimeLabel04;

    @FXML
    private Label actualCheckinTimeLabel02;

    @FXML
    private Label actualCheckinTimeLabel03;

    @FXML
    private Label actualCheckinTimeLabel01;

    @FXML
    private Label generationDateLabel05;

    @FXML
    private DatePicker actualCheckoutDate21;

    @FXML
    private Label generationDateLabel04;

    @FXML
    private TextField actualCheckinTimeTextField11;

    @FXML
    private Label generationDateLabel03;

    @FXML
    private Label generationDateLabel02;

    @FXML
    private Label roomNumLabel002;

    @FXML
    private Label showBlankLabel02;

    @FXML
    private Label roomNumLabel001;

    @FXML
    private Label showBlankLabel01;

    @FXML
    private Label valueLabel04;

    @FXML
    private Label valueLabel03;

    @FXML
    private Label valueLabel02;

    @FXML
    private Label valueLabel01;

    @FXML
    private Label generationDateLabel01;

    @FXML
    private Button backButton;

    @FXML
    private Label expectedCheckinDateLabel0;

    @FXML
    private Label expectedCheckinDateLabel21;

    @FXML
    private Label valueLabel05;

    @FXML
    private TextField actualCheckoutTimeTextField11;

    @FXML
    private DatePicker actualCheckinDate1;

    @FXML
    private Label generationDateLabel2;

    @FXML
    private DatePicker actualCheckinDate2;

    @FXML
    private TextField actualCheckinTimeTextField01;

    @FXML
    private Label showBlankLabel11;

    @FXML
    private Label generationDateLabel1;

    @FXML
    private Label generationDateLabel0;

    @FXML
    private DatePicker actualCheckinDate0;

    @FXML
    private Label showBlankLabel04;

    @FXML
    private Button executeButton0;

    @FXML
    private Label actualCheckinDateLabel0;

    @FXML
    private Label showBlankLabel03;

    @FXML
    private Button executeButton1;

    @FXML
    private Button executeButton2;

    @FXML
    private Label showBlankLabel05;

    @FXML
    private Label valueLabel11;

    @FXML
    private Label expectedCheckoutTimeLabel01;

    @FXML
    private Label expectedCheckoutTimeLabel02;

    @FXML
    private Label expectedCheckoutTimeLabel05;

    @FXML
    private Label expectedCheckoutTimeLabel03;

    @FXML
    private Label expectedCheckoutTimeLabel04;

    @FXML
    private Label roomNumLabel1;

    @FXML
    private Label userLabel0;

    @FXML
    private Label roomNumLabel2;

    @FXML
    private Label actualCheckoutTimeLabel0;

    @FXML
    private TextField actualCheckoutTimeTextField01;

    @FXML
    private Label userLabel1;

    @FXML
    private Label roomNumLabel0;

    @FXML
    private Label userLabel2;

    @FXML
    private DatePicker actualCheckoutDate01;

    @FXML
    private TextField actualCheckinTimeTextField1;

    @FXML
    private AnchorPane executedPane1;

    @FXML
    private TextField actualCheckinTimeTextField2;

    @FXML
    private AnchorPane executedPane2;

    @FXML
    private AnchorPane executedPane0;

    @FXML
    private Label userLabel04;

    @FXML
    private Label userLabel03;

    @FXML
    private TextField actualCheckinTimeTextField0;

    @FXML
    private Label userLabel05;

    @FXML
    private Label valueLabel21;

    @FXML
    private Tab unexecutedTab;

    @FXML
    private Label userLabel02;

    @FXML
    private Label userLabel01;

    @FXML
    private Label expectedCheckinDateLabel04;

    @FXML
    private GridPane revokedTabGridPane1;

    @FXML
    private Label expectedCheckinDateLabel03;

    @FXML
    private Label expectedCheckoutTimeLabel11;

    @FXML
    private Label valueLabel0;

    @FXML
    private Label actualCheckinDateLabel04;

    @FXML
    private Label actualCheckinDateLabel03;

    @FXML
    private Label valueLabel2;

    @FXML
    private Label actualCheckinDateLabel02;

    @FXML
    private Label expectedCheckinDateLabel02;

    @FXML
    private Label valueLabel1;

    @FXML
    private Label expectedCheckinDateLabel01;

    @FXML
    private Label actualCheckinDateLabel01;

    @FXML
    private AnchorPane unexecutedTabAnchorPane;

    @FXML
    private DatePicker actualCheckoutDate11;

    @FXML
    private TextField actualCheckinTimeTextField21;

    @FXML
    private Tab revokedTab;

    @FXML
    private Label expectedCheckoutDateLabel2;

    @FXML
    private ImageView background;

    @FXML
    private Label expectedCheckoutDateLabel0;

    @FXML
    private Label expectedCheckoutTimeLabel0;

    @FXML
    private Label oderNumberLabel1;

    @FXML
    private Label expectedCheckoutDateLabel1;

    @FXML
    private Label oderNumberLabel2;

    @FXML
    private GridPane executedTabGridPane;

    @FXML
    private Label expectedCheckoutTimeLabel2;

    @FXML
    private Label oderNumberLabel0;

    @FXML
    private Label expectedCheckoutTimeLabel1;

    @FXML
    private Label expectedCheckoutTimeLabel21;

    @FXML
    private Label expectedCheckinDateLabel11;

    @FXML
    private Button executeButton01;

    @FXML
    private Label oderNumberLabel21;

    @FXML
    private AnchorPane revokedPane1;

    @FXML
    private AnchorPane revokedPane0;

    @FXML
    private Label expectedCheckinDateLabel012;

    @FXML
    private AnchorPane revokedPane2;

    @FXML
    private Label roomTypeLabel05;

    @FXML
    private Label roomTypeLabel04;

    @FXML
    private Label roomTypeLabel03;

    @FXML
    private Label roomTypeLabel02;

    @FXML
    private Label roomTypeLabel01;

    @FXML
    private Label roomTypeLabel11;

    @FXML
    private Label expectedCheckinTimeLabel03;

    @FXML
    private Label expectedCheckinTimeLabel02;

    @FXML
    private Label expectedCheckinTimeLabel05;

    @FXML
    private Label expectedCheckoutDateLabel11;

    @FXML
    private Label expectedCheckinTimeLabel04;

    @FXML
    private Label prePageLabel;

    @FXML
    private Label userLabel21;

    @FXML
    private Label expectedCheckinTimeLabel01;

    @FXML
    private Label expectedCheckinTimeLabel2;

    @FXML
    private GridPane unexecutedTabGridPane1;

    @FXML
    private Label actualCheckinTimeLabel0;

    @FXML
    private Label expectedCheckinTimeLabel1;

    @FXML
    private Label expectedCheckinTimeLabel0;

    @FXML
    private Label showBlankLabel2;

    @FXML
    private Label showBlankLabel1;

    @FXML
    private Label showBlankLabel0;

    @FXML
    private DatePicker actualCheckinDate21;

    @FXML
    private Button executeButton11;

    @FXML
    private AnchorPane exceptionalPane2;

    @FXML
    private Label actualCheckoutDateLabel02;

    @FXML
    private AnchorPane exceptionalPane1;

    @FXML
    private AnchorPane exceptionalPane0;

    @FXML
    private Label roomTypeLabel21;

    @FXML
    private Label actualCheckoutDateLabel03;

    @FXML
    private Label actualCheckoutDateLabel04;

    @FXML
    private Label userLabel11;

    @FXML
    private Label actualCheckoutDateLabel0;

    @FXML
    private Label actualCheckoutDateLabel01;

    @FXML
    private Label expectedCheckinTimeLabel11;

    @FXML
    private Label expectedCheckinDateLabel011;

    @FXML
    private Label expectedCheckoutDateLabel21;

    @FXML
    private Label roomNumLabel21;

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
    // 该酒店所有未执行订单
    private ArrayList<OrderVO> unexecutedOrder;
    private ArrayList<OrderVO> executedOrder;
    private ArrayList<OrderVO> exceptionalOrder;
    private ArrayList<OrderVO> revokedOrder;

    // 每页显示几条订单记录
    private static final int NUM_OF_ORDERS_SHOWN = 3;
    // 指向当前类型（tab）对应的的订单数组
    private ArrayList<OrderVO> currentOrder;
    StateOfOrder currentOrderType = null;
    // 存放当前页面显示的有限条订单
    private OrderVO[] orderOnShow = new OrderVO[NUM_OF_ORDERS_SHOWN];
    // 用于当前页面显示的有限个anchorPane
    AnchorPane[] aPanesForShow = new AnchorPane[NUM_OF_ORDERS_SHOWN];
    // 当前类型（tab）对应的订单共几页
    int fullPageNum;
    // 最后剩下不满一页的订单有几条
    int remainderOrderNum;
    // TODO 当前页数，从0开始计，但显示出来要加一
    int currentPage=0;

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }

    public void setCurrentOrderType(StateOfOrder currentOrderType) {
        this.currentOrderType = currentOrderType;
    }

    public void setUnexecutedOrder() {
        // TODO 从数据库拿到各种order
        this.unexecutedOrder = DataFactory.getOrderVOList(5);
        this.executedOrder = DataFactory.getOrderVOList(4);
        this.exceptionalOrder = DataFactory.getOrderVOList(3);
        this.revokedOrder = DataFactory.getOrderVOList(2);
    }

    @FXML
    void unexecutedTabSelected() {
        if(isUnExeSelectable ){
            setCurrentOrderType(StateOfOrder.unexecuted);
            setUnexecutedOrder();
            currentOrder = unexecutedOrder;
            setfullPageNum();
            setRemainderOrderNum();
            showPage();
        }


        // TODO 想办法提取一个方法，统一判断
        isUnExeSelectable = false;
        isExeSelectable = true;
        isExcSelectable = true;
        isRevoSelectable = true;
    }

    private void showPage() {
        if(currentPage>=0&&currentPage<fullPageNum)
            setOrderOnShow(true);
        else if((remainderOrderNum!=0)&&(currentPage==fullPageNum))
            setOrderOnShow(false);
        else if(currentPage<0){
            System.out.println("已是第一页！");
            currentPage++;
            return;
        } else {
            System.out.println("已是最后一页！");
            currentPage--;
            return;
        }
        setAPanesForShow(currentOrderType);
        showOrder();
    }

    // 显示存放于orderOnShow[]的有限条订单
    private void showOrder() {
        for(int i=0; i<NUM_OF_ORDERS_SHOWN; i++){
            showOrderItems(aPanesForShow[i], orderOnShow[i]);
        }
    }

    private void showOrderItems(AnchorPane theAnchorePane, OrderVO theOrder){

        if(theOrder!=null){

            String userID = theOrder.getUserID();
            String userName = theOrder.getUserName();
            String orderID = theOrder.getOrderID();
            String roomType = theOrder.getRoom().roomType;
            int roomNum = theOrder.getRoomNumber();
            double trueValue = theOrder.getTrueValue();
            Date checkIn = new Date(2016, 12, 9, 18, 30, 0);
            Date checkOut = new Date(2016, 12, 10, 10, 30, 0);
            Date generationDate = new Date(2016, 11, 9, 18, 30, 0);

            ((Label)theAnchorePane.getChildren().get(0)).setText(userID+"("+userName+")");
            ((Label)theAnchorePane.getChildren().get(1)).setText(orderID);
            ((Label)theAnchorePane.getChildren().get(2)).setText(roomType);
            ((Label)theAnchorePane.getChildren().get(3)).setText(String.valueOf(roomNum));
            ((Label)theAnchorePane.getChildren().get(4)).setText("￥ "+String.valueOf(trueValue));
            ((Label)theAnchorePane.getChildren().get(5)).setText(String.valueOf(generationDate.getTime()));
            ((Label)theAnchorePane.getChildren().get(6)).setText(String.valueOf(checkIn.getTime()));
            ((Label)theAnchorePane.getChildren().get(7)).setText("19:00:00");
            ((Label)theAnchorePane.getChildren().get(8)).setText(String.valueOf(checkOut.getTime()));
            ((Label)theAnchorePane.getChildren().get(9)).setText("10:00:00");

        } else {
            showBlank(theAnchorePane);
        }

    }

    private void showBlank(AnchorPane theAnchorePane) {
        int size = theAnchorePane.getChildren().size();
        ((Label)theAnchorePane.getChildren().get(size-1)).setOpacity(1);
    }

    // 初始化showBlankLabel透明度为零
    private void initAPanesForShow() {
        int size = 0;
        for(int i=0; i<NUM_OF_ORDERS_SHOWN; i++){
            size = aPanesForShow[i].getChildren().size();
            aPanesForShow[i].getChildren().get(size-1).setOpacity(0);
        }
    }

    private void setOrderOnShow(boolean isFullPage) {
        if(isFullPage)
            for(int i=0; i<NUM_OF_ORDERS_SHOWN; i++){
                /**
                 * 根据当前页码获得当前页数的orders，并依次存入orderOnShow数组
                 */
                orderOnShow[i] = currentOrder.get(currentPage*NUM_OF_ORDERS_SHOWN+i);
             }
        else {
            for(int i=0; i<remainderOrderNum; i++){
                orderOnShow[i] = currentOrder.get(currentPage*NUM_OF_ORDERS_SHOWN+i);
            }
            /**
             * 为防空指针异常，用null补齐，并在显示时判断
             */
            for(int i=remainderOrderNum; i<NUM_OF_ORDERS_SHOWN; i++){
                orderOnShow[i] = null;
            }
        }

    }

    private void setAPanesForShow(StateOfOrder stateOfOrder){

        if(stateOfOrder.equals(StateOfOrder.unexecuted)){
            aPanesForShow[0] = unexecutedPane0;
            aPanesForShow[1] = unexecutedPane1;
            aPanesForShow[2] = unexecutedPane2;
        }
        if(stateOfOrder.equals(StateOfOrder.executed)){
            aPanesForShow[0] = executedPane0;
            aPanesForShow[1] = executedPane1;
            aPanesForShow[2] = executedPane2;
        }
        if(stateOfOrder.equals(StateOfOrder.abnormal)){
            aPanesForShow[0] = exceptionalPane0;
            aPanesForShow[1] = exceptionalPane1;
            aPanesForShow[2] = exceptionalPane2;

        }
        if(stateOfOrder.equals(StateOfOrder.canceled)){
            aPanesForShow[0] = revokedPane0;
            aPanesForShow[1] = revokedPane1;
            aPanesForShow[2] = revokedPane2;

        }
    }

    private void setRemainderOrderNum() {
        remainderOrderNum = currentOrder.size()%NUM_OF_ORDERS_SHOWN;
    }

    private void setfullPageNum() {
        fullPageNum = currentOrder.size()/NUM_OF_ORDERS_SHOWN;
    }

    @FXML
    void executedTabSelected(){
        if(isExeSelectable)

        isUnExeSelectable = true;
        isExeSelectable = false;
        isExcSelectable = true;
        isRevoSelectable = true;
    }

    @FXML
    void exceptionalTabSelected(){
        if(isExcSelectable)

        isUnExeSelectable = true;
        isExeSelectable = true;
        isExcSelectable = false;
        isRevoSelectable = true;
    }

    @FXML
    void revokedTabSelected(){
        if(isRevoSelectable)

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
        currentPage++;
        showPage();


    }

    @FXML
    void prePageLabelClicked(MouseEvent event) {
        initAPanesForShow();
        currentPage--;
        showPage();
    }





    @FXML
    void initialize() {
        assert oderNumberLabel01 != null : "fx:id=\"oderNumberLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel02 != null : "fx:id=\"oderNumberLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel05 != null : "fx:id=\"oderNumberLabel05\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel03 != null : "fx:id=\"oderNumberLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel04 != null : "fx:id=\"oderNumberLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedPane2 != null : "fx:id=\"unexecutedPane2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeLabel01 != null : "fx:id=\"actualCheckoutTimeLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeLabel02 != null : "fx:id=\"actualCheckoutTimeLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedPane0 != null : "fx:id=\"unexecutedPane0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeLabel03 != null : "fx:id=\"actualCheckoutTimeLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedPane1 != null : "fx:id=\"unexecutedPane1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeLabel04 != null : "fx:id=\"actualCheckoutTimeLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDate2 != null : "fx:id=\"actualCheckoutDate2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDate11 != null : "fx:id=\"actualCheckinDate11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedTabGridPane != null : "fx:id=\"unexecutedTabGridPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert showBlankLabel21 != null : "fx:id=\"showBlankLabel21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton21 != null : "fx:id=\"executeButton21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert exceptionalTab != null : "fx:id=\"exceptionalTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDate0 != null : "fx:id=\"actualCheckoutDate0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDate1 != null : "fx:id=\"actualCheckoutDate1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel21 != null : "fx:id=\"expectedCheckinTimeLabel21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel21 != null : "fx:id=\"generationDateLabel21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel11 != null : "fx:id=\"roomNumLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executedTab != null : "fx:id=\"executedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel11 != null : "fx:id=\"oderNumberLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel2 != null : "fx:id=\"expectedCheckinDateLabel2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel1 != null : "fx:id=\"expectedCheckinDateLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel1 != null : "fx:id=\"roomTypeLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel2 != null : "fx:id=\"roomTypeLabel2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel0 != null : "fx:id=\"roomTypeLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDate01 != null : "fx:id=\"actualCheckinDate01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel03 != null : "fx:id=\"expectedCheckoutDateLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel02 != null : "fx:id=\"expectedCheckoutDateLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel01 != null : "fx:id=\"expectedCheckoutDateLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel11 != null : "fx:id=\"generationDateLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel05 != null : "fx:id=\"expectedCheckoutDateLabel05\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel04 != null : "fx:id=\"expectedCheckoutDateLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel03 != null : "fx:id=\"roomNumLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert telescope != null : "fx:id=\"telescope\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel00 != null : "fx:id=\"roomNumLabel00\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeTextField2 != null : "fx:id=\"actualCheckoutTimeTextField2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeTextField1 != null : "fx:id=\"actualCheckoutTimeTextField1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel02 != null : "fx:id=\"roomNumLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeTextField0 != null : "fx:id=\"actualCheckoutTimeTextField0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel01 != null : "fx:id=\"roomNumLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeTextField21 != null : "fx:id=\"actualCheckoutTimeTextField21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeLabel04 != null : "fx:id=\"actualCheckinTimeLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeLabel02 != null : "fx:id=\"actualCheckinTimeLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeLabel03 != null : "fx:id=\"actualCheckinTimeLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeLabel01 != null : "fx:id=\"actualCheckinTimeLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel05 != null : "fx:id=\"generationDateLabel05\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDate21 != null : "fx:id=\"actualCheckoutDate21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel04 != null : "fx:id=\"generationDateLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeTextField11 != null : "fx:id=\"actualCheckinTimeTextField11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel03 != null : "fx:id=\"generationDateLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel02 != null : "fx:id=\"generationDateLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel002 != null : "fx:id=\"roomNumLabel002\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert showBlankLabel02 != null : "fx:id=\"showBlankLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel001 != null : "fx:id=\"roomNumLabel001\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert showBlankLabel01 != null : "fx:id=\"showBlankLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel04 != null : "fx:id=\"valueLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel03 != null : "fx:id=\"valueLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel02 != null : "fx:id=\"valueLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel01 != null : "fx:id=\"valueLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel01 != null : "fx:id=\"generationDateLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel0 != null : "fx:id=\"expectedCheckinDateLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel21 != null : "fx:id=\"expectedCheckinDateLabel21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel05 != null : "fx:id=\"valueLabel05\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeTextField11 != null : "fx:id=\"actualCheckoutTimeTextField11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDate1 != null : "fx:id=\"actualCheckinDate1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel2 != null : "fx:id=\"generationDateLabel2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDate2 != null : "fx:id=\"actualCheckinDate2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeTextField01 != null : "fx:id=\"actualCheckinTimeTextField01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert showBlankLabel11 != null : "fx:id=\"showBlankLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel1 != null : "fx:id=\"generationDateLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel0 != null : "fx:id=\"generationDateLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDate0 != null : "fx:id=\"actualCheckinDate0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert showBlankLabel04 != null : "fx:id=\"showBlankLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton0 != null : "fx:id=\"executeButton0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDateLabel0 != null : "fx:id=\"actualCheckinDateLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert showBlankLabel03 != null : "fx:id=\"showBlankLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton1 != null : "fx:id=\"executeButton1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton2 != null : "fx:id=\"executeButton2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert showBlankLabel05 != null : "fx:id=\"showBlankLabel05\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel11 != null : "fx:id=\"valueLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel01 != null : "fx:id=\"expectedCheckoutTimeLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel02 != null : "fx:id=\"expectedCheckoutTimeLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel05 != null : "fx:id=\"expectedCheckoutTimeLabel05\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel03 != null : "fx:id=\"expectedCheckoutTimeLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel04 != null : "fx:id=\"expectedCheckoutTimeLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel1 != null : "fx:id=\"roomNumLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel0 != null : "fx:id=\"userLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel2 != null : "fx:id=\"roomNumLabel2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeLabel0 != null : "fx:id=\"actualCheckoutTimeLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeTextField01 != null : "fx:id=\"actualCheckoutTimeTextField01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel1 != null : "fx:id=\"userLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel0 != null : "fx:id=\"roomNumLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel2 != null : "fx:id=\"userLabel2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDate01 != null : "fx:id=\"actualCheckoutDate01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeTextField1 != null : "fx:id=\"actualCheckinTimeTextField1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executedPane1 != null : "fx:id=\"executedPane1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeTextField2 != null : "fx:id=\"actualCheckinTimeTextField2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executedPane2 != null : "fx:id=\"executedPane2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executedPane0 != null : "fx:id=\"executedPane0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel04 != null : "fx:id=\"userLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel03 != null : "fx:id=\"userLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeTextField0 != null : "fx:id=\"actualCheckinTimeTextField0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel05 != null : "fx:id=\"userLabel05\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel21 != null : "fx:id=\"valueLabel21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedTab != null : "fx:id=\"unexecutedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel02 != null : "fx:id=\"userLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel01 != null : "fx:id=\"userLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel04 != null : "fx:id=\"expectedCheckinDateLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert revokedTabGridPane1 != null : "fx:id=\"revokedTabGridPane1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel03 != null : "fx:id=\"expectedCheckinDateLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel11 != null : "fx:id=\"expectedCheckoutTimeLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel0 != null : "fx:id=\"valueLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDateLabel04 != null : "fx:id=\"actualCheckinDateLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDateLabel03 != null : "fx:id=\"actualCheckinDateLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel2 != null : "fx:id=\"valueLabel2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDateLabel02 != null : "fx:id=\"actualCheckinDateLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel02 != null : "fx:id=\"expectedCheckinDateLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert valueLabel1 != null : "fx:id=\"valueLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel01 != null : "fx:id=\"expectedCheckinDateLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDateLabel01 != null : "fx:id=\"actualCheckinDateLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedTabAnchorPane != null : "fx:id=\"unexecutedTabAnchorPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDate11 != null : "fx:id=\"actualCheckoutDate11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeTextField21 != null : "fx:id=\"actualCheckinTimeTextField21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert revokedTab != null : "fx:id=\"revokedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel2 != null : "fx:id=\"expectedCheckoutDateLabel2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel0 != null : "fx:id=\"expectedCheckoutDateLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel0 != null : "fx:id=\"expectedCheckoutTimeLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel1 != null : "fx:id=\"oderNumberLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel1 != null : "fx:id=\"expectedCheckoutDateLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel2 != null : "fx:id=\"oderNumberLabel2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executedTabGridPane != null : "fx:id=\"executedTabGridPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel2 != null : "fx:id=\"expectedCheckoutTimeLabel2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel0 != null : "fx:id=\"oderNumberLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel1 != null : "fx:id=\"expectedCheckoutTimeLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel21 != null : "fx:id=\"expectedCheckoutTimeLabel21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel11 != null : "fx:id=\"expectedCheckinDateLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton01 != null : "fx:id=\"executeButton01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert oderNumberLabel21 != null : "fx:id=\"oderNumberLabel21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert revokedPane1 != null : "fx:id=\"revokedPane1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert revokedPane0 != null : "fx:id=\"revokedPane0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel012 != null : "fx:id=\"expectedCheckinDateLabel012\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert revokedPane2 != null : "fx:id=\"revokedPane2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel05 != null : "fx:id=\"roomTypeLabel05\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel04 != null : "fx:id=\"roomTypeLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel03 != null : "fx:id=\"roomTypeLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel02 != null : "fx:id=\"roomTypeLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel01 != null : "fx:id=\"roomTypeLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel11 != null : "fx:id=\"roomTypeLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel03 != null : "fx:id=\"expectedCheckinTimeLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel02 != null : "fx:id=\"expectedCheckinTimeLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel05 != null : "fx:id=\"expectedCheckinTimeLabel05\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel11 != null : "fx:id=\"expectedCheckoutDateLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel04 != null : "fx:id=\"expectedCheckinTimeLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel21 != null : "fx:id=\"userLabel21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel01 != null : "fx:id=\"expectedCheckinTimeLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel2 != null : "fx:id=\"expectedCheckinTimeLabel2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedTabGridPane1 != null : "fx:id=\"unexecutedTabGridPane1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinTimeLabel0 != null : "fx:id=\"actualCheckinTimeLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel1 != null : "fx:id=\"expectedCheckinTimeLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel0 != null : "fx:id=\"expectedCheckinTimeLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert showBlankLabel2 != null : "fx:id=\"showBlankLabel2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert showBlankLabel1 != null : "fx:id=\"showBlankLabel1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert showBlankLabel0 != null : "fx:id=\"showBlankLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDate21 != null : "fx:id=\"actualCheckinDate21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton11 != null : "fx:id=\"executeButton11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert exceptionalPane2 != null : "fx:id=\"exceptionalPane2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDateLabel02 != null : "fx:id=\"actualCheckoutDateLabel02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert exceptionalPane1 != null : "fx:id=\"exceptionalPane1\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert exceptionalPane0 != null : "fx:id=\"exceptionalPane0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomTypeLabel21 != null : "fx:id=\"roomTypeLabel21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDateLabel03 != null : "fx:id=\"actualCheckoutDateLabel03\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDateLabel04 != null : "fx:id=\"actualCheckoutDateLabel04\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert userLabel11 != null : "fx:id=\"userLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDateLabel0 != null : "fx:id=\"actualCheckoutDateLabel0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutDateLabel01 != null : "fx:id=\"actualCheckoutDateLabel01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel11 != null : "fx:id=\"expectedCheckinTimeLabel11\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinDateLabel011 != null : "fx:id=\"expectedCheckinDateLabel011\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutDateLabel21 != null : "fx:id=\"expectedCheckoutDateLabel21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert roomNumLabel21 != null : "fx:id=\"roomNumLabel21\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
    }
}
