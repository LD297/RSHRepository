package presentation.hotelcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PromotionUIController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private AnchorPane anchorePane;

        @FXML
        private Button confirmButton;

        private AnchorPane prePane;

        @FXML
        void confirmButtonClicked(MouseEvent event) {
                ((Stage)anchorePane.getScene().getWindow()).setScene(prePane.getScene());
        }

        @FXML
        void initialize() {
                assert anchorePane != null : "fx:id=\"anchorePane\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
                assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";

        }

        public void setPrePane(AnchorPane prePane) {
                this.prePane = prePane;
        }
}
