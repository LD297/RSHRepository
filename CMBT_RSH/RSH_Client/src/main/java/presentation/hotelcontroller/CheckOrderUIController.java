package presentation.hotelcontroller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import bl.orderservice.OrderForHotel;
import bl.orderserviceimpl.miscellaneous.OrderForHotel_Stub;
import constant.ResultMessage;
import constant.StateOfOrder;
import javafx.beans.property.DoubleProperty;
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
import presentation.hotelcontrollertools.HotelServiceFactory;
import presentation.tools.MyDateFormat;
import vo.OrderVO;
import vo.RoomNormVO;

import javax.xml.crypto.Data;

public class CheckOrderUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button executeButton01;

    @FXML
    private Button executeButton02;

    @FXML
    private Tab executedTab;

    @FXML
    private Button revokeButton0;

    @FXML
    private Tab revokedTab;

    @FXML
    private Button executeButton0;

    @FXML
    private Tab exceptionalTab;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label prePageLabel;

    @FXML
    private Button checkOutButton01;

    @FXML
    private ImageView background;

    @FXML
    private Tab unexecutedTab;

    @FXML
    private AnchorPane unexecutePane0;

    @FXML
    private AnchorPane unexecutePane01;

    @FXML
    private AnchorPane unexecutePane02;

    @FXML
    private Button checkOutButton02;

    @FXML
    private Button backButton;

    @FXML
    private Label nextPageLabel;

    @FXML
    private Button revokeButton02;

    @FXML
    private Label pageNumberLabel;

    @FXML
    private Button checkOutButton0;

    @FXML
    private Button revokeButton01;

    @FXML
    private ImageView telescope;

    @FXML
    private TextField searchTextField;

    @FXML
    private TabPane tabPane;


    // 酒店首页根结点
    private AnchorPane prePane;
    private OrderForHotel orderForHotel;
    private String hotelId;

    // 当前tab的anchorPane
    private AnchorPane currentTabAnchorPane;
    // 当前tabAnchorPane的唯一子女gridPane
    private GridPane currentGridPane;
    /**
     * 未执行订单的tab可选吗？
     */
    boolean isUnExeSelectable = false;
    /**
     * 已执行订单的tab可选吗？
     */
    boolean isExeSelectable = false;
    /**
     * 异常订单的tab可选吗？
     */
    boolean isExcSelectable = false;
    /**
     * 已撤销订单的tab可选吗？
     */
    boolean isRevoSelectable = false;
    // 该酒店所有未执行订单
    private ArrayList<OrderVO> unexecutedOrder;
    private ArrayList<OrderVO> executedOrder;
    private ArrayList<OrderVO> exceptionalOrder;
    private ArrayList<OrderVO> revokedOrder;

    // 每页显示几条订单记录
    private static final int NUM_OF_ORDERS_SHOWN = 3;
    // 当前tab的订单类型
    private StateOfOrder currentOrderType = null;
    // 指向当前类型（tab）对应的的订单数组
    private ArrayList<OrderVO> currentOrder;
    // 存放当前页面显示的有限条订单
    private OrderVO[] orderOnShow = new OrderVO[NUM_OF_ORDERS_SHOWN];
    // 用于当前页面显示的gridPane中有限个anchorPane
    private AnchorPane[] aPanesForShow = new AnchorPane[NUM_OF_ORDERS_SHOWN];
    // 当前类型（tab）对应的订单共几页
    private int fullPageNum = 0;
    // 最后剩下不满一页的订单有几条
    private int remainderOrderNum = 0;
    // 当前页数，从0开始计，显示出来要加一
    private int currentPage=0;

    private void setUnexecutedOrder(){
        this.unexecutedOrder = orderForHotel.hotelClassify(hotelId, StateOfOrder.unexecuted);
    }
    private void setExecutedOrder(){
        this.executedOrder = orderForHotel.hotelClassify(hotelId,StateOfOrder.executed);
    }
    private void setExceptionalOrder(){
        this.exceptionalOrder = orderForHotel.hotelClassify(hotelId,StateOfOrder.abnormal);
    }
    private void setRevokedOrder(){
        this.revokedOrder = orderForHotel.hotelClassify(hotelId, StateOfOrder.canceled);
    }

    // 每次更换tab回到开始页
    private void initCurrentPage() {
        currentPage = 0;
    }

    public void setCurrentOrderType(StateOfOrder currentOrderType) {
        this.currentOrderType = currentOrderType;
    }

    private void setCurrentGridPane(){
        currentGridPane = (GridPane) currentTabAnchorPane.getChildren().get(0);
    }

    private void setFullPageNum() {
        fullPageNum = currentOrder.size()/NUM_OF_ORDERS_SHOWN;
    }

    private void setRemainderOrderNum() {
        remainderOrderNum = currentOrder.size()%NUM_OF_ORDERS_SHOWN;
    }

    private void setOrderOnShow(boolean isFullPage) {
        if(isFullPage)
            for(int i=0; i<NUM_OF_ORDERS_SHOWN; i++)
            /**
             * 根据当前页码获得当前页数的orders，并依次存入orderOnShow数组
             */
                orderOnShow[i] = currentOrder.get(currentPage*NUM_OF_ORDERS_SHOWN+i);
        else {
            for(int i=0; i<remainderOrderNum; i++)
                orderOnShow[i] = currentOrder.get(currentPage*NUM_OF_ORDERS_SHOWN+i);
            /**
             * 为防止前一页遗留，重置order on show时，缺省项用null补齐，并在显示时判断
             */
            for(int i=remainderOrderNum; i<NUM_OF_ORDERS_SHOWN; i++)
                orderOnShow[i] = null;
        }
    }

    private void setAPanesForShow(){
        aPanesForShow[0] = (AnchorPane) currentGridPane.getChildren().get(3);
        aPanesForShow[1] = (AnchorPane) currentGridPane.getChildren().get(4);
        aPanesForShow[2] = (AnchorPane) currentGridPane.getChildren().get(5);
    }
    // 初始化anchorPanes所有子女可见
    private void initAPanesForShow() {
        if(aPanesForShow!=null){
            int size = 0;
            for(int i=0; i<NUM_OF_ORDERS_SHOWN; i++){
                size = aPanesForShow[i].getChildren().size();
                for(int j=0; j<size; j++){
                    aPanesForShow[i].getChildren().get(j).setVisible(true);
                }
            }
        }
    }
    // 设置该条目anchorPane所有子女不可见
    private void showBlank(AnchorPane theAnchorPane) {
        int size = theAnchorPane.getChildren().size();
        for(int i=0; i<size; i++){
            theAnchorPane.getChildren().get(i).setVisible(false);
        }
    }
    private void showOrderItems(AnchorPane theAnchorePane, OrderVO theOrder){

        if(theOrder!=null){
            // 要展示的订单信息
            String userID = theOrder.getUserID();
            String userName = theOrder.getUserName();
            String orderID = theOrder.getOrderID();
            String roomType = theOrder.getRoom().getRoomType();
            int roomNum = theOrder.getRoomNumber();
            double trueValue = theOrder.getTrueValue();
            Date generationDate = theOrder.getGenerationDate();
            Date checkIn = theOrder.getCheckIn();
            Date checkOut = theOrder.getCheckOut();
            Date actualIn = theOrder.getActualCheckIn();
            Date actualOut = theOrder.getActualCheckOut();

            // 需要格式转换的信息
            String roomNumStr = String.valueOf(roomNum);
            String trueValueStr = String.valueOf(trueValue);
            String generationDateStr = MyDateFormat.getInstance().toString(generationDate, true);
            String checkInStr = MyDateFormat.getInstance().toString(checkIn, true);
            String checkOutStr = MyDateFormat.getInstance().toString(checkOut, true);
            String actualInStr = MyDateFormat.getInstance().toString(actualIn, true);
            String actualOutStr = MyDateFormat.getInstance().toString(actualOut, true);

            // 对应组件
            Label idLabel = (Label)theAnchorePane.getChildren().get(0);
            Label orderIdLabel = (Label)theAnchorePane.getChildren().get(1);
            Label roomTypeLabel = (Label)theAnchorePane.getChildren().get(2);
            Label roomNumLabel = (Label)theAnchorePane.getChildren().get(3);
            Label priceLabel = (Label)theAnchorePane.getChildren().get(4);
            Label generationDateLabel = (Label)theAnchorePane.getChildren().get(5);
            Label checkInLabel = (Label)theAnchorePane.getChildren().get(6);
            Label checkOutLabel = (Label)theAnchorePane.getChildren().get(7);
            Label actualCheckInLabel = (Label)theAnchorePane.getChildren().get(8);
            Label actualCheckOutLabel = (Label)theAnchorePane.getChildren().get(9);

            // 实际入住、实际离开（提示的汉字）
            Label actualInText = (Label)theAnchorePane.getChildren().get(19);
            Label actualOutText = (Label)theAnchorePane.getChildren().get(20);

            // 将信息填充
            idLabel.setText(userID+"("+userName+")");
            orderIdLabel.setText(orderID);
            roomTypeLabel.setText(roomType);
            roomNumLabel.setText(roomNumStr);
            priceLabel.setText("￥ "+trueValueStr);
            generationDateLabel.setText(generationDateStr);
            checkInLabel.setText(checkInStr);
            checkOutLabel.setText(checkOutStr);

            // 实际入住、实际离开的汉字和对应时间默认不可见
            actualInText.setVisible(false);
            actualOutText.setVisible(false);
            actualCheckInLabel.setVisible(false);
            actualCheckOutLabel.setVisible(false);

            if(currentOrderType.equals(StateOfOrder.canceled)){
                Label canceledLabel = (Label)theAnchorePane.getChildren().get(10);
                canceledLabel.setVisible(true);
            } else if(currentOrderType.equals(StateOfOrder.executed)){
                // 客人有入住时间
                actualInText.setVisible(true);
                actualCheckInLabel.setVisible(true);
                actualCheckInLabel.setText(actualInStr);

                if(actualOutStr!=""){
                    // 客人有离开时间
                    actualOutText.setVisible(true);
                    actualCheckOutLabel.setVisible(true);
                    actualCheckOutLabel.setText(actualOutStr);
                    // 右下角不显示"退房"按钮
                    theAnchorePane.getChildren().get(10).setVisible(false);
                    // 显示对号的ImageView
                    theAnchorePane.getChildren().get(21).setVisible(true);
                } else {
                    // 客人未离开,显示"退房"按钮，不显示对号的ImageView
                    theAnchorePane.getChildren().get(10).setVisible(true);
                    theAnchorePane.getChildren().get(21).setVisible(false);
                }
            } else {
                // 未执行或异常的
                Button exeOrevButton = (Button)theAnchorePane.getChildren().get(10);
                exeOrevButton.setVisible(true);
            }
        } else {
            showBlank(theAnchorePane);
        }
    }
    // 显示存放于orderOnShow[]的有限条订单
    private void showOrder() {
        for(int i=0; i<NUM_OF_ORDERS_SHOWN; i++){
            showOrderItems(aPanesForShow[i], orderOnShow[i]);
        }
    }
    private void showPage() {
        // 流程：set当前页面要显示的order-> set要显示的anchorPanes->初始化容器->显示order
        if(currentPage>=0&&currentPage<fullPageNum)
            setOrderOnShow(true);
        else if((fullPageNum==0&&remainderOrderNum==0)||(remainderOrderNum>0&&currentPage==fullPageNum))
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
        setAPanesForShow();
        initAPanesForShow();
        showOrder();
        showPageNumber();
    }
    private void showPageNumber() {
        if(pageNumberLabel!=null)
            pageNumberLabel.setText(String.valueOf(currentPage+1));
    }
    @FXML
    void unexecutedTabSelected() {
        searchTextField.setText("");
        if(isUnExeSelectable ){
            // 从数据库获得未执行订单
            setUnexecutedOrder();
            // 设置当前订单（指向未执行订单）
            currentOrder = unexecutedOrder;
            // 初始化页数
            initCurrentPage();
            // 设置当前tab对应的订单类型
            setCurrentOrderType(StateOfOrder.unexecuted);
            // 设置当前tab的anchorPane
            currentTabAnchorPane = (AnchorPane) unexecutedTab.getContent();
            // 设置当前tabAnchorPane的唯一子女gridPane
            setCurrentGridPane();

            // 设置满页数目
            setFullPageNum();
            // 设置不满页的订单数目
            setRemainderOrderNum();
            // 显示当前页
            showPage();
        }
        // TODO 想办法提取一个方法，统一判断
        isUnExeSelectable = false;
        isExeSelectable = true;
        isExcSelectable = true;
        isRevoSelectable = true;
    }

    @FXML
    void executedTabSelected(){
        searchTextField.setText("");
        if(isExeSelectable ){
            // 从数据库获得已执行订单
            setExecutedOrder();
            // 设置当前订单（指向已执行订单）
            currentOrder = executedOrder;
            // 初始化页数
            initCurrentPage();
            // 设置当前tab对应的订单类型
            setCurrentOrderType(StateOfOrder.executed);
            // 设置当前tab的anchorPane
            currentTabAnchorPane = (AnchorPane) executedTab.getContent();
            // 设置当前tabAnchorPane的唯一子女gridPane
            setCurrentGridPane();

            // 设置满页数目
            setFullPageNum();
            // 设置不满页的订单数目
            setRemainderOrderNum();
            // 显示当前页
            showPage();
        }
        isUnExeSelectable = true;
        isExeSelectable = false;
        isExcSelectable = true;
        isRevoSelectable = true;
    }


    @FXML
    void exceptionalTabSelected(){
        searchTextField.setText("");
        if(isExcSelectable ){
            // 从数据库获得异常订单
            setExceptionalOrder();
            // 设置当前订单（指向异常订单）
            currentOrder = exceptionalOrder;
            // 初始化页数
            initCurrentPage();
            // 设置当前tab对应的订单类型
            setCurrentOrderType(StateOfOrder.abnormal);
            // 设置当前tab的anchorPane
            currentTabAnchorPane = (AnchorPane) exceptionalTab.getContent();
            // 设置当前tabAnchorPane的唯一子女gridPane
            setCurrentGridPane();

            // 设置满页数目
            setFullPageNum();
            // 设置不满页的订单数目
            setRemainderOrderNum();
            // 显示当前页
            showPage();
        }
        isUnExeSelectable = true;
        isExeSelectable = true;
        isExcSelectable = false;
        isRevoSelectable = true;
    }

    @FXML
    void revokedTabSelected(){
        searchTextField.setText("");
        if(isRevoSelectable ){
            // 从数据库获得已撤销订单
            setRevokedOrder();
            // 设置当前订单（指向已撤销订单）
            currentOrder = revokedOrder;
            // 初始化页数
            initCurrentPage();
            // 设置当前tab对应的订单类型
            setCurrentOrderType(StateOfOrder.canceled);
            // 设置当前tab的anchorPane
            currentTabAnchorPane = (AnchorPane) revokedTab.getContent();
            // 设置当前tabAnchorPane的唯一子女gridPane
            setCurrentGridPane();

            // 设置满页数目
            setFullPageNum();
            // 设置不满页的订单数目
            setRemainderOrderNum();
            // 显示当前页
            showPage();
        }

        isUnExeSelectable = true;
        isExeSelectable = true;
        isExcSelectable = true;
        isRevoSelectable = false;
    }

    private String getOrderID(int orderNo){
        Label orderIDLabel = (Label)aPanesForShow[orderNo].getChildren().get(1);
        String orderID = orderIDLabel.getText();
        return orderID;
    }

    private ResultMessage executeOrder(int orderNo){
       String orderID = getOrderID(orderNo);
        System.out.println(orderID);
        return orderForHotel.execute(orderID);
    }
    private ResultMessage checkOut(int orderNo){
        String orderID = getOrderID(orderNo);
        return orderForHotel.leaveUpdate(orderID);
    }
    private ResultMessage revokeOrder(int orderNo){
        String orderID = getOrderID(orderNo);
        System.out.println(orderID+"ui");
        return orderForHotel.hotelCancelAbnormal(orderID);
    }

    @FXML
    void execute0(MouseEvent event) {
        ResultMessage rm = executeOrder(0);
        if(rm.equals(ResultMessage.succeed)){
            isUnExeSelectable = true;
            unexecutedTabSelected();
        }
        else
            System.out.println(rm);
    }

    @FXML
    void execute01(MouseEvent event) {
        ResultMessage rm = executeOrder(1);
        if(rm.equals(ResultMessage.succeed)){
            isUnExeSelectable = true;
            unexecutedTabSelected();
        }
        else
            System.out.println(rm);
    }

    @FXML
    void execute02(MouseEvent event) {
        ResultMessage rm = executeOrder(2);
        if(rm.equals(ResultMessage.succeed)){
            isUnExeSelectable = true;
            unexecutedTabSelected();
        }
        else
            System.out.println(rm);
    }

    @FXML
    void checkOut0(MouseEvent event) {
        ResultMessage rm = checkOut(0);
        if(rm.equals(ResultMessage.succeed)){
            isExeSelectable = true;
            executedTabSelected();
        }
        else
            System.out.println(rm);
    }

    @FXML
    void checkOut01(MouseEvent event) {
        ResultMessage rm = checkOut(1);
        if(rm.equals(ResultMessage.succeed)){
            isExeSelectable = true;
            executedTabSelected();
        }
        else
            System.out.println(rm);
    }

    @FXML
    void checkOut02(MouseEvent event) {
        ResultMessage rm = checkOut(2);
        if(rm.equals(ResultMessage.succeed)){
            isExeSelectable = true;
            executedTabSelected();
        }
        else
            System.out.println(rm);
    }

    @FXML
    void revoke0(MouseEvent event) {
        ResultMessage rm = revokeOrder(0);
        if(rm.equals(ResultMessage.succeed)){
            isRevoSelectable = true;
            exceptionalTabSelected();
        }
        else
            System.out.println(rm);
    }

    @FXML
    void revoke01(MouseEvent event) {
        ResultMessage rm = revokeOrder(1);
        if(rm.equals(ResultMessage.succeed)){
            isRevoSelectable = true;
            exceptionalTabSelected();
        }
        else
            System.out.println(rm);
    }

    @FXML
    void revoke02(MouseEvent event) {
        ResultMessage rm = revokeOrder(2);
        if(rm.equals(ResultMessage.succeed)){
            isRevoSelectable = true;
            exceptionalTabSelected();
        }else
            System.out.println(rm);
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
        currentPage--;
        showPage();
    }

    @FXML
    void searchOrderByID(MouseEvent event){
        System.out.println("!~!~!");
        String id = searchTextField.getText().trim();
        for(OrderVO orderVO:currentOrder){
            System.out.println("id: "+id+"   orderVo: "+orderVO.getOrderID());
            if(orderVO.getOrderID().equals(id)){
                int index = currentOrder.indexOf(orderVO);
                int page = index/NUM_OF_ORDERS_SHOWN;
                currentPage = page;
                showPage();
                System.out.println("查找："+index+" "+page);
                return;
            }
        }
        System.out.println("当前类型不存在该订单");
    }

    @FXML
    void initialize() {
        assert executeButton01 != null : "fx:id=\"executeButton01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton02 != null : "fx:id=\"executeButton02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executedTab != null : "fx:id=\"executedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert revokeButton0 != null : "fx:id=\"revokeButton0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert revokedTab != null : "fx:id=\"revokedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton0 != null : "fx:id=\"executeButton0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert exceptionalTab != null : "fx:id=\"exceptionalTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutePane0 != null : "fx:id=\"unececutePane0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutePane01 != null : "fx:id=\"unexecutePane01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutePane02 != null : "fx:id=\"unexecutePane02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert checkOutButton01 != null : "fx:id=\"checkOutButton01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedTab != null : "fx:id=\"unexecutedTab\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert checkOutButton02 != null : "fx:id=\"checkOutButton02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert revokeButton02 != null : "fx:id=\"revokeButton02\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert pageNumberLabel != null : "fx:id=\"pageNumberLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert checkOutButton0 != null : "fx:id=\"checkOutButton0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert revokeButton01 != null : "fx:id=\"revokeButton01\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert telescope != null : "fx:id=\"telescope\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";

        initializeService();
    }

    private void initializeService() {
        this.orderForHotel = HotelServiceFactory.getInstance().getOrderForHotel();
    }

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    public void initSelectable(){
        isUnExeSelectable = true;
        isExcSelectable = true;
        isExcSelectable = true;
        isRevoSelectable = true;
    }
}
