package presentation.websalesmancontroller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by a297 on 16/12/18.
 */
public class ExceptionalOrderUIController {

    private AnchorPane prePane;

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button revokeButton0;

    @FXML
    private TextField searchTextField;

    @FXML
    private Tab revokedTab;

    @FXML
    private Tab exceptionalTab;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label prePageLabel;

    @FXML
    private ImageView background;

    @FXML
    private Button backButton;

    @FXML
    private Label nextPageLabel;

    @FXML
    private Button revokeButton02;

    @FXML
    private Label pageNumberLabel;

    @FXML
    private Button revokeButton01;

    @FXML
    private ImageView telescope;

    @FXML
    private TabPane tabPane;

    @FXML
    void backButtonClicked(MouseEvent event) {
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void nextPageLabelClicked(MouseEvent event) {

    }

    @FXML
    void prePageLabelClicked(MouseEvent event) {

    }

    @FXML
    void searchOrderByID(MouseEvent event) {

    }

    @FXML
    void exceptionalTabSelected(MouseEvent event) {

    }

    @FXML
    void revoke0(MouseEvent event) {

    }

    @FXML
    void revoke01(MouseEvent event) {

    }

    @FXML
    void revoke02(MouseEvent event) {

    }

    @FXML
    void revokedTabSelected(MouseEvent event) {

    }



    @FXML
    void initialize() {
        assert revokeButton0 != null : "fx:id=\"revokeButton0\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert searchTextField != null : "fx:id=\"searchTextField\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert revokedTab != null : "fx:id=\"revokedTab\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert exceptionalTab != null : "fx:id=\"exceptionalTab\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert revokeButton02 != null : "fx:id=\"revokeButton02\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert pageNumberLabel != null : "fx:id=\"pageNumberLabel\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert revokeButton01 != null : "fx:id=\"revokeButton01\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert telescope != null : "fx:id=\"telescope\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";

    }
}
