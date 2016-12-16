package presentation.hotelcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class PromotionUIController {


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
    private Label greyLabel;

    @FXML
    private Button delete0;

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


    private AnchorPane prePane;

        private Label label;

        @FXML
        void confirmButtonClicked(MouseEvent event) {
               // label.setTextAlignment(TextAlignment.CENTER);
                ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
        }

        @FXML
        void initialize() {
            assert showPane02 != null : "fx:id=\"showPane02\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert showPane01 != null : "fx:id=\"showPane01\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert showPane04 != null : "fx:id=\"showPane04\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert showPane03 != null : "fx:id=\"showPane03\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert showPane05 != null : "fx:id=\"showPane05\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert delete05 != null : "fx:id=\"delete05\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert plus != null : "fx:id=\"plus\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert greyLabel != null : "fx:id=\"greyLabel\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert delete0 != null : "fx:id=\"delete0\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert delete04 != null : "fx:id=\"delete04\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert delete03 != null : "fx:id=\"delete03\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert delete02 != null : "fx:id=\"delete02\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert delete01 != null : "fx:id=\"delete01\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert showPane0 != null : "fx:id=\"showPane0\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
            assert pageLabel != null : "fx:id=\"pageLabel\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";

        }

        public void setPrePane(AnchorPane prePane) {
                this.prePane = prePane;
        }
}
