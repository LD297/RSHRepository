package presentation.websalesmancontroller;

import bl.userservice.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Label creditPrompt;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button backButton;

    @FXML
    private TextField creditTextField;

    @FXML
    private Button confirmButton;

    private AnchorPane prePane;

        private UserService userService;

        public void setPrePane(AnchorPane prePane){
            this.prePane = prePane;
        }
        @FXML
        void confirmButtonClicked(MouseEvent event) {
            String boundary = creditTextField.getText();
            if(boundary!=null){
                int credit = Integer.valueOf(boundary);
                if(credit>0){
                    creditPrompt.setVisible(false);
//                    userService.setMemberStandard();
                    backButtonClicked(null);
                    creditTextField.setPromptText(boundary);
                }
            } else
                creditPrompt.setVisible(true);
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
            assert creditPrompt != null : "fx:id=\"creditPrompt\" was not injected: check your FXML file '制定会员等级界面.fxml'.";
            assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '制定会员等级界面.fxml'.";
            assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '制定会员等级界面.fxml'.";
            assert creditTextField != null : "fx:id=\"creditTextField\" was not injected: check your FXML file '制定会员等级界面.fxml'.";
            assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '制定会员等级界面.fxml'.";

            creditPrompt.setVisible(false);
        }

}
