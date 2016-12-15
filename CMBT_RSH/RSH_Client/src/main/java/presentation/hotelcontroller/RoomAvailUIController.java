package presentation.hotelcontroller;

/**
 * Created by a297 on 16/12/5.
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vo.RoomAvailVO;

public class RoomAvailUIController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView minusLabel01;

    @FXML
    private AnchorPane showPane02;

    @FXML
    private ImageView minusLabel03;

    @FXML
    private ImageView minusLabel02;

    @FXML
    private AnchorPane showPane04;

    @FXML
    private ImageView minusLabel05;

    @FXML
    private AnchorPane showPane03;

    @FXML
    private ImageView minusLabel04;

    @FXML
    private AnchorPane showPane05;

    @FXML
    private Button confirmButton;

    @FXML
    private ImageView plusLabel02;

    @FXML
    private ImageView plusLabel03;

    @FXML
    private ImageView plusLabel04;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView plusLabel05;

    @FXML
    private Label prePageLabel;

    @FXML
    private Label gotoLabel;

    @FXML
    private ImageView plusLabel01;

    @FXML
    private Button backButton;

    @FXML
    private Label nextPageLabel;

    @FXML
    private AnchorPane showPanw01;

    @FXML
    private ImageView editImageView;

    @FXML
    private AnchorPane showPane0;

    @FXML
    private ImageView plusLabel0;

    @FXML
    private ImageView minusLabel0;

    @FXML
    private Label pageLabel;

    @FXML
    void plus0(MouseEvent event) {

    }

    @FXML
    void minus0(MouseEvent event) {

    }

    @FXML
    void plus01(MouseEvent event) {

    }

    @FXML
    void minus01(MouseEvent event) {

    }

    @FXML
    void plus02(MouseEvent event) {

    }

    @FXML
    void minus02(MouseEvent event) {

    }

    @FXML
    void plus03(MouseEvent event) {

    }

    @FXML
    void minus03(MouseEvent event) {

    }

    @FXML
    void plus04(MouseEvent event) {

    }

    @FXML
    void minus04(MouseEvent event) {

    }

    @FXML
    void plus05(MouseEvent event) {

    }

    @FXML
    void minus05(MouseEvent event) {

    }

    @FXML
    void editClicked(MouseEvent event) {

    }

    @FXML
    void prePageClicked(MouseEvent event) {

    }

    @FXML
    void nextPageClicked(MouseEvent event) {

    }

    @FXML
    void gotoClicked(MouseEvent event) {

    }

    // TODO 根据日期从数据库得到当天各种类型的可用数量
    ArrayList<RoomAvailVO> currentRoomAvailList;


    private static AnchorPane prePane;

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }

    @FXML
    void confirmButtonClicked(MouseEvent event) {
        // TODO 条件判断
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert minusLabel01 != null : "fx:id=\"minusLabel01\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert showPane02 != null : "fx:id=\"showPane02\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert minusLabel03 != null : "fx:id=\"minusLabel03\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert minusLabel02 != null : "fx:id=\"minusLabel02\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert showPane04 != null : "fx:id=\"showPane04\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert minusLabel05 != null : "fx:id=\"minusLabel05\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert showPane03 != null : "fx:id=\"showPane03\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert minusLabel04 != null : "fx:id=\"minusLabel04\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert showPane05 != null : "fx:id=\"showPane05\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plusLabel02 != null : "fx:id=\"plusLabel02\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plusLabel03 != null : "fx:id=\"plusLabel03\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plusLabel04 != null : "fx:id=\"plusLabel04\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plusLabel05 != null : "fx:id=\"plusLabel05\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert gotoLabel != null : "fx:id=\"gotoLabel\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plusLabel01 != null : "fx:id=\"plusLabel01\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert showPanw01 != null : "fx:id=\"showPanw01\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert editImageView != null : "fx:id=\"editImageView\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert showPane0 != null : "fx:id=\"showPane0\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plusLabel0 != null : "fx:id=\"plusLabel0\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert minusLabel0 != null : "fx:id=\"minusLabel0\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert pageLabel != null : "fx:id=\"pageLabel\" was not injected: check your FXML file '可用客房信息维护.fxml'.";

    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
}

