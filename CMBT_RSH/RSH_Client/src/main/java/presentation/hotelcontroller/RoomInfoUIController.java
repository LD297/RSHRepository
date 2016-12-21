package presentation.hotelcontroller;

/**
 * Created by a297 on 16/12/6.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.HotelService_Stub;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import presentation.hotelcontrollertools.HotelUIFXMLFactory;
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
    private ImageView plus;

    @FXML
    private Button delete0;

    @FXML
    private Label greyLabel;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label prePageLabel;

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
    private HotelService hotelService;
    private String hotelId;
    // 当前的room
    private ArrayList<RoomVO> currentRoom;
    private static final int NUM_OF_ITEMS = 3;
    private static final int NUM_OF_ROOMS_SHOWN = 3;
    // 当前页面的room
    private RoomVO[] roomOnShow = new RoomVO[NUM_OF_ROOMS_SHOWN];
    // 用于展示的anchorPane
    private AnchorPane[] showPanes;

    private int currentPage = 0;
    private int fullPageNum = 0;
    private int remainderRoomVONum = 0;

    private void initCurrentPage(){
        currentPage = 0;
    }
    private void setCurrentRoom(){
        currentRoom = hotelService.getRoomList(hotelId);
    }
    private void setFullPageNum(){
        fullPageNum = currentRoom.size()/NUM_OF_ROOMS_SHOWN;
    }
    private void setRemainderRoomVONum(){
        remainderRoomVONum = currentRoom.size()%NUM_OF_ROOMS_SHOWN;
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
    // 设置该条目anchorPane所有子女不可见
    private void showBlank(AnchorPane theAnchorPane){
        int size = theAnchorPane.getChildren().size();
        for(int i=0; i<size; i++){
            theAnchorPane.getChildren().get(i).setVisible(false);
        }
    }
    private void showRoomItems(AnchorPane theAnchorPane, RoomVO theRoom){
        if(theRoom!=null){
            // 显示该类型房间图片
            ImageView roomImage = (ImageView) theAnchorPane.getChildren().get(0);
            roomImage.setImage(new Image( , 146, 92, false, true));
            // 存放每条roomItem展示信息的label
            ArrayList<Label> labels = new ArrayList<>(NUM_OF_ITEMS);
            for(int i=0; i<NUM_OF_ITEMS; i++){
                labels.add((Label) theAnchorPane.getChildren().get(i+1));
            }

            //  存放每条roomItem相应的展示信息(房间、数量、价格)
            String[] items = new String[]{theRoom.roomType, String.valueOf(theRoom.numOfRoom),
                    String.valueOf(theRoom.price)};

            // 将每条信息的string放进相应的label
            for(int i=0; i<NUM_OF_ITEMS; i++){
                labels.get(i).setTextAlignment(TextAlignment.CENTER);
                labels.get(i).setText(items[i]);
            }
        } else {
            showBlank(theAnchorPane);
        }
    }
    private void showRoom(){
        for(int i=0; i<NUM_OF_ROOMS_SHOWN; i++)
            showRoomItems(showPanes[i], roomOnShow[i]);
    }
    private void showPageNumber(){
        if(pageLabel!=null)
            pageLabel.setText(String.valueOf(currentPage+1));
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
            System.out.println("已是最后一页！");
            currentPage--;
            return;
        }
        initShowPanes();
        showRoom();
        showPageNumber();
    }

    private RoomVO createRoomByPane(AnchorPane thePane){
        String type = ((Label)thePane.getChildren().get(1)).getText();
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
        FXMLLoader loader = HotelUIFXMLFactory.getInstance().getAddRoomUILoader();
        if(addRoomAnchorPane==null)
            try {
                addRoomAnchorPane = (AnchorPane) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if(addRoomUIController==null)
            addRoomUIController = loader.getController();

        addRoomUIController.setPrePane(anchorPane);

        greyLabel.setVisible(true);

        AnchorPane.setTopAnchor(addRoomAnchorPane,140.0);
        AnchorPane.setLeftAnchor(addRoomAnchorPane,100.0);
        anchorPane.getChildren().add(addRoomAnchorPane);
    }
    @FXML
    void backButtonClicked(MouseEvent event) {
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert showPane02 != null : "fx:id=\"showPane02\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert showPane01 != null : "fx:id=\"showPane01\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert plus != null : "fx:id=\"plus\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert delete0 != null : "fx:id=\"delete0\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert greyLabel != null : "fx:id=\"greyLabel\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert delete02 != null : "fx:id=\"delete02\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert delete01 != null : "fx:id=\"delete01\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert showPane0 != null : "fx:id=\"showPane0\" was not injected: check your FXML file '客房信息维护.fxml'.";
        assert pageLabel != null : "fx:id=\"pageLabel\" was not injected: check your FXML file '客房信息维护.fxml'.";

        setShowPanes();
    }
    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    private void setShowPanes(){
        showPanes =  new AnchorPane[]{showPane0, showPane01, showPane02};
    }

    public void refreshPage(){
        initCurrentPage();
        setCurrentRoom();
        setFullPageNum();
        setRemainderRoomVONum();
        showPage();
    }
}
