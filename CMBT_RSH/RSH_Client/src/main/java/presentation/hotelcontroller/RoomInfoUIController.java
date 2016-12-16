package presentation.hotelcontroller;

/**
 * Created by a297 on 16/12/6.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private ImageView minus01;

    @FXML
    private AnchorPane showPane04;

    @FXML
    private AnchorPane showPane03;

    @FXML
    private ImageView minus03;

    @FXML
    private ImageView plus0;

    @FXML
    private ImageView minus02;

    @FXML
    private AnchorPane showPane05;

    @FXML
    private ImageView minus05;

    @FXML
    private ImageView minus04;

    @FXML
    private Button confirmButton;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label prePageLabel;

    @FXML
    private ImageView plus05;

    @FXML
    private Button backButton;

    @FXML
    private Label nextPageLabel;

    @FXML
    private ImageView plus04;

    @FXML
    private ImageView plus03;

    @FXML
    private ImageView plus02;

    @FXML
    private ImageView plus01;

    @FXML
    private Label gotoImageView;

    @FXML
    private ImageView editImageView;

    @FXML
    private AnchorPane showPane0;

    @FXML
    private ImageView minus0;

    @FXML
    private Label pageLabel;

    private AnchorPane prePane;


    @FXML
    void plus0Clicked(MouseEvent event) {

    }

    @FXML
    void minus0Clicked(MouseEvent event) {

    }

    @FXML
    void prePageClicked(MouseEvent event) {

    }

    @FXML
    void nextPageClicked(MouseEvent event) {

    }

    @FXML
    void gotoDate(MouseEvent event) {

    }

    @FXML
    void editClicked(MouseEvent event) {

    }

    @FXML
    void confirmButtonClicked(MouseEvent event) {

    }
    @FXML
    void backButtonClicked(MouseEvent event) {
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());

    }

    @FXML
    void initialize() {
        assert showPane02 != null : "fx:id=\"showPane02\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert showPane01 != null : "fx:id=\"showPane01\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert minus01 != null : "fx:id=\"minus01\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert showPane04 != null : "fx:id=\"showPane04\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert showPane03 != null : "fx:id=\"showPane03\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert minus03 != null : "fx:id=\"minus03\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plus0 != null : "fx:id=\"plus0\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert minus02 != null : "fx:id=\"minus02\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert showPane05 != null : "fx:id=\"showPane05\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert minus05 != null : "fx:id=\"minus05\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert minus04 != null : "fx:id=\"minus04\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plus05 != null : "fx:id=\"plus05\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plus04 != null : "fx:id=\"plus04\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plus03 != null : "fx:id=\"plus03\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plus02 != null : "fx:id=\"plus02\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert plus01 != null : "fx:id=\"plus01\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert gotoImageView != null : "fx:id=\"gotoImageView\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert editImageView != null : "fx:id=\"editImageView\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert showPane0 != null : "fx:id=\"showPane0\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert minus0 != null : "fx:id=\"minus0\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert pageLabel != null : "fx:id=\"pageLabel\" was not injected: check your FXML file '可用客房信息维护.fxml'.";

    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }
}
