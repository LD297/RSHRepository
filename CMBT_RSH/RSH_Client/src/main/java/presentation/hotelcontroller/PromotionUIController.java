package presentation.hotelcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by a297 on 16/12/5.
 */
public class PromotionUIController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private AnchorPane anchorPane;

        @FXML
        private Button confirmButton;

        private AnchorPane prePane;

        @FXML
        void confirmButtonClicked(MouseEvent event) {
                ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());

        }

        public void setAnchorPane(AnchorPane anchorPane) {
            this.anchorPane = anchorPane;
        }

        public void setPrePane(AnchorPane prePane) {
            this.prePane = prePane;
        }

        @FXML
        void initialize() {
            assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";

        }

}
