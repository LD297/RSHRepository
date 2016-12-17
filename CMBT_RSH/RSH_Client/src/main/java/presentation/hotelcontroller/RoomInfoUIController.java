package presentation.hotelcontroller;

/**
 * Created by a297 on 16/12/6.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.hotelservice.HotelService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.tools.HotelUIFactory;
import vo.RoomVO;

public class RoomInfoUIController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane showPane02;

    @FXML
    private AnchorPane showPane01;

    @FXML
    private AnchorPane showPane04;

    @FXML
    private AnchorPane showPane03;

    @FXML
    private AnchorPane showPane05;

    @FXML
    private Button delete05;

    @FXML
    private ImageView plus;

    @FXML
    private Button delete0;

    @FXML
    private Label greyLabel;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button delete04;

    @FXML
    private Label prePageLabel;

    @FXML
    private Button delete03;

    @FXML
    private Button delete02;

    @FXML
    private Button delete01;

    @FXML
    private Button backButton;

    @FXML
    private Label nextPageLabel;

    @FXML
    private AnchorPane showPane0;

    @FXML
    private Label pageLabel;

    AnchorPane addRoomAnchorPane;
    AddRoomUIController addRoomUIController;

    // 酒店主界面根结点
    private AnchorPane prePane;
    // TODO
    private String hotelid;
    private HotelService hotelService;
    // 当前的room
    private ArrayList<RoomVO> currentRoom;
    private static final int NUM_OF_ITEMS = 4;
    private static final int NUM_OF_ROOMS_SHOWN = 6;
    // 当前页面的room
    private RoomVO[] roomOnShow = new RoomVO[NUM_OF_ROOMS_SHOWN];
    // 用于展示的anchorPane
    private AnchorPane[] showPanes;

    private int currentPage = 0;
    private int fullPageNum = 0;
    private int remainderRoomVONum = 0;

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }


    private void setCurrentRoom(){
        currentRoom = hotelService.getRoomList();
    }
    private void setFullPageNum(){
        fullPageNum = currentRoom.size()/NUM_OF_ROOMS_SHOWN;
    }
    private void setRemainderRoomVONum(){
        remainderRoomVONum = currentRoom.size()%NUM_OF_ROOMS_SHOWN;
    }

    private void setShowPanes(){
        showPanes =  new AnchorPane[]{showPane0, showPane01, showPane02,
                showPane03, showPane04,showPane05};
    }
    private void initCurrentPage(){
        currentPage = 0;
    }
    private void showPageNumber(){
        if(pageLabel!=null)
            pageLabel.setText(String.valueOf(currentPage+1));
    }

    public void refreshPage(){
        initCurrentPage();
        setCurrentRoom();
        setFullPageNum();
        setRemainderRoomVONum();
        showPage();
    }
    private void showPage(){
        if((currentPage>=0)&&(currentPage<fullPageNum))
            setRoomOnShow(true);
        else if((remainderRoomVONum!=0)&&(currentPage==fullPageNum))
            setRoomOnShow(false);
        else if(currentPage<0){
            System.out.println("已是第一页！");
            currentPage++;
            return;
        }  else {
            System.out.println("已是第一页！");
             currentPage--;
            return;
        }
        initShowPanes();
        showRoom();
        showPageNumber();
    }

    private void setRoomOnShow(boolean isFullPage){
        if(isFullPage){
            for(int i=0; i<NUM_OF_ROOMS_SHOWN; i++)
                roomOnShow[i] = currentRoom.get(currentPage*NUM_OF_ROOMS_SHOWN+i);
        } else {
            for(int i=0; i<remainderRoomVONum; i++)
                roomOnShow[i] = currentRoom.get(currentPage*NUM_OF_ROOMS_SHOWN+i);
            for(int i=remainderRoomVONum; i<NUM_OF_ROOMS_SHOWN; i++){
                roomOnShow[i] = null;
            }
        }
    }

    private void showRoom(){
        for(int i=0; i<NUM_OF_ROOMS_SHOWN; i++)
            showRoomItems(showPanes[i], roomOnShow[i]);
    }
    private void showRoomItems(AnchorPane theAnchorPane, RoomVO theRoom){
        if(theRoom!=null){
            // 存放每条roomItem展示信息的label
            ArrayList<Label> labels = new ArrayList<>(NUM_OF_ITEMS);
            for(int i=0; i<NUM_OF_ITEMS; i++){
                labels.set(i, (Label) theAnchorPane.getChildren().get(i));
            }

            //  存放每条roomItem相应的展示信息
            String[] items = new String[]{theRoom.roomType, theRoom.basicOrSpecial,
                    String.valueOf(theRoom.price),String.valueOf(theRoom.numOfRoom)};

            // 将每条信息的string放进相应的label
            for(int i=0; i<NUM_OF_ITEMS; i++){
                labels.get(i).setText(items[i]);
            }
        } else {
            showBlank(theAnchorPane);
        }
    }

    // 设置该条目anchorPane所有子女不可见
    private void showBlank(AnchorPane theAnchorPane){
        int size = theAnchorPane.getChildren().size();
        for(int i=0; i<size; i++){
            theAnchorPane.getChildren().get(i).setVisible(false);
        }
    }

    // 设置showPanes所有子女可见
    private void initShowPanes(){
        if(showPanes!=null){
            int size= 0;
            for(int i=0; i<NUM_OF_ROOMS_SHOWN; i++){
                size = showPanes[i].getChildren().size();
                for(int j=0; j<size; j++){
                    showPanes[i].getChildren().get(j).setVisible(true);
                }
            }
        }
    }

    private RoomVO createRoomByPane(AnchorPane thePane){
        String type = ((Label)thePane.getChildren().get(0)).getText();
        RoomVO roomVO = new RoomVO("",type, 0, 0.0,"");
        return roomVO;
    }

    private void deleteTheRoom(AnchorPane thePane){
        RoomVO roomToDelete = createRoomByPane(thePane);
        hotelService.deleteSpecialRoom(roomToDelete);
    }
    @FXML
    void delete0Clicked(MouseEvent event) {
        deleteTheRoom(showPane0);
        refreshPage();
    }
    @FXML
    void delete01Clicked(MouseEvent event) {
        deleteTheRoom(showPane01);
        refreshPage();
    }
    @FXML
    void delete02Clicked(MouseEvent event) {
        deleteTheRoom(showPane02);
        refreshPage();
    }
    @FXML
    void delete03Clicked(MouseEvent event) {
        deleteTheRoom(showPane03);
        refreshPage();
    }
    @FXML
    void delete04Clicked(MouseEvent event) {
        deleteTheRoom(showPane04);
        refreshPage();
    }
    @FXML
    void delete05Clicked(MouseEvent event) {
        deleteTheRoom(showPane05);
        refreshPage();
    }

    @FXML
    void prePageClicked(MouseEvent event) {
        currentPage--;
        showPage();
    }

    @FXML
    void nextPageClicked(MouseEvent event) {
        currentPage++;
        showPage();;
    }

    @FXML
    void addRoom(MouseEvent event) {
        FXMLLoader loader = HotelUIFactory.getInstance().getAddRoomUILoader();
        if(addRoomAnchorPane==null)
            try {
                addRoomAnchorPane = (AnchorPane) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if(addRoomUIController==null){
            addRoomUIController = loader.getController();
        }
        addRoomUIController.setPrePane(anchorPane);

        Scene scene = null;
        if(addRoomAnchorPane.getScene()==null)
            scene = new Scene(addRoomAnchorPane, 600, 400);
        else
            scene = addRoomAnchorPane.getScene();
        Stage stage = new Stage();

        anchorPane.getChildren().get(0).setVisible(true);

        stage.setScene(scene);
    }
    @FXML
    void backButtonClicked(MouseEvent event) {
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert showPane02 != null : "fx:id=\"showPane02\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert showPane01 != null : "fx:id=\"showPane01\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert showPane04 != null : "fx:id=\"showPane04\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert showPane03 != null : "fx:id=\"showPane03\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert showPane05 != null : "fx:id=\"showPane05\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert delete05 != null : "fx:id=\"delete05\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert plus != null : "fx:id=\"plus\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert delete0 != null : "fx:id=\"delete0\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert greyLabel != null : "fx:id=\"greyLabel\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert delete04 != null : "fx:id=\"delete04\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert delete03 != null : "fx:id=\"delete03\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert delete02 != null : "fx:id=\"delete02\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert delete01 != null : "fx:id=\"delete01\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert showPane0 != null : "fx:id=\"showPane0\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert pageLabel != null : "fx:id=\"pageLabel\" was not injected: check your FXML file '客房信息维护.fxml'.";

        refreshPage();
    }
}
