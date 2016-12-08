package presentation.hotelcontroller;

import java.net.URL;
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
import javafx.stage.Stage;

public class CheckOrderUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label userLabel;

    @FXML
    private Label expectedCheckinTimeLabel;

    @FXML
    private Button executeButton;

    @FXML
    private TextField actualCheckoutTimeTextField;

    @FXML
    private Label expectedCheckoutTimeLabel;

    @FXML
    private AnchorPane unexecutedPane2;

    @FXML
    private AnchorPane unexecutedPane0;

    @FXML
    private DatePicker actualCheckinDate;

    @FXML
    private Label generationDateLabel;

    @FXML
    private AnchorPane unexecuredPane4;

    @FXML
    private Tab exceptionalTab;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label prePageLabel;

    @FXML
    private Tab unexecutedTab;

    @FXML
    private TextField actualCheckinTimeTextField;

    @FXML
    private DatePicker actualCheckoutDate;

    @FXML
    private Button backButton;

    @FXML
    private Label nextPageLabel;

    @FXML
    private Label expectedCheckinDateLabel;

    @FXML
    private Tab executedTab;

    @FXML
    private Tab revokedTab;

    @FXML
    private Label expectedCheckoutDateLabel;

    @FXML
    private Label valueLabel;

    @FXML
    private TabPane tabPane;

    private AnchorPane prePane;

//    private ArrayList<OrderPO>;

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
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert userLabel != null : "fx:id=\"userLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckinTimeLabel != null : "fx:id=\"expectedCheckinTimeLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert executeButton != null : "fx:id=\"executeButton\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckoutTimeTextField != null : "fx:id=\"actualCheckoutTimeTextField\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert expectedCheckoutTimeLabel != null : "fx:id=\"expectedCheckoutTimeLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedPane2 != null : "fx:id=\"unexecutedPane2\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecutedPane0 != null : "fx:id=\"unexecutedPane0\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert actualCheckinDate != null : "fx:id=\"actualCheckinDate\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert generationDateLabel != null : "fx:id=\"generationDateLabel\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert unexecuredPane4 != null : "fx:id=\"unexecuredPane4\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
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

    }

    public void setPrePane(AnchorPane prePane){
        this.prePane = prePane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
}