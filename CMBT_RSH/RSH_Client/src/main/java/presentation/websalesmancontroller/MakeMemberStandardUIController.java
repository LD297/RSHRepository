package presentation.websalesmancontroller;

import bl.userservice.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.websalesmancontrollertools.WebSalesmanUIFXMLFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by a297 on 16/12/18.
 */
public class MakeMemberStandardUIController {
        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private AnchorPane anchorPane;

        @FXML
        private TextField levelTextField;

        @FXML
        private TextField boundaryTextField;

        @FXML
        private Button backButton;

        @FXML
        private Button confirmButton;

        private AnchorPane prePane;

        private UserService userService;

        public void setPrePane(AnchorPane prePane){
            this.prePane = prePane;
        }
        @FXML
        void confirmButtonClicked(MouseEvent event) {
            String boundary = boundaryTextField.getText();
            String level = levelTextField.getText();
            int[] standard = new int[]{Integer.valueOf(boundary), Integer.valueOf(level)};
//        userService.setMemberStandard(standard);
            backButtonClicked(null);
        }

        @FXML
        void backButtonClicked(MouseEvent event) {
            Stage stage = (Stage)anchorPane.getScene().getWindow();
            stage.setX(WebSalesmanUIFXMLFactory.UI_X);
            stage.setY(WebSalesmanUIFXMLFactory.UI_Y);
            ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
        }

        @FXML
        void initialize() {
            assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '制定会员等级界面.fxml'.";
            assert levelTextField != null : "fx:id=\"levelTextField\" was not injected: check your FXML file '制定会员等级界面.fxml'.";
            assert boundaryTextField != null : "fx:id=\"boundaryTextField\" was not injected: check your FXML file '制定会员等级界面.fxml'.";
            assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '制定会员等级界面.fxml'.";
            assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '制定会员等级界面.fxml'.";

        }

}
